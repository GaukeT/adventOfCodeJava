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
        var result = solve(INPUT_INT);
        return new long[]{result, 342534};
    }

    @Override
    public long[] solvePart2() {
        var result = solve2(INPUT_INT);
        return new long[]{result};
    }

    public static long solve(int[] input) {
        Arrays.sort(input); // O(n * log(n))

        var horizontals = new int[input[input.length - 1] + 1];
        var winning = Integer.MAX_VALUE;

        for (int j = 0; j < horizontals.length; j++) {
            for (var i : input) {
                horizontals[j] += Math.abs(i - j);
            }

            winning = Math.min(horizontals[j], winning);
        }

        return winning;
    }

    public static long solve2(int[] input) {
        Arrays.sort(input); // O(n * log(n))

        var horizontals = new int[input[input.length - 1] + 1];

        for (int j = 0; j < horizontals.length; j++) {
            var fuelConsumption = 1;
            for (var i : input) {
                horizontals[j] += (Math.abs(i - j) * fuelConsumption);
                fuelConsumption++;
            }
        }

        Arrays.sort(horizontals);
        return horizontals[0];
    }
}
