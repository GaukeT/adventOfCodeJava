package nl.gauket.mission2020;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day2Test {

    @Test
    void part1() {
        List<String> input = List.of("1-3 a: abcde", "1-3 b: cdefg", "2-9 c: ccccccccc");
        int expected = 2;

        var result = Day2.solve(input, 1);
        assertEquals(expected, result);
    }

    @Test
    void part2() {
        List<String> input = List.of("1-3 a: abcde", "1-3 b: cdefg", "2-9 c: ccccccccc");
        int expected = 1;

        var result = Day2.solve(input, 2);
        assertEquals(expected, result);
    }
}
