package examples

data class Location(val lat: Double, val lon: Double)
infix fun Double.x(that: Double) = Location(this, that)
operator fun Location.plus(other: Location) = Location(lat = lat + other.lat, lon = lon + other.lon)


fun main() {
    val position = 55.7522 x  37.6133
    val result = position + Location(1.00, 1.00)
    println(result)

}