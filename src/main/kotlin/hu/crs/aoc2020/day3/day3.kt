package hu.crs.aoc2020.day3

import java.io.File

fun main() {
    val input = File("src/main/resources/day3.txt").readLines()
    val right1Down1Trees = countTrees(input, 1, 1)
    val right3Down1Trees = countTrees(input, 3, 1)
    val right5Down1Trees = countTrees(input, 5, 1)
    val right7Down1Trees = countTrees(input, 7, 1)
    val right1Down2Trees = countTrees(input, 1, 2)

    println(right1Down1Trees)
    val allTrailsTrees = 1L * right1Down1Trees * right3Down1Trees * right5Down1Trees * right7Down1Trees * right1Down2Trees
    println(allTrailsTrees)
}

fun countTrees(map: List<String>, rightMovement: Int, downMovement: Int): Int {
    var treeCount = 0

    var column = 0

    for (row in downMovement until map.size step downMovement) {
        column += rightMovement

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