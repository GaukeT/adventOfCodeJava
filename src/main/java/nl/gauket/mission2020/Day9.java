package nl.gauket.mission2020;

import nl.gauket.common.Day;
import nl.gauket.common.InputReader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashSet;

import static nl.gauket.common.ResultLogger.printResult;

public class Day9 extends Day {
    private static final int DAY = 9;

    public static void main(String[] args) throws IOException, URISyntaxException {
        prepareDaily(YEAR20, DAY);
        part1();
        part2();
    }

    private static void part1() throws IOException, URISyntaxException {
        start();
        // part 1 //
        var input = InputReader.readInputAsLongArray(YEAR20, DAY, "\n");
        var result = String.valueOf(solve(input, 25,1));

        stop();
        printResult(DAY, "", result);
    }

    private static void part2() throws IOException, URISyntaxException {
        start();
        // part 2 //
        var input = InputReader.readInputAsLongArray(YEAR20, DAY, "\n");
        var result = String.valueOf(solve(input, 25,2));

        stop();
        printResult(DAY, "", result);
    }

    public static long solve(long[] input, int preamble, int part) {
        for (int rowIndex = (preamble+1); rowIndex < input.length; rowIndex++) {
            var validNums = createArrayOfValidNumbers(rowIndex, preamble, input);
            if (!validNums.contains(input[rowIndex])) return input[rowIndex];
            rowIndex++;
        }

        throw new IllegalArgumentException("No invalid nr found");
    }

    private static HashSet<Long> createArrayOfValidNumbers(int start, int preamble, long[] input) {
        var res = new HashSet<Long>();
        var s = (start-1) - preamble;

        for (int i = s; i < start; i++) {
            for (int j = s; j < start; j++) {
                if (i != j) {
                    res.add(input[i] + input[j]);
                }
            }
        }

        return res;
    }

}
