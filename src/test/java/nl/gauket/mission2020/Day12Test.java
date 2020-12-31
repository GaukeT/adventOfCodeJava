package nl.gauket.mission2020;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day12Test {
    @Test
    void part1() {
        var input = new String[]{"F10", "N3", "F7", "R90", "F11"};
        int expected = 25;

        int result = Day12.solve(input, 1);
        assertEquals(expected, result);
    }

    @Test
    void part2() {
        var input = new String[]{"F10", "N3", "F7", "R90", "F11"};
        int expected = 286;

        int result = Day12.solve(input, 2);
        assertEquals(expected, result);
    }

    @Test
    void part2a() {
        var input = new String[]{"F10", "N3", "F7", "R90", "L90", "R180", "L180", "R270", "L270", "R90", "F11"};
        int expected = 286;

        int result = Day12.solve(input, 2);
        assertEquals(expected, result);
    }

}