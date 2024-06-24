fun main() {
    val s = listOf(1, 2, 1, 3, 2)
    val d = 3
    val m = 2
    val result = birthday(s, d, m)
    println(result)


    val s2 = listOf(2, 2, 1, 3, 2)
    val d2 = 4
    val m2 = 2
    val result2 = birthday(s2, d2, m2)
    println(result2)

    val s3 = listOf(1, 1, 1, 1, 1, 1)
    val d3 = 3
    val m3 = 2
    val result3 = birthday(s3, d3, m3)
    println(result3)

    val s4 = listOf(1, 2, 1, 3, 2)
    val d4 = 3
    val m4 = 2
    val result4 = birthday(s4, d4, m4)
    println(result4)
}

fun birthday(s: List<Int>, d: Int, m: Int): Int {
    var count = 0
    s.forEachIndexed { i, n ->
        if (s.size - i < m) {
            return@forEachIndexed
        }
        //val f = s.subList(i, i + m).sum()
        var f = 0
        for (j in i until i + m) {
            f += s[j]
        }
        if (f == d) {
            count++
        }
    }
    return count
}


