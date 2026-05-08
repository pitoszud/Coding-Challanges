package coroutines_revisited.examples

import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.milliseconds

fun main() {
    //structuredConcurrencyExample()
    structuredConcurrencyExample2()
}

fun structuredConcurrencyExample() {
    val viewModelScope = CoroutineScope(Job())
    viewModelScope.launch {
        coroutineScope {
            launch {
                println("Start Task 1")
                delay(100.milliseconds)
                println("Task 1 Completed")
            }

            launch {
                println("Start Task 2")
                delay(300.milliseconds)
                println("Task 2 Completed")
            }
        }

        // This scope will be run after the first scope has completed
        viewModelScope.launch {
            println("Start Task 3")
            delay(300.milliseconds)
            println("Task 3 Completed")
        }
    }
    Thread.sleep(1000)
}

fun structuredConcurrencyExample2() {
    val viewModelScope = CoroutineScope(SupervisorJob() + Dispatchers.Default)
    val repoScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    viewModelScope.launch {
        println("Start Task 1")
        delay(300.milliseconds)
        println("Task 1 Completed")

        repoScope.launch {
            launch {
                println("Start Task 2")
                delay(100.milliseconds)
                println("Task 2 Completed")
            }

            launch {
                println("Start Task 3")
                delay(300.milliseconds)
                println("Task 3 Completed")
            }
        }

        println("Start Task 4")
        delay(300.milliseconds)
        println("Task 4 Completed")
    }
    Thread.sleep(1000)
}