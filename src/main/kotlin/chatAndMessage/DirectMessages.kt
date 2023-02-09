package chatAndMessage

data class DirectMessages (
    //val userId: Int,
    //val userLogin: String,
    var messeges: MutableList<Message> = mutableListOf()
        )
{

//    override fun toString(): String {
//        return "Chat with user: id $userId login $userLogin, amount of messages: ${messeges.size}"
//    }
}