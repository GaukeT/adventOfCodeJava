package nl.gauket.mission2020;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day18Test {

    @ParameterizedTest(name = "{index}, isAdvanced: {0} - input: {1}")
    @MethodSource
    void test_day18(boolean isAdvanced, String[] input, long expected) {
        var result = Day18.solve(input, isAdvanced);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> test_day18() {
        return Stream.of(
                // part 1
                Arguments.of(false, new String[]{"2 * 3 + (4 * 5)"}, 26L),
                Arguments.of(false, new String[]{"5 + (8 * 3 + 9 + 3 * 4 * 3)"}, 437L),
                Arguments.of(false, new String[]{"5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))"} , 12240L),
                Arguments.of(false, new String[]{"((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2"}, 13632L),
                Arguments.of(false, new String[]{"1 + 2 * 3 + 4 * 5 + 6"}, 71L),
                Arguments.of(false, new String[]{"1 + (2 * 3) + (4 * (5 + 6))"}, 51L),
                Arguments.of(false, new String[]{"2 * 3 + (4 * 5)","2 * 3 + (4 * 5)"}, 52L),
                Arguments.of(false, new String[]{"8 + ((7 + 3 + 7 * 7) * (6 * 4 * 6 * 3 + 3 + 9)) * (8 * (3 * 5 * 5 * 6 + 6 * 7) + 5 + 4)"}, 1_349_899_980L),
                // part 2
                Arguments.of(true, new String[]{"2 * 3 + (4 * 5)"}, 46L),
                Arguments.of(true, new String[]{"1 + (2 * 3) + (4 * (5 + 6))"}, 51L),
                Arguments.of(true, new String[]{"5 + (8 * 3 + 9 + 3 * 4 * 3)"}, 1445L),
                Arguments.of(true, new String[]{"5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))"}, 669060L),
                Arguments.of(true, new String[]{"((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2"}, 23340L)
        );
    }
}