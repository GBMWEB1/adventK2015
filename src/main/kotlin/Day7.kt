class Day7 {

    class Operation(instruction: String){

        var destination = instruction.substringAfter("-> ")
        private var command = instruction.substringBefore(" ->")

        private fun parseValue(part: String, values: Map<String, Int>): Int?{
            var value = part.toIntOrNull()
            if (value == null){
                value = values[part]
            }
            return value
        }

        private fun processAnd(values: Map<String, Int>): Pair<String, Int>? {
            val part1 = parseValue(command.substringBefore(" AND"), values)
            val part2 = parseValue(command.substringAfter("AND "), values)
            if (part1 != null && part2 != null) {
                return destination to part1.and(part2)
            }
            return null
        }

        private fun processOr(values: Map<String, Int>): Pair<String, Int>? {
            val part1 = parseValue(command.substringBefore(" OR"), values)
            val part2 = parseValue(command.substringAfter("OR "), values)
            if (part1 != null && part2 != null) {
                return destination to part1.or(part2)
            }
            return null
        }

        private fun processLeftShift(values: Map<String, Int>): Pair<String, Int>? {
            val part1 = parseValue(command.substringBefore(" LSHIFT"), values)
            val part2 = parseValue(command.substringAfter("LSHIFT "), values)
            if (part1 != null && part2 != null) {
                return destination to part1.shl(part2)
            }
            return null
        }

        private fun processRightShift(values: Map<String, Int>): Pair<String, Int>? {
            val part1 = parseValue(command.substringBefore(" RSHIFT"), values)
            val part2 = parseValue(command.substringAfter("RSHIFT "), values)
            if (part1 != null && part2 != null) {
                return destination to part1.shr(part2)
            }
            return null
        }

        private fun processNot(values: Map<String, Int>): Pair<String, Int>? {
            val part1 = parseValue(command.substringAfter("NOT "), values)
            if (part1 != null) {
                val converted = Integer.toBinaryString(part1.inv())
                val truncated = converted.substring(converted.length-16)

                return destination to truncated.toInt(2)
            }
            return null
        }

        fun fire(values: Map<String, Int>): Pair<String, Int>?{
            if (command.contains("AND")){
                return processAnd(values)
            }
            if (command.contains("OR")){
                return processOr(values)
            }
            if (command.contains("LSHIFT")){
                return processLeftShift(values)
            }
            if (command.contains("RSHIFT")){
                return processRightShift(values)
            }
            if (command.contains("NOT")){
                return processNot(values)
            }
            if (command.toIntOrNull()!= null){
                return destination to command.toInt()
            }
            if (values[command] != null){
                return destination to values[command]!!
            }
            return null
        }
    }

    fun processInstructions(data: List<String>, values: MutableMap<String, Int> = mutableMapOf()): Map<String, Int>{
        var operations = data
            .map { Operation(it) }
            .filter { !values.keys.contains(it.destination)}

        while (operations.isNotEmpty()){
            operations = operations.filter { !processInstruction(it, values) }
        }
        return values
    }

    private fun processInstruction(it: Operation, values: MutableMap<String, Int>) : Boolean {
        val result = it.fire(values)
        if (result!= null){
            values[result.first] = result.second
            return true
        }
        return false
    }
}