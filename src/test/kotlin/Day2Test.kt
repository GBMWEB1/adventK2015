import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day2Test {

    @Test
    fun testSamples() {
        assertEquals(58, Day2().calcWrappingPaper(2,3,4))
        assertEquals(43, Day2().calcWrappingPaper(1,1,10))
    }

    @Test
    fun testPart1() {
        val data = Util().readData("day2-1.txt")
        assertEquals(1588178, Day2().calcTotalArea(data))
    }

    @Test
    fun testSampleRibbonToWrap() {
        assertEquals(10, Day2().calcRibbonToWrap(2, 3, 4))
        assertEquals(4, Day2().calcRibbonToWrap(1, 1, 10))
    }


    @Test
    fun testSampleRibbonBow() {
        assertEquals(24, Day2().calcRibbonForBow(2, 3, 4))
        assertEquals(10, Day2().calcRibbonForBow(1, 1, 10))
    }

    @Test
    fun testSampleRibbon() {
        assertEquals(34, Day2().calcRibbon(2, 3, 4))
        assertEquals(14, Day2().calcRibbon(1, 1, 10))
    }

    @Test
    fun testPart2() {
        val data = Util().readData("day2-1.txt")
        assertEquals(3783758, Day2().calcTotalRibbon(data))
    }
}