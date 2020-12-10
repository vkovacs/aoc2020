package hu.crs.aoc2020.day3

import java.io.File

fun main() {
    val input = File("src/main/resources/day3.txt").readLines()
    println(countTrees(input))
}

fun countTrees(map: List<String>): Int {
    var treeCount = 0

    var column = 0

    for (row in 1 until map.size) {
        column += 3

        if (column >= map[row].length) {
            column -= map[row].length
        }

        if (map[row][column] == '#')
            treeCount++

        visualizeTrail(map[row], column)
    }

    return treeCount
}

fun visualizeTrail(line: String, actualColumn: Int) {
    val toCharArray = line.toCharArray()
    toCharArray[actualColumn] = 'O'
    println(toCharArray)
}