package day06

import util.Utils

fun main() {
    val currentDay = Day06()
    val input = Utils().readFileAsIntListCommaSeparated("input_day06.txt")
    val lanternFishes = input.map { Lanternfish(it) }.toList()

    println("task1 = ${currentDay.task1(lanternFishes, 80)}") // 365131
}


class Day06 {

    fun task1(fishes: List<Lanternfish>, days: Int): Int {
        // create mutable list based on the input
        var mutablesFishes = fishes.toMutableList()

//        println("initial state: ${mutablesFishes.size} fishes")
//        println("$mutablesFishes")


        for (i in 1..days) {
            val mutablesFishesWithNewBorns = mutablesFishes.toMutableList()
            for (fish in mutablesFishes) {
                if (fish.day == 0) {
                    mutablesFishesWithNewBorns.add(Lanternfish())
                    fish.resetDays()
                } else {
                    fish.day--
                }
            }

            mutablesFishes = mutablesFishesWithNewBorns
            //println("after $i days: ${mutablesFishes.size} fishes")
        }

        return mutablesFishes.size
    }
}
