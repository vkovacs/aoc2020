package hu.crs.aoc2020.day3

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test


internal class Day3KtTest {
    @Test
    internal fun `should count trees`() {
        val map = """
            ..##.......
            #...#...#..
            .#....#..#.
            ..#.#...#.#
            .#...##..#.
            ..#.##.....
            .#.#.#....#
            .#........#
            #.##...#...
            #...##....#
            .#..#...#.#
        """.trimIndent()

        Assertions.assertEquals(7, countTrees(map.lines()))
    }
}