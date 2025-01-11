import array.isWithinDistance
import array.pickingNumbers
import org.junit.Assert
import org.junit.Test

class HackerRankTest {

    @Test
    fun `picking numbers testA`() {
        val a1 = arrayOf(1, 1, 2, 2, 4, 4, 5, 5, 5)
        val longest1 = pickingNumbers(a1)
        Assert.assertEquals(5, longest1)
    }

    @Test
    fun `pick numbers testB`() {
        val a2 = arrayOf(4, 6, 5, 3, 3, 1)
        // 1, 3, 3, 4, 5, 6
        val longest2 = pickingNumbers(a2) // 4, 3, 3
        Assert.assertEquals(3, longest2)
    }

    @Test
    fun `pick numbers testC`() {
        val a3 = arrayOf(1, 2, 2, 3, 1, 2)
        val longest3 = pickingNumbers(a3) // 1, 2, 2, 1, 2
        Assert.assertEquals(5, longest3)
    }

    @Test
    fun `distance between numbers`() {
        val a4 = listOf(4, 3, 3, 4, 5)
        val result = isWithinDistance(a4, 1)
        Assert.assertEquals(false, result)
    }

}