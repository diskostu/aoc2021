package day07

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day07Test {

    @Test
    fun `should calc correct fuel for task 1`() {
        // given
        val input = createInput()

        // when
        val calcFuel: Int = Day07().calcFuelTask1(input)

        // then
        assertThat(calcFuel).isEqualTo(37)
    }

    @Test
    fun `should calc correct fuel for task 2`() {
        // given
        val input = createInput()

        // when
        val calcFuel: Int = Day07().calcFuelTask2(input)

        // then
        assertThat(calcFuel).isEqualTo(168)
    }

    private fun createInput(): List<Int> {
        return "16,1,2,0,4,2,7,1,2,14"
            .split(",")
            .map { it.toInt() }
            .toList()
    }
}
