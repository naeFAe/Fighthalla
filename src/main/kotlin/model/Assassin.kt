/*
package model

import abstract.Fighter
import abstract.Rogue
import abstract.Warrior
import enum.Bless

data class Assassin(
    override var name: String,
    override var armor: Int,
    override var strength: Int,
    override var agility: Int
) : Fighter(
    name
), Rogue, Warrior {
    override val healthPointsMultiplier = 0.85
    override val staminaPointsMultiplier = 1.1
    override val strengthMultiplier = 1.625
    override val agilityMultiplier = 1.625

    override val basicAttackName = "swing with the dagger"
    override val specialAttackName = "stab in the back"
    override val ultimateAttackName = "storm of knives"

    override var damageTaken: Int = 0
    override var bless: Bless = Bless.NONE

    init {
        healthPoints = (healthPoints * healthPointsMultiplier).toInt()
        staminaPoints = (staminaPoints * staminaPointsMultiplier).toInt()
        agility = (agility * agilityMultiplier).toInt()
    }

    companion object {
        fun getFighter(name: String): Fighter {
            return Assassin(name, 1, 1, 1)
        }
    }

    override fun warriorSkill() {
        TODO("Not yet implemented")
    }

    override fun rogueSkill() {
        TODO("Not yet implemented")
    }
}*/
