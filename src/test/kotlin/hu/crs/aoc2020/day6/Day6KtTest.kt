package hu.crs.aoc2020.day6

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class Day6KtTest {
    @Test
    internal fun `count yes answers`() {
        val answers = """
            abc

            a
            b
            c

            ab
            ac

            a
            a
            a
            a

            b""".trimIndent()
        Assertions.assertEquals(11, countYes(answers))
    }

    @Test
    internal fun `count all yes answers`() {
        val answers = """
            abc

            a
            b
            c

            ab
            ac

            a
            a
            a
            a

            b""".trimIndent()
        Assertions.assertEquals(6, countAllYes(answers))
    }
}