package examples

import java.util.IdentityHashMap

class Post(val id: Int, val text: String, val likes: Int){
    override fun toString(): String {
        return "Id: $id. Text: $text. Likes: $likes."
    }

}
fun main() {
    val list = mutableListOf(
        Post(1, "first post", 0),
        Post(2, "second post", 10),
        Post(3, "third post", 0),
        Post(4, "forth post", 40)
    )
    val short = ::liked
    val full: (post: Post) -> Boolean = ::liked
    val predicate = fun (post: Post) = post.likes > 0
    val likedList = list.filter(predicate)
    println(likedList)
    println(short(list.first()))
    println(full(list.first()))
}

fun liked(post: Post) = post.likes > 0