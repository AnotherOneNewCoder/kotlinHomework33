package chatAndMessage

import examples.Post

object ChatService {

    val chatsList = mutableListOf<DirectMessages>()
    var idChat = 0
    var idMessages = 0

    fun createChat(chatId:Int,message: Message): Boolean {
        //val predicate = fun (direct: DirectMessages) = direct.id != chatId
        for (chat in chatsList){
            if (chat.id == chatId)
                return false
        }
        val tempList = mutableListOf<Message>()
        message.id = ++idMessages
        tempList.add(message)

        chatsList.add(DirectMessages(chatId, tempList))
        return true
    }
    fun getChats(): String {
        return chatsList.toString()
    }
    fun deleteAllChats(): MutableList<DirectMessages>{
        chatsList.removeAll { it.id > 0 }
        return chatsList
    }
    fun deleteChat(chatId: Int) : MutableList<DirectMessages> {
        chatsList.removeAll { it.id == chatId }
        return chatsList
    }
    fun newMessage(chatId: Int, message: Message):Boolean {
        for (chat in chatsList) {
            if (chat.id == chatId) {
                message.id = ++idMessages
                chat.mutableList.add(message)
                return true
            }
        }
        createChat(chatId, message)
        return true
    }
    fun editMessage(messageId: Int, editMessage: Message): Boolean{
        for (chat in chatsList) {
            for ((index,message) in chat.mutableList.withIndex()){
                if (message.id == messageId) {
                    val newMessage = editMessage.copy(id = message.id)
                    chat.mutableList.set(index, newMessage)
                    return true

                }
            }
        }
        return false
    }
    fun displayAllMessages(){
        for (chat in chatsList){
            for (message in chat.mutableList){
                println(message)
            }
        }
    }
    fun deleteMessage(messageId: Int){
        for (chat in chatsList){
            chat.mutableList.removeAll { it.id ==messageId }
        }
        //chatsList.removeAll { it.mutableList.removeAll { it.id == messageId } }
    }

}

//fun <E> MutableList<E>.contains(index: Int) {
//    if (index == )
//}