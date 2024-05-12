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
        assertTrue(output.contains("Password correct!"), "Expected output to confirm correct password")
    }

    @Test
    fun testPasswordWithSpecialCharacters() {
        every { inputReader.readLine() } returns "Abcde#123"
        securityProcessor.checkPassword()
        val output = outputStreamCaptor.toString()
        assertTrue(output.contains("Incorrect password. Please try again."), "Expected output for incorrect password with valid format")
    }

    @Test
    fun testPasswordWithNoSpecialCharacter() {
        every { inputReader.readLine() } returns "Abcde1234"
        securityProcessor.checkPassword()
        val output = outputStreamCaptor.toString()
        assertTrue(output.contains("Password must contain at least one number, one uppercase letter, and one special character."), "Expected specific validation error for missing special character")
    }

    @Test
    fun testInvalidPasswordFormat() {
        every { inputReader.readLine() } returns "short"
        securityProcessor.checkPassword()
        val output = outputStreamCaptor.toString()
        assertTrue(output.contains("Password must be at least 8 characters long"), "Expected output to indicate password length error")
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
}



