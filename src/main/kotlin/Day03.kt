import util.Utils

fun main() {
    val input = Utils().readFileAsStringList("input_day03.txt")
    task1(input) // 749376
    task2(input) // 2372923
}

private fun task1(input: List<String>) {
    val lengthRow = input[0].length
    var gamma = ""
    var epsilon = ""

    for (i in 0 until lengthRow) {
        var count0 = 0
        var count1 = 0
        for (s in input) {
            if (s[i] == '0') count0++ else count1++
        }

        if (count0 > count1) {
            gamma += "0"
            epsilon += "1"
        } else {
            gamma += "1"
            epsilon += "0"
        }
    }

    println("task1 = ${gamma.toInt(2) * epsilon.toInt(2)}")
}

private fun task2(input: List<String>) {
    val oxygenRating = reduceList(input, true)
    val co2Rating = reduceList(input, false)

    println("task2 = ${oxygenRating.toInt(2) * co2Rating.toInt(2)}")
}

private fun reduceList(list: List<String>, biggerIsBetter: Boolean): String {
    val rowLength = list[0].length
    var mutableList = list.toMutableList()

    for (i in 0 until rowLength) {
        var count0 = 0
        var count1 = 0
        for (s in mutableList) {
            if (s[i] == '0') count0++ else count1++

        }

        var charToFilter: Char
        if (mutableList.size > 1) {
            charToFilter = if (count0 > count1) {
                if (biggerIsBetter) '0' else '1'
            } else {
                if (biggerIsBetter) '1' else '0'
            }

            mutableList = mutableList.stream().filter { s -> s[i] == charToFilter }.toList()
        } else {
            return mutableList[0]
        }
    }

    if (mutableList.size == 1) return mutableList[0]
    else throw IllegalStateException("more than 1 element in list")
}
