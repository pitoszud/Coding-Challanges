package design_patterns.mediator


// TODO - Modify this pattern to use an example from Kotlin Design Patterns book and Android app

fun main() {
    val receiverA = ReceiverSquare(name = "ReceiverA", type = ReceiverTypeSquare.A)
    val receiverB = ReceiverSquare(name = "ReceiverB", type = ReceiverTypeSquare.A)
    val receiverC = ReceiverSquare(name = "ReceiverB", type = ReceiverTypeSquare.B)

    val mediator = MediatorSquare()
    val message = MessageSquare(
        type = ReceiverTypeSquare.A,
        message = "Well done",
        mediator = mediator
    )
    mediator.addReceiver(receiverA)
    mediator.addReceiver(receiverB)
    mediator.addReceiver(receiverC)
    message.sendMessage()

}


class MediatorSquare {
    private val receivers = ArrayList<ReceiverSquare>()

    fun addReceiver(receiver: ReceiverSquare) {
        receivers.add(receiver)
    }

    fun sendMessage(type: ReceiverTypeSquare, message: String) {
        receivers.forEach { rcvr ->
            if (rcvr.type == type) {
                rcvr.updateMessages(message)
            }
        }
    }
}

class MessageSquare(private val type: ReceiverTypeSquare, private val message: String, private val mediator: MediatorSquare) {
    fun sendMessage() {
        mediator.sendMessage(type, message)
    }
}

class ReceiverSquare(private val name: String, val type: ReceiverTypeSquare) {
    private val messages = mutableListOf<String>()

    fun updateMessages(message: String) {
        messages.add(message)
        println("Messages for receiver $name, $messages")
    }
}

enum class ReceiverTypeSquare {
    A, B
}