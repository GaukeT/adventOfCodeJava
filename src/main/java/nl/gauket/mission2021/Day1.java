package nl.gauket.mission2021;

import nl.gauket.common.InputReader;
import nl.gauket.common.NewDay;

public class Day1 extends NewDay {
    @Override
    public void before(int year, int day) {
        INPUT_INT = InputReader.readInputAsIntStream(year, day).toArray();
    }

    @Override
    public long[] solvePart1() {
        var result = solveFirst(INPUT_INT.clone());
        return new long[] {result, 1466};
    }

    @Override
    public long[] solvePart2() {
        var result = solveSecond(INPUT_INT.clone());
        return new long[] {result, 1491};
    }

    public static long solveFirst(int[] input) {
        var result = 0;
        var prev = input[0];
        for (int i = 1; i < input.length; i++) {
            var m = input[i];
            if (m > prev) result++;
            prev = m;
        }

        return result;
    }

    public static long solveSecond(int[] input) {
        var result = 0;
        var prev = getSumOfWindowAtIndex(input, 0);
        for (int i = 1; i < input.length-2; i++) {
            var m = getSumOfWindowAtIndex(input, i);
            if (m > prev) result++;
            prev = m;
        }

        return result;
    }

    private static int getSumOfWindowAtIndex(int[] input, int i) {
        return input[i] + input[i+1] + input[i+2];
    }
}
