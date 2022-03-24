package model

import abstract.Fighter
import abstract.Rogue
import enum.Bless

data class Archer(
    override var name: String,
    override var armor: Int,
    override var strength: Int,
    override var agility: Int
) : Fighter(
    name
), Rogue {
    override val healthPointsMultiplier = 0.8
    override val staminaPointsMultiplier = 1.4
    override val agilityMultiplier = 2.0

    override val basicAttackName = "quick shot"
    override val specialAttackName = "empowered shot"
    override val ultimateAttackName = "rain of arrows"

    override var damageTaken: Int = 0
    override var bless: Bless = Bless.NONE

    init {
        healthPoints = (healthPoints * healthPointsMultiplier).toInt()
        staminaPoints = (staminaPoints * staminaPointsMultiplier).toInt()
        agility = (agility * agilityMultiplier).toInt()
    }

    companion object {
        fun getFighter(name: String): Fighter {
            return Archer(name, 1, 1, 1)
        }
    }

    override fun rogueSkill() {
        TODO("Not yet implemented")
    }

    override fun toString(): String {
        return ""
    }
}