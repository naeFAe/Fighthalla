/*
import abstract.Fighter
import controller.InputController
import controller.RandomController
import enum.Bless
import model.*

class Arena {
    var duel: Pair<Fighter, Fighter> = Pair(introduceFighter(), introduceFighter())

    init {
        if (!RandomController.isStarting()) duel = Pair(duel.second, duel.first)

        println("\nWelcome to the arena!")
        println("The gods decided that ${duel.first::class.simpleName} ${duel.first.name} is starting!\n")
    }

    fun fight(duel: Pair<Fighter, Fighter>) {
        while (true) {
            if ((duel.first.healthPoints > 0)) {
                turn(duel.first, duel.second)
                if (duel.second.healthPoints > 0) {
                    turn(duel.second, duel.first)
                } else {
                    println("${duel.first::class.simpleName} ${duel.first.name} is the winner and his opponent is dead!")
                    break
                }
            } else {
                println("${duel.second::class.simpleName} ${duel.second.name} is the winner and his opponent is dead!")
                break
            }
        }
    }

    //region PRIVATE METHODS

    private fun introduceFighter(): Fighter {
        println(
            """
            |
            |Select your fighter's class:
            |1. Archer - 
            |2. Berserk - 
            |3. Sentinel - 
            |4. Assassin - 
            |5. Warden - 
            |6. Priest - 
        """.trimMargin()
        )
        val fighterClass = InputController.getOption(6)

        println("Name your fighter:")
        val fighterName = InputController.getName()

        lateinit var fighter: Fighter
        when (fighterClass) {
            1 -> fighter = Archer.getFighter(fighterName)
            2 -> fighter = Berserk.getFighter(fighterName)
            3 -> fighter = Sentinel.getFighter(fighterName)
            4 -> fighter = Assassin.getFighter(fighterName)
            5 -> fighter = Warden.getFighter(fighterName)
            6 -> fighter = Priest.getFighter(fighterName)
        }
        return fighter
    }

    private fun turn(attacker: Fighter, defender: Fighter) {
        println(attacker.getHealthPointsInfo())
        println(defender.getHealthPointsInfo())

        //get bless but not invincibility cuz it's attacker
        if (attacker.bless == Bless.NONE)
            do {
                attacker.bless = RandomController.getBless()
                println("attacker " + attacker.bless.description)
            } while (attacker.bless == Bless.INVINCIBILITY)
        if (attacker.bless != Bless.NONE)
            println("In the name of the gods ${attacker::class.simpleName} ${attacker.name} got ${attacker.bless.description}")

        //get bless but not exodia cuz it's defender
        if (defender.bless == Bless.NONE)
            do {
                defender.bless = RandomController.getBless()
                println("defender " + defender.bless.description)
            } while (defender.bless == Bless.EXODIA)
        if (defender.bless != Bless.NONE)
            println("In the name of the gods ${defender::class.simpleName} ${defender.name} got ${defender.bless.description}")

        println("")

        attacker.attack(defender)
        attacker.bless = Bless.NONE
        defender.bless = Bless.NONE
        println()
    }

    //endregion
}*/
