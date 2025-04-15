package grid

import kotlin.random.Random

fun main() {
    val grid = buildGrid(5, 3)
    printGrid(grid)
    println("--------")
    largestRow(grid.map { it.toIntArray() }.toTypedArray())
    //printGridWithIndices(grid)
//    println("--------")
//    printGridArray(grid)
      println("--------")
      sumRows(grid)
}


fun buildGrid(rows: Int, cols: Int): Array<Array<Int>> {
    val grid: Array<Array<Int>> = Array(rows) { Array(cols) { 0 } }

    for (r in 0 until rows) {
        for (c in 0 until cols) {
            grid[r][c] = Random.nextInt(1, 9)
        }
    }
    return grid
}

// ----- Print -----
fun printGrid(grid: Array<Array<Int>>) {
    for (r in grid) {
        for (c in r) {
            print("$c\t")
        }
        println()
    }
}

fun printGridWithIndices(grid: Array<Array<Int>>) {
    for (r in grid.indices) {
        for (c in grid[r].indices) {
            print("${grid[r][c]}\t")
        }
        println()
    }
}

fun printGridArray(grid: Array<Array<Int>>) {
    print("[")
    for (r in grid.indices) {
        print("[")
        for (c in grid[r].indices) {
            print(grid[r][c])
            if (c != grid[r].lastIndex) print(",")
        }
        print("]")
        if (r != grid.lastIndex) print(",")
    }
    print("]")
}


fun sumRows(grid: Array<Array<Int>>) {
    for (r in grid.indices) {
        var rowSum = 0
        for (c in grid[r].indices) {
            rowSum += grid[r][c]
        }
        println(rowSum)
    }
}

fun largestRow(grid: Array<IntArray>) {
    var largestRow = 0
    for (r in grid.indices) {
        var rowSum = 0
        for (c in grid[r].indices) {
            rowSum += grid[r][c]
        }
        if (largestRow < rowSum) {
            largestRow = rowSum
        }
    }
    println("Largest row is: $largestRow")
}