/*
import abstract.Fighter
import enum.Bless
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class FighterClassTest {
    private lateinit var fighter: Fighter

    @Before
    fun setUp() {
        fighter = mock(Fighter::class.java).apply {
            `when`(armor).thenReturn(100)
            `when`(strength).thenReturn(100)
            `when`(agility).thenReturn(100)
            `when`(isUltimateAvailable).thenReturn(false)
        }
    }

    @Test
    fun testApplyBlessArmor() {
        fighter.applyBless(Bless.ARMOR)
        assertEquals(100, fighter.armor)
    }

    @Test
    fun testApplyBlessStrength() {
        fighter.applyBless(Bless.STRENGTH)
        assertEquals(100, fighter.strength)
    }

    @Test
    fun testApplyBlessAgility() {
        fighter.applyBless(Bless.AGILITY)
        assertEquals(100, fighter.agility)
    }

    @Test
    fun testApplyBlessUltimate() {
        fighter.applyBless(Bless.ULTIMATE)
        assertTrue(!fighter.isUltimateAvailable)
    }
}
*/
