fun main() {

    val max = getMoneySpent(
        keyboards = arrayOf(3, 1),
        drives = arrayOf(5, 2, 8),
        b = 10
    )
    println(max)
}


fun getMoneySpent(keyboards: Array<Int>, drives: Array<Int>, b: Int): Int {
    var max = 0
    keyboards.forEach { k ->
        drives.forEach { d ->
            val sum = k + d
            if (sum in (max + 1)..b) {
                max = k + d
            }
        }
    }
    return if (max == 0) -1 else max

}