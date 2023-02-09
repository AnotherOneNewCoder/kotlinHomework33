package chatAndMessage

 data class Message  (

//     var read: Boolean,
//     var recieved: Boolean
     var text: String,
     val deleted: Boolean = false,
     val messageId: Int = 0)
 {



    override fun toString(): String {

        return "Id: $messageId, text: $text, deleted: $deleted"
   }
}