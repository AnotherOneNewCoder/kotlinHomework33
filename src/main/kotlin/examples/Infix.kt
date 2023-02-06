data class Location(val lat: Double, val lon: Double)
infix fun Double.x(that: Double) = Location(this, that)


fun main() {
    val position = 55.7522 to 37.6133
    val position2 = 55.7522 x  37.6133
    println(position)
    println(position2)
}