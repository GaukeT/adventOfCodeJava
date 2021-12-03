package nl.gauket.mission2020;

import nl.gauket.common.NewDay;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Day15 extends NewDay {
    @Override
    public void before(int year, int day) {
        super.before(year, day);
        INPUT_INT = Arrays.stream(INPUT[0].split(","))
                .flatMapToInt(num -> IntStream.of(Integer.parseInt(num))).toArray();
    }

    @Override
    public long[] solvePart1() {
        var result = solve(INPUT_INT.clone(), 2020);
        return new long[]{result, 595L};
    }

    @Override
    public long[] solvePart2() {
        var result = solve(INPUT_INT.clone(), 30_000_000);
        return new long[]{result, 1708310L};
    }

    /** example of how the bit shifting works, see {@link Day15Test.java} */
    static long solve(int[] input, int totalRounds) {
        // array of long (concat of 2 times 32 bits) with length of rounds as memory
        var memory = new long[totalRounds];

        // put all input numbers into memory
        for (int i = 0; i < input.length; i++) {
            // round number = i + 1
            memory[input[i]] = i + 1;
        }

        // determine last spoken
        var curr = input[input.length - 1];

        for (int i = input.length; i < totalRounds; i++) {
            var next = (int) (memory[curr] >> 32);
            var isUsedBefore = next > 0;

            if (!isUsedBefore) {
                memory[next] = memory[next] << 32 | (i + 1);
                curr = next;
            } else {
                curr = (int) memory[curr] - next;
                memory[curr] = memory[curr] << 32 | (i + 1);
            }
        }

        return curr;
    }
}
