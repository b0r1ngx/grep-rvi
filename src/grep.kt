import java.io.File
import java.util.ArrayList
import java.util.regex.Pattern

class Grep(path: String, private val ignore: Boolean,
           private val regexp:Boolean, private val invert:Boolean) {
    private val string: List<String>

    init {
        try {
            this.string = File(path).readLines()
        } catch (e: Exception) {
            throw IllegalArgumentException(e.message)
        }
    }

     fun search(regex: String): List<String> {
        val result = ArrayList<String>()
         val word = if (!regexp) "\\Q$regex\\E" else regex
        val p: Regex = if (ignore)
            Regex(word, RegexOption.IGNORE_CASE)
        else
            Regex(word)
        for (strings in string) {
            if (strings.contains(p) != invert) {
                result.add(strings)
            }
        }
        return result
    }

  //  fun regexp(regex: String): List<String> {
  //      return explorer(regex, false)
  //  }

 //   fun invert(regex: String): List<String> {
 //       return explorer(regex, true)
 //   }

}