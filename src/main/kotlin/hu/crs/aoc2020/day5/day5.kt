package hu.crs.aoc2020.day5

import java.io.File
import kotlin.math.ceil

fun main() {
    val input = File("src/main/resources/day5.txt").readLines()

    var maxSeatId = seatId(input[0])
    for (i in 1 until input.size) {
        val seatId = seatId(input[i])
        if (seatId > maxSeatId) {
            maxSeatId = seatId
        }
    }

    println(maxSeatId)
}

internal fun seatId(seatLocator: String): Int {
    var rowLower = 0
    var rowUpper = 127

    for (i in 0 until 7) {
        if (seatLocator[i] == 'F') {
            rowUpper -= ceil((rowUpper - rowLower).toDouble() / 2).toInt()
        } else {
            rowLower += ceil((rowUpper - rowLower).toDouble() / 2).toInt()
        }
    }

    assert(rowLower == rowUpper)

    var colLower = 0
    var colUpper = 7
    for (i in 7 until 10) {
        if (seatLocator[i] == 'L') {
            colUpper -= ceil((colUpper - colLower).toDouble() / 2).toInt()
        } else {
            colLower += ceil((colUpper - colLower).toDouble() / 2).toInt()
        }
    }

    assert(colLower == colUpper)

    return rowLower * 8 + colLower
}