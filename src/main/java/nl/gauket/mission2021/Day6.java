package nl.gauket.mission2021;

import nl.gauket.common.InputReader;
import nl.gauket.common.NewDay;

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
        return new long[]{result, 1644286074024L};
    }

    public static long solve(int[] input, int days) {
        var result = new long[9];

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

        return Arrays.stream(result).reduce(0, Long::sum);
    }
}
