package nl.gauket.mission2020;

import nl.gauket.common.Day;
import nl.gauket.common.InputReader;

import static java.lang.Integer.parseInt;
import static nl.gauket.common.ResultLogger.printResult;

public class Day8 extends Day {
    private static final int DAY = 8;

    public static void main(String[] args) {
        prepareDaily(YEAR20, DAY);
        part1();
        part2();
    }

    private static void part1() {
        start();
        // part 1 //
        var input = InputReader.readInputAsStringArray(YEAR20, DAY);
        var result = solve(input, 1);

        stop();
        printResult(DAY, 1420, result);
    }

    private static void part2() {
        start();
        // part 2 //
        var input = InputReader.readInputAsStringArray(YEAR20, DAY);
        var result = solve(input, 2);

        stop();
        printResult(DAY, 0, result);
    }

    public static int solve(String[] input, int part) {
        if (part == 2) return solve2(input, part);

        var accumulator = 0;
        var index = 0;
        while (true) {
            if (null == input[index]) break;

            var row = input[index].split(" ");
            var operation = row[0];
            var argument = parseInt(row[1]);

            input[index] = null; // index is visited

            switch (operation) {
                case "acc":
                    accumulator += argument;
                case "nop":
                    index++;
                    break;
                case "jmp":
                    index += argument;
                    break;
                default:
                    throw new IllegalArgumentException("operation " + operation + " not implemented");
            }

            if (index > input.length)
                throw new IllegalStateException("Impossible index: " + index + " | input size " + input.length);
            if (index < 0)
                throw new IllegalStateException("Impossible index: " + index + " | input size " + input.length);
        }

        return accumulator;
    }

    public static int solve2(String[] input, int part) {
        var accumulator = 0;


        return accumulator;
    }
}
