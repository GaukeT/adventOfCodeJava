package nl.gauket.mission2020;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Day15Test {
    @ParameterizedTest(name = "{index}, input: {0}")
    @MethodSource
    void part1(int[] input, int totalRounds, long expected) {
        var result = Day15.solve(input, totalRounds);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> part1() {
        return Stream.of(
                Arguments.of(new int[]{0,3,6}, 2020, 436L),
                Arguments.of(new int[]{1,3,2}, 2020, 1L),
                Arguments.of(new int[]{2,1,3}, 2020, 10L),
                Arguments.of(new int[]{1,2,3}, 2020, 27L),
                Arguments.of(new int[]{2,3,1}, 2020, 78L),
                Arguments.of(new int[]{3,2,1}, 2020, 438L),
                Arguments.of(new int[]{3,1,2}, 2020, 1836L)
        );
    }

}
