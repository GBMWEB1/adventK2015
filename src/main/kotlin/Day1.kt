class Day1 {

    fun calcFloor(input: String): Int{
        val ups = input.count { it== '(' }
        val downs = input.count { it== ')' }
        return ups - downs
    }

    fun calcBasement(input: String): Int {
        var pos = 0
        input.forEachIndexed { index, char ->
            if (char=='('){
                pos++
            } else{
                pos--
            }
            if (pos==-1){
                return index+1
            }
        }
        return -1
    }
}