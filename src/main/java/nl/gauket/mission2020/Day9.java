package nl.gauket.mission2020;

import nl.gauket.common.InputReader;
import nl.gauket.common.NewDay;

import java.util.Arrays;

import static java.util.Arrays.copyOfRange;
import static java.util.Arrays.stream;
import static nl.gauket.common.Calculator.add;

public class Day9 extends NewDay {
    @Override
    public void before(int year, int day) {
        INPUT_LONG = InputReader.readInputAsLongArray(year, day, "\r\n");
    }

    @Override
    public long[] solvePart1() {
        var result = solve(INPUT_LONG.clone(), 25, 1);
        return new long[]{result, 23278925L};
    }

    @Override
    public long[] solvePart2() {
        var result = solve(INPUT_LONG.clone(), 25, 2);
        return new long[]{result, 4011064L};
    }

    public static long solve(long[] input, int preamble, int part) {
        for (int rowIndex = (preamble + 1); rowIndex < input.length; rowIndex++) {

            var validNum = isValidNum(rowIndex, preamble, input, input[rowIndex]);

            if (!validNum && part == 1) return input[rowIndex];
            if (!validNum && part == 2) return findContiguousSet(input, input[rowIndex]);

            rowIndex++;
        }

        throw new IllegalArgumentException("No invalid nr found");
    }

    private static boolean isValidNum(int start, int preamble, long[] input, long value) {
        var s = (start - 1) - preamble;

        for (int i = s; i < start; i++) {
            for (int j = s; j < start; j++) {
                if (i != j) {
                    var sum = input[i] + input[j];
                    if (sum == value) return true;
                }
            }
        }

        return false;
    }

    private static long findContiguousSet(long[] input, long search) {
        var sum = 0L;
        var copy = new long[]{};

        for (int i = 0; i < input.length; i++) {
            for (int j = (i + 2); j < input.length; j++) {
                copy = copyOfRange(input, i, j + 1);
                sum = stream(copy).sum();
                if (search == sum) {
                    Arrays.sort(copy);
                    return add((int) copy[0], (int) copy[copy.length - 1]);
                }
            }
        }

        return sum;
    }
}
