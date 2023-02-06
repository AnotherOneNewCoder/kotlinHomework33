package examples

fun main() {
    val list = mutableListOf(1,2,3)
    println(list)
    list.swap(0,2)
    println(list)

    val list2 = mutableListOf("One", "Two", "Three")
    println(list2)
    list2.swap(0,2)
    println(list2)
}

fun <E> MutableList<E>.swap(index1: Int, index2: Int) {
    val el1 = get(index1)
    val el2 = get(index2)
    this[index1] = el2
    this[index2] = el1
}