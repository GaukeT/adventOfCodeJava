package nl.gauket.mission2020;

import nl.gauket.common.Day;
import nl.gauket.common.InputReader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;

import static nl.gauket.common.Calculator.add;
import static nl.gauket.common.Calculator.multiply;
import static nl.gauket.common.ResultLogger.printResult;

public class Day1 extends Day {
    private static final int DAY = 1;

    public static void main(String[] args) throws IOException, URISyntaxException {
        prepareDaily(YEAR20, DAY);

        start();
        var input = InputReader.readInputAsIntStream(YEAR20, DAY).toArray();
        Arrays.sort(input);  // O(n * log(n))
        stop("Parse input");

        part1(input.clone());
        part1b(input.clone());
        part1c(input.clone());
        part2(input.clone());
    }

    private static void part1(int[] input) {
        start();
        var result = solve(input, 2);
        printResult(DAY, 787776, result);
        stop();
    }

    private static void part1b(int[] input) {
        start();
        var result = solveB(input);
        printResult(DAY, 787776, result);
        stop();
    }

    private static void part1c(int[] input) {
        start();
        var result = solveC(input); // recursive solution
        printResult(DAY, 787776, result);
        stop();
    }

    private static void part2(int[] input) {
        start();
        var result = solve(input, 3);
        printResult(DAY, 262738554, result);
        stop();
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
        throw new IllegalArgumentException("Invalid input");
    }
}
