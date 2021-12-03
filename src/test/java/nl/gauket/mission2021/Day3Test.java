package nl.gauket.mission2021;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day3Test {

    @Test
    void solvePart1() {
        var input = new String[] {
                "00100",
                "11110",
                "10110",
                "10111",
                "10101",
                "01111",
                "00111",
                "11100",
                "10000",
                "11001",
                "00010",
                "01010"
        };

        int expected = 198;

        var result = Day3.solveFirst(input);
        assertEquals(expected, result);
    }

    @Test
    void solvePart2() {
        var input = new String[] {
                "00100",
                "11110",
                "10110",
                "10111",
                "10101",
                "01111",
                "00111",
                "11100",
                "10000",
                "11001",
                "00010",
                "01010"
        };

        int expected = 230;

        var result = Day3.solveSecond(input);
        assertEquals(expected, result);
    }
}