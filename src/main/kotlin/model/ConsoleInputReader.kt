package model

class ConsoleInputReader : InputReader {
    override fun readLine(): String? = kotlin.io.readLine()
}