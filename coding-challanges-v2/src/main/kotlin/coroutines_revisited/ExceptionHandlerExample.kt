package coroutines_revisited

import kotlinx.coroutines.*

fun main() {
    val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        println("Caught exception: $exception")
    }
    cancellationExample4(exceptionHandler)
    Thread.sleep(2000)
}

fun cancellationExample4(coroutineHandler: CoroutineExceptionHandler) {

    val job = CoroutineScope(Job() + coroutineHandler).launch {
        launch {
            println("fetch user data")
            delay(1000)
            println("user data fetched")
        }

        launch {
            println("fetch app data")
            delay(100)
            throw RuntimeException("App data fetch failed")
        }
    }

/*
* fetch user data
  fetch app data
  Caught exception: java.lang.RuntimeException: App data fetch failed
* */
}