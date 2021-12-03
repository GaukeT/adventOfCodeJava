package nl.gauket.mission2020;

import nl.gauket.common.NewDay;

import static java.lang.Integer.parseInt;

public class Day8 extends NewDay {
    @Override
    public long[] solvePart1() {
        var result = (long) solve(INPUT.clone(), 1);
        return new long[]{result, 1420};
    }

    @Override
    public long[] solvePart2() {
        var result = (long) solve(INPUT.clone(), 2);
        return new long[]{result, 1245};
    }

    public static int solve(String[] input, int part) {
        if (part == 2) return solve2(input);

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

    public static int solve2(String[] input) {
        var accumulator = 0;
        var index = 0;
        var curr_index = 0; // hack to delete visited

        var patched = false;
        var patchedIndex = -1;
        var accumulator_copy = -1;
        String[] input_copy = null;

        while (true) {
            if (null == input[index]) {
                patched = false;
                index = patchedIndex;
                accumulator = accumulator_copy;
                input = input_copy;
            }

            var row = input[index].split(" ");
            var operation = row[0];
            var argument = parseInt(row[1]);

            curr_index = index;

            if (patched || patchedIndex == index) {
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
            } else {
                switch (operation) {
                    case "acc":
                        accumulator += argument;
                        index++;
                        break;
                    case "nop":
                        patched = true;
                        patchedIndex = index;
                        accumulator_copy = accumulator;
                        input_copy = input.clone();

                        index += argument;
                        break;
                    case "jmp":
                        patched = true;
                        patchedIndex = index;
                        accumulator_copy = accumulator;
                        input_copy = input.clone();

                        index++;
                        break;
                    default:
                        throw new IllegalArgumentException("operation " + operation + " not implemented");
                }
            }

            input[curr_index] = null; // index is visited

            if (index == input.length)
                break; // successful reached the end.
            else if (index > input.length)
                throw new IllegalStateException("Impossible index: " + index + " | input size " + input.length);
            else if (index < 0)
                throw new IllegalStateException("Impossible index: " + index + " | input size " + input.length);
        }

        return accumulator;
    }
}
