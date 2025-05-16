package string

import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.security.KeyPairGenerator
import java.util.Base64
import kotlin.coroutines.cancellation.CancellationException

fun main() = runBlocking {
    updateProfile()

    Thread.sleep(4000)

}
suspend fun updateProfile(): String? = coroutineScope {

    val result = StringBuilder()
    val job1 = async {
        delay(1000)
        result.append("Profile updated, ")
    }
    val job2 = async {
        delay(2000)
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

suspend fun updateProfile1() = coroutineScope {
    val updateProfileJob = launch {
        // Simulate a long-running task
        delay(1000)
        println("Profile updated")
    }

    val uploadProfilePictureJob = launch {
        // Simulate a long-running task
        delay(2000)
        println("Profile picture uploaded")
    }

    updateProfileJob.join()
    uploadProfilePictureJob.join()
}