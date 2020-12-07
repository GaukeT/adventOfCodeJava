package nl.gauket.mission2020;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day1Test {

    @Test
    void part1() {
        int[] input = {1721, 979, 366, 299, 675, 1456};
        int expected = 514579;

        int result = Day1.solve(input, 2);
        assertEquals(expected, result);
    }

    @Test
    void part2() {
        int[] input = {1721, 979, 366, 299, 675, 1456};
        int expected = 241861950;

        int result = Day1.solve(input, 3);
        assertEquals(expected, result);
    }
}
