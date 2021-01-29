package lpk.austen

import java.nio.file.Path
import java.nio.file.Files

/**
 * Collects word usage data.
 */
class Histogram {
    val counter = mutableMapOf<String, Int>()

    fun record(word: String) {
        val currentCount = counter[word] ?: 0
        val newCount = currentCount + 1
        counter.put(word, newCount)
    }

    fun allWords(): Set<String> {
        return counter.keys
    }

    fun totalWords() : Int {
        var result = 0
        for (key in counter.keys) {
            val count = counter[key] ?: 0
            result = result + count
        }
        return result
    }

    fun toCSV(file : Path) {
        val csvLines = mutableListOf<String>()
        for (word in allWords()) {
            val timesGiven = numberOfTimesGiven(word)
            val line = "$word,$timesGiven"
            csvLines.add(line)
        }
        Files.write(file, csvLines)
    }

    fun numberOfTimesGiven(word: String): Int {
        return counter[word] ?: 0
    }
}