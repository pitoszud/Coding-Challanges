package codingInterview

import com.sun.org.apache.xpath.internal.operations.Bool
import org.junit.Assert.*
import org.hamcrest.CoreMatchers.*
import org.junit.Assert.assertThat

class CountingVallyesTest {

    var SUT: CountingVallyes? = null

    @org.junit.Before
    fun setUp() {
        SUT = CountingVallyes()
    }

    @org.junit.Test
    fun match_leftEdge_true() {
        val match: Boolean = SUT!!.matchConstraints(2, "U")
        assertThat(match, `is`(true))
    }


    @org.junit.Test
    fun match_rightEdge_true() {
        val match: Boolean = SUT!!.matchConstraints(1000000, "D")
        assertThat(match, `is`(true))
    }

    @org.junit.Test
    fun match_overEdge_true() {
        val match: Boolean = SUT!!.matchConstraints(10000000, "D")
        assertThat(match, `is`(false))
    }


    @org.junit.Test
    fun match_diffLetter_true() {
        val match: Boolean = SUT!!.matchConstraints(1000000, "P")
        assertThat(match, `is`(false))
    }
}