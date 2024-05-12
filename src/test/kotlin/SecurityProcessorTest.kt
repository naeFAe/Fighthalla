import io.mockk.every
import io.mockk.mockk
import model.InputReader
import model.SecurityProcessor
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import org.junit.Before
import org.junit.After
import org.junit.Test
import kotlin.test.assertTrue
import kotlin.test.assertFalse
import kotlin.test.assertFailsWith

class SecurityProcessorTest {

    private lateinit var inputReader: InputReader
    private lateinit var securityProcessor: SecurityProcessor
    private val originalOut = System.out
    private val outputStreamCaptor = ByteArrayOutputStream()

    @Before
    fun setup() {
        inputReader = mockk(relaxed = true)
        securityProcessor = SecurityProcessor(inputReader)
        System.setOut(PrintStream(outputStreamCaptor))  // Redirect System.out to capture output
    }

    @After
    fun tearDown() {
        System.setOut(originalOut)  // Restore original System out
    }

    @Test
    fun testValidPassword() {
        every { inputReader.readLine() } returns "KotlinSecure123!"
        securityProcessor.checkPassword()
        val output = outputStreamCaptor.toString()
        assertTrue(output.contains("Password correct!"), "Expected output" +
                " to confirm correct password")
    }

    @Test
    fun testInvalidPasswordFormat() {
        every { inputReader.readLine() } returns "short"
        securityProcessor.checkPassword()
        val output = outputStreamCaptor.toString()
        assertTrue(output.contains("Password must be at least 8 characters long"),
            "Expected output to indicate password length error")
    }

    @Test
    fun testPasswordWithSpecialCharacters() {
        every { inputReader.readLine() } returns "Abcde#123"
        securityProcessor.checkPassword()
        val output = outputStreamCaptor.toString()
        assertTrue(output.contains("Incorrect password. Please try again."),
            "Expected output for incorrect password with valid format")
    }

    @Test
    fun testPasswordWithNoSpecialCharacter() {
        every { inputReader.readLine() } returns "Abcde1234"
        securityProcessor.checkPassword()
        val output = outputStreamCaptor.toString()
        assertTrue(output.contains("Password must contain at least one number, " +
                "one uppercase letter, and one special character."),
            "Expected specific validation error for missing special character")
    }

    @Test
    fun testInvalidPasswordThreeTimes() {
        every { inputReader.readLine() } returnsMany listOf("short", "noNumber", "noSpecialChar123")
        securityProcessor.checkPassword()
        val output = outputStreamCaptor.toString()
        assertTrue(output.contains("Maximum attempt limit reached. Access denied."), "Expected output to confirm access denial after maximum attempts")
    }

    @Test
    fun testBoundaryAttemptLimit() {
        every { inputReader.readLine() } returnsMany listOf("wrong1", "wrong2", "KotlinSecure123!")
        securityProcessor.checkPassword()
        val output = outputStreamCaptor.toString()
        assertTrue(output.contains("Password correct!"), "Expected output to confirm correct password on last attempt")
    }

    @Test
    fun testExceededAttemptBoundary() {
        // Assume attemptCount might be modified unexpectedly
        every { inputReader.readLine() } returns "wrongPassword"
        repeat(4) { securityProcessor.checkPassword() } // Exceeding attempts more than maxAttempts to trigger boundary condition
        val output = outputStreamCaptor.toString()
        assertTrue(output.contains("Maximum attempt limit reached. Access denied."), "Expected output when max attempts are exceeded initially")
    }

    @Test
    fun testValidatePasswordBoundary() {
        every { inputReader.readLine() } returns "A1#aaaaa" // exactly 8 characters, valid case
        securityProcessor.checkPassword()
        val output = outputStreamCaptor.toString()
        assertTrue(output.contains("Incorrect password. Please try again."), "Expected output for boundary password length")
    }

    @Test
    fun testFalseReturnMutations() {
        every { inputReader.readLine() } returns "Short1#"
        securityProcessor.checkPassword()
        val output = outputStreamCaptor.toString()
        assertTrue(output.contains("Password must be at least 8 characters long"), "Expected validation failure on mutated true to false return")
    }

    @Test
    fun testIsMaxAttemptReachedWithInvalidInput() {
        assertFailsWith<IllegalArgumentException> {
            securityProcessor.isMaxAttemptReached(-1, 3)
        }
        assertFailsWith<IllegalArgumentException> {
            securityProcessor.isMaxAttemptReached(1, 0)
        }
    }

    @Test
    fun testIsMaxAttemptReached() {
        assertFalse(securityProcessor.isMaxAttemptReached(1, 3))
        assertTrue(securityProcessor.isMaxAttemptReached(3, 3))
        assertTrue(securityProcessor.isMaxAttemptReached(4, 3))
    }


}



