import junit.framework.TestCase.*
import model.AdvancedProcessor
import org.junit.Assert.assertThrows
import org.junit.Test
import org.junit.jupiter.api.assertThrows

class AdvancedProcessorTest {
    private val processor = AdvancedProcessor()

    @Test
    fun testAnalyzeNumber() {
        assertEquals("Negative", processor.analyzeNumber(-5))
        assertEquals("Zero", processor.analyzeNumber(0))
        assertEquals("Small Positive", processor.analyzeNumber(5))
        assertEquals("Medium Positive", processor.analyzeNumber(50))
        assertEquals("Large Positive", processor.analyzeNumber(500))
    }

    @Test
    fun testValidateUserInput() {
        assertThrows<IllegalArgumentException> { processor.validateUserInput(null) }
        assertThrows<IllegalArgumentException> { processor.validateUserInput("") }
        assertFalse(processor.validateUserInput("abc"))
        assertTrue(processor.validateUserInput("abcde"))
    }

    @Test
    fun testCalculateDiscount() {
        assertEquals(25.0, processor.calculateDiscount(100.0, "Winter", true))
        assertEquals(15.0, processor.calculateDiscount(100.0, "Winter", false))
        assertEquals(20.0, processor.calculateDiscount(100.0, "Summer", true))
        assertEquals(10.0, processor.calculateDiscount(100.0, "Summer", false))
        assertThrows<IllegalArgumentException> { processor.calculateDiscount(-100.0, "Summer", true) }
    }

}