package day04

import util.Utils

fun main() {
    val input = Utils().readFileAsStringList("input_day04.txt")
    task1(input) // 72770
    // task2(input) // ???
}

private fun task1(input: List<String>) {
    val numbersToDraw = input[0].split(",")
    val bingoBoards = mutableListOf<BingoBoard>()
    val boardRows = 5
    val boardColumns = 5

    var board: BingoBoard
    for (inputIndex in 1 until input.size) {
        if (input[inputIndex].isBlank()) {
            println("new board")
            board = BingoBoard(boardColumns, boardRows)
            for (boardRowIndex in 1..boardRows) {
                val boardRow = input[inputIndex + boardRowIndex]
                board.addNumbersToBoard(boardRow
                    .split(" ")
                    .filter { s -> s.isNotBlank() }
                    .map { it.toInt() })
            }
            board.printBoard()
            bingoBoards.add(board)
        }
    }

    println("we have ${bingoBoards.size} boards.")

    var result:Int = -1
    for (numberToDraw in numbersToDraw) {
        println("drawing number $numberToDraw")
        for (bingoBoard in bingoBoards) {
            bingoBoard.markNumber(numberToDraw.toInt())
            if (bingoBoard.hasBingo()) {
                result = bingoBoard.getSumOfAllUnmarkedNumbers() * numberToDraw.toInt()
                break
            }
        }
        if (result > 0) break
    }

    println("task1 = $result")
}


