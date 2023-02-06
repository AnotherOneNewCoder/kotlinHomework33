package examples

fun main() {
    val list = mutableListOf(
        Post(1, "first post", 0),
        Post(2, "second post", 10),
        Post(3, "third post", 0),
        Post(4, "forth post", 40)
    )
    list.filter { it.likes > 0 }
    list.filterIndexed { _, post -> post.likes > 0 }
}