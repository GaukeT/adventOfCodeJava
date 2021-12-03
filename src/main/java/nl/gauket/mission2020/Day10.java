package nl.gauket.mission2020;

import nl.gauket.common.Calculator;
import nl.gauket.common.InputReader;
import nl.gauket.common.NewDay;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Day10 extends NewDay {
    @Override
    public void before(int year, int day) {
        INPUT_INT = InputReader.readInputAsIntStream(year, day).toArray();
        Arrays.sort(INPUT_INT); // O(n * log(n))
    }

    @Override
    public long[] solvePart1() {
        var result = solve(INPUT_INT.clone(), 1);
        return new long[]{result, 2760};
    }

    @Override
    public long[] solvePart2() {
        var result = solve2(INPUT_INT.clone());
        return new long[]{result, 13816758796288L};
    }

    public static long solve(int[] input, int part) {
        if (part == 2) return solve2(input);

        var oneJolt = 1;
        var treeJolts = 1;

        for (int i = 0; i < input.length; i++) {
            if (i == input.length - 1) break; // last item

            var diff = input[i + 1] - input[i];

            if (diff == 1) oneJolt++;
            else if (diff == 3) treeJolts++;
        }

        return Calculator.multiply(treeJolts, oneJolt);
    }

    private static long solve2(int[] input) {
        var arrangements = Arrays.stream(input).boxed().collect(Collectors.toList());
        arrangements.add(0);

        var max = arrangements.stream().max(Integer::compare).get() + 3;
        var map = new HashMap<Integer, Long>();
        map.put(max, 1L);

        Collections.sort(arrangements, Collections.reverseOrder());
        for (var arr : arrangements) {
            var diff1 = map.getOrDefault(arr + 1, 0L);
            var diff2 = map.getOrDefault(arr + 2, 0L);
            var diff3 = map.getOrDefault(arr + 3, 0L);

            map.put(arr, diff1 + diff2 + diff3);
        }

        return map.get(0);
    }
}
