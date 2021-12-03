package nl.gauket.mission2021;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day1Test {
    @Test
    void solvePart1() {
        var input = new int[] { 199, 200, 208, 210, 200, 207, 240, 269, 260, 263 };

        int expected = 7;

        var result = Day1.solveFirst(input);
        assertEquals(expected, result);
    }

    @Test
    void solvePart2() {
        var input = new int[] { 199, 200, 208, 210, 200, 207, 240, 269, 260, 263 };

        int expected = 5;

        var result = Day1.solveSecond(input);
        assertEquals(expected, result);
    }
}