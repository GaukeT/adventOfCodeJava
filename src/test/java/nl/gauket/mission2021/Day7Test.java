package nl.gauket.mission2021;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day7Test {

    @ParameterizedTest(name = "{index}, days: {1} - input: {0}")
    @MethodSource
    void solve(int[] input, long expected) {
        var result = Day7.solve(input);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> solve() {
        return Stream.of(
                Arguments.of(new int[]{ 16,1,2,0,4,2,7,1,2,14 }, 37)
        );
    }

    @ParameterizedTest(name = "{index}, days: {1} - input: {0}")
    @MethodSource
    void solve2(int[] input, long expected) {
        var result = Day7.solve2(input);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> solve2() {
        return Stream.of(
                Arguments.of(new int[]{ 16,1,2,0,4,2,7,1,2,14 }, 168)
        );
    }
}