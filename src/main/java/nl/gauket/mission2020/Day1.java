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
        part1();
        part2();
    }

    private static void part1() throws IOException, URISyntaxException {
        start(YEAR20, DAY);
        // part 1 // 787776
        var input = InputReader.readInputAsIntStream(YEAR20, DAY).toArray();
        var result = solve(input, 2);

        stopTimer();
        printResult(DAY, result);
    }

    private static void part2() throws IOException, URISyntaxException {
        start(YEAR20, DAY);        // part 1 // 262738554
        var input = InputReader.readInputAsIntStream(YEAR20, DAY).toArray();
        var result = solve(input, 3);

        stopTimer();
        printResult(DAY, result);
    }

    public static int solve(int[] input, int nrOfItems) {
        Arrays.sort(input);
        var min = input[0];
        var maxNr = 2020 - min;

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                if (i == j) continue;
                if (input[i] > maxNr || input[j] > maxNr) continue;

                if (nrOfItems == 2) {
                    if (2020 == add(input[i], input[j])) return multiply(input[i], input[j]);
                } else if (nrOfItems == 3) {
                    for (int z = 0; z < input.length; z++) {
                        if (i == z) continue;
                        if (input[z] > maxNr) continue;
                        if (2020 == add(input[i], input[j], input[z])) return multiply(input[i], input[j], input[z]);
                    }
                } else {
                    throw new IllegalArgumentException("Only 2 and 3 of nrOfItems are implemented.");
                }
            }
        }
        throw new IllegalArgumentException("Invalid input");
    }
}
