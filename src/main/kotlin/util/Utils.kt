package util

import java.io.File

class Utils {

    fun readFileAsStringList(fileName: String): List<String> =
        File("src/main/resources/$fileName").bufferedReader().readLines()

    fun readFileAsIntList(fileName: String): List<Int> =
        File("src/main/resources/$fileName").bufferedReader().readLines().map { it.toInt() }

    fun readFileAsPairStringIntList(fileName: String): List<Pair<String, Int>> {
        val lines = File("src/main/resources/$fileName").bufferedReader().readLines()
        val pairList = mutableListOf<Pair<String, Int>>()
        for (line in lines) {
            val split = line.split(" ")
            pairList.add(Pair(split[0], split[1].toInt()))
        }

        return pairList
    }
}
