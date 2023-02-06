package chatAndMessage

data class Message (var id: Int, var read: Boolean, val recieved: Boolean) {
    override fun toString(): String {
        return "Id: $id, read: $read, recieved: $recieved"
    }
}