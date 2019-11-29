import java.io.File
import java.util.ArrayList
import java.util.regex.Pattern

class Grep(path: String, private val ignore: Boolean) {
    private val string: List<String>

    init {
        try {
            this.string = File(path).readLines()
        } catch (e: Exception) {
            throw IllegalArgumentException(e.message)
        }

    }

    private fun explorer(regex: String, invert: Boolean): List<String> {
        val result = ArrayList<String>()
        val p: Regex = if (ignore)
            Regex(regex, RegexOption.IGNORE_CASE)
        else
            Regex(regex)
        for (strings in string) {
            if (strings.contains(p) != invert) {
                result.add(strings)
            }
        }
        return result
    }

    fun regexp(regex: String): List<String> {
        return explorer(regex, false)
    }

    fun invert(regex: String): List<String> {
        return explorer(regex, true)
    }

}