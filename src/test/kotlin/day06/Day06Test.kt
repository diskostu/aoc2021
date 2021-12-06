package day06

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day06Test {
    @Test
    fun `should calculate correct amount for task 1`() {
        // given
        val lanternfishList = "3,4,3,1,2"
            .split(",")
            .map { it.toInt() }
            .map { Lanternfish(it) }
            .toList()

        // when
        val task1 = Day06().task1(lanternfishList, 80)

        // then
        assertThat(task1).isEqualTo(5934)
    }

    @Test
    fun `should calculate correct amount for task 2`() {
        // given
        val lanternfishList = "3,4,3,1,2"
            .split(",")
            .map { it.toInt() }
            .map { Lanternfish(it) }
            .toList()

        // when
        val task1 = Day06().task1(lanternfishList, 180)

        // then
        assertThat(task1).isEqualTo(26984457539)
    }
}
