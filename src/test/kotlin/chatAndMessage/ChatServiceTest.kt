package chatAndMessage

import org.junit.Test

import org.junit.Assert.*

class ChatServiceTest {
    val mess1 = Message("first")
    val mess2 = Message("second", true)
    val mess3 = Message("third", false, true)
    val mess4 = Message("fourth", true)

    @Test
    fun getChatsListDeleted() {
        ChatService.deleteChat(1)
        ChatService.add(1, mess2)
        val result = ChatService.getChatsList().toString()
        val expect = "[No messages]"
        assertEquals(expect,result)
    }
    @Test
    fun getChatsListNotDeleted() {
        ChatService.add(1, mess1)
        val result = ChatService.getChatsList().toString()
        val expect = "[first]"
        assertEquals(expect,result)
    }


    @Test(expected = NoSuchChatException::class)
    fun getChatMessagesException() {
        val service = ChatService
        service.getChatMessages(22, 11)
    }
    @Test
    fun getChatMessages() {
        val service = ChatService
        service.add(4, mess1)
        service.add(4, mess2)
        service.add(4, mess3)
        service.add(4, mess4)
        val result = service.getChatMessages(4, 4).toString()
        val expected = "[Id: 3, text: first, read: false, deleted: false, Id: 5, text: third, read: true, deleted: false]"
        assertEquals(expected, result)
    }

    @Test
    fun deleteChat() {
    }

    @Test
    fun editMessage1() {
    }

    @Test
    fun displayAllMessages() {
    }

    @Test
    fun deleteMessage() {
    }

    @Test
    fun getMessages() {
    }
}