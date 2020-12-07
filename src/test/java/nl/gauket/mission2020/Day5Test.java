package nl.gauket.mission2020;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day5Test {
    @Test
    void part1a() {
        String[] input = {"FBFBBFFRLR"};
        int expected = 357;

        int result = Day5.solve(input, 1);
        assertEquals(expected, result);
    }

    @Test
    void part1b() {
        String[] input = {"FBFBBFFRLR", "BFFFBBFRRR", "FFFBBBFRRR", "BBFFBBFRLL"};
        int expected = 820;

        int result = Day5.solve(input, 1);
        assertEquals(expected, result);
    }
}