import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import java.util.*
import kotlin.random.Random

fun main() {
    fizzBuzz(20)
}


fun fizzBuzz(n: Int): List<String> {
    val resL = mutableListOf<String>()
    for (i in 1..n) {
        val d3 = i % 3
        val d5 = i % 5
        val r = when {
            d3 == 0 && d5 == 0 -> "FizzBuzz"
            d3 == 0 && d5 != 0 -> "Fizz"
            d3 != 0 && d5 == 0 -> "Buzz"
            else -> "$i"
        }
        resL.add(r)
    }
    return resL
}






