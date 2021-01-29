package lpk.austen

/**
 * Represents a line of text read in from a book.
 */
class Line(line: String) {
    val words = mutableListOf<String>()

    init {
        var currentWord = ""
        for (c in line) {
            if (isWordTerminator(c)) {
                addWord(currentWord)
                currentWord = ""
            } else {
                currentWord = currentWord + c
            }
        }
        addWord(currentWord)
    }

    fun words(): List<String> {
        return words
    }

    fun addWord(str: String) {
        if (isWord(str)) {
            words.add(str.toLowerCase())
        }
    }
    fun isWordTerminator(c: Char): Boolean {
        if (c == ' ') return true
        if (c == '.') return true
        if (c == ',') return true
        if (c == '!') return true
        if (c == '?') return true
        if (c == '\"') return true
        if (c == '_') return true
        if (c == ';') return true
        if (c == ':') return true
        if (c == '(') return true
        if (c == ')') return true
        return false
    }

    fun isWord(str: String) : Boolean {
        if (str == "") return false
        if (str == "'") return false
        return true
    }
}