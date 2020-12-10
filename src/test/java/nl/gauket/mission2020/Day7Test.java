package nl.gauket.mission2020;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day7Test {
    @Test
    void part1() {
        var input = new String[]{
                "light red bags contain 1 bright white bag, 2 muted yellow bags.",
                "dark orange bags contain 3 bright white bags, 4 muted yellow bags.",
                "bright white bags contain 1 shiny gold bag.",
                "muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.",
                "shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.",
                "dark olive bags contain 3 faded blue bags, 4 dotted black bags.",
                "vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.",
                "faded blue bags contain no other bags.",
                "dotted black bags contain no other bags."
        };
        int expected = 4;

        int result = Day7.solve(input, 1);
        assertEquals(expected, result);
    }

    @Test
    void part2() {
        var input = new String[]{
                "shiny gold bags contain 2 dark red bags.",
                "dark red bags contain 2 dark orange bags.",
                "dark orange bags contain 2 dark yellow bags.",
                "dark yellow bags contain 2 dark green bags.",
                "dark green bags contain 2 dark blue bags.",
                "dark blue bags contain 2 dark violet bags.",
                "dark violet bags contain no other bags."
        };
        int expected = 126;

        int result = Day7.solve(input, 2);
        assertEquals(expected, result);
    }

    @Test
    void part2b() {
        var input = new String[]{
                "shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.",       // 1x3
                "dark olive bags contain 3 faded blue bags, 4 dotted black bags.",      // 1x7
                "vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.",    // 2x5 + 2x6
                "faded blue bags contain no other bags.",                               //
                "dotted black bags contain no other bags."                              //
        };
        int expected = 32;

        int result = Day7.solve(input, 2);
        assertEquals(expected, result);
    }

}