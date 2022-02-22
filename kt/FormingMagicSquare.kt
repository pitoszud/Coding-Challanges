
fun main(args: Array<String>) {
    val mb = arrayOf(arrayOf(5,3,4), arrayOf(1,5,8), arrayOf(6,4,2))
    val result = formingMagicSquare(mb) == (abs(5-8) + abs(8-9) + abs(4-7))
    println(result)
}


fun formingMagicSquare(mb: Array<Array<Int>>): Int {
    val p = arrayOf(
        arrayOf(intArrayOf(8, 1, 6), intArrayOf(3, 5, 7), intArrayOf(4, 9, 2)),
        arrayOf(intArrayOf(6, 1, 8), intArrayOf(7, 5, 3), intArrayOf(2, 9, 4)),
        arrayOf(intArrayOf(8, 3, 4), intArrayOf(1, 5, 9), intArrayOf(6, 7, 2)),
        arrayOf(intArrayOf(6, 7, 2), intArrayOf(1, 5, 9), intArrayOf(8, 3, 4)),
        arrayOf(intArrayOf(4, 9, 2), intArrayOf(3, 5, 7), intArrayOf(8, 1, 6)),
        arrayOf(intArrayOf(2, 9, 4), intArrayOf(7, 5, 3), intArrayOf(6, 1, 8)),
        arrayOf(intArrayOf(2, 7, 6), intArrayOf(9, 5, 1), intArrayOf(4, 3, 8)),
        arrayOf(intArrayOf(4, 3, 8), intArrayOf(9, 5, 1), intArrayOf(2, 7, 6))
    )
    var min = 100
    for (i in 0..7) {
        var diff = 0
        for (x in 0..2) {
            for (y in 0..2) {
                diff += abs(p[i][x][y] - mb[x][y])
            }
        }
        if (diff < min) min = diff
    }
    return min
}