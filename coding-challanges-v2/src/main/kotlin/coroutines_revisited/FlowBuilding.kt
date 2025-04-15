package coroutines_revisited

import kotlinx.coroutines.*
import kotlinx.coroutines.NonCancellable.cancel
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.flow.internal.ChannelFlow

suspend fun main() {


}


/*
* - Does not retain the last emitted value by default.
* - Does not require an initial value.
* - New collectors will not receive any previously emitted values unless replay is configured.
* - Can be configured to replay a specific number of previously emitted values with replay.
* - Suitable for broadcast event-driven flows where you may not need to retain state
* */
class FlowRepoA() {
    private val _events = MutableSharedFlow<String>(replay = 0)
    val events: Flow<String> = _events

    fun updateEvent(event: String) {
        _events.tryEmit(event)
    }
}

/*
* - allows for concurrent emissions
* */
class FlowRepoB() {
    private val events = MutableSharedFlow<Int>(replay = 0)

    suspend fun eventsFlow(): Flow<Int> = withContext(Dispatchers.IO) {
        channelFlow {
            events.collect {
                if (it > 3) {
                    send(it)
                }
            }
        }
    }

    fun updateFlow(value: Int) {
        events.tryEmit(value)
    }
}

/*
* - Always retains the latest value.
* - Requires an initial value to represent the starting state.
* - New collectors will immediately receive the current value upon subscription.
* - Always replays exactly one value (the current state) to new collectors.
* - Designed for state management, where you need to hold and observe the latest state consistently.
* */
class FlowRepoD {
    private val _stateFlow = MutableStateFlow(0)
    val stateFlow: StateFlow<Int> = _stateFlow

    fun updateState(value: Int) {
        _stateFlow.value = value
    }
}


/*
* - used in Callback-Based APIs
* */
class FlowRepoC {
    fun eventsFlow(): Flow<Int> = callbackFlow {
        val listener = { value: Int ->
            trySend(value)
        }

        launch {
            for (i in 1..5) {
                delay(500)
                listener(i)
            }
        }

        awaitClose { /* Clean up resources if needed */ }
    }
}

