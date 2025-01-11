import array.isWithinDistance
import array.pickingNumbers
import implementation.DayOfProgrammer
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class DayOfProgrammerTest {

    lateinit var dayOfProgrammer: DayOfProgrammer

    @Before
    fun setUp() {
        dayOfProgrammer = DayOfProgrammer()
    }

    @Test
    fun testLeapYear() {
        val result1 = dayOfProgrammer.dayOfProgrammer(1984)
        Assert.assertEquals("12.09.1984", result1)

        val result2 = dayOfProgrammer.dayOfProgrammer(1704)
        Assert.assertEquals("12.09.1704", result2)

        val result3 = dayOfProgrammer.dayOfProgrammer(1800)
        Assert.assertEquals("12.09.1800", result3)
    }

    @Test
    fun testNonLeapYear() {
        val result1 = dayOfProgrammer.dayOfProgrammer(2017)
        Assert.assertEquals("13.09.2017", result1)

        val result2 = dayOfProgrammer.dayOfProgrammer(2018)
        Assert.assertEquals("13.09.2018", result2)

        val result3 = dayOfProgrammer.dayOfProgrammer(2100)
        Assert.assertEquals("13.09.2100", result3)
    }

}