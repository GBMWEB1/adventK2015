import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day5Test {


    @Test
    fun testSampleNice() {
        assertEquals(true, Day5().isNice("ugknbfddgicrmopn"))
        assertEquals(true, Day5().isNice("aaa"))
    }

    @Test
    fun testSampleNaughty() {
        assertEquals(false, Day5().isNice("jchzalrnumimnmhp"))
        assertEquals(false, Day5().isNice("haegwjzuvuyypxyu"))
        assertEquals(false, Day5().isNice("dvszwmarrgswjxmb"))
    }

    @Test
    fun testRepeatingPair() {
        assertEquals(true, Day5().hasRepeatingPair("xyxy"))
        assertEquals(true, Day5().hasRepeatingPair("aabcdefgaa"))
        assertEquals(false, Day5().hasRepeatingPair("aaa"))
    }

    @Test
    fun testRepeatingLetter() {
        assertEquals(true, Day5().hasRepeatingLetter("xyx"))
        assertEquals(true, Day5().hasRepeatingLetter("abcdefeghi"))
        assertEquals(true, Day5().hasRepeatingLetter("aaa"))
    }

    @Test
    fun testSampleBetterNice() {
        assertEquals(true, Day5().isBetterNice("qjhvhtzxzqqjkmpb"))
        assertEquals(true, Day5().isBetterNice("xxyxx"))
        assertEquals(false, Day5().isBetterNice("uurcxstgmygtbstg"))
        assertEquals(false, Day5().isBetterNice("ieodomkazucvgmuy"))
    }

    @Test
    fun testPart1() {
        val data = Util().readData("day5.txt")
        assertEquals(258, Day5().countNice(data))
    }

    @Test
    fun testPart2() {
        val data = Util().readData("day5.txt")
        assertEquals(53, Day5().countBetterNice(data))
    }
}