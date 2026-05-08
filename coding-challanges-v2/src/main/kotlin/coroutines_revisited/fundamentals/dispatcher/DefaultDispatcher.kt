package coroutines_revisited.fundamentals.dispatcher

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.random.Random

suspend fun main() = coroutineScope {
    repeat(1000) {
        launch {
            busy()
            val threadName = Thread.currentThread().name
            println("Running on $threadName")
        }


    }
}

fun busy() {
    List(1000) {
        Random.nextLong()
    }.maxOrNull()
}