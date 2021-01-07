package nl.gauket.mission2020;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day13Test {
    @Test
    void part1() {
        var input = new String[]{
                "939",
                "7,13,x,x,59,x,31,19"
        };
        var expected = 295L;

        var result = Day13.solve(input);
        assertEquals(expected, result);
    }

    @ParameterizedTest(name = "{index}, input: {0}")
    @MethodSource
    void part2(String[] input, long expected) {
        var result = Day13.solve2(input);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> part2() {
        return Stream.of(
                Arguments.of(new String[]{"ignore","7,13,x,x,59,x,31,19"}, 1068781L),
                Arguments.of(new String[]{"ignore","17,x,13,19"}, 3417L),
                Arguments.of(new String[]{"ignore","67,7,59,61"}, 754018L),
                Arguments.of(new String[]{"ignore","67,x,7,59,61"}, 779210L),
                Arguments.of(new String[]{"ignore","67,7,x,59,61"}, 1261476L),
                Arguments.of(new String[]{"ignore","1789,37,47,1889"}, 1202161486L)
        );
    }
}