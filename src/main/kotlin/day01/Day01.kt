package day01

import util.Utils

fun main() {
    task1()
}

private fun task1() {
    val depths = Utils().readFileAsIntList("day01/input.txt")

    var depthsGreater = 0
    var previousDepth = -1
    for (depth in depths) {
        if (previousDepth == -1) {
            previousDepth = depth
            continue
        }

        if (depth > previousDepth) {
            depthsGreater++
        }

        previousDepth = depth
    }

    println("task1: $depthsGreater")
}
