package hu.crs.aoc2020.day7

import java.io.File

fun main() {
    val input = File("src/main/resources/day7.txt").readText()
    val bagGraph = graph(input)
    println("Solution 1: ${bagCountThatContainMyBag(bagGraph)}")
    println("Solution 2: ${countBagsInShinyGoldenBag(bagGraph)}")
}

fun bagCountThatContainMyBag(bagGraph: Map<String, List<Pair<Int, String>>>): Int {
    val canContain = mutableSetOf("shiny gold")
    var canContainDirectlyOrIndirectlyUpdated: Set<String>

    do {
        canContainDirectlyOrIndirectlyUpdated = containingBags(bagGraph, canContain)
        if (canContain == canContainDirectlyOrIndirectlyUpdated) {
            return canContain.size - 1
        } else {
            canContain.addAll(canContainDirectlyOrIndirectlyUpdated)
        }
    } while (true)
}

private fun containingBags(bagGraph: Map<String, List<Pair<Int, String>>>, canContain: Set<String>): Set<String> {
    val updatedCanContain = mutableSetOf<String>()
    updatedCanContain.addAll(canContain)

    canContain.forEach { bagsCanContain ->
        bagGraph.entries.forEach { isContain ->
            isContain.value.forEach {
                if (it.second == bagsCanContain) {
                    updatedCanContain.add(isContain.key)
                }
            }
        }
    }

    return updatedCanContain
}

internal fun countBagsInShinyGoldenBag(bagGraph: Map<String, List<Pair<Int, String>>>): Int {
    return countBags(bagGraph, "shiny gold")
}

fun countBags(graph: Map<String, List<Pair<Int, String>>>, nodeName: String): Int {
    val node = graph[nodeName]!!

    var sum = 0
    for (bag in node) {
        sum += bag.first + bag.first * countBags(graph, bag.second)
    }

    return sum
}


internal fun graph(rules: String): Map<String, List<Pair<Int, String>>> {
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