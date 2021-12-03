package nl.gauket.mission2021;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day2Test {

    @Test
    void solvePart1() {
        var input = new String[] {
                "forward 5",
                "down 5",
                "forward 8",
                "up 3",
                "down 8",
                "forward 2"
        };

        int expected = 150;

        var result = Day2.solveFirst(input);
        assertEquals(expected, result);
    }

    @Test
    void solvePart2() {
        var input = new String[] {
                "forward 5",
                "down 5",
                "forward 8",
                "up 3",
                "down 8",
                "forward 2"
        };

        int expected = 900;

        var result = Day2.solveSecond(input);
        assertEquals(expected, result);
    }
}