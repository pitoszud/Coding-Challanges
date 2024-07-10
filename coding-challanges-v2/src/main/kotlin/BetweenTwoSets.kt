import kotlin.math.max

fun main() {
    val a = arrayOf(2, 6)
    val b = arrayOf(24, 36)
    val t = getTotalX(a, b)
    println(t)
}


fun getTotalX(a: Array<Int>, b: Array<Int>): Int {
    val largest = (a + b).maxOrNull() ?: 0
    val foundNumbers = mutableListOf<Int>()
    (1..largest).forEach { i ->
        if (a.all { i % it == 0 } && b.all { it % i == 0 }) {
            foundNumbers.add(i)
        }
    }
    foundNumbers.forEach {
        println(it)
    }
    return foundNumbers.size
}

fun lcm(a: Int, b: Int): Int {
    var larger = a.coerceAtLeast(b)
    var smaller = a.coerceAtMost(b)
    while (smaller != 0) {
        val temp = larger % smaller
        larger = smaller
        smaller = temp
    }
    return a * b / larger // GCD * LCM = a * b
}
