import chatAndMessage.ChatService
import chatAndMessage.Message

fun main() {
    /*Должны быть чаты. Чат — это общение с одним человеком, так называемые direct messages.
    Можно создавать чаты, удалять их, получать список имеющихся чатов.
    В каждом чате есть сообщения от 1 до нескольких (см. раздел ниже).
    Можно создавать сообщения, редактировать их и удалять. Для простоты — можно удалять и свои, и чужие.
    В каждом чате есть прочитанные и непрочитанные сообщения
    Возможности для пользователя:
    Видеть, сколько чатов не прочитано (например, service.getUnreadChatsCount). В каждом из таких чатов есть хотя бы одно непрочитанное сообщение.
    Получить список чатов (например, service.getChats), где в каждом есть последнее сообщение. Если нет, то пишется «нет сообщений».
    Получить список сообщений из чата, указав:
        ID чата;
        ID последнего сообщения, начиная с которого нужно подгрузить более новые;
        количество сообщений. После того как вызвана эта функция, все отданные сообщения автоматически считаются прочитанными.
    Создать новое сообщение.
    Удалить сообщение. При удалении последнего сообщения в чате весь чат удаляется.
    Создать чат. Чат создаётся, когда пользователю отправляется первое сообщение.
    Удалить чат, т. е. целиком удалить всю переписку.

Важный момент: чтобы отделять одного пользователя от другого, передавайте во все функции первым параметром id пользователя. Например, service.getChats(999) — все чаты для пользователя с id=999.

Старайтесь использовать lambda-функции (их напишите сами) и extension-функции (есть в составе Iterable, Collection, List).

Расчёт статистики старайтесь производить как цепочку вызовов lambda-функций. Попробуйте обойтись без for, while и do-while.
     */
    ChatService.createChat(1, Message(1,false,true))
    ChatService.createChat(2, Message(1,false,true))
    ChatService.createChat(3, Message(1,false,true))
    println(ChatService.getChats())
    //ChatService.deleteAllChats()
    ChatService.deleteChat(2)
    ChatService.newMessage(2, Message(56, true,true))
    ChatService.newMessage(1, Message(56, true,true))
    ChatService.newMessage(1, Message(56, true,true))
    ChatService.newMessage(1, Message(56, true,true))
    ChatService.newMessage(1, Message(56, true,true))
    ChatService.newMessage(1, Message(56, true,true))
    println(ChatService.getChats())
    ChatService.displayAllMessages()
    ChatService.deleteMessage(8)
    println()
    ChatService.displayAllMessages()




}