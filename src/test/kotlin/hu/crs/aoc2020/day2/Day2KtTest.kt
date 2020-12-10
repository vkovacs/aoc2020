package hu.crs.aoc2020.day2

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class Day2KtTest {
    @Test
    internal fun `password should contain the given number of letters`() {
        val input = listOf("1-3 a: abcde", "1-3 b: cdefg", "2-9 c: ccccccccc")
        Assertions.assertEquals(2, validPasswordsByLetterCountCount(input))
    }

    @Test
    internal fun `should be exactly one letter at the given positions`() {
        val input = listOf("1-3 a: abcde", "1-3 b: cdefg", "2-9 c: ccccccccc")
        Assertions.assertEquals(1, validPasswordsByLettersAtGivenPositionCount(input))
    }
}
