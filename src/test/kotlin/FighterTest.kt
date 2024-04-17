import abstract.Fighter
import enum.Bless
import org.junit.Test
import org.junit.Before
import org.junit.After
import org.junit.Assert.*
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import kotlin.test.Ignore

class FighterTest {
    private val originalOut = System.out
    private val outContent = ByteArrayOutputStream()
    private lateinit var fighter: Fighter
    private lateinit var opponent: Fighter

    @Before
    fun setUp() {
        System.setOut(PrintStream(outContent))
        fighter = mock(Fighter::class.java)
        opponent = mock(Fighter::class.java)
    }

    @After
    fun tearDown() {
        System.setOut(originalOut)
    }

    @Test
    @Ignore
    fun testAttackWithExodiaBless() {
        `when`(fighter.bless).thenReturn(Bless.EXODIA)
        fighter.attack(opponent)
        // Verifică output-ul specific pentru EXODIA
        assertTrue("Expected output to contain 'Exodia effect'", outContent.toString().contains("Exodia effect"))
    }

    @Test
    @Ignore
    fun testAttackWithoutExodiaBless() {
        `when`(fighter.bless).thenReturn(Bless.NONE)
        fighter.attack(opponent)
        // Verifică output-ul standard
        assertFalse("Expected output not to contain 'Exodia effect'", outContent.toString().contains("Exodia effect"))
    }
}
