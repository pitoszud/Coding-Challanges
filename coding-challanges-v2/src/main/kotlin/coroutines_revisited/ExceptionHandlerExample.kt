package coroutines_revisited

import kotlinx.coroutines.*

fun main() {
    val c = CoroutineExceptionHandler { _, exception ->
        println("Caught exception: $exception")
    }
}

suspend fun cancellationExample4(coroutineHandler: CoroutineExceptionHandler) {

    val job = CoroutineScope(Job() + coroutineHandler).launch {
        delay(200)
        throw RuntimeException("Error")
    }
}