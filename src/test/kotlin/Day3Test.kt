import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day3Test {

    @Test
    fun testSamples() {
        assertEquals(2, Day3().navigateAll(">"))
        assertEquals(4, Day3().navigateAll("^>v<"))
        assertEquals(2, Day3().navigateAll("^v^v^v^v^v"))
    }

    @Test
    fun testPart1() {
        val data = Util().readData("day3.txt")[0]
        assertEquals(2081, Day3().navigateAll(data))
    }

    @Test
    fun testSamplesPart2() {
        assertEquals(3, Day3(2).navigateAll("^v"))
        assertEquals(3, Day3(2).navigateAll("^>v<"))
        assertEquals(11, Day3(2).navigateAll("^v^v^v^v^v"))
    }

    @Test
    fun testPart2() {
        val data = Util().readData("day3.txt")[0]
        assertEquals(2341, Day3(2).navigateAll(data))
    }
}