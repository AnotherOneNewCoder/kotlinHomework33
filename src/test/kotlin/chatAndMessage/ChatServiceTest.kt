package chatAndMessage

import org.junit.Test

import org.junit.Assert.*

class ChatServiceTest {
    val mess1 = Message("first")
    val mess2 = Message("second", true)
    val mess3 = Message("third", false, true)
    val mess4 = Message("fourth", true)
    val editmess = Message("edit")




    @Test
    fun getChatsListDeleted() {
        ChatService.deleteChat(1)
        ChatService.add(1, mess2)
        val result = ChatService.getChatsList().toString()
        val expect = "[No messages, first, No messages]"
        assertEquals(expect,result)
    }
    @Test
    fun getChatsListNotDeleted() {
        ChatService.add(1, mess1)
        val result = ChatService.getChatsList().toString()
        val expect = "[No messages, first, first]"
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
        val expected = "[Id: 11, text: first, read: false, deleted: false, Id: 13, text: third, read: true, deleted: false]"
        assertEquals(expected, result)
    }

    @Test(expected = NoSuchChatException::class)
    fun deleteChatException() {
        val service = ChatService
        service.deleteChat(66)
    }
    @Test
    fun deleteChat() {
        val service = ChatService
        service.add(15, mess1)
        service.deleteChat(15)
        val result = service.getChatsList().toString()
        val expected = "[No messages, first, No messages, first]"
        assertEquals(expected, result)
    }
    @Test
    fun editMessageDone() {
        val  service = ChatService
        service.add(5, mess1)
        val result = service.editMessage(1, editmess)

        assertTrue(result)
    }
    @Test
    fun editMessageFail() {
        val  service = ChatService
        val result = service.editMessage(111, editmess)

        assertFalse(result)
    }

    @Test
    fun deleteMessageTrue() {
        val service = ChatService
        service.add(4, mess1)
        val result = service.deleteMessage(1)
        assertTrue(result)

    }
    @Test
    fun deleteMessageFalse() {
        val service = ChatService
        val result = service.deleteMessage(1111)
        assertFalse(result)
    }

    @Test(expected = NoSuchMessageException::class)
    fun getMessagesException() {
        val service = ChatService
        service.getMessages(1,1,5)


    }
    @Test
    fun getMessages() {
        val service = ChatService
        service.add(32, mess1)
        service.add(32, mess2)
        service.add(32, mess3)
        service.add(32, mess4)
        service.add(32, mess1)
        val result = service.getMessages(32,1,5).toString()
        val expected = "[Id: 7, text: third, read: true, deleted: false, Id: 9, text: first, read: true, deleted: false]"
        assertEquals(expected, result)
    }

}