package util

import java.io.File

class Utils {

    fun readFileAsStringList(fileName: String): List<String> =
        File("src/main/resources/$fileName").bufferedReader().readLines()

    fun readFileAsIntList(fileName: String): List<Int> =
        File("src/main/resources/$fileName").bufferedReader().readLines().map { it.toInt() }
}
