package model

import abstract.Fighter
import abstract.Paladin
import enum.Bless

data class Sentinel(
    override var name: String,
    override var armor: Int,
    override var strength: Int,
    override var agility: Int,
) : Fighter(
    name
), Paladin {
    override val healthPointsMultiplier = 1.2
    override val staminaPointsMultiplier = 0.6
    override val armorMultiplier = 2.0

    override val basicAttackName = "slow hit"
    override val specialAttackName = "shield bash"
    override val ultimateAttackName = "mental slash"

    override var damageTaken: Int = 0
    override var bless: Bless = Bless.NONE

    init {
        healthPoints = (healthPoints * healthPointsMultiplier).toInt()
        staminaPoints = (staminaPoints * staminaPointsMultiplier).toInt()
        armor = (agility * armorMultiplier).toInt()
    }

    companion object {
        fun getFighter(name: String): Fighter {
            return Sentinel(name, 1, 1, 1)
        }
    }

    override fun paladinSkill() {
        TODO("Not yet implemented")
    }
}
