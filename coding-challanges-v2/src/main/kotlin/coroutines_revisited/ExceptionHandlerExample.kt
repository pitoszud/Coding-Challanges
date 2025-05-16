package coroutines_revisited

import kotlinx.coroutines.*

fun main() {
    val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        println("Caught exception: $exception")
    }
    //throwAndCancelSiblingExampleA(exceptionHandler)
    //throwAndCancelSiblingExampleB(exceptionHandler)
    throwIndependently(exceptionHandler)
    Thread.sleep(2000)
}

fun throwAndCancelSiblingExampleA(coroutineHandler: CoroutineExceptionHandler) {
    val job: Job = CoroutineScope(Job() + coroutineHandler).launch {
        launch {
            println("fetch user data")
            delay(1000)
            throw RuntimeException("User data fetch failed")
            //println("user data fetched")
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


fun throwAndCancelSiblingExampleB(coroutineHandler: CoroutineExceptionHandler) {
    val scope = CoroutineScope(Job() + coroutineHandler)
    scope.launch {
        println("fetch user data")
        delay(1000)
        throw RuntimeException("User data fetch failed")
        //println("user data fetched")
    }

    scope.launch {
        println("fetch app data")
        delay(100)
        throw RuntimeException("App data fetch failed")
    }

    /*
    * fetch user data
      fetch app data
      Caught exception: java.lang.RuntimeException: App data fetch failed
    * */
}


fun throwIndependently(coroutineHandler: CoroutineExceptionHandler) {
    val scope: CoroutineScope = CoroutineScope(SupervisorJob() + coroutineHandler)
    scope.launch {
        println("fetch user data")
        delay(1000)
        throw RuntimeException("User data fetch failed")
    }
    scope.launch {
        println("fetch app data")
        delay(100)
        throw RuntimeException("App data fetch failed")
    }

    /*
    * fetch user data
      fetch app data
      Caught exception: java.lang.RuntimeException: App data fetch failed
      Caught exception: java.lang.RuntimeException: User data fetch failed
    * */
}