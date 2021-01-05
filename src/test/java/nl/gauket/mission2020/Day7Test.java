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
        var expected = 4L;

        var result = Day7.solve(input);
        assertEquals(expected, result);
    }

    @Test
    void part2() {
        var input = new String[]{
                "shiny gold bags contain 2 dark red bags.",     // 1x2
                "dark red bags contain 2 dark orange bags.",    // 2x2
                "dark orange bags contain 2 dark yellow bags.", // 4x2
                "dark yellow bags contain 2 dark green bags.",  // 8x2
                "dark green bags contain 2 dark blue bags.",    // 16x2
                "dark blue bags contain 2 dark violet bags.",   // 32x2
                "dark violet bags contain no other bags."       // 64
        };
        var expected = 126L;

        var result = Day7.solve2(input);
        assertEquals(expected, result);
    }

    @Test
    void part2c() {
        var input = new String[]{
                "light red bags contain 1 bright white bag, 2 muted yellow bags.",
                "dark orange bags contain 3 bright white bags, 4 muted yellow bags.",
                "bright white bags contain 1 shiny gold bag.",
                "muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.",
                "shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.",     // 1*1 + 1*2 = 3
                "dark olive bags contain 3 faded blue bags, 4 dotted black bags.",    // 1*3 + 1*4 = 7
                "vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.",  // 2*5 + 2*6 = 22
                "faded blue bags contain no other bags.",
                "dotted black bags contain no other bags."
        };
        var expected = 32L;

        var result = Day7.solve2(input);
        assertEquals(expected, result);
    }

    @Test
    void part2d() {
        var input = new String[]{
                "shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.",     // 1*1 + 1*2 = 3
                "dark olive bags contain 3 faded blue bags, 4 dotted black bags.",    // 1*3 + 1*4 = 7
                "vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.",  // 2*5 + 2*6 = 22
                "faded blue bags contain 1 muted yellow bag.",
                "dotted black bags contain no other bags.",
                "muted yellow bags contain no other bags."
        };
        var expected = 45L;

        var result = Day7.solve2(input);
        assertEquals(expected, result);
    }

}