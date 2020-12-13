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
        Assertions.assertEquals(6, bagCountThatContainMyBag(graph(rules)))
    }

    @Test
    internal fun `should count bags that can contain my bag`() {
        val rules = """
        light red bags contain 1 bright white bag, 2 muted yellow bags.
        dark orange bags contain 3 bright white bags, 4 muted yellow bags.
        bright white bags contain 1 shiny gold bag.
        muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.
        shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.
        dark olive bags contain 3 faded blue bags, 4 dotted black bags.
        vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.
        faded blue bags contain no other bags.
        dotted black bags contain no other bags.""".trimIndent()

        Assertions.assertEquals(4, bagCountThatContainMyBag(graph(rules)))
    }

    @Test
    internal fun `should count bags in shiny gold bag`() {
        val rules = """
            light red bags contain 1 bright white bag, 2 muted yellow bags.
            dark orange bags contain 3 bright white bags, 4 muted yellow bags.
            bright white bags contain 1 shiny gold bag.
            muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.
            shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.
            dark olive bags contain 3 faded blue bags, 4 dotted black bags.
            vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.
            faded blue bags contain no other bags.
            dotted black bags contain no other bags.
        """.trimIndent()
        Assertions.assertEquals(32, countBagsInShinyGoldenBag(graph(rules)))
    }

    @Test
    internal fun `should count bags in shiny gold bag another`() {
        val rules = """
            shiny gold bags contain 2 dark red bags.
            dark red bags contain 2 dark orange bags.
            dark orange bags contain 2 dark yellow bags.
            dark yellow bags contain 2 dark green bags.
            dark green bags contain 2 dark blue bags.
            dark blue bags contain 2 dark violet bags.
            dark violet bags contain no other bags.""".trimIndent()
            Assertions.assertEquals(126, countBagsInShinyGoldenBag(graph(rules)))
    }
}

