import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day1Test {

    @Test
    fun testSamples() {
        assertEquals(0, Day1().calcFloor("(())"))
        assertEquals(0, Day1().calcFloor("()()"))

        assertEquals(3, Day1().calcFloor("((("))
        assertEquals(3, Day1().calcFloor("(()(()("))
        assertEquals(3, Day1().calcFloor("))((((("))

        assertEquals(-1, Day1().calcFloor("())"))
        assertEquals(-1, Day1().calcFloor("))("))

        assertEquals(-3, Day1().calcFloor(")))"))
        assertEquals(-3, Day1().calcFloor(")())())"))
    }

    @Test
    fun testPart1() {
        val data = Util().readData("day1-1.txt")[0]
        assertEquals(138, Day1().calcFloor(data))
    }

    @Test
    fun testSampleBasement() {
        assertEquals(1, Day1().calcBasement(")"))
        assertEquals(5, Day1().calcBasement("()())"))
    }

    @Test
    fun testPart2() {
        val data = Util().readData("day1-1.txt")[0]
        assertEquals(1771, Day1().calcBasement(data))
    }

}