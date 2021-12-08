package nl.gauket.mission2021;

import nl.gauket.common.InputReader;
import nl.gauket.common.NewDay;

import java.util.ArrayList;
import java.util.Arrays;

public class Day6 extends NewDay {
    @Override
    public void before(int year, int day) {
        INPUT_INT = InputReader.readInputAsIntArray(year, day, ",");
    }

    @Override
    public long[] solvePart1() {
        var result = solve(INPUT_INT, 80);
        return new long[]{result, 363101};
    }

    @Override
    public long[] solvePart2() {
        var result = solve(INPUT_INT, 256);
        return new long[]{result}; // 686400344 too low
    }

    public static long solve(int[] input, int days) {
        var result = new int[9];

        for (var fish : input) {
            result[fish]++;
        }

        for (int i = 1; i <= days; i++) {
            var count = result[0];

            for (int j = 1; j < result.length; j++) {
                result[j - 1] = result[j];
            }

            result[8] = count; // amount of new fishes created
            result[6] += count; // evolved fishes reset timer to 6
        }

        return Arrays.stream(result).reduce(0, Integer::sum);
    }

    // out of memory exception in part 2
    public static long solveArr(int[] input, int days) {
        for (int i = 0; i < days; i++) {
            var grow = new ArrayList<Integer>();

            for (int j = input.length - 1; j >= 0; j--) {
                var temp = input[j];
                temp--;

                if (temp < 0) {
                    temp = 6;
                    grow.add(8);
                }

                input[j] = temp;
            }

            if (!grow.isEmpty()) {
                var tempArr = new int[input.length + grow.size()];
                for (int j = 0; j < tempArr.length; j++) {
                    if (j < input.length) {
                        tempArr[j] = input[j];
                    } else {
                        tempArr[j] = grow.get(j - input.length);
                    }
                }
                input = tempArr;
            }

            print("day: " + (i + 1) + " total: " + input.length);
        }

        return input.length;
    }
}
