package day07

import util.Utils
import kotlin.math.absoluteValue

fun main() {
    val currentDay = Day07()
    val input = Utils().readFileAsIntListCommaSeparated("input_day07.txt")

    println("task 1 = ${currentDay.calcFuelTask1(input)}")
}


class Day07 {

    fun calcFuelTask1(input: List<Int>): Int {
        val max = input.maxOrNull()!!

        var fuelSumLeast = Int.MAX_VALUE
        for (i in 1..max) {
            var fuelSumCurrent = 0
            for (j in input) {
                fuelSumCurrent += (i - j).absoluteValue
            }

            if (fuelSumCurrent < fuelSumLeast) fuelSumLeast = fuelSumCurrent
        }

        return fuelSumLeast
    }

    fun calcFuelTask2(input: List<Int>): Int {
        TODO("Not yet implemented")
    }
}
