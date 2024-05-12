/*
package controller

object InputController {
    fun getOption(numberOfOptions: Int): Int {
        var option: Int
        while (true) {
            try {
                option = readOption(numberOfOptions)
                break
            } catch (e: IllegalArgumentException) {
                println(e.localizedMessage)
            }
        }
        return option
    }

    fun getName(): String {
        var name: String
        while (true) {
            try {
                name = readName()
                break
            } catch (e: IllegalArgumentException) {
                println(e.localizedMessage)
            }
        }
        return name
    }

    //region PRIVATE METHODS

    private fun readOption(numberOfOptions: Int): Int {
        val input = readLine()
        if (input == null) throw IllegalArgumentException("Unexpected error. Option can't be null.")
        else if (input.toIntOrNull() == null) throw IllegalArgumentException("Invalid input. Option must be a number.")
        else if (input.toInt() !in 1..numberOfOptions) throw IllegalArgumentException("There is no such option.")
        else return input.toInt()
    }

    private fun readName(): String {
        val input = readLine()
        if (input == null) throw IllegalArgumentException("Unexpected error. Name can't be null.")
        else if (input.length < 3) throw IllegalArgumentException("Name must be at least 3 char long.")
        else if (input[0].isLowerCase()) throw IllegalArgumentException("Name must start with capitol letter.")
        else return input
    }

    //endregion
}*/
