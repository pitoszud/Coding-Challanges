package coroutines_revisited.examples

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.cancellation.CancellationException
import kotlin.time.Duration.Companion.milliseconds

fun main() = runBlocking {
    asyncCancel1()
    Thread.sleep(4000)
}


suspend fun asyncCancel1() = coroutineScope {
    launch {
        try {
            delay(1000.milliseconds)
            throw Exception("Profile update failed")
        } catch (e: Exception) {
            if (e is CancellationException) throw e
            println("Profile update failed: ${e.message}")
            throw e
        }
    }

    launch {
        try {
            delay(2000.milliseconds)
            println("Profile picture uploaded")
            // Uncomment to simulate failure: throw Exception("Upload failed")
        } catch (e: Exception) {
            if (e is CancellationException) throw e
            println("Profile picture upload failed: ${e.message}")
            throw e
        }
    }
}


suspend fun asyncCancel2(): String? = coroutineScope {

    val result = StringBuilder()
    val job1 = async {
        delay(1000.milliseconds)
        result.append("Profile updated, ")
    }
    val job2 = async {
        delay(2000.milliseconds)
        result.append("Profile picture uploaded, ")
    }
    try {
        awaitAll(job1, job2)
        result.toString()
    } catch (e: Exception) {
        if (e is CancellationException) throw e
        // coroutineContext.ensureActive() // same as above
        println("Error: ${e.message}")
        null
    }
}


suspend fun asyncCancel3() = coroutineScope {
    // Typically used in parent and passed to child coroutines
    val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        println("Caught exception: ${exception.message}")
    }

    CoroutineScope(Job() + exceptionHandler).launch {
        launch(exceptionHandler) {
            delay(1000.milliseconds)
            throw Exception("Profile update failed")
        }

        launch(exceptionHandler) {
            delay(2000.milliseconds)
            println("Profile picture uploaded")
            throw Exception("Upload failed")
        }
    }

}