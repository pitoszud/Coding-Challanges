import implementation.BillDivision
import implementation.DayOfProgrammer
import org.junit.Assert
import org.junit.Before
import org.junit.Test


class BillDivisionTest {

    lateinit var billDivision: BillDivision

    @Before
    fun setup() {
        billDivision = BillDivision()
    }

    @Test
    fun testCorrectlySplitBill() {
        val result = billDivision.bonAppetit(
            bill = arrayOf(3, 10, 2, 9),
            k = 1,
            b = 7
        )
        Assert.assertEquals("Bon Appetit", result)
    }

    @Test
    fun testOverchargedBill() {
        val result = billDivision.bonAppetit(
            bill = arrayOf(3, 10, 2, 9),
            k = 1,
            b = 12
        )
        Assert.assertEquals("5", result)
    }

}