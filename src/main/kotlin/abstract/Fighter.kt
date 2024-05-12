/*
package abstract

import controller.InputController
import controller.RandomController
import enum.Bless
import enum.Potion

abstract class Fighter(
    open var name: String,
    open var healthPoints: Int = 100,
    open var staminaPoints: Int = 100,
    open var isUltimateAvailable: Boolean = true,
    private val potions: MutableList<Potion> = mutableListOf()
) {
    abstract var armor: Int
    abstract var strength: Int
    abstract var agility: Int
    abstract val basicAttackName: String
    abstract val specialAttackName: String
    abstract val ultimateAttackName: String
    abstract var damageTaken: Int
    abstract var bless: Bless

    init {
        potions.add(RandomController.getPotion())
        potions.add(RandomController.getPotion())
        potions.add(RandomController.getPotion())
    }

    fun attack(opponent: Fighter) {
        if (bless != Bless.EXODIA) println(getAttacksInfo()) else println(getExodiaInfo())
        var exodia = 0
        if (bless == Bless.EXODIA) {
            exodia = InputController.getOption(2)
        }
        while (exodia != 1) {
            if (bless == Bless.EXODIA) println(getAttacksInfo())
            when (InputController.getOption(4)) {
                1 -> basicAttack(opponent)
                2 -> specialAttack(opponent)
                3 -> {
                    if (isUltimateAvailable)
                        ultimateAttack(opponent)
                    else {
                        println("${this::class.simpleName} ${this.name} has already used his ultimate attack")
                        continue
                    }
                }
                4 -> {
                    println()
                    println(getPotionsInfo())
                    val potion = InputController.getOption(3)
                    //Go back without using potion case
                    if (potion == 3) {
                        println()
                        println(getAttacksInfo())
                        continue
                    }
                    //Go back because there is no selected potion left case
                    if (!usePotion(potion)) {
                        println()
                        println(getAttacksInfo())
                        continue
                    }
                }
            }
            break
        }
        registerDamage(opponent, exodia)
    }

    fun getHealthPointsInfo(): String {
        return "${this::class.simpleName} $name has $healthPoints HP left"
    }

    //region PRIVATE METHODS

    private fun basicAttack(opponent: Fighter) {
        opponent.damageTaken = (10..15).random() * strength
        println("\n${this::class.simpleName} $name performs $basicAttackName on ${opponent::class.simpleName} ${opponent.name} dealing ${opponent.damageTaken} damage")
    }

    private fun specialAttack(opponent: Fighter) {
        opponent.damageTaken = (0..20).random() * strength
        println("\n${this::class.simpleName} $name performs $specialAttackName on ${opponent::class.simpleName} ${opponent.name} dealing ${opponent.damageTaken} damage")
    }

    private fun ultimateAttack(opponent: Fighter) {
        opponent.damageTaken = (20..30).random() * strength
        println("\n${this::class.simpleName} $name performs $ultimateAttackName on ${opponent::class.simpleName} ${opponent.name} dealing ${opponent.damageTaken} damage")
        isUltimateAvailable = false
    }

    private fun usePotion(potion: Int): Boolean {
        return when (potion) {
            1 -> {
                if (potions.contains(Potion.HEALTH)) {
                    healthPoints += 25
                    println("${this::class.simpleName} $name restored 25 health points")
                    potions.remove(Potion.HEALTH)
                    true
                } else {
                    println("${this::class.simpleName} $name has no more ${Potion.HEALTH.description} left")
                    return false
                }
            }
            2 -> {
                if (potions.contains(Potion.STAMINA)) {
                    staminaPoints += 25
                    println("${this::class.simpleName} $name restored 25 stamina points")
                    potions.remove(Potion.STAMINA)
                    true
                } else {
                    println("${this::class.simpleName} $name has no more ${Potion.STAMINA.description} left")
                    return false
                }
            }
            else -> {
                println("Unexpected input of potion type.")
                false
            }
        }
    }

    private fun registerDamage(opponent: Fighter, exodia: Int) {
        if (exodia == 1) {
            opponent.healthPoints -= 1000
        } else if (opponent.bless == Bless.INVINCIBILITY) {
            opponent.damageTaken = 0
            println("However, ${opponent::class.simpleName} ${opponent.name} is invincible and took no damage.")
        } else {
            if (RandomController.dodge(opponent)) {
                println("${opponent::class.simpleName} ${opponent.name} dodged the attack")
                opponent.damageTaken = 0
            } else if (RandomController.block(opponent)) {
                opponent.damageTaken /= 2
                print("${opponent::class.simpleName} ${opponent.name} blocked the attack")
                if (RandomController.counter(opponent)) {
                    healthPoints -= opponent.damageTaken
                    print(" and countered. ${this::class.simpleName} $name got ${opponent.damageTaken} damage back")
                    opponent.healthPoints -= opponent.damageTaken
                }
                println()
            }
            opponent.healthPoints -= opponent.damageTaken
        }
    }

    fun applyBless(bless: Bless) {
        when (bless) {
            Bless.ARMOR -> armor = (armor * 1.25).toInt()
            Bless.STRENGTH -> strength = (strength * 1.25).toInt()
            Bless.AGILITY -> agility = (agility * 1.25).toInt()
            Bless.ULTIMATE -> isUltimateAvailable = true
            else -> {}
        }
    }

    private fun getAttacksInfo(): String {
        return """
            |Select the ${this::class.simpleName} $name's attack:
            |1. Basic attack - $basicAttackName
            |2. Special attack - $specialAttackName
            |3. Ultimate attack - $ultimateAttackName
            |4. Use a potion
        """.trimMargin()
    }

    private fun getExodiaInfo(): String {
        return """
            |Make your choice
            |1. Finish him!
            |2. Spare his life and continue the fight.
        """.trimMargin() + "\n"
    }

    private fun getPotionsInfo(): String {
        var hp = 0
        var sp = 0
        for (potion in potions)
            if (potion == Potion.HEALTH) hp++
            else if (potion == Potion.STAMINA) sp++
        return """
            |${this::class.simpleName} $name has $hp health potions and $sp stamina potions. Select potion or go back
            |1. Health potion
            |2. Stamina potion
            |3. Go back
        """.trimMargin()
    }

    //endregion
}*/
