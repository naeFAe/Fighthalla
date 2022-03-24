package controller

import abstract.Fighter
import enum.Bless
import enum.Potion

object RandomController {
    fun isStarting(): Boolean {
        return (0..1).random() != 0
    }

    fun dodge(fighter: Fighter): Boolean {
        return (1..100).random() in 1..10 * fighter.agility
    }

    fun block(fighter: Fighter): Boolean {
        return (1..100).random() in 1..10 * fighter.armor
    }

    fun counter(fighter: Fighter): Boolean {
        return (1..100).random() in 1..5 * fighter.strength
    }

    fun getBless(): Bless {
        if ((1..100).random() !in 1..10) //10% for bless
            return Bless.NONE

        //TODO implement bless random based on the chance
        var sum = 0
        Bless.values().forEach { sum += it.weight }
        var rand = (1..sum).random()
        for (value in Bless.values()) {
            rand -= value.weight
            if (rand <= 0) return value
        }
        return Bless.NONE
    }

    fun getPotion(): Potion {
        var potion = Potion.values().random()
        while (potion == Potion.NONE)
            potion = Potion.values().random()
        return potion
    }
}