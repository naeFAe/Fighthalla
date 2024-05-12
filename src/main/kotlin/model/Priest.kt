/*
package model

import abstract.Fighter
import abstract.Paladin
import abstract.Warrior
import enum.Bless

data class Priest(
    override var name: String,
    override var armor: Int,
    override var strength: Int,
    override var agility: Int,
) : Fighter(
    name
), Warrior, Paladin {
    override val healthPointsMultiplier = 1.05
    override val staminaPointsMultiplier = 0.7
    override val strengthMultiplier = 1.625
    override val armorMultiplier = 1.625

    override val basicAttackName = "censer on the chin"
    override val specialAttackName = "punishment of unholy"
    override val ultimateAttackName = "holy head bonk"

    override var damageTaken: Int = 0
    override var bless: Bless = Bless.NONE

    init {
        healthPoints = (healthPoints * healthPointsMultiplier).toInt()
        staminaPoints = (staminaPoints * staminaPointsMultiplier).toInt()
        strength = (strength * strengthMultiplier).toInt()
        armor = (armor * strengthMultiplier).toInt()
    }

    companion object {
        fun getFighter(name: String): Fighter {
            return Priest(name, 1, 1, 1)
        }
    }

    override fun warriorSkill() {
        TODO("Not yet implemented")
    }

    override fun paladinSkill() {
        TODO("Not yet implemented")
    }
}*/
