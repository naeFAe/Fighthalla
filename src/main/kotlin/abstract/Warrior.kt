package abstract

interface Warrior {
    val healthPointsMultiplier: Double
    val staminaPointsMultiplier: Double
    val strengthMultiplier: Double

    fun warriorSkill ()
}