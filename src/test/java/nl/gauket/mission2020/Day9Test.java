package nl.gauket.mission2020;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day9Test {
    @Test
    void part1() {
        var input = new long[]{35L, 20L, 15L, 25L, 47L, 40L, 62L, 55L, 65L, 95L, 102L, 117L, 150L, 182L, 127L, 219L, 299L, 277L, 309L, 576L};
        var expected = 127L;

        var result = Day9.solve(input, 5, 1);
        assertEquals(expected, result);
    }

    @Test
    void part2() {
        var input = new long[]{35L, 20L, 15L, 25L, 47L, 40L, 62L, 55L, 65L, 95L, 102L, 117L, 150L, 182L, 127L, 219L, 299L, 277L, 309L, 576L};
        var expected = 62L;

        var result = Day9.solve(input, 5, 2);
        assertEquals(expected, result);
    }
}