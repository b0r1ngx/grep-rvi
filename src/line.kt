//object Line {
//    @JvmStatic
//class Line {
    fun main(args: Array<String>) {
        var invert = false
        var regexp = false
        var ignore = false
        var fileName: String? = null
        var word: String? = null
        for (i in 0 until args.size - 2) {
            when (args[i]) {
                "-r" -> regexp = true
                "-v" -> invert = true
                "-i" -> ignore = true
                else -> {
                    println("неверный формат")
                    //System.exit(1)
                }
            }
        }
        if (args.size >= 2) {
            word = args[args.size - 2]
            fileName = args[args.size - 1]
        } else {
            println("неверный формат")
            //System.exit(1)
        }
        if (!regexp) {
            word = "\\Q$word\\E"
        }
        try {
            val g = fileName?.let { Grep(it, ignore) }
            if (word != null) {
                if (invert) {
                    output(g!!.invert(word))
                } else
                    output(g!!.regexp(word))
            } else {
                println("неверный формат")
                //System.exit(1)
            }
        } catch (e: IllegalArgumentException) {
            println("неверный формат")
        }

    }

    fun output(stringList: List<String>) {
        for (i in stringList) {
            println("Строки: $i")
        }
    }
//}