package hu.crs.aoc2020.day2

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class Day2KtTest {
    @Test
    internal fun shouldReturnIsValid() {
        val input = listOf("1-3 a: abcde", "1-3 b: cdefg", "22-9 c: ccccccccc")
        Assertions.assertEquals(2, validPasswordCount(input))
    }
}
