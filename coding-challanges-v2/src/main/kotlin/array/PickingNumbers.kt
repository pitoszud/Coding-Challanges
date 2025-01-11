package array

import kotlin.math.abs


fun main() {
    val a = arrayOf(1, 1, 2, 2, 4, 4, 5, 5, 5)
    val longest = pickingNumbers(a)
    println(longest)
}

// 4 6 5 3 3 1 => 3
// 1 2 2 3 1 2 => 5


fun pickingNumbers(a: Array<Int>): Int {
    val t = IntArray(101) {0}
    a.forEach { t[it] ++ }
    var max = 1
    for(i in 1 until t.size) {
        max = max.coerceAtLeast(t[i] + t[i - 1])
    }
    return max
}




fun isWithinDistance(numbers: List<Int>, distance: Int): Boolean {
    for (i in numbers.indices) {
        for (j in i + 1 until numbers.size) {
            println("i: $i (${numbers[i]}), j: $j (${numbers[j]})")
            val diff = abs(numbers[i] - numbers[j])
            println("diff: $diff")
            println("----------------")
            if (diff > distance) return false
        }
    }
    return true
}