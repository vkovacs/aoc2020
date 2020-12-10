package hu.crs.aoc2020.day2

import java.io.File

fun main() {
    val input = File("src/main/resources/day2.txt").readLines()

    println(validPasswordCount(input))
}

internal fun validPasswordCount(passwordEntries: List<String>): Int {
    val regex = Regex("([0-9]+)-([0-9]+) ([a-z]): ([a-z]+)")

    return passwordEntries.count { it ->
        regex.matchEntire(it)?.let { matchResult ->
            val (_, min, max, letter, password) = matchResult.groupValues

            val letterCountInPassword = password.filter {
                it == letter.single()
            }.count()

            return@count letterCountInPassword in (min.toInt()..max.toInt())
        }

        return@count false
    }
}