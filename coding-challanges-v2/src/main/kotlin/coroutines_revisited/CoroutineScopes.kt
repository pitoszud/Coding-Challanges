package coroutines_revisited

import kotlinx.coroutines.*

fun main() {
    structuredConcurrencyExample2()
}

fun structuredConcurrencyExample() {
    val viewModelScope = CoroutineScope(Job())
    viewModelScope.launch {
        coroutineScope {
            launch {
                println("Start Task 1")
                delay(100)
                println("Task 1 Completed")
            }

            launch {
                println("Start Task 2")
                delay(300)
                println("Task 2 Completed")
            }
        }

        // This scope will be run after the first scope has completed
        viewModelScope.launch {
            println("Start Task 3")
            delay(300)
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
        delay(300)
        println("Task 1 Completed")

        repoScope.launch {
            launch {
                println("Start Task 2")
                delay(100)
                println("Task 2 Completed")
            }

            launch {
                println("Start Task 3")
                delay(300)
                println("Task 3 Completed")
            }
        }

        println("Start Task 4")
        delay(300)
        println("Task 4 Completed")
    }
    Thread.sleep(1000)

    /*
    *
Start Task 1
Task 1 Completed
Start Task 4
Start Task 2
Start Task 3
Task 2 Completed
Task 4 Completed
Task 3 Completed
    * */
}