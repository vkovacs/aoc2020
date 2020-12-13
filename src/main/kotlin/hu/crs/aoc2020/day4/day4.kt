package hu.crs.aoc2020.day4

import java.io.File

fun main() {
    val input = File("src/main/resources/day4.txt").readText()
    println(validPassportCount(input, ::validatePassportMap))
    println(validPassportCount(input, ::validatePassportMapWithConstraints))
}

internal fun validPassportCount(papers: String, validate : (Map<String, String>) -> Boolean): Int {
    var validPassportsCount = 0

    val papersStringList = papers.split("\n\n")
    for (papersStringDelimited in papersStringList) {
        val papersString = papersStringDelimited.replace("\n", " ")

        val paperMap = parseToMap(papersString)

        if (validate(paperMap)) {
            validPassportsCount++
        }
    }

    return validPassportsCount
}

private fun parseToMap(papersString: String): Map<String, String> {
    val paperMap = mutableMapOf<String, String>()

    for (keyValue in papersString.split(" ")) {
        val split = keyValue.split(":")

        val key = split[0]
        val value = split[1]

        paperMap[key] = value
    }
    return paperMap
}

fun validatePassportMap(paperMap: Map<String, String>): Boolean {
    return paperMap["byr"] != null && paperMap["iyr"] != null && paperMap["eyr"] != null && paperMap["hgt"] != null &&
            paperMap["hcl"] != null && paperMap["ecl"] != null && paperMap["pid"] != null
}

fun validatePassportMapWithConstraints(paperMap: Map<String, String>): Boolean {
    val byr = paperMap["byr"]
    val iyr = paperMap["iyr"]
    val eyr = paperMap["eyr"]
    val hgt = paperMap["hgt"]
    val hcl = paperMap["hcl"]
    val ecl = paperMap["ecl"]
    val pid = paperMap["pid"]

    if (byr == null || iyr == null || eyr == null || hgt == null || hcl == null || ecl == null || pid == null)
        return false

    if (byr.toInt() !in 1920..2002)
        return false

    if (iyr.toInt() !in 2010..2020)
        return false

    if (eyr.toInt() !in 2020..2030)
        return false

    val heightMatchResult = Regex("([0-9]{2,3})(cm|in)").matchEntire(hgt) ?: return false

    val (_, number, unit) = heightMatchResult.groupValues
    when (unit) {
        "cm" -> if (number.toInt() !in 150..193) {
            return false
        }
        "in" -> if (number.toInt() !in 59..76) {
            return false
        }
    }

    if (!Regex("^#[0-9a-f]{6}$").matches(hcl)) {
        return false
    }

    if (!Regex("^amb|blu|brn|gry|grn|hzl|oth$").matches(ecl)) {
        return false
    }

    if (!Regex("^[0-9]{9}$").matches(pid)) {
        return false
    }
    return true
}
