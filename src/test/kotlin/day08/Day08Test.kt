package day08

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import util.Utils

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class Day08Test {

    lateinit var input: List<String>

    @BeforeAll
    private fun beforeAll() {
        input = Utils().readFileAsStringList("input_test_day08.txt")
    }


    @Test
    fun `should count values for task 1 correctly`() {
        // arrange

        // act
        val calcTask1 = Day08().calcTask1(input)

        // assert
        assertThat(calcTask1).isEqualTo(26)
    }


    @Test
    fun `should count values for task 2 correctly`() {
        // arrange

        // act
        val calcTask1 = Day08().calcTask2(input)

        // assert
        assertThat(calcTask1).isEqualTo(61229)
    }
}
