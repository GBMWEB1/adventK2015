import java.math.BigInteger
import java.security.MessageDigest

class Day4() {

    fun md5(input:String): String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
    }

    fun findLowest(key: String, match : String = "00000"): Int {
        var counter = 0;
        var toCheck = "$key$counter"
        while (!md5(toCheck).startsWith(match)){
            counter++
            toCheck = "$key$counter"
        }
        return counter;
    }



}