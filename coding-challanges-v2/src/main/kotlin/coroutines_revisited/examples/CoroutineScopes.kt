package coroutines_revisited.examples

import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.milliseconds

fun main() {
    //launchChildrenAndWaitWithCoroutineScope()
    //launchIntoIndependentScopeWithoutWaiting()

    //launchSiblingCoroutinesAndWaitForAll()
    //launchSiblingsWithSupervisorScope()
    //launchNestedWorkPerItem()
}

fun launchChildrenAndWaitWithCoroutineScope() {
    val parentScope = CoroutineScope(Job() + Dispatchers.Default)
    parentScope.launch {
        println("--- coroutineScope waits for all launched children ---")
        coroutineScope {
            launch {
                runTask("Task 1", 100)
            }

            launch {
                runTask("Task 2", 300)
            }
        }

        println("All children finished, now starting follow-up work")
        parentScope.launch {
            runTask("Task 3", 300)
        }
    }
    Thread.sleep(1000)
    parentScope.cancel()
}
/*
Start Task 1
Start Task 2
Task 1 Completed
Task 2 Completed
All children finished, now starting follow-up work
Start Task 3
Task 3 Completed
* */

fun launchIntoIndependentScopeWithoutWaiting() {
    val scope = CoroutineScope(SupervisorJob() + Dispatchers.Default)
    val repoScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    scope.launch {
        repoScope.launch {
            launch {
                runTask("Task 1", 100)
            }

            launch {
                runTask("Task 2", 300)
            }
        }

        println("Task 4 starts immediately because repoScope is independent")
        runTask("Task 3", 300)
    }
    Thread.sleep(1000)
    scope.cancel()
    repoScope.cancel()
}

/*
Start Task 3
Start Task 1
Start Task 2
Task 1 Completed
Task 3 Completed
Task 2 Completed
* */

fun launchSiblingCoroutinesAndWaitForAll() {
    val screenScope = CoroutineScope(Job() + Dispatchers.Default)
    screenScope.launch {
        println("--- fan out work with launch and wait using joinAll ---")
        val jobs = listOf(
            launch { runTask("Load Profile", 200) },
            launch { runTask("Load Feed", 300) },
            launch { runTask("Load Notifications", 150) },
        )

        jobs.joinAll()
        println("All sibling launches completed")
    }
    Thread.sleep(1000)
    screenScope.cancel()
}

fun launchSiblingsWithSupervisorScope() {
    val appScope = CoroutineScope(SupervisorJob() + Dispatchers.Default)
    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        println("Cache Warmup failed: ${throwable.message}")
    }

    appScope.launch {
        println("--- supervisorScope isolates sibling failures ---")
        supervisorScope {
            val cacheWarmup = launch(exceptionHandler) {
                println("Start Cache Warmup")
                delay(100.milliseconds)
                error("Cache service unavailable")
            }

            val analyticsUpload = launch {
                runTask("Analytics Upload", 250)
            }

            val refreshUi = launch {
                runTask("Refresh UI", 300)
            }

            joinAll(cacheWarmup, analyticsUpload, refreshUi)
        }

        println("Healthy siblings were allowed to finish")
    }
    Thread.sleep(1000)
    appScope.cancel()
}

fun launchNestedWorkPerItem() {
    val processingScope = CoroutineScope(Job() + Dispatchers.Default)
    processingScope.launch {
        println("--- each parent item launches concurrent child work ---")
        val parentJobs = (1..3).map { itemId ->
            launch {
                println("Preparing item $itemId")
                coroutineScope {
                    launch { runTask("Item $itemId - read cache", 100) }
                    launch { runTask("Item $itemId - read network", 200) }
                }
                println("Item $itemId is fully prepared")
            }
        }

        parentJobs.joinAll()
        println("All items were processed")
    }
    Thread.sleep(1200)
    processingScope.cancel()
}

private suspend fun runTask(taskName: String, durationInMs: Long) {
    println("Start $taskName")
    delay(durationInMs.milliseconds)
    println("$taskName Completed")
}