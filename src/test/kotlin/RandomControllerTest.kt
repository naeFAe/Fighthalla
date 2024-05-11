/*
import abstract.Fighter
import controller.RandomController
import org.junit.Test
import org.mockito.Mockito
import kotlin.test.assertTrue

class RandomControllerTest {

    @Test
    fun testIsStartingReturnsTrue() {
        val wasStarting = mutableListOf<Boolean>()

        repeat(100) {
            wasStarting.add(RandomController.isStarting())
        }

        assertTrue(wasStarting.contains(true), "Expected isStarting to return true at least once")
    }

    @Test
    fun testDodgeWithLowAgility() {
        val fighter = Mockito.mock(Fighter::class.java)
        Mockito.`when`(fighter.agility).thenReturn(1)
        val dodges = (1..100).map { RandomController.dodge(fighter) }
        assertTrue(dodges.contains(false), "Expected dodge to fail with low agility")
    }

//    Explicații
//    Clase de echivalență: Avem două clase aici - metoda returnează true și false.
//    Valori de frontieră: Nu sunt aplicabile direct aici, deoarece metoda este bazată pe un apel random.
//    Acoperire: Aceste teste asigură că ambele căi ale metodei sunt testate (returnarea true și false).
    @Test
    fun testDodgeWithHighAgility() {
        val fighter = Mockito.mock(Fighter::class.java)
        Mockito.`when`(fighter.agility).thenReturn(10)
        val dodges = (1..100).map { RandomController.dodge(fighter) }
        assertTrue(dodges.contains(true), "Expected dodge to succeed with high agility")
    }

    @Test
    fun testIsStartingReturnsFalse() {
        val wasNotStarting = mutableListOf<Boolean>()

        repeat(100) {
            wasNotStarting.add(!RandomController.isStarting())
        }

        assertTrue(wasNotStarting.contains(true), "Expected isStarting to return false at least once")
    }
//    Clase de echivalență și Valori de frontieră: Testăm cu putere scăzută și înaltă.
//    Acoperire: Acoperire completă a deciziilor și condițiilor.
    @Test
    fun testBlockWithLowArmor() {
        val fighter = Mockito.mock(Fighter::class.java)
        Mockito.`when`(fighter.armor).thenReturn(1)
        val blocks = (1..100).map { RandomController.block(fighter) }
        assertTrue(blocks.contains(false), "Expected block to fail with low armor")
}

    @Test
    fun testBlockWithHighArmor() {
        val fighter = Mockito.mock(Fighter::class.java)
        Mockito.`when`(fighter.armor).thenReturn(10)
        val blocks = (1..100).map { RandomController.block(fighter) }
        assertTrue(blocks.contains(true), "Expected block to succeed with high armor")
    }

//    Clase de echivalență și Valori de frontieră: Similar cu dodge, testăm extreme pentru armură.
//    Acoperire: Asigurăm că ambele rezultate posibile ale metodei sunt generate.

    @Test
    fun testCounterWithLowStrength() {
        val fighter = Mockito.mock(Fighter::class.java)
        Mockito.`when`(fighter.strength).thenReturn(1)
        val counters = (1..100).map { RandomController.counter(fighter) }
        assertTrue(counters.contains(false), "Expected counter to fail with low strength")
    }

    @Test
    fun testCounterWithHighStrength() {
        val fighter = Mockito.mock(Fighter::class.java)
        Mockito.`when`(fighter.strength).thenReturn(10)
        val counters = (1..100).map { RandomController.counter(fighter) }
        assertTrue(counters.contains(true), "Expected counter to succeed with high strength")
    }

//    Clase de echivalență și Valori de frontieră: Testăm cu putere scăzută și înaltă.
//    Acoperire: Acoperire completă a deciziilor și condițiilor.
}
*/
