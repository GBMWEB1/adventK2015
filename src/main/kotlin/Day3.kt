
typealias Position = Pair<Int, Int>

class Day3(count: Int = 1) {

    private var santas : ArrayDeque<Position> = ArrayDeque()
    private var positions : MutableSet<Position> = mutableSetOf()

    init {
        val startPosition = 0 to 0
        repeat(count){
            santas.add(startPosition)
        }
        positions.add(startPosition)
    }

    private fun navigate(position: Position, direction: Char): Position {
        return when (direction){
            '>'-> position.first + 1 to position.second
            '<'-> position.first -1 to position.second
            '^'-> position.first to position.second -1
            'v'-> position.first to position.second + 1
            else -> throw Error("Unknown direction $direction")
        }
    }

    private fun navigate(direction: Char) {
        val currentPosition = santas.removeFirst()
        val nextPosition = navigate(currentPosition, direction)
        santas.addLast(nextPosition)
        positions.add(nextPosition)
    }

    fun navigateAll(directions: String): Int {
        directions.forEach { navigate(it) }
        return getHouses()
    }

    private fun getHouses(): Int {
        return positions.size
    }
}

