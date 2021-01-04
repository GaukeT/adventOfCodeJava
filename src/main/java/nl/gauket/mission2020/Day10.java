package nl.gauket.mission2020;

import nl.gauket.common.Calculator;
import nl.gauket.common.InputReader;
import nl.gauket.common.MyDay;

import java.util.Arrays;

public class Day10 extends MyDay {
    @Override
    public void before(int year, int day) {
        INPUT_INT = InputReader.readInputAsIntStream(year, day).toArray();
        Arrays.sort(INPUT_INT); // O(n * log(n))
    }

    @Override
    public long[] solvePart1() {
        var result = (long) solve(INPUT_INT.clone(), 1);
        return new long[]{result, 2760};
    }

    @Override
    public long[] solvePart2() {
        var result = solve(INPUT_INT.clone(), 2);
        return new long[]{result, 0};
    }

    public static int solve(int[] input, int part) {
        Arrays.sort(input);
        if (part == 2) return solve2(input);

        var oneJolt = 1;
        var treeJolts = 1;


        for (int i = 0; i < input.length; i++) {
            if (i == input.length - 1) break; // last item

            var diff = input[i + 1] - input[i];

            if (diff == 1) oneJolt++;
            else if (diff == 3) treeJolts++;
        }

        return Calculator.multiply(treeJolts, oneJolt);
    }

    private static int solve2(int[] input) {
        var arrangements = 1;

        for (int i = 0; i < input.length; i++) {
            var diff1 = calculateDiff(i, 1, input);
            if (diff1 == -1) break;
            if (diff1 == 3) continue;

            var diff2 = calculateDiff(i, 2, input);
            if (diff1 == 1 && isSkippable(diff2)) {
                arrangements *= 2;

                var diff3 = calculateDiff(i, 3, input);
                if (diff2 == 2 && isSkippable(diff3)) {
                    arrangements++;
                }
            }
        }

        return arrangements;
    }

    private static boolean isSkippable(int diff) {
        return diff <= 3;
    }

    private static int calculateDiff(int index, int to, int[] input) {
        if (input.length <= index + to) return -1; //
        return input[index + to] - input[index];
    }

}
