package lpk.austen.test

import org.junit.Assert
import org.junit.Test
import lpk.austen.Book
import java.nio.file.Paths

class BookTest {
    @Test
    fun shortStory() {
        val book =
            Book(Paths.get("src/test/resources/books/ShortStory.txt"))
        val allWords = book.histogram.allWords()
        Assert.assertEquals(4, allWords.size)
        Assert.assertTrue(allWords.contains("the"))
        Assert.assertTrue(allWords.contains("beginning"))
        Assert.assertTrue(allWords.contains("middle"))
        Assert.assertTrue(allWords.contains("end"))
        Assert.assertEquals(3, book.histogram.numberOfTimesGiven("the"))
        Assert.assertEquals(
            1,
            book.histogram.numberOfTimesGiven("beginning")
        )
        Assert.assertEquals(
            1,
            book.histogram.numberOfTimesGiven("middle")
        )
        Assert.assertEquals(1, book.histogram.numberOfTimesGiven("end"));
    }

    @Test
    fun horrorStory() {
        val book =
            Book(Paths.get("src/test/resources/books/HorrorStory.txt"))
        val allWords = book.histogram.allWords()
        Assert.assertEquals(7, allWords.size)
        Assert.assertTrue(allWords.contains("it"))
        Assert.assertTrue(allWords.contains("was"))
        Assert.assertTrue(allWords.contains("a"))
        Assert.assertTrue(allWords.contains("and"))
        Assert.assertTrue(allWords.contains("stormy"))
        Assert.assertTrue(allWords.contains("night"))
        Assert.assertTrue(allWords.contains("dark"))
        Assert.assertEquals(1, book.histogram.numberOfTimesGiven("it"))
        Assert.assertEquals(
            1,
            book.histogram.numberOfTimesGiven("was")
        )
        Assert.assertEquals(1, book.histogram.numberOfTimesGiven("a"))
        Assert.assertEquals(
            1,
            book.histogram.numberOfTimesGiven("dark")
        );
        Assert.assertEquals(
            1,
            book.histogram.numberOfTimesGiven("and")
        );
        Assert.assertEquals(
            1,
            book.histogram.numberOfTimesGiven("stormy")
        );
        Assert.assertEquals(
            1,
            book.histogram.numberOfTimesGiven("night")
        );
    }

    @Test
    fun littleBookOfCalmTest() {
        val book = Book(
            Paths.get(
                "src/test/resources/books/TheLittleBookOfCalm.txt"
            )
        )
        //This book has two lines with several repeated words.
        //There is also a blank line.
        //The two non-blank lines end in full stops.
        val histogram = book.histogram
        print(histogram.allWords())
        Assert.assertEquals(2, histogram.numberOfTimesGiven("this"))
        Assert.assertEquals(1, histogram.numberOfTimesGiven("is"))
        Assert.assertEquals(1, histogram.numberOfTimesGiven("a"))
        Assert.assertEquals(3, histogram.numberOfTimesGiven("very"))
        Assert.assertEquals(2, histogram.numberOfTimesGiven("short"))
        Assert.assertEquals(2, histogram.numberOfTimesGiven("book"))
        Assert.assertEquals(1, histogram.numberOfTimesGiven("we"))
        Assert.assertEquals(1, histogram.numberOfTimesGiven("hope"))
        Assert.assertEquals(1, histogram.numberOfTimesGiven("that"))
        Assert.assertEquals(1, histogram.numberOfTimesGiven("you"))
        Assert.assertEquals(1, histogram.numberOfTimesGiven("find"))
        Assert.assertEquals(1, histogram.numberOfTimesGiven("calming"))
    }

    @Test
    fun prideAndPrejudice() {
        val book = Book(Paths.get(
            "src/test/resources/books/Page1.txt"))
//32 lines from the start of Pride and Prejudice
        val histogram = book.histogram
//Check some words that we have
//counted using a text editor.
        Assert.assertEquals(1, histogram.numberOfTimesGiven("pride"))
        Assert.assertEquals(5, histogram.numberOfTimesGiven("it"))
        Assert.assertEquals(3, histogram.numberOfTimesGiven("and"))
        Assert.assertEquals(3, histogram.numberOfTimesGiven("bennet"))
//Check that some words followed by
//punctuation are counted correctly.
        Assert.assertEquals(3, histogram.numberOfTimesGiven("you"))
        Assert.assertEquals(2, histogram.numberOfTimesGiven("she"))
    }

}
