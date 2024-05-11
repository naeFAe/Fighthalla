package model

class SecurityProcessor {
    fun checkPassword() {
        val correctPassword = "KotlinSecure123!"
        var attempt: String
        var attemptCount = 0
        val maxAttempts = 3

        println("Please enter your password (you have $maxAttempts attempts, password must include a number, an uppercase letter, and a special character):")

        do {
            attempt = readLine() ?: ""
            if (validatePassword(attempt)) {
                if (attempt == correctPassword) {
                    println("Password correct!")
                    return
                } else {
                    println("Incorrect password. Please try again.")
                }
            }
            attemptCount++
            if (attemptCount < maxAttempts) {
                println("${maxAttempts - attemptCount} attempts left.")
            }
        } while (attempt != correctPassword && attemptCount < maxAttempts)

        if (attemptCount == maxAttempts) {
            println("Maximum attempt limit reached. Access denied.")
        }
    }

    private fun validatePassword(password: String): Boolean {
        if (password.length < 8) {
            println("Password must be at least 8 characters long.")
            return false
        }
        var hasNumber = false
        var hasUppercase = false
        var hasSpecial = false
        for (ch in password) {
            when {
                ch.isDigit() -> hasNumber = true
                ch.isUpperCase() -> hasUppercase = true
                !ch.isLetterOrDigit() -> hasSpecial = true
            }
        }
        if (!hasNumber || !hasUppercase || !hasSpecial) {
            println("Password must contain at least one number, one uppercase letter, and one special character.")
            return false
        }
        return true
    }
}