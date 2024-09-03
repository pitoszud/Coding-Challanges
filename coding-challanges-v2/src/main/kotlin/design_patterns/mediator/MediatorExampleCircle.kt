package design_patterns.mediator

fun main() {
    val receiverA = ReceiverCircle(name = "ReceiverA", type = ReceiverTypeCircle.A)
    val receiverB = ReceiverCircle(name = "ReceiverB", type = ReceiverTypeCircle.A)
    val receiverC = ReceiverCircle(name = "ReceiverB", type = ReceiverTypeCircle.B)

    val mediator = MediatorCircle()
    val message = MessageCircle(
        type = ReceiverTypeCircle.A,
        message = "Well done",
        mediator = mediator
    )
    mediator.addReceiver(receiverA)
    mediator.addReceiver(receiverB)
    mediator.addReceiver(receiverC)
    message.sendMessage()

}


class MediatorCircle {
    private val receivers = ArrayList<ReceiverCircle>()

    fun addReceiver(receiver: ReceiverCircle) {
        receivers.add(receiver)
    }

    fun sendMessage(type: ReceiverTypeCircle, message: String) {
        receivers.forEach { rcvr ->
            if (rcvr.type == type) {
                rcvr.updateMessages(message)
            }
        }
    }
}

class MessageCircle(private val type: ReceiverTypeCircle, private val message: String, private val mediator: MediatorCircle) {
    fun sendMessage() {
        mediator.sendMessage(type, message)
    }
}

class ReceiverCircle(private val name: String, val type: ReceiverTypeCircle) {
    private val messages = mutableListOf<String>()

    fun updateMessages(message: String) {
        messages.add(message)
        println("Messages for receiver $name, $messages")
    }
}

enum class ReceiverTypeCircle {
    A, B
}