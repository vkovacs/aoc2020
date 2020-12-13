package hu.crs.aoc2020.day6

import java.io.File

fun main() {
    val input = File("src/main/resources/day6.txt").readText()
    println(countYes(input))
    println(countAllYes(input))
}


internal fun countYes(answers: String): Int {
    val groupAnswers = answers.split("\n\n")

    var sum = 0
    for (groupAnswer in groupAnswers) {
        val distinctGroupAnswers = mutableSetOf<Char>()
        for (answer in groupAnswer.replace("\n", "")) {
            distinctGroupAnswers.add(answer)
        }
        sum += distinctGroupAnswers.size
    }

    return sum
}

internal fun countAllYes(answers: String): Int {
    val groupAnswers = answers.split("\n\n")

    var sum = 0
    for (groupAnswer in groupAnswers) {
        val respondents = groupAnswer.filter { it == '\n' }.count() + 1

        val inlineGroupAnswer = groupAnswer.replace("\n", "")
        sum += inlineGroupAnswer.groupBy { it }
            .filterValues { it.size == respondents }
            .count()
    }

    return sum
}