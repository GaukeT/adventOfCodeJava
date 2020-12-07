package nl.gauket.mission2020;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day6Test {
    @Test
    void part1a() {
        var input = List.of("abcx", "abcy", "abcz");
        int expected = 6;

        int result = Day6.solve(new ArrayList<>(input), 1);
        assertEquals(expected, result);
    }

    @Test
    void part1b() {
        var input = List.of(
                "abc",
                "",
                "a",
                "b",
                "c",
                "",
                "ab",
                "ac",
                "",
                "a",
                "a",
                "a",
                "a",
                "",
                "b");
        int expected = 11;

        int result = Day6.solve(new ArrayList<>(input), 1);
        assertEquals(expected, result);
    }

    @Test
    void part2() {
        var input = List.of(
                "abc",
                "",
                "a",
                "b",
                "c",
                "",
                "ab",
                "ac",
                "",
                "a",
                "a",
                "a",
                "a",
                "",
                "b");
        int expected = 6;

        int result = Day6.solve(new ArrayList<>(input), 2);
        assertEquals(expected, result);
    }
}