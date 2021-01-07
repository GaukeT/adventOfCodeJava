package nl.gauket.mission2020;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day1Test {

    @ParameterizedTest(name = "{index}, nrOfItems: {1} - input: {0}")
    @MethodSource
    void test_day1(int[] input, int nrOfItems, long expected) {
        // TODO: sort happens in @before
        Arrays.sort(input);

        var result = Day1.solve(input, nrOfItems);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> test_day1() {
        return Stream.of(
                // part 1
                Arguments.of(new int[]{1721, 979, 366, 299, 675, 1456}, 2, 514579),
                // part 2
                Arguments.of(new int[]{1721, 979, 366, 299, 675, 1456}, 3, 241861950)
        );
    }
}
