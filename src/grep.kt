import java.nio.file.Files
import java.nio.file.Paths
import java.util.ArrayList
import java.util.regex.Pattern

class Grep(path: String, private val ignore: Boolean) {
    private var string: List<String>? = null

    init {
        try {
            this.string = Files.readAllLines(Paths.get(path))
        } catch (e: Exception) {
            throw IllegalArgumentException(e.message)
        }

    }

    private fun explorer(regex: String, invert: Boolean): List<String> {
        val result = ArrayList<String>()
        val p: Pattern = if (ignore)
            Pattern.compile(regex, Pattern.CASE_INSENSITIVE)
        else
            Pattern.compile(regex)
        for (strings in string!!) {
            if (p.matcher(strings).find() != invert) {
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