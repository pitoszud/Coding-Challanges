package coroutines_revisited

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.coroutines.EmptyCoroutineContext

suspend fun main() = coroutineScope {

    val intFlow = flow {
        delay(100)
        emit(1)
        delay(200)
        emit(2)
        delay(300)
        throw RuntimeException("Flow failed")
        emit(3)
        delay(400)
        emit(4)
    }

    val scope = CoroutineScope(EmptyCoroutineContext)

    // Launching a flow in a coroutine scope
    intFlow
        .map { it.toDouble() * 1.123 }
        .onStart { println("---- Starting flow 1 ----") }
        .onCompletion { cause ->
            if (cause != null) {
                println("Flow completed exceptionally")
            } else {
                println("Flow completed successfully")
            }
            println("---------------------------------")
        }
        .onEach {
            println("Each: $it")
        }
        .retry(1) { cause ->
            println("Caught exception: $cause, Retry flow")
            true
        }
        .catch { t ->
            println("Caught exception: ${t.message}")
            emit(0.0)
            emitAll(fallbackFlow().map { it.toDouble() })
        }
        .launchIn(scope) // shorthand for scope.launch { flow. collect() }



    // Collecting a flow in a coroutine scope
    intFlow
        .map { it.toDouble() * 1.123 }
        .onStart { println("----- Starting flow 2 -----") }
        .onCompletion { cause ->
            if (cause != null) {
                println("Flow completed exceptionally")
            } else {
                println("Flow completed successfully")
            }
            println("---------------------------------")
        }
        .onEach {
            println("Each: $it")
        }
        .retry(1) { cause ->
            println("Caught exception: $cause, Retry flow")
            true
        }
        .catch { t ->
            println("Caught exception: ${t.message}")
            emit(0.0)
            emitAll(fallbackFlow().map { it.toDouble() })
        }
        .collect {
            println("Received from collect: $it")
        }


    intFlow
        .map { it.toDouble() * 1.123 }
        .onStart { println("----- Starting flow 2 -----") }
        .onCompletion { cause ->
            if (cause != null) {
                println("Flow completed exceptionally")
            } else {
                println("Flow completed successfully")
            }
            println("---------------------------------")
        }
        .onEach {
            println("Each: $it")
        }
        .retry(1) { cause ->
            println("Caught exception: $cause, Retry flow")
            true
        }
        .catch { t ->
            println("Caught exception: ${t.message}")
            emit(0.0)
            emitAll(fallbackFlow().map { it.toDouble() })
        }
        .collect {
            println("Received from collect: $it")
        }


    /*
    * Cancel flow
    * */
    intFlow
        .map { it.toDouble() * 1.123 }
        .onStart { println("----- Starting flow 3 -----") }
        .onCompletion {
            println("---------------------------------")
        }
        .onEach {
            println("Each: $it")
            // if (currentCoroutineContext().job.isActive) { throw CancellationException() } // same as ensureActive() and .cancellable()
            // ensureActive() // same as .cancellable() and the one above
        }
        .cancellable()
        .collect {
            println("Received from collect: $it")
            if (it >= 2) {
                println("cancelling flow")
                cancel()
            }
        }

    Thread.sleep(2000)

}

fun fallbackFlow(): Flow<Int> {
    return flow {
        emit(5)
        delay(100)
        emit(6)
        delay(200)
        emit(7)
    }
}

sealed class Output {
    data class Success(val value: Int) : Output()
    data class Error(val message: String) : Output()
}