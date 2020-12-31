package nl.gauket.mission2020;

import nl.gauket.common.InputReader;
import nl.gauket.common.MyDay;

import java.util.Arrays;

import static nl.gauket.common.Calculator.add;
import static nl.gauket.common.Calculator.multiply;

public class Day1 extends MyDay {
    @Override
    public void before(int year, int day) {
        INPUT_INT = InputReader.readInputAsIntStream(year, day).toArray();
        Arrays.sort(INPUT_INT); // O(n * log(n))
    }

    @Override
    public long[] solvePart1() {
        var result = (long) solve(INPUT_INT.clone(), 2);
        return new long[]{result, 787776};
    }

    @Override
    public long[] solvePart2() {
        var result = solve(INPUT_INT.clone(), 3);
        return new long[]{result, 262738554};
    }

    public static int solve(int[] input, int nrOfItems) {
        var min = input[0];
        var maxNr = 2020 - min;

        // O(n^2) || O(n^3)
        for (int i = 0; i < input.length; i++) {
            for (int j = i + 1; j < input.length; j++) {
                if (input[i] > maxNr || input[j] > maxNr) break;

                if (nrOfItems == 2) {
                    var sum = add(input[i], input[j]);
                    if (2020 == sum) return multiply(input[i], input[j]);
                    else if (sum > 2020) break;
                } else if (nrOfItems == 3) {
                    for (int z = j + 1; z < input.length; z++) {
                        if (input[z] > maxNr) break;
                        var sum = add(input[i], input[j], input[z]);
                        if (2020 == sum) return multiply(input[i], input[j], input[z]);
                        else if (sum > 2020) break;
                    }
                } else {
                    throw new IllegalArgumentException("Only 2 and 3 of nrOfItems are implemented.");
                }
            }
        }
        return -1;
    }

    // ############################################################################################################## //
    // ##################################### OTHER IMPLEMENTATIONS ################################################## //
    // ############################################################################################################## //

    private static void part1b(int[] input) {
        var result = solveB(input);
    }

    private static void part1c(int[] input) {
        var result = solveC(input);
    }

    private static void part2b(int[] input) {
        var result = solve2B(input);
    }

    private static int solve2B(int[] input) {
        // O(n^2)
        for (var num : input) {
            var result = recSolveC(input, 2020 - num, 0, input.length - 1);
            if (result != -1) return result * num;
        }

        return -1;
    }

    private static int solveC(int[] input) {
        return recSolveC(input, 2020, 0, input.length - 1);
    }

    private static int recSolveC(int[] input, int target, int i, int j) {
        if (j < i) return -1;

        var n1 = input[i];
        var n2 = input[j];
        var sum = n1 + n2;

        if (sum == target) {
            return n1 * n2;
        } else if (sum < target) {
            return recSolveC(input, target, ++i, j);
        } else {
            return recSolveC(input, target, i, --j);
        }
    }

    private static int solveB(int[] input) {
        var target = 2020;
        var maxNr = 2020 - input[0];

        var i = 0;
        var j = input.length - 1;

        // O(n)
        while (j > i) {
            var n2 = input[j];
            if (n2 > maxNr){
                j--;
                continue;
            }

            var n1 = input[i];
            var sum = n1 + n2;

            if (sum == target) {
                return n1 * n2;
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }

        return -1;
    }
}
