import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class grepTest {
    @Test
    fun allTest() {
    val grep = Grep("input", true, true, true )
        val exp = listOf("Car is good!")
        assertEquals(exp, grep.search("""g\w+t"""))
    }

    @Test
    fun regexTest() {
        val grep = Grep("input", false, true, false)
        val exp = listOf("London is a capital of Great Britain!","london is a capital of great britain")
        assertEquals(exp, grep.search("""capital"""))
    }

    @Test
    fun invertTest() {
        val grep = Grep("input", false, true, true )
        val exp = listOf ("London is a capital of Great Britain!", "Car is good!")
        assertEquals(exp, grep.search("""london"""))
    }

    @Test
    fun ignoreTest() {
        val grep = Grep("input", true, true, true )
        val exp = listOf ("Car is good!")
        assertEquals(exp, grep.search("""london"""))
    }
}
