package nl.gauket.mission2020;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day2Test {

    @ParameterizedTest(name = "{index}, part: {1} - input: {0}")
    @MethodSource
    void test_day2(List<String> input, int part, long expected) {
        var result = Day2.solve(input, part);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> test_day2() {
        return Stream.of(
                // part 1
                Arguments.of(List.of("1-3 a: abcde", "1-3 b: cdefg", "2-9 c: ccccccccc"), 1, 2),
                // part 2
                Arguments.of(List.of("1-3 a: abcde", "1-3 b: cdefg", "2-9 c: ccccccccc"), 2, 1)
        );
    }
}
