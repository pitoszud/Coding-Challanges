package coroutines_revisited

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlin.coroutines.EmptyCoroutineContext

fun main() {

    val intFlow = flow {
        delay(100)
        emit(1)
        delay(200)
        emit(2)
        delay(300)
        emit(3)
    }

    val scope = CoroutineScope(EmptyCoroutineContext)

    intFlow
        .map { it.toDouble() }
        .onStart { println("Starting flow") }
        .onEach { it * 1.123 }
        .onCompletion { cause ->
            
        }
        .launchIn(scope)

}

sealed class Output {
    data class Success(val value: Int) : Output()
    data class Error(val message: String) : Output()
}