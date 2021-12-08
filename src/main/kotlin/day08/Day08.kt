package day08

import util.Utils

fun main() {
    val currentDay = Day08()
    val input = Utils().readFileAsStringList("input_day08.txt")

    println("task1: ${currentDay.calcTask1(input)}") // 355
}


class Day08 {

    fun calcTask1(input: List<String>): Int {
        // 0 - 6
        // 1 - 2
        // 2 - 5
        // 3 - 5
        // 4 - 4
        // 5 - 5
        // 6 - 6
        // 7 - 3
        // 8 - 7
        // 9 - 6

        // unique:
        // 1 - 2
        // 4 - 4
        // 7 - 3
        // 8 - 7

        var sumForTask = 0
        for (line in input) {
            val split = line.split(" | ")
            val numbersToDisplay = split[1].split(" ")

            val variants = numbersToDisplay
                .groupingBy { it.length }
                .eachCount().toMutableMap().toSortedMap()

            val sum = variants
                .filter { entry -> entry.key in 2..4 || entry.key == 7 }
                .toMap()
                .values.sum()

            sumForTask += sum
        }

        return sumForTask
    }

    fun calcTask2(input: List<String>): Int {
        TODO("Not yet implemented")
    }
}
