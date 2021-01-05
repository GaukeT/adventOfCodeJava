package nl.gauket.mission2020;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day10Test {
    @Test
    void part1() {
        var input = new int[]{16,10,15,5,1,11,7,19,6,12,4};
        var expected = 35;

        // TODO: sort happens in @before
        Arrays.sort(input);

        var result = Day10.solve(input, 1);
        assertEquals(expected, result);
    }

    @Test
    void part1b() {
        var input = new int[]{28,33,18,42,31,14,46,20,48,47,24,23,49,45,19,38,39,11,1,32,25,35,8,17,7,9,4,2,34,10,3};
        var expected = 220;

        // TODO: sort happens in @before
        Arrays.sort(input);

        var result = Day10.solve(input, 1);
        assertEquals(expected, result);
    }

    @Test
    void part2() {
        var input = new int[]{16,10,15,5,1,11,7,19,6,12,4};
        var expected = 8;

        // TODO: sort happens in @before
        Arrays.sort(input);

        var result = Day10.solve2(input);
        assertEquals(expected, result);
    }

    @Test
    void part2b() {
        var input = new int[]{28,33,18,42,31,14,46,20,48,47,24,23,49,45,19,38,39,11,1,32,25,35,8,17,7,9,4,2,34,10,3};
        var expected = 19208;

        // TODO: sort happens in @before
        Arrays.sort(input);

        var result = Day10.solve2(input);
        assertEquals(expected, result);
    }

}