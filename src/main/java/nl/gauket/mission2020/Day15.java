package nl.gauket.mission2020;

import nl.gauket.common.MyDay;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.IntStream;

public class Day15 extends MyDay {
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

    static long solve(int[] input, int totalRounds) {
        // TODO: use array of long (2x int) with length of rounds as memory
        // map of spoken number, last round used
        var memory = new HashMap<Integer, Integer>();


        // put all input numbers into memory
        for (int i = 0; i < input.length-1; i++) {
            memory.put(input[i], i+1);
        }

        // determine last spoken
        var curr = input[input.length - 1];

        for (int i = input.length; i < totalRounds; i++) {
            // determine next spoken
            var next = memory.getOrDefault(curr, 0);

            // put curr to memory
            memory.put(curr, i);

            // curr is never used before
            if (next == 0) curr = 0;
            // 1 added, because thinking a round ahead
            else curr = i - next;
        }

        return curr;
    }
}
