package day06

import util.Utils

fun main() {
    val currentDay = Day06()
    val input = Utils().readFileAsIntListCommaSeparated("input_day06.txt")

    println("task 1 = ${currentDay.simulate(input, 80)}")
    println("task 2 = ${currentDay.simulate(input, 256)}")
}


class Day06 {

    /**
     * My own solution was way to inperformant for task 2 (heap space problem). So I looked over
     * at reddit, and of course... so many smart solutions. I grabbed this one:
     * https://www.reddit.com/r/adventofcode/comments/r9z49j/comment/hngygcy
     *
     * Man. So cool.
     *
     * I added some inline comments trying to explain (and understand for myself :)) what's going
     * on.
     *
     */
    fun simulate(input: List<Int>, days: Int): Long {
        // create the initial variants of the days (hence the list size of 9: we have days from 0
        // to 8)
        var dayVariants = MutableList(9) { index ->
            input.count { it == index }.toLong()
        }


        repeat(days) {
            // get the count of fishes whose days are 0
            val fishAtZero = dayVariants.first()

            // now, rotating begins. "day 8" becomes "day 7", "day 7" becomes "day 6" and so on.
            // therefore, we remove the first element of the list. "day 1" becomes "day 0". "day
            // 8" is missing, but will be added in a moment
            dayVariants = dayVariants.drop(1).toMutableList()

            // the fishes with zero now reset their days to "6", hence the value at index 6 in
            // the list has to increase
            dayVariants[6] = dayVariants[6] + fishAtZero

            // the newborn fishes with 8 days are appended to the end of the list
            dayVariants.add(fishAtZero)
        }

        return dayVariants.sum()
    }
}
