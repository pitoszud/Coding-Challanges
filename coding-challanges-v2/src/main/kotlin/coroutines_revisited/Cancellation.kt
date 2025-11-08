package coroutines_revisited

import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.coroutines.EmptyCoroutineContext


fun main() = runBlocking {
    val value = 3
    val result = value.coerceIn(1..5) // result = 3
    val result2 = value.coerceIn(4..10) // result2 = 4
    println("Result: $result, Result2: $result2")
}


suspend fun cancellationExample3() {
    val job = CoroutineScope(Dispatchers.Default).launch {
        while (true) {
            try {
                longOperation(1)
            } catch (e: Exception) {
                kotlin.coroutines.coroutineContext.ensureActive()
                println("Caught exception: $e")
            }
        }
    }
    delay(100)
    job.cancel()
}

suspend fun cancellationExample2() {
    val job = CoroutineScope(Dispatchers.Default).launch {
        try {
            longOperation(1)
        } finally {
            println("Running finally block...")
            /*
            * This operation will not be executed because the job is already cancelled.
            * Avoid calling suspend functions in finally block.
            * If you need to execute a suspend function in finally block
            * use:
            * withContext(NonCancellable) { longOperation(2) }
            * */
            longOperation(2)
        }
    }
    delay(100)
    job.cancel()
}


suspend fun cancellationExample1() {
    val repoJob = CoroutineScope(Dispatchers.Default).launch {
        repeat(10) { i ->
            println("sync process $i ...")
            Thread.sleep(100)
        }
    }

    longOperation(1)
    println("Cancelling the job")
    repoJob.cancel()
}


suspend fun longOperation(num: Int) {
    withContext(Dispatchers.IO) {
        println("Start long operation $num")
        delay(250)
        println("Long operation $num completed")
    }
}
