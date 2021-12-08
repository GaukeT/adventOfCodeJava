package nl.gauket.mission2021;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day6Test {

    @ParameterizedTest(name = "{index}, days: {1} - input: {0}")
    @MethodSource
    void solveArr(int[] input, int days, long expected) {
        var result = Day6.solveArr(input, days);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> solveArr() {
        return Stream.of(
                Arguments.of(new int[]{ 3,4,3,1,2 }, 18, 26),
                Arguments.of(new int[]{ 3,4,3,1,2 }, 80, 5934)
//                Arguments.of(new int[]{ 3,4,3,1,2 }, 256, 26984457539L)
        );
    }

    @ParameterizedTest(name = "{index}, days: {1} - input: {0}")
    @MethodSource
    void solve(int[] input, int days, long expected) {
        var result = Day6.solve(input, days);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> solve() {
        return Stream.of(
                Arguments.of(new int[]{ 3,4,3,1,2 }, 18, 26),
                Arguments.of(new int[]{ 3,4,3,1,2 }, 80, 5934)
//                Arguments.of(new int[]{ 3,4,3,1,2 }, 256, 26984457539L)
        );
    }
}