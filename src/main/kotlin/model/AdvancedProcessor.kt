package model

class AdvancedProcessor {
    fun analyzeNumber(value: Int): String {
        return when {
            value < 0 -> "Negative"
            value == 0 -> "Zero"
            value in 1..10 -> "Small Positive"
            value in 11..100 -> "Medium Positive"
            else -> "Large Positive"
        }
    }

    fun validateUserInput(input: String?): Boolean {
        if (input.isNullOrBlank()) {
            throw IllegalArgumentException("Input cannot be blank")
        }
        return input.trim().length >= 5
    }

    fun calculateDiscount(price: Double, season: String, isHoliday: Boolean): Double {
        if (price < 0) throw IllegalArgumentException("Price must be positive")
        var discount = 0.0
        if (season == "Winter" && isHoliday) {
            discount = 0.25
        } else if (season == "Winter") {
            discount = 0.15
        } else if (season == "Summer" && isHoliday) {
            discount = 0.20
        } else if (season == "Summer") {
            discount = 0.10
        }
        return price * discount
    }
}