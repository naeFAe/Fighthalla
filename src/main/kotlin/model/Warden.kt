package model

import abstract.Fighter
import abstract.Paladin
import abstract.Rogue
import enum.Bless

data class Warden(
    override var name: String,
    override var armor: Int,
    override var strength: Int,
    override var agility: Int
) : Fighter(
    name
), Paladin, Rogue {
    override val healthPointsMultiplier = 1.0
    override val staminaPointsMultiplier = 1.0
    override val armorMultiplier = 1.5
    override val agilityMultiplier = 1.5

    override val basicAttackName = "crossbow hit"
    override val specialAttackName = "triple shot"
    override val ultimateAttackName = "whale killer"

    override var damageTaken: Int = 0
    override var bless: Bless = Bless.NONE

    init {
        healthPoints = (healthPoints * healthPointsMultiplier).toInt()
        staminaPoints = (staminaPoints * staminaPointsMultiplier).toInt()
        agility = (agility * agilityMultiplier).toInt()
        armor = (armor * armorMultiplier).toInt()
    }

    companion object {
        fun getFighter(name: String): Fighter {
            return Warden(name, 1, 1, 1)
        }
    }

    override fun paladinSkill() {
        TODO("Not yet implemented")
    }

    override fun rogueSkill() {
        TODO("Not yet implemented")
    }
}