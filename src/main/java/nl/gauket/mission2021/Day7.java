package nl.gauket.mission2021;

import nl.gauket.common.InputReader;
import nl.gauket.common.NewDay;

import java.util.Arrays;

public class Day7 extends NewDay {
    @Override
    public void before(int year, int day) {
        INPUT_INT = InputReader.readInputAsIntArray(year, day, ",");
    }

    @Override
    public long[] solvePart1() {
        var result = solve(INPUT_INT, false);
        return new long[]{result, 342534};
    }

    @Override
    public long[] solvePart2() {
        var result = solve(INPUT_INT, true);
        return new long[]{result, 94004208};
    }

    public static long solve(int[] input, boolean expensiveCost) {
        Arrays.sort(input); // O(n * log(n))

        var horizontals = new int[input[input.length - 1] + 1];
        var winning = Integer.MAX_VALUE;

        for (int j = 0; j < horizontals.length; j++) {
            for (var i : input) {
                horizontals[j] += cost(Math.abs(i - j), expensiveCost);
            }

            winning = Math.min(horizontals[j], winning);
        }

        return winning;
    }

    private static int cost(int dist, boolean expensiveCost) {
        if (!expensiveCost) return dist;
        return dist * (dist + 1) / 2;
    }
}
