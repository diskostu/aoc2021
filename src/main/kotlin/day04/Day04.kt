package day04

import util.Utils

fun main() {
    val input = Utils().readFileAsStringList("input_day04.txt")
    val numbersToDraw = input[0].split(",")
    var bingoBoards = createBingoBoards(input)
    task1(numbersToDraw, bingoBoards) // 72770

    bingoBoards = createBingoBoards(input)
    task2(numbersToDraw, bingoBoards) // 13912
}

private fun task1(numbersToDraw: List<String>, bingoBoards: List<BingoBoard>) {
    var result: Int = -1
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

private fun task2(numbersToDraw: List<String>, bingoBoards: List<BingoBoard>) {
    var result: Int = -1

    val boardsWithBingo = mutableListOf<BingoBoard>()

    for (numberToDraw in numbersToDraw) {
        println("drawing number $numberToDraw")
        for (bingoBoard in bingoBoards) {
            bingoBoard.markNumber(numberToDraw.toInt())
            if (bingoBoard.hasBingo()) {
                if(!boardsWithBingo.contains(bingoBoard)) boardsWithBingo.add(bingoBoard)
                if (boardsWithBingo.size == bingoBoards.size) {
                    result = bingoBoard.getSumOfAllUnmarkedNumbers() * numberToDraw.toInt()
                    break
                }
            }
        }
        println("boardsWithBingo = $boardsWithBingo")
        if (result > 0) break
    }

    println("task2 = $result")
}

private fun createBingoBoards(input: List<String>): MutableList<BingoBoard> {
    val bingoBoards = mutableListOf<BingoBoard>()
    val boardRows = 5
    val boardColumns = 5

    var board: BingoBoard
    for (inputIndex in 1 until input.size) {
        if (input[inputIndex].isBlank()) {
            board = BingoBoard(boardColumns, boardRows)
            for (boardRowIndex in 1..boardRows) {
                val boardRow = input[inputIndex + boardRowIndex]
                board.addNumbersToBoard(boardRow
                    .split(" ")
                    .filter { s -> s.isNotBlank() }
                    .map { it.toInt() })
            }
            bingoBoards.add(board)
        }
    }

    return bingoBoards
}


