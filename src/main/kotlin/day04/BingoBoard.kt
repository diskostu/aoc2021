package day04

class BingoBoard(private val cols: Int, private val rows: Int) {
    private val numbers = mutableListOf<BingoNumber>()

    fun addNumbersToBoard(intList: List<Int>) {
        if (numbers.size + intList.size > cols * rows) {
            throw IllegalArgumentException("too much numbers for the board!")
        }

        println("adding numbers: $intList")
        for (int in intList) {
            numbers.add(BingoNumber(int))
        }

        println("board now contains ${numbers.size} numbers")
    }

    fun markNumber(numberToMark: Int) {
        val toList = numbers.firstOrNull { number -> number.number == numberToMark }
        if (toList != null) toList.marked = true
    }

    fun hasBingo(): Boolean {
        //  0  1  2  3  4
        //  5  6  7  8  9
        // 10 11 12 13 14
        // 15 16 17 18 19
        // 20 21 22 23 24

        // rows
        for (i in 0 until numbers.size step cols) {
            val subList = numbers.subList(i, i + cols)
            //println("checking row $subList")
            val size = subList.filter { !it.marked }.size
            if (size == 0) {
                println("List has Bingo! $subList")
                return true
            }
        }

        // cols
        for (i in 0 until cols) {
            val subList = mutableListOf<BingoNumber>()
            for (j in 0 until cols * rows step cols) {
                subList.add(numbers[j])
            }
            val size = subList.filter { !it.marked }.size
            if (size == 0) {
                println("List has Bingo! $subList")
                return true
            }
        }


        return false
    }

    fun getSumOfAllUnmarkedNumbers(): Int {
        return numbers.filter { number -> !number.marked }.sumOf { it.number }
    }

    private fun getMarkedNumbersCount(): Int {
        return numbers.filter { numbers -> numbers.marked }.size
    }

    fun printBoard() {
        if (numbers.size < (cols * rows)) {
            println("Not enough numbers yes (${numbers.size})")
            return
        }

        println()
        println("Board with ${getMarkedNumbersCount()} marked numbers:")
        for (i in 0 until rows) {
            for (j in 0 until cols) {
                print("${numbers[(i * cols) + j]} ")
            }
            print("\n")
        }
        println()
    }
}
