
import org.junit.Test
import kotlin.test.assertTrue

class GameOfLifeTest {

    @Test
    fun `build grid`() {
        val gameOfLife = GameOfLife(5, 5)
        gameOfLife.updateCell(0, 0, true)
        gameOfLife.updateCell(1, 0, true)
        assertTrue(gameOfLife.getCell(0, 0))
        assertTrue(gameOfLife.getCell(1, 0))
    }





}