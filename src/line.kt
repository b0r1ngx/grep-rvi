import kotlin.system.exitProcess

//object Line {
//    @JvmStatic
//class Line {
    fun main(args: Array<String>) {
        var invert = false
        var regexp = false
        var ignore = false
        val fileName: String
        var word: String
        for (i in 0 until args.size - 2) {
            when (args[i]) {
                "-r" -> regexp = true
                "-v" -> invert = true
                "-i" -> ignore = true
                else -> {
                    println("неверный формат")
                    exitProcess(1)
                }
            }
        }
        if (args.size >= 2) {
            word = args[args.size - 2]
            fileName = args[args.size - 1]
        } else {
            println("неверный формат")
            exitProcess(1)
        }
        try {
            val g = Grep(fileName, ignore, regexp, invert)
            output(g.search(word))
  //          if (invert) {
   //             output(g.invert(word))
    //        } else
    //            output(g.regexp(word))
        } catch (e: IllegalArgumentException) {
            println("неверный формат")
        }

    }

    fun output(stringList: List<String>) {
        for (i in stringList) {
            println(i)
        }
    }

    //inline fun exitProcess(status: Int): Nothing
//}
