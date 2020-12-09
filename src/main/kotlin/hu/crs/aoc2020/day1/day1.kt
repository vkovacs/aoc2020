package hu.crs.aoc2020.day1

import java.io.File

fun main() {

    val input = File("src/main/resources/day1.txt").useLines { it ->
        it.map { it.toInt() }
            .toList()
    }

    findTwoNumberSum2020(input)?.let {
        val (factor0, factor1) = it
        println("Sum of two: ${factor0 * factor1}")
    }

    findThreeNumbersSum2020(input)?.let {
        val (factor0, factor1, factor2) = it
        println("Sum of three: ${factor0 * factor1 * factor2}")
    }
}

internal fun findTwoNumberSum2020(input: List<Int>): Pair<Int, Int>? {
    for (i in input.indices) {
        for (j in input.indices) {
            if (input[i] + input[j] == 2020) return Pair(input[i], input[j])
        }
    }
    return null
}

internal fun findThreeNumbersSum2020(input: List<Int>): Triple<Int, Int, Int>? {
    for (i in input.indices) {
        for (j in input.indices) {
            for (k in input.indices) {
                if (input[i] + input[j] + input[k] == 2020) return Triple(input[i], input[j], input[k])
            }
        }
    }
    return null
}
