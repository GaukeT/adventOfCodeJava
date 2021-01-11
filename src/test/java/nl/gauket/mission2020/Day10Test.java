package nl.gauket.mission2020;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day10Test {
    @ParameterizedTest(name = "{index}, part: {0} - input: {1}")
    @MethodSource
    void test_day18(int part, int[] input, long expected) {
        // TODO: sort happens in @before
        Arrays.sort(input);

        var result = Day10.solve(input, part);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> test_day18() {
        return Stream.of(
                // part 1
                Arguments.of(1, new int[]{16, 10, 15, 5, 1, 11, 7, 19, 6, 12, 4}, 35L),
                Arguments.of(1, new int[]{28, 33, 18, 42, 31, 14, 46, 20, 48, 47, 24, 23, 49, 45, 19, 38, 39, 11, 1, 32, 25, 35, 8, 17, 7, 9, 4, 2, 34, 10, 3}, 220L),
                // part 2
                Arguments.of(2, new int[]{16, 10, 15, 5, 1, 11, 7, 19, 6, 12, 4}, 8L),
                Arguments.of(2, new int[]{28, 33, 18, 42, 31, 14, 46, 20, 48, 47, 24, 23, 49, 45, 19, 38, 39, 11, 1, 32, 25, 35, 8, 17, 7, 9, 4, 2, 34, 10, 3}, 19208L)
        );
    }
}