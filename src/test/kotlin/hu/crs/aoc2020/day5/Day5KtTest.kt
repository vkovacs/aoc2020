package hu.crs.aoc2020.day5

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class Day5KtTest {

    @Test
    internal fun `should determine seatId`() {
        Assertions.assertEquals(357, seatId("FBFBBFFRLR"))
        Assertions.assertEquals(567, seatId("BFFFBBFRRR"))
        Assertions.assertEquals(119, seatId("FFFBBBFRRR"))
        Assertions.assertEquals(820, seatId("BBFFBBFRLL"))
    }
}