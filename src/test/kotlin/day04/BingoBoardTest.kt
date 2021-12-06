package day04

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class BingoBoardTest {

    private lateinit var board: BingoBoard

    @BeforeEach
    private fun init() {
        board = BingoBoard(3, 4)
        board.addNumbersToBoard(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12))
    }

    @Test
    fun `should have Bingo col 1`() {
        // arrange
        board.markNumber(1)
        board.markNumber(4)
        board.markNumber(7)
        board.markNumber(10)

        // act / assert
        assertThat(board.hasBingo()).isTrue
    }

    @Test
    fun `should have Bingo col 2`() {
        // arrange
        board.markNumber(2)
        board.markNumber(5)
        board.markNumber(8)
        board.markNumber(11)

        // act / assert
        assertThat(board.hasBingo()).isTrue
    }

    @Test
    fun `should have Bingo col 3`() {
        // arrange
        board.markNumber(3)
        board.markNumber(6)
        board.markNumber(9)
        board.markNumber(12)

        // act / assert
        assertThat(board.hasBingo()).isTrue
    }

    @Test
    fun `should have Bingo row 1`() {
        // arrange
        board.markNumber(1)
        board.markNumber(2)
        board.markNumber(3)

        // act / assert
        assertThat(board.hasBingo()).isTrue
    }

    @Test
    fun `should have Bingo row 2`() {
        // arrange
        board.markNumber(4)
        board.markNumber(5)
        board.markNumber(6)

        // act / assert
        assertThat(board.hasBingo()).isTrue
    }

    @Test
    fun `should have Bingo row 3`() {
        // arrange
        board.markNumber(7)
        board.markNumber(8)
        board.markNumber(9)

        // act / assert
        assertThat(board.hasBingo()).isTrue
    }

    @Test
    fun `should not have Bingo 1`() {
        // arrange

        // act / assert
        assertThat(board.hasBingo()).isFalse
    }

    @Test
    fun `should not have Bingo 2`() {
        // arrange
        board.markNumber(1)
        board.markNumber(5)
        board.markNumber(9)

        // act / assert
        assertThat(board.hasBingo()).isFalse
    }
}
