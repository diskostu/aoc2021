package day01

import util.Utils

fun main() {
    val input = Utils().readFileAsIntList("day01/input.txt")
    task1(input) // 1766
    task2(input) // 1797
}

private fun task1(input: List<Int>) {
    var depthsGreater = 0
    var previousDepth = -1
    for (depth in input) {
        if (previousDepth == -1) {
            previousDepth = depth
            continue
        }

        if (depth > previousDepth) {
            depthsGreater++
        }

        previousDepth = depth
    }

    println("task1 = $depthsGreater")
}

private fun task2(input: List<Int>) {
    var greaterDepths = 0
    for (i in 0..input.lastIndex - 3) {
        val triple1 = Triple(input[i], input[i + 1], input[i + 2])
        val triple2 = Triple(input[i + 1], input[i + 2], input[i + 3])

        if (tripleSum(triple2) > tripleSum(triple1)) greaterDepths++
    }

    println("task2 = $greaterDepths")

}

private fun tripleSum(triple: Triple<Int, Int, Int>): Int {
    return triple.first + triple.second + triple.third
}
