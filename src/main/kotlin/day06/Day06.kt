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
        var mutableFishes = fishes.toMutableList()

//        println("initial state: ${mutablesFishes.size} fishes")
//        println("$mutablesFishes")

        val startTimeTotal = System.currentTimeMillis()

        for (i in 1..days) {
            //println("--------------- new day ------------")
            val startTimeDay = System.currentTimeMillis()
            val mutableFishesWithNewBorns = mutableFishes.toMutableList()
            //println("duplicating finished: ${System.currentTimeMillis() - startTimeDay} ms")

            for (fish in mutableFishes) {
                if (fish.day == 0) {
                    mutableFishesWithNewBorns.add(Lanternfish())
                    fish.resetDays()
                } else {
                    fish.day--
                }
            }
            println("for-loop finished: ${System.currentTimeMillis() - startTimeDay} ms")

            mutableFishes = mutableFishesWithNewBorns
            println("after $i days: ${mutableFishes.size} fishes")
            //println("$mutableFishes")
        }

        println("Total time: ${System.currentTimeMillis() - startTimeTotal} ms")

        return mutableFishes.size
    }
}
