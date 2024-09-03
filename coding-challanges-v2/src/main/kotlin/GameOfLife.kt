

class GameOfLife(private val width: Int, private val height: Int) {

    private var grid: Array<BooleanArray> = arrayOf(booleanArrayOf())

    init {
        grid = Array(width) { BooleanArray(height) { false } }
    }


    fun updateCell(x: Int, y: Int, alive: Boolean) {
        grid.getOrNull(y)?.let { row ->
            if (x in row.indices) {
                row[x] = alive
            }
        }
    }


    fun getCell(x: Int, y: Int): Boolean {
        display()
        return grid.getOrNull(y)?.getOrNull(x) ?: false
    }


    private fun display() {
        for (row in grid) {
            for (cell in row) {
                print(if (cell) "1 " else "0 ")
            }
            println()
        }
    }

    fun shouldBeAlive(x: Int, y: Int): Boolean {
        val neighbours = listOf(
            Pair(x - 1, y - 1), Pair(x, y - 1), Pair(x + 1, y - 1),
            Pair(x - 1, y), /* Current Cell */ Pair(x + 1, y),
            Pair(x - 1, y + 1), Pair(x, y + 1), Pair(x + 1, y + 1)
        )

        val aliveNeighbours = neighbours.count { (nx, ny) ->
            grid.getOrNull(ny)?.getOrNull(nx) ?: false
        }

        return aliveNeighbours in 2..3

    }


}





