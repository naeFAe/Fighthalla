package enum

enum class Bless(val weight: Int, val description: String) {
    NONE(0, "nothing"),
    INVINCIBILITY(3, "invincibility bless and is now untouched!"),
    EXODIA(1, "exodia bless, he is chosen by the gods and snaps his opponent out of existence!"),
    ULTIMATE(2, "ultimate bless and now his ultimate attack is available!"),
    ARMOR(5, "armor bless and now his armor is increased!"),
    STRENGTH(5, "strength bless and now his strength is increased!"),
    AGILITY(5, "agility bless and now his agility is increased!")
}