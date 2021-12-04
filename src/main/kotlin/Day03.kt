import util.Utils

fun main() {
    val input = Utils().readFileAsStringList("input_day03.txt")
    task1(input) // 749376
    task2(input) // ???
}

fun task1(input: List<String>) {
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

fun task2(input: List<String>) {
    TODO("Not yet implemented")
}
