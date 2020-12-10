package hu.crs.aoc2020.day2

import java.io.File

fun main() {
    val input = File("src/main/resources/day2.txt").readLines()

    println(validPasswordsByLetterCountCount(input))
    println(validPasswordsByLettersAtGivenPositionCount(input))
}

internal fun validPasswordsByLetterCountCount(passwordEntries: List<String>): Int {
    val regex = Regex("([0-9]+)-([0-9]+) ([a-z]): ([a-z]+)")

    return passwordEntries.count { passwordEntry ->
        regex.matchEntire(passwordEntry)?.let { matchResult ->
            val (_, min, max, letter, password) = matchResult.groupValues

            val letterCountInPassword = password.filter {
                it == letter.single()
            }.count()

            return@count letterCountInPassword in (min.toInt()..max.toInt())
        }

        return@count false
    }
}

internal fun validPasswordsByLettersAtGivenPositionCount(passwordEntries: List<String>): Int {
    val regex = Regex("([0-9]+)-([0-9]+) ([a-z]): ([a-z]+)")

    return passwordEntries.count { passwordEntry ->
        regex.matchEntire(passwordEntry)?.let { matchResult ->
            val (_, firstPosition, secondPosition, letter, password) = matchResult.groupValues

            var letterUsageCount = if (password[firstPosition.toInt() - 1] == letter.single()) 1 else 0
            if (password[secondPosition.toInt() - 1] == letter.single()) letterUsageCount++

            return@count letterUsageCount == 1
        }

        return@count false
    }
}