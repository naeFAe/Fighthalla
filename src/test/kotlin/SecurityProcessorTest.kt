import io.mockk.every
import io.mockk.mockkStatic
import io.mockk.slot
import io.mockk.unmockkAll
import model.SecurityProcessor
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class SecurityProcessorTest {

    @AfterEach
    fun tearDown() {
        unmockkAll() // Clears all mocks to avoid state leakage
    }

    @Test
    fun testCheckPassword() {
        mockkStatic("kotlin.io.ConsoleKt")

        every { readLine() } returnsMany listOf("weak", "Weak123", "KotlinSecure123!")

        val output = mutableListOf<String>()
        mockkStatic("kotlin.ConsoleKt") {
            every { println(capture(slot<String>())) } answers { output.add(firstArg()) }
            val securityProcessor = SecurityProcessor()
            securityProcessor.checkPassword()
        }

        assertEquals(listOf(
            "Please enter your password (you have 3 attempts, password must include a number, an uppercase letter, and a special character):",
            "Password must be at least 8 characters long.",
            "Incorrect password. Please try again.",
            "2 attempts left.",
            "Password must contain at least one number, one uppercase letter, and one special character.",
            "Incorrect password. Please try again.",
            "1 attempts left.",
            "Password correct!"
        ), output)
    }
}