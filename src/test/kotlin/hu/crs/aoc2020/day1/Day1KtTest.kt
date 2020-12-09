package hu.crs.aoc2020.day1

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class Day1KtTest {
    @Test
    internal fun findTwoNumbers() {
        val findTwoNumberSum2020 = findTwoNumberSum2020(listOf(1721, 979, 366, 299, 675, 1456))
        Assertions.assertEquals(514579, findTwoNumberSum2020!!.first * findTwoNumberSum2020.second)
    }

    @Test
    internal fun findThreeNumbers() {
        val findThreeNumberSum2020 = findThreeNumbersSum2020(listOf(1721, 979, 366, 299, 675, 1456))
        Assertions.assertEquals(241861950, findThreeNumberSum2020!!.first * findThreeNumberSum2020.second * findThreeNumberSum2020.third)
    }
}


