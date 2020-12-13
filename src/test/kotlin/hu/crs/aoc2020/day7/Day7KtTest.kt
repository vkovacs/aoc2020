package hu.crs.aoc2020.day7

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class Day7KtTest {

    @Test
    internal fun `should count directly containing bags`() {
        val rules = """
            dotted black bags contain 1 shiny gold bag.
            vibrant plum bags contain 3 shiny gold bags.
            dark orange bags contain 1 bright white bag, 1 shiny gold bag.
            bright white bags contain 2 shiny gold bags, 1 faded blue bag.
            dark olive bags contain 1 shiny gold bag, 1 faded blue bag.
            light red bags contain 1 bright white bag, 2 shiny gold bags.
        """.trimIndent()
        Assertions.assertEquals(6, bagCountThatContainMyBag(rules))
    }

    @Test
    internal fun `should count bags that can contain my bag`() {
        val rules ="""
        light red bags contain 1 bright white bag, 2 muted yellow bags.
        dark orange bags contain 3 bright white bags, 4 muted yellow bags.
        bright white bags contain 1 shiny gold bag.
        muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.
        shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.
        dark olive bags contain 3 faded blue bags, 4 dotted black bags.
        vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.
        faded blue bags contain no other bags.
        dotted black bags contain no other bags.""".trimIndent()

        Assertions.assertEquals(4, bagCountThatContainMyBag(rules))
    }
}

