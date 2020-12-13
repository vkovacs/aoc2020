package hu.crs.aoc2020.day7

import java.io.File

fun main() {
    val input = File("src/main/resources/day7.txt").readText()
    println("Solution 1: ${bagCountThatContainMyBag(input)}")
    println("Solution 2: ${countBagsInShinyGoldenBag(input)}")
}

fun bagCountThatContainMyBag(rules: String): Int {
    val rulesList = rules.split("\n")
    val canContain = mutableSetOf("shiny gold")
    var canContainDirectlyOrIndirectlyUpdated: Set<String>

    do {
        canContainDirectlyOrIndirectlyUpdated = containingBags(rulesList, canContain)
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
    val directContainRegex2 =
        Regex("([a-z ]+) bags contain ([0-9]+) ([a-z ]+) (bag|bags), ([0-9]+) ([a-z ]+) (bag|bags)\\.");
    val directContainRegex3 =
        Regex("([a-z ]+) bags contain ([0-9]+) ([a-z ]+) (bag|bags), ([0-9]+) ([a-z ]+) (bag|bags), ([0-9]+) ([a-z ]+) (bag|bags)\\.");
    val directContainRegex4 =
        Regex("([a-z ]+) bags contain ([0-9]+) ([a-z ]+) (bag|bags), ([0-9]+) ([a-z ]+) (bag|bags), ([0-9]+) ([a-z ]+) (bag|bags), ([0-9]+) ([a-z ]+) (bag|bags)\\.");

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

internal fun countBagsInShinyGoldenBag(rules: String): Int {
    return countBags(graph(rules), "shiny gold")
}

fun countBags(graph: Map<String, List<Pair<Int, String>>>, nodeName: String): Int {
    val node = graph[nodeName]!!

    var sum = 0
    for (bag in node) {
        sum += bag.first + bag.first * countBags(graph, bag.second)
    }

    return sum
}


private fun graph(rules: String): Map<String, List<Pair<Int, String>>> {
    val graph: MutableMap<String, MutableList<Pair<Int, String>>> = mutableMapOf()
    rules.replace("bags", "bag")
        .replace(".", "")
        .split("\n")
        .forEach {
            var (container, contains) = it.split(" bag contain")
            contains = contains.replace("bag", "")
            val containedBags = contains.split(",")

            val countColorRegex = Regex("([0-9])+ ([a-z ]+)")
            graph[container] = mutableListOf()

            for (bag in containedBags) {
                val bagCountColorMatch = countColorRegex.matchEntire(bag.trim())
                if (bagCountColorMatch != null) {
                    val (_, count, color) = bagCountColorMatch.groupValues
                    graph[container]!!.add(count.toInt() to color)
                }
            }
        }

    return graph
}