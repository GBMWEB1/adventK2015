class Day5 {
    private fun countVowels(s:String): Int{
        val vowels = listOf('a','e','i','o','u')
        return s.count { vowels.contains(it) }
    }

    fun hasDoubleLetter(s:String): Boolean {
        var lastLetter = ' '
        s.forEach {
            if (lastLetter == it){
                return true
            }
            lastLetter = it
        }
        return false;
    }

    fun doesNotContainString(s:String): Boolean{
        val naughty = listOf("ab","cd", "pq","xy")
        return !naughty.any { s.indexOf(it)>-1 }
    }

    fun isNice(s: String): Boolean {
        if (countVowels(s)>= 3 && hasDoubleLetter(s) && doesNotContainString(s)){
            return true
        }
        return false
    }

    fun hasRepeatingPair(s:String): Boolean {
        val previous : MutableSet<String> = mutableSetOf()
        s.forEachIndexed { index, c ->
            if (index< s.length-1) {
                val pair = "$c${s[index + 1]}"
                if (previous.contains(pair)) {
                    if (index > 0 && setOf(s[index - 1], c, s[index + 1]).size>1){
                        return true
                    }
                }
                previous.add(pair)
            }
        }
        return false;
    }

    fun hasRepeatingLetter(s:String): Boolean {
        for (x in 0..s.length-3){
            if (s[x] == s[x+2]){
                return true
            }
        }
        return false
    }

    fun isBetterNice(s:String): Boolean{
        return hasRepeatingPair(s) && hasRepeatingLetter(s)
    }

    fun countNice(data: List<String>): Int {
        return data.count { isNice(it) }
    }

    fun countBetterNice(data: List<String>): Int {
        return data.count { isBetterNice(it) }
    }
}