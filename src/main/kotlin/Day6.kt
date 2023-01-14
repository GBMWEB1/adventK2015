class Day6(private val grid : Grid = BooleanGrid()) {

    enum class Command{
        TURN_ON,
        TURN_OFF,
        TOGGLE
    }

    interface Grid {
        fun turnOn(x: Int, y: Int)
        fun turnOff(x: Int, y: Int)
        fun toggle(x: Int, y: Int)
        fun count(): Int
    }

    class BooleanGrid: Grid{
        private val cells : MutableList<MutableList<Boolean>> =  mutableListOf()

        init {
            for (y in 0..999){
                val row = mutableListOf<Boolean>()
                for (x in 0..999){
                    row.add(false)
                }
                cells.add(row)
            }
        }

        override fun turnOn(x: Int, y: Int){
            cells[y][x] = true
        }

        override fun turnOff(x: Int, y: Int){
            cells[y][x] = false
        }

        override fun toggle(x:Int, y:Int){
            cells[y][x] = !cells[y][x]
        }

        override fun count(): Int {
            return cells.flatten().count { it }
        }
    }

    class IntGrid: Grid{
        private val cells : MutableList<MutableList<Int>> =  mutableListOf()

        init {
            for (y in 0..999){
                val row = mutableListOf<Int>()
                for (x in 0..999){
                    row.add(0)
                }
                cells.add(row)
            }
        }

        override fun turnOn(x: Int, y: Int){
            cells[y][x] = cells[y][x]+1
        }

        override fun turnOff(x: Int, y: Int){
            cells[y][x] = maxOf(cells[y][x]-1,0)
        }

        override fun toggle(x:Int, y:Int){
            cells[y][x] = cells[y][x]+2
        }

        override fun count(): Int {
            return cells.flatten().sumOf { it }
        }
    }


    data class Instruction(val command: Command, val x: Pair<Int, Int>, val y: Pair<Int, Int>){
        companion object {
            fun from(string: String): Instruction {
                val command = determineCommand(string)
                val x1 = string.substringBefore(",").substringAfterLast(" ").toInt()
                val x2 = string.substringAfter("through ").substringBefore(",").toInt()
                val y1 = string.substringAfter(",").substringBefore(" through").toInt()
                val y2 = string.substringAfter("through").substringAfter(",").toInt()

                return Instruction(command, x1 to x2, y1 to y2 )
            }

            private fun determineCommand(string: String): Command {
                if (string.contains("turn on")) {
                    return Command.TURN_ON
                }
                if (string.contains("turn off")) {
                    return Command.TURN_OFF
                }
                return Command.TOGGLE
            }
        }
    }

    fun turnOn(x: Pair<Int, Int>, y: Pair<Int, Int>) {
        for (cellsY in y.first .. y.second){
            for (cellsX in x.first .. x.second){
                grid.turnOn(cellsX, cellsY)
            }
        }
    }

    fun toggle(x: Pair<Int, Int>, y: Pair<Int, Int>) {
        for (cellsY in y.first .. y.second){
            for (cellsX in x.first .. x.second){
                grid.toggle(cellsX, cellsY)
            }
        }

    }

    fun turnOff(x: Pair<Int, Int>, y: Pair<Int, Int>) {
        for (cellsY in y.first .. y.second){
            for (cellsX in x.first .. x.second){
                grid.turnOff(cellsX, cellsY)
            }
        }
    }

    fun countLights(): Int {
        return grid.count()
    }

    fun process(data: List<String>) {
        data.map { Instruction.from(it) }
            .forEach { processInstruction(it) }
    }

    private fun processInstruction(instruction: Instruction) {
        when (instruction.command){
            Command.TURN_ON -> turnOn(instruction.x, instruction.y)
            Command.TURN_OFF -> turnOff(instruction.x, instruction.y)
            Command.TOGGLE -> toggle(instruction.x, instruction.y)
        }
    }
}