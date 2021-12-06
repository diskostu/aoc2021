package day05

import util.Utils

fun main() {
    val input = Utils().readFileAsStringList("input_day05.txt")
    val pointPairs = createPointPairs(input)
    val currentDay = Day05()

    currentDay.task1(pointPairs)
}


class Day05 {

    fun task1(input: MutableList<Pair<Point, Point>>) {
        val filteredList = input
            .filter { pair -> pair.first.x == pair.second.x || pair.first.y == pair.second.y }
            .toList()

        println("input size = ${input.size}")
        println("filtered size = ${filteredList.size}")

        val markedPoints = mutableMapOf<Point, Int>()
        for (element in filteredList) {
            val linePoints = getLinePointsForTwoPoints(element)
            for (linePoint in linePoints) {
                markedPoints.putIfAbsent(linePoint, 0)
                markedPoints[linePoint] = markedPoints[linePoint]!! + 1
            }
        }

        println("task1 = ${markedPoints.filter { entry -> entry.value > 1 }.count()}")
    }

    fun getLinePointsForTwoPoints(points: Pair<Point, Point>): List<Point> {
        val lineOfPoints = mutableListOf<Point>()

        if (points.first.x == points.second.x) {
            if (points.first.y < points.second.y) {
                for (i in points.first.y..points.second.y) {
                    lineOfPoints.add(Point(points.first.x, i))
                }
            } else {
                for (i in points.second.y..points.first.y) {
                    lineOfPoints.add(Point(points.first.x, i))
                }
            }
        } else if (points.first.y == points.second.y) {
            if (points.first.x < points.second.x) {
                for (i in points.first.x..points.second.x) {
                    lineOfPoints.add(Point(i, points.first.y))
                }
            } else {
                for (i in points.second.x..points.first.x) {
                    lineOfPoints.add(Point(i, points.first.y))
                }
            }
        } else {
            throw IllegalStateException("neither x nor y are the same")
        }

        return lineOfPoints
    }
}

private fun createPointPairs(input: List<String>): MutableList<Pair<Point, Point>> {
    val pointPairs = mutableListOf<Pair<Point, Point>>()
    for (line in input) {
        val split = line.split(" -> ")
        val x1 = split[0].split(",")[0].trim().toInt()
        val y1 = split[0].split(",")[1].trim().toInt()
        val x2 = split[1].split(",")[0].trim().toInt()
        val y2 = split[1].split(",")[1].trim().toInt()
        pointPairs.add(Pair(Point(x1, y1), Point(x2, y2)))
    }
    return pointPairs
}
