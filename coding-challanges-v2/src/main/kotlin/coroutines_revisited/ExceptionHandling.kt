package coroutines_revisited

import kotlinx.coroutines.*

fun main() {
    val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        println("Caught exception: $exception")
    }
    //exceptionHandlingExample1()
    exceptionHandlingExample2(exceptionHandler)
    exceptionHandlingExample3(exceptionHandler)

    Thread.sleep(2000)
}

private fun exceptionHandlingExample1() {
    val scope = CoroutineScope(Job())
    scope.launch {
        try {
            networkFetch(true)
        } catch (e: Exception) {
            println("Caught exception: $e")
        }
        networkFetch(true)
    }
}

private fun exceptionHandlingExample2(handler: CoroutineExceptionHandler) {
    // Use exception handler to handle exceptions in the parent (no need to use try/catch)
    val scope = CoroutineScope(SupervisorJob() + handler)
    scope.launch {
        networkFetch(true)
    }
}

private fun exceptionHandlingExample3(handler: CoroutineExceptionHandler) {
    val scope = CoroutineScope(SupervisorJob())
    scope.launch(handler) {
        val u1 = async {
            getUser(false)
        }

        val u2 = async {
            getUser(true)
        }

        try {
            u1.await()
            u2.await()
        } catch (e: Exception) {
            if (e is CancellationException) {
                throw e
            }
            println("Caught exception: $e")
        }
    }
}

fun networkFetch(exception: Boolean) {
    if (exception) {
        throw RuntimeException("Network fetch failed")
    }
}

suspend fun getUser(exception: Boolean): String {
    delay(100)
    if (exception) {
        throw RuntimeException("User fetch failed")
    }
    return "User"
}

