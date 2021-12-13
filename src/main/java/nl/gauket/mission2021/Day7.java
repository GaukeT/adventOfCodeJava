package nl.gauket.mission2021;

import nl.gauket.common.InputReader;
import nl.gauket.common.NewDay;

import java.util.Arrays;
import java.util.HashMap;

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
        var cache = new HashMap<Integer, Integer>();

        for (int j = 0; j < horizontals.length; j++) {
            for (var i : input) {
                horizontals[j] += cost(Math.abs(i - j), expensiveCost, cache);
                if (horizontals[j] > winning) break;
            }

            winning = Math.min(horizontals[j], winning);
        }

        return winning;
    }

    private static int cost(int dist, boolean expensiveCost, HashMap<Integer, Integer> cache) {
        if (!expensiveCost) return dist;

        var result = cache.getOrDefault(dist, 0);

        if (result == 0) {
            for (int i = dist; i > 0; i--) {
                result += i;
            }
            cache.put(dist, result);
        }

        return result;
    }
}
