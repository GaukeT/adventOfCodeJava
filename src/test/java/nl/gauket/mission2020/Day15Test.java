package nl.gauket.mission2020;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Day15Test {
    @ParameterizedTest(name = "{index}, rounds: {1} input: {0}")
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
                Arguments.of(new int[]{3,1,2}, 2020, 1836L),
                Arguments.of(new int[]{0,3,6}, 30000000, 175594L),
                Arguments.of(new int[]{1,3,2}, 30000000, 2578L),
                Arguments.of(new int[]{2,1,3}, 30000000, 3544142L),
                Arguments.of(new int[]{1,2,3}, 30000000, 261214L),
                Arguments.of(new int[]{2,3,1}, 30000000, 6895259L),
                Arguments.of(new int[]{3,2,1}, 30000000, 18L),
                Arguments.of(new int[]{3,1,2}, 30000000, 362L)
        );
    }


    @Test
    @DisplayName("Bit shift test")
    void shift() {
        System.out.println("->");
        var first = 2L;
        System.out.println("F  " + first);
        System.out.println("Fb " + Long.toBinaryString(first));

        var last = 4L;
        System.out.println("L  " + last);
        System.out.println("Lb " + Long.toBinaryString(last));

        System.out.println("->");
        var newVal = first << 32 | last;
        System.out.println("Nb " + Long.toBinaryString(newVal));
        System.out.println("N  " + newVal);

        System.out.println("->");
        var extractedFirst = (newVal >> 32);
        System.out.println("Fb " + Long.toBinaryString(extractedFirst));
        System.out.println("F  " + extractedFirst);

        var extractedLast = (int) newVal;
        System.out.println("Lb " + Long.toBinaryString(extractedLast));
        System.out.println("L  " + extractedLast);
        System.out.println("->");

        assertEquals(first, extractedFirst);
        assertEquals(last, extractedLast);
    }
}