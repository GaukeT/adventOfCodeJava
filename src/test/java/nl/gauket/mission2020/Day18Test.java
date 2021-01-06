package nl.gauket.mission2020;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day18Test {

    @Test
    void part1() {
        var input = new String[]{
                "2 * 3 + (4 * 5)"
        };
        var expected = 26L;

        var result = Day18.solve(input);
        assertEquals(expected, result);
    }

    @Test
    void part1b() {
        var input = new String[]{
                "5 + (8 * 3 + 9 + 3 * 4 * 3)"
        };
        var expected = 437L;

        var result = Day18.solve(input);
        assertEquals(expected, result);
    }

    @Test
    void part1c() {
        var input = new String[]{
                "5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))"
        };
        var expected = 12240L;

        var result = Day18.solve(input);
        assertEquals(expected, result);
    }

    @Test
    void part1d() {
        var input = new String[]{
                "((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2"
        };
        var expected = 13632L;

        var result = Day18.solve(input);
        assertEquals(expected, result);
    }

    @Test
    void part1e() {
        var input = new String[]{
                "1 + 2 * 3 + 4 * 5 + 6"
        };
        var expected = 71L;

        var result = Day18.solve(input);
        assertEquals(expected, result);
    }

    @Test
    void part1f() {
        var input = new String[]{
                "1 + (2 * 3) + (4 * (5 + 6))"
        };
        var expected = 51L;

        var result = Day18.solve(input);
        assertEquals(expected, result);
    }

    @Test
    void part1g() {
        var input = new String[]{
                "2 * 3 + (4 * 5)",
                "2 * 3 + (4 * 5)"
        };
        var expected = 52L;

        var result = Day18.solve(input);
        assertEquals(expected, result);
    }

    @Test
    void part1h() {
        var input = new String[]{
                "8 + ((7 + 3 + 7 * 7) * (6 * 4 * 6 * 3 + 3 + 9)) * (8 * (3 * 5 * 5 * 6 + 6 * 7) + 5 + 4)"
        };
        var expected = 1_349_899_980L;

        var result = Day18.solve(input);
        assertEquals(expected, result);
    }


}