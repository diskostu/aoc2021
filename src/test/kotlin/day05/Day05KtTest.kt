package day05

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class Day05KtTest {

    lateinit var day: Day05

    @BeforeEach
    fun initAll() {
        day = Day05()
    }

    @Test
    fun `should return correct horizontal point list 1`() {
        // given
        val pairOfPoints = Pair(Point(0, 0), Point(3, 0))

        // when
        val pointList = day.getLinePointsForTwoPoints(pairOfPoints)

        // then
        assertThat(pointList).containsExactlyInAnyOrder(
            Point(0, 0),
            Point(1, 0),
            Point(2, 0),
            Point(3, 0))
    }


    @Test
    fun `should return correct horizontal point list 2`() {
        // given
        val pairOfPoints = Pair(Point(3, 0), Point(0, 0))

        // when
        val pointList = day.getLinePointsForTwoPoints(pairOfPoints)

        // then
        assertThat(pointList).containsExactlyInAnyOrder(
            Point(0, 0),
            Point(1, 0),
            Point(2, 0),
            Point(3, 0))
    }

    @Test
    fun `should return correct vertical point list 1`() {
        // given
        val pairOfPoints = Pair(Point(0, 0), Point(0, 3))

        // when
        val pointList = day.getLinePointsForTwoPoints(pairOfPoints)

        // then
        assertThat(pointList).containsExactlyInAnyOrder(
            Point(0, 0),
            Point(0, 1),
            Point(0, 2),
            Point(0, 3))
    }

    @Test
    fun `should return correct vertical point list 2`() {
        // given
        val pairOfPoints = Pair(Point(0, 3), Point(0, 0))

        // when
        val pointList = day.getLinePointsForTwoPoints(pairOfPoints)

        // then
        assertThat(pointList).containsExactlyInAnyOrder(
            Point(0, 0),
            Point(0, 1),
            Point(0, 2),
            Point(0, 3))
    }

    @Test
    fun `should return correct diagonal point list 1a`() {
        // given
        val pairOfPoints = Pair(Point(0, 0), Point(3, 3))

        // when
        val pointList = day.getLinePointsForTwoPoints(pairOfPoints)

        // then
        assertThat(pointList).containsExactlyInAnyOrder(
            Point(0, 0),
            Point(1, 1),
            Point(2, 2),
            Point(3, 3))
    }

    @Test
    fun `should return correct diagonal point list 1b`() {
        // given
        val pairOfPoints = Pair(Point(3, 3), Point(0, 0))

        // when
        val pointList = day.getLinePointsForTwoPoints(pairOfPoints)

        // then
        assertThat(pointList).containsExactlyInAnyOrder(
            Point(0, 0),
            Point(1, 1),
            Point(2, 2),
            Point(3, 3))
    }

    @Test
    fun `should return correct diagonal point list 2a`() {
        // given
        val pairOfPoints = Pair(Point(0, 3), Point(3, 0))

        // when
        val pointList = day.getLinePointsForTwoPoints(pairOfPoints)

        // then
        assertThat(pointList).containsExactlyInAnyOrder(
            Point(0, 3),
            Point(1, 2),
            Point(2, 1),
            Point(3, 0))
    }

    @Test
    fun `should return correct diagonal point list 2b`() {
        // given
        val pairOfPoints = Pair(Point(3, 0), Point(0, 3))

        // when
        val pointList = day.getLinePointsForTwoPoints(pairOfPoints)

        // then
        assertThat(pointList).containsExactlyInAnyOrder(
            Point(0, 3),
            Point(1, 2),
            Point(2, 1),
            Point(3, 0))
    }
}

