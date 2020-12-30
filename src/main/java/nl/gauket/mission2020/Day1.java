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
        part1();
        part2();
    }

    private static void part1() throws IOException, URISyntaxException {
        start();
        // part 1 //
        var input = InputReader.readInputAsIntStream(YEAR20, DAY).toArray();
        var result = solve(input, 2);

        stop();
        printResult(DAY, 787776, result);
    }

    private static void part2() throws IOException, URISyntaxException {
        start();
        // part 1 //
        var input = InputReader.readInputAsIntStream(YEAR20, DAY).toArray();
        var result = solve(input, 3);

        stop();
        printResult(DAY, 262738554, result);
    }

    public static int solve(int[] input, int nrOfItems) {
        Arrays.sort(input);
        var min = input[0];
        var maxNr = 2020 - min;

        for (int i = 0; i < input.length; i++) {
            for (int j = i + 1; j < input.length; j++) {
                if (input[i] > maxNr || input[j] > maxNr) break;

                if (nrOfItems == 2) {
                    var sum = add(input[i], input[j]);
                    if (2020 == sum) return multiply(input[i], input[j]);
                    else if (sum > 2020) break;
                } else if (nrOfItems == 3) {
                    for (int z = j + 1 ; z < input.length; z++) {
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
