package coroutines_revisited.fundamentals.exception_handling

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds

fun main(): Unit = runBlocking {
    launch {
        launch {
            delay(1000.milliseconds)
            throw Error("Some error")
        }

        launch {
            delay(2000.milliseconds)
            println("Not printed - longer than exception")
        }

        launch {
            delay(500.milliseconds)
            println("Printed - faster than exception")
        }
    }

    launch {
        delay(2000.milliseconds)
        println("Not printed - longer than exception")
    }
}