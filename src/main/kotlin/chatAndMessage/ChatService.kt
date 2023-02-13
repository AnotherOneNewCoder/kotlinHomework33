package chatAndMessage

import examples.swap


object ChatService {

    private val chats = mutableMapOf<Int, DirectMessages>()
    var idMessages = 0

    class NoSuchChatException : Exception()
    class NoSuchMessageException : Exception()

    fun add(userId: Int, message: Message) {
        val newMess = message.copy(messageId = ++idMessages)
        chats.getOrPut(userId) { DirectMessages() }.messeges.add(newMess)
    }

    fun getChatsList(): List<String> =
        chats.values.map { it.messeges.lastOrNull { message -> !message.deleted }?.text ?: "No messages" }

    fun getChatMessages(userId: Int, count: Int): List<Message> {
        val chat = chats[userId] ?: throw NoSuchChatException()
        return chat.messeges.filter { !it.deleted }.takeLast(count)
    }

    fun deleteChat(userId: Int): DirectMessages? {
        if (chats[userId] == null)
            throw NoSuchChatException()
        else
            return chats.remove(userId)
    }

    //    fun editMessage(editMessageId: Int, editMessage: Message): Boolean {
//        chats.values.map {
//            it.messeges.forEach { message ->
//                if (message.messageId == editMessageId) {
//                    val newM = editMessage.copy(messageId = editMessageId)
//                    //message.copy(text = newM.text, deleted = newM.deleted, messageId = newM.messageId)
//                    // не знаю почему copy() не срабатывает, помогло только изменение с val на var в дата классе Messages
//                    message.text = newM.text
//                    return true
//                }
//            }
//
//        }
//        println("Сообщения с таким ID не найдено!!")
//        return false
//    }
    fun editMessage1(editMessageId: Int, editMessage: Message): Boolean {
        chats.values.map {
            it.messeges.forEach {
                if (it.messageId == editMessageId) {
                    val newMes = editMessage.copy(messageId = editMessageId)
                    //it.copy(text = editMessage.text)
                    it.text = editMessage.text

                    return true
                }
//                    val newM = editMessage.copy(messageId = editMessageId)
//                    //message.copy(text = newM.text, deleted = newM.deleted, messageId = newM.messageId)
//                    // не знаю почему copy() не срабатывает, помогло только изменение с val на var в дата классе Messages
//                    message.text = newM.text

            }
        }


        println("Сообщения с таким ID не найдено!!")
        return false
    }

    fun displayAllMessages() {
        for ((key, value) in chats) {
            print(" $key = $value")

        }
        println()
    }

    fun deleteMessage(delMessageId: Int): Boolean {
        chats.values.map {
            it.messeges.forEach { message ->
                if (message.messageId == delMessageId) {
                    message.deleted = true
                    return true
                }
            }
        }
        return false
    }

    fun getMessages(chatId: Int,messagesLastId: Int, count: Int): List<Message> {

        val chat = chats[chatId] ?: throw NoSuchChatException()
        val chat2 = chat.messeges.filter { !it.deleted} //&& it.messageId >= messagesLastId }
            .drop(messagesLastId)
            .take(count)
            .ifEmpty { throw NoSuchMessageException() }
        chat2.forEach{it.read = true}
        return chat2

    }
}

/*    fun createChat(login: String,message: Message): Boolean {
//        //val predicate = fun (direct: DirectMessages) = direct.id != chatId
//        for (chat in chatsList){
//            if (chat.userLogin == login)
//                return false
//        }
//        val tempList = mutableListOf<Message>()
//        message.id = ++idMessages
//        tempList.add(message)
//
//        chatsList.add(DirectMessages(++user_id, login ,tempList))
//        return true
//    }
//    fun getChats(): String {
//        return chatsList.toString()
//    }
//    fun deleteAllChats(): MutableList<DirectMessages>{
//        chatsList.removeAll { it.userId > 0 }
//        return chatsList
//    }
//    fun deleteChat(uId: Int) : MutableList<DirectMessages> {
//        chatsList.removeAll { it.userId == uId }
//        return chatsList */
//    }
/*    fun newMessage(uId: Int, message: Message):Boolean {
//        for (chat in chatsList) {
//            if (chat.userId == uId) {
//                message.id = ++idMessages
//                chat.mutableList.add(message)
//                return true
//            }
//        }
//        message.id = ++idMessages
//        createChat("Waiting for authorization", message)
//        return true
    }*/
//    fun editMessage(messageId: Int, editMessage: Message): Boolean{
//        for (chat in chatsList) {
//            for ((index,message) in chat.mutableList.withIndex()){
//                if (message.id == messageId) {
//                    editMessage.id = message.id
//                    chat.mutableList.set(index, editMessage)
//                    return true
//
//                }
//            }
//        }
//        return false
//    }
//    fun displayAllMessages(){
//        for (chat in chatsList){
//            for (message in chat.mutableList){
//                println(message)
//            }
//        }
//    }
//    fun deleteMessage(messageId: Int){
//        for (chat in chatsList){
//            chat.mutableList.removeAll { it.id ==messageId }
//        }
//        //chatsList.removeAll { it.mutableList.removeAll { it.id == messageId } }
//    }
//    fun getUnreadChatsCount() : List<DirectMessages>{
//        val unreadChats = mutableListOf<DirectMessages>()
//        for (chat in chatsList) {
//            for (message in chat.mutableList)
//                if (message.read == false)
//                    if (!unreadChats.contains(chat))
//                        unreadChats.add(chat)
//        }
////        val predicate = fun (direct: DirectMessages) = direct.mutableList.filter { it.recieved }
////        val getChats = chatsList.filter(predicate)
//        return unreadChats
//    }
//



//fun <E> MutableList<E>.count(index1: Int, index2: MutableList<T>) {
//    val el1 = get(index1)
//    val el2 = get(index2)
//    this[index1] = el2
//    this[index2] = el1
