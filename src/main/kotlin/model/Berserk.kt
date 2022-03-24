package model

import abstract.Fighter
import abstract.Warrior
import enum.Bless

data class Berserk(
    override var name: String,
    override var armor: Int,
    override var strength: Int,
    override var agility: Int
) : Fighter(
    name
), Warrior {
    override val healthPointsMultiplier = 0.9
    override val staminaPointsMultiplier = 0.8
    override val strengthMultiplier = 2.5

    override val basicAttackName = "fast swing"
    override val specialAttackName = "axe uppercut"
    override val ultimateAttackName = "axe whirlwind"

    override var damageTaken: Int = 0
    override var bless: Bless = Bless.NONE

    init {
        healthPoints = (healthPoints * healthPointsMultiplier).toInt()
        staminaPoints = (staminaPoints * staminaPointsMultiplier).toInt()
        agility = (agility * strengthMultiplier).toInt()
    }

    companion object {
        fun getFighter(name: String): Fighter {
            return Berserk(name, 1, 1, 1)
        }
    }

    override fun warriorSkill() {
        TODO("Not yet implemented")
    }
}