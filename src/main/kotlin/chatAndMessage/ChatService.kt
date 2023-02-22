package chatAndMessage

import examples.swap


object ChatService {

    private val chats = mutableMapOf<Int, DirectMessages>()
    var idMessages = 0



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

    fun editMessage(editMessageId: Int, editMessage: Message): Boolean {
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
            .asSequence()
            .drop(messagesLastId)
            .take(count)
            .ifEmpty { throw NoSuchMessageException() }
            .toList()
        chat2.forEach{it.read = true}
        return chat2

    }
    fun displayChatTextUnreadMessages(chatId: Int, count: Int): String{
        val chat = chats[chatId] ?: throw NoSuchChatException()
        val chat2 = chat.messeges.filter { !it.deleted && !it.read }
            .asSequence()
            .take(count)
            .ifEmpty { throw NoSuchMessageException() }
            .joinToString("\n") { it.text }
        return chat2
    }



}
class NoSuchChatException : Exception()
class NoSuchMessageException : Exception()

