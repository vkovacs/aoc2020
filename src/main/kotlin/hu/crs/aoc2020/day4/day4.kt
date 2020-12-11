package hu.crs.aoc2020.day4

import java.io.File

fun main() {
    val input = File("src/main/resources/day4.txt").readText()
    println(validPapersCount(input))
}

internal fun validPapersCount(papers: String): Int {
    var validPapersCount = 0

    val papersStringList = papers.split("\n\n")
    for (papersStringDelimited in papersStringList) {
        val papersString = papersStringDelimited.replace("\n", " ")

        val paperMap = parseToMap(papersString)

        if (validatePaperMap(paperMap)) {
            validPapersCount++
        }
    }

    return validPapersCount
}

private fun parseToMap(papersString: String): MutableMap<String, String> {
    val paperMap = mutableMapOf<String, String>()

    for (keyValue in papersString.split(" ")) {
        val split = keyValue.split(":")

        val key = split[0]
        val value = split[1]

        paperMap[key] = value
    }
    return paperMap
}

fun validatePaperMap(paperMap: MutableMap<String, String>): Boolean {
    return paperMap["byr"] != null && paperMap["iyr"] != null && paperMap["eyr"] != null && paperMap["hgt"] != null &&
            paperMap["hcl"] != null && paperMap["ecl"] != null && paperMap["pid"] != null
}
