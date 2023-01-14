import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day7Test{

    @Test
    fun evaluateValue(){
        val operation = Day7.Operation("123 -> x")
        val values = buildMap<String, Int>{}
        assertEquals("x" to 123, operation.fire(values))
    }

    @Test
    fun evaluateAnd(){
        val operation = Day7.Operation("x AND y -> d")
        val values = mutableMapOf<String, Int>()
        assertEquals(null, operation.fire(values))
        values["x"] = 5
        assertEquals(null, operation.fire(values))
        values["y"] = 3
        assertEquals("d" to 1, operation.fire(values))
    }

    @Test
    fun evaluateAndWithValue(){
        val operation = Day7.Operation("x AND 3 -> d")
        val values = mutableMapOf<String, Int>()
        assertEquals(null, operation.fire(values))
        values["x"] = 5
        assertEquals("d" to 1, operation.fire(values))
    }

    @Test
    fun evaluateAndWithNoValues(){
        val operation = Day7.Operation("5 AND 3 -> d")
        val values = mutableMapOf<String, Int>()
        assertEquals("d" to 1, operation.fire(values))
    }

    @Test
    fun evaluateOr(){
        val operation = Day7.Operation("x OR y -> d")
        val values = mutableMapOf<String, Int>()
        assertEquals(null, operation.fire(values))
        values["x"] = 5
        assertEquals(null, operation.fire(values))
        values["y"] = 3
        assertEquals("d" to 7, operation.fire(values))
    }

    @Test
    fun evaluateLShift(){
        val operation = Day7.Operation("x LSHIFT 2 -> d")
        val values = mutableMapOf<String, Int>()
        assertEquals(null, operation.fire(values))
        values["x"] = 4
        assertEquals("d" to 16, operation.fire(values))
    }

    @Test
    fun evaluateRShift(){
        val operation = Day7.Operation("x RSHIFT 2 -> d")
        val values = mutableMapOf<String, Int>()
        assertEquals(null, operation.fire(values))
        values["x"] = 4
        assertEquals("d" to 1, operation.fire(values))
    }

    @Test
    fun evaluateNot(){
        val operation = Day7.Operation("NOT x -> d")
        val values = mutableMapOf<String, Int>()
        assertEquals(null, operation.fire(values))
        values["x"] = 123
        assertEquals("d" to 65412, operation.fire(values))
    }

    @Test
    fun evaluateNot2(){
        val operation = Day7.Operation("NOT x -> d")
        val values = mutableMapOf<String, Int>()
        values["x"] = 456
        assertEquals("d" to 65079, operation.fire(values))
    }

    @Test
    fun testPart1Sample(){
        val values = Day7().processInstructions(Util().readData("day7-1.txt"))

        assertEquals(72,values["d"])
        assertEquals( 507,values["e"])
        assertEquals( 492,values["f"])
        assertEquals(114,values["g"])
        assertEquals(65412,values["h"])
        assertEquals(65079,values["i"])
        assertEquals(123,values["x"])
        assertEquals(456,values["y"])
    }

    @Test
    fun testPart1(){
        val values = Day7().processInstructions(Util().readData("day7-2.txt"))
        assertEquals(3176,values["a"])
    }

    @Test
    fun testPart2(){
        val values = mutableMapOf<String, Int>()
        values["b"] = 3176
        Day7().processInstructions(Util().readData("day7-2.txt"), values)
        assertEquals(14710,values["a"])
    }
}