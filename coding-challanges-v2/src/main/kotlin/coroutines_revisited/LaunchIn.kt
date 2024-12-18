package coroutines_revisited

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
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
        .onEach { println("Received from launchIn: $it") }
        .launchIn(scope)

    intFlow
        .onEach { println("Received from launchIn: $it") }
        .launchIn(scope)



    scope.launch {
        intFlow
            .onEach { println("Received from onEach: $it") }
            .collect {
            println("Received from collect: $it")
        }
    }

    scope.launch {
        intFlow
            .onEach { println("Received from onEach: $it") }
            .collect {
            println("Received from collect $it")
        }
    }

    Thread.sleep(1000)


}