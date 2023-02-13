package chatAndMessage

 data class Message  (

     var text: String,
     var deleted: Boolean = false,
     var read: Boolean = false,
     val messageId: Int = 0)
 {



    override fun toString(): String {

        return "Id: $messageId, text: $text, read: $read, deleted: $deleted"
   }
}