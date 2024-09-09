import org.junit.Assert.assertFalse
import string.Ghappy
import kotlin.test.Test
import kotlin.test.assertTrue

class StringChallengeTest {
    val ghappy = Ghappy()

    @Test
    fun testGhappy() {
        assertTrue(ghappy.ghappy("xxggxx"))
        assertFalse(ghappy.ghappy("xxgxx"))
        assertFalse(ghappy.ghappy("xxggyygxx"))
        assertFalse(ghappy.ghappy("g"))
        assertFalse(ghappy.ghappy("gxxggyyggxx"))
        assertFalse(ghappy.ghappy("ggxxggyyggxxg"))
        assertTrue(ghappy.ghappy("gg"))
        assertTrue(ghappy.ghappy("xxggxx"))
        assertFalse(ghappy.ghappy("xxgxx"))
        assertFalse(ghappy.ghappy("xxggyygxx"))
        assertTrue(ghappy.ghappy(""))
        assertTrue(ghappy.ghappy("xxgggxyz"))
        assertFalse(ghappy.ghappy("xxgggxyg"))
        assertTrue(ghappy.ghappy("xxgggxygg"))
        assertFalse(ghappy.ghappy("mgm"))
        assertTrue(ghappy.ghappy("mggm"))
        assertTrue(ghappy.ghappy("yyygggxyy"))
    }
}