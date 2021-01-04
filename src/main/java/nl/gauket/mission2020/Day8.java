package nl.gauket.mission2020;

import nl.gauket.common.MyDay;

import static java.lang.Integer.parseInt;

public class Day8 extends MyDay {
    @Override
    public long[] solvePart1() {
        var result = (long) solve(INPUT.clone(), 1);
        return new long[]{result, 1420};
    }

    @Override
    public long[] solvePart2() {
        var result = (long) solve(INPUT.clone(), 2);
        return new long[]{result, 0};
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
