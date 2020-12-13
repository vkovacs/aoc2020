package hu.crs.aoc2020.day7

import java.io.File

fun main() {
    val input = File("src/main/resources/day7.txt").readText()
    println(bagCountThatContainMyBag(input))
}

fun bagCountThatContainMyBag(rules: String): Int {
    val rulesList = rules.split("\n")
    val canContain = mutableSetOf("shiny gold")
    var canContainDirectlyOrIndirectlyUpdated: Set<String>

    do {
        canContainDirectlyOrIndirectlyUpdated = containingBags(rulesList, canContain)
        println(canContainDirectlyOrIndirectlyUpdated)
        if (canContain == canContainDirectlyOrIndirectlyUpdated) {
            return canContain.size - 1
        } else {
            canContain.addAll(canContainDirectlyOrIndirectlyUpdated)
        }
    } while (true)
}

private fun containingBags(rulesList: List<String>, canContain: Set<String>): Set<String> {

    val canContainNewBags = mutableSetOf<String>()
    canContainNewBags.addAll(canContain)

    val directContainRegex1 = Regex("([a-z ]+) bags contain ([0-9]+) ([a-z ]+) (bag|bags)\\.")
    val directContainRegex2 = Regex("([a-z ]+) bags contain ([0-9]+) ([a-z ]+) (bag|bags), ([0-9]+) ([a-z ]+) (bag|bags)\\.");
    val directContainRegex3 = Regex("([a-z ]+) bags contain ([0-9]+) ([a-z ]+) (bag|bags), ([0-9]+) ([a-z ]+) (bag|bags), ([0-9]+) ([a-z ]+) (bag|bags)\\.");
    val directContainRegex4 = Regex("([a-z ]+) bags contain ([0-9]+) ([a-z ]+) (bag|bags), ([0-9]+) ([a-z ]+) (bag|bags), ([0-9]+) ([a-z ]+) (bag|bags), ([0-9]+) ([a-z ]+) (bag|bags)\\.");

    for (rule in rulesList) {
        val matchContainment1 = directContainRegex1.matchEntire(rule)
        if (matchContainment1 != null) {
            val containedBagColor0 = matchContainment1.groupValues[3]
            if (canContainNewBags.contains(containedBagColor0))
                canContainNewBags.add(matchContainment1.groupValues[1])
            continue
        }
        val matchContainment2 = directContainRegex2.matchEntire(rule)
        if (matchContainment2 != null) {
            val containedBagColor0 = matchContainment2.groupValues[3]
            if (canContainNewBags.contains(containedBagColor0)) {
                canContainNewBags.add(matchContainment2.groupValues[1])
                continue
            }
            val containedBagColor1 = matchContainment2.groupValues[6]
            if (canContainNewBags.contains(containedBagColor1)) {
                canContainNewBags.add(matchContainment2.groupValues[1])
                continue
            }
        }

        val matchContainment3 = directContainRegex3.matchEntire(rule)
        if (matchContainment3 != null) {
            val containedBagColor0 = matchContainment3.groupValues[3]
            if (canContainNewBags.contains(containedBagColor0)) {
                canContainNewBags.add(matchContainment3.groupValues[1])
                continue
            }
            val containedBagColor1 = matchContainment3.groupValues[6]
            if (canContainNewBags.contains(containedBagColor1)) {
                canContainNewBags.add(matchContainment3.groupValues[1])
                continue
            }
            val containedBagColor2 = matchContainment3.groupValues[9]
            if (canContainNewBags.contains(containedBagColor2)) {
                canContainNewBags.add(matchContainment3.groupValues[1])
                continue
            }
        }

        val matchContainment4 = directContainRegex4.matchEntire(rule)
        if (matchContainment4 != null) {
            val containedBagColor0 = matchContainment4.groupValues[3]
            if (canContainNewBags.contains(containedBagColor0)) {
                canContainNewBags.add(matchContainment4.groupValues[1])
                continue
            }
            val containedBagColor1 = matchContainment4.groupValues[6]
            if (canContainNewBags.contains(containedBagColor1)) {
                canContainNewBags.add(matchContainment4.groupValues[1])
                continue
            }
            val containedBagColor2 = matchContainment4.groupValues[9]
            if (canContainNewBags.contains(containedBagColor2)) {
                canContainNewBags.add(matchContainment4.groupValues[1])
                continue
            }
            val containedBagColor3 = matchContainment4.groupValues[12]
            if (canContainNewBags.contains(containedBagColor3)) {
                canContainNewBags.add(matchContainment4.groupValues[1])
                continue
            }
        }
    }
    return canContainNewBags
}