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

    val mySeat = mySeat(input)
    println(seatId(mySeat.first, mySeat.second))
}

internal fun mySeat(seats: List<String>): Pair<Int, Int> {
    val plain = populatePlane(seats)

    var isExpectingMySeat = true

    for (i in 0 until 128) {
        for (j in 1 until 8) {
            if (plain[i][j]) isExpectingMySeat = false

            if (!plain[i][j] && !isExpectingMySeat) {
                return Pair(i, j)
            }
        }
    }
    throw IllegalArgumentException("There must be a seat for me!")
}

private fun populatePlane(seats: List<String>): Array<BooleanArray> {
    val plain = Array(128) { BooleanArray(8) }

    for (seat in seats) {
        val row = row(seat)
        val col = col(seat)
        plain[row][col] = true
    }
    return plain
}

internal fun row(seatLocator: String): Int {
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

    return rowLower
}

internal fun col(seatLocator: String): Int {
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

    return colLower
}

internal fun seatId(seatLocator: String): Int {
    return row(seatLocator) * 8 + col(seatLocator)
}

internal fun seatId(row: Int, col: Int): Int {
    return row * 8 + col
}