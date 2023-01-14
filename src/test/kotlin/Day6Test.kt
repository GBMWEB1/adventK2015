import Day6.Command
import Day6.IntGrid
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day6Test{

    @Test
    fun turnOnEveryLight(){
        val day6 = Day6()
        day6.turnOn(0 to 999, 0 to 999)
        assertEquals(1_000_000, day6.countLights())
    }

    @Test
    fun toggleFirstLine(){
        val day6 = Day6()
        day6.toggle(0 to 999, 0 to 0)
        assertEquals(1000, day6.countLights())
    }

    @Test
    fun turnOff(){
        val day6 = Day6()
        day6.turnOn(0 to 999, 0 to 999)
        day6.turnOff(499 to 500, 499 to 500)
        assertEquals(999_996, day6.countLights())
    }

    @Test
    fun parseInstruction(){
        assertEquals(Day6.Instruction(Command.TURN_ON, 489 to 759, 959 to 964), Day6.Instruction.from("turn on 489,959 through 759,964"))
        assertEquals(Day6.Instruction(Command.TURN_OFF, 820 to 871, 516 to 914), Day6.Instruction.from("turn off 820,516 through 871,914"))
        assertEquals(Day6.Instruction(Command.TOGGLE, 756 to 812, 965 to 992), Day6.Instruction.from("toggle 756,965 through 812,992"))
    }

    @Test
    fun part1(){
        val data = Util().readData("day6.txt")
        val day6 = Day6()
        day6.process(data)
        assertEquals(569999, day6.countLights())
    }

    @Test
    fun part2TurnOn(){
        val day6 = Day6(grid = IntGrid())
        day6.turnOn(0 to 0, 0 to 0)
        assertEquals(1, day6.countLights())
    }

    @Test
    fun part2Toggle(){
        val day6 = Day6(grid = IntGrid())
        day6.toggle(0 to 999, 0 to 999)
        assertEquals(2_000_000, day6.countLights())
    }

    @Test
    fun part2(){
        val data = Util().readData("day6.txt")
        val day6 = Day6(grid = IntGrid())
        day6.process(data)
        assertEquals(17836115, day6.countLights())
    }
}