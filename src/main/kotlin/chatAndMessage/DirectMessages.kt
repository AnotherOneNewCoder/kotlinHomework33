package chatAndMessage

data class DirectMessages (
    val id: Int,
    var mutableList: MutableList<Message>
        )
{

    override fun toString(): String {
        return "Chat id: $id, amount of messages: ${mutableList.size}"
    }
}