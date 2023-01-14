import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day4Test {

    @Test
    fun testSamples() {
        assertEquals(609043, Day4().findLowest("abcdef"))
        assertEquals(1048970, Day4().findLowest("pqrstuv"))
    }

    @Test
    fun testPart1() {
        assertEquals(117946, Day4().findLowest("ckczppom"))
    }

    @Test
    fun testPart2() {
        assertEquals(3938038, Day4().findLowest("ckczppom", "000000"))
    }


//
//    @Test
//    fun testSamplesPart2() {
//        assertEquals(3, Day3(2).navigateAll("^v"))
//        assertEquals(3, Day3(2).navigateAll("^>v<"))
//        assertEquals(11, Day3(2).navigateAll("^v^v^v^v^v"))
//    }
//
//    @Test
//    fun testPart2() {
//        val data = Util().readData("day3.txt")[0]
//        assertEquals(2341, Day3(2).navigateAll(data))
//    }
}