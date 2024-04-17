import controller.InputController
import org.junit.Test
import java.io.ByteArrayInputStream
import kotlin.test.assertEquals

class InputControllerTest {

    @Test
    fun testGetOptionValidInput() {
        val input = ByteArrayInputStream("1\n".toByteArray())
        System.setIn(input)
        val option = InputController.getOption(3)
        assertEquals(1, option, "Should return valid option")
    }

    @Test
    fun testGetOptionInvalidInputThenValidInput() {
        val input = ByteArrayInputStream("invalid\n4\n2\n".toByteArray())
        System.setIn(input)
        val option = InputController.getOption(3)
        assertEquals(2, option, "Should return valid option after invalid input")
    }

    //Clase de echivalență și Valori de frontieră: Testăm cu input valid și cu input care nu este un număr, urmat de un număr în afara opțiunilor valide, și apoi cu un număr valid.
    //Acoperire: Acoperirea instrucțiunii și a deciziilor este realizată prin verificarea ramurilor de eroare și succes.
    @Test
    fun testGetNameValidInput() {
        val input = ByteArrayInputStream("John\n".toByteArray())
        System.setIn(input)
        val name = InputController.getName()
        assertEquals("John", name, "Should return valid name")
    }

    @Test
    fun testGetNameInvalidInputThenValidInput() {
        val input = ByteArrayInputStream("jo\nJohn\n".toByteArray())
        System.setIn(input)
        val name = InputController.getName()
        assertEquals("John", name, "Should return valid name after invalid input")
    }

//    Clase de echivalență și Valori de frontieră: Testăm cu un nume valid, un nume prea scurt și un nume care nu începe cu literă mare.
//    Acoperire: Asigurăm că toate cazurile de validare sunt testate.

}
