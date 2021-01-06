package nl.gauket.mission2020;

import nl.gauket.common.MyDay;

import java.util.LinkedHashMap;

public class Day13 extends MyDay {

    @Override
    public long[] solvePart1() {
        var result = solve(INPUT);
        return new long[]{result, 207L};
    }

    @Override
    public long[] solvePart2() {
        var result = solve2(INPUT);
        return new long[]{result, 530015546283687L};
    }

    static long solve(String[] input) {
        var currTime = Integer.parseInt(input[0]);
        var busses = input[1].replace(",x", "").split(",");

        var result = check(currTime, busses);
        var waitTime = result[0] - currTime;
        var busId = result[1];

        return waitTime * busId;
    }

    private static int[] check(int currTime, String[] busses) {
        var waitTime = Integer.MAX_VALUE;
        var busId = 0;

        for (var bus : busses) {
            if ("x".equals(bus)) continue;
            var iBus = Integer.parseInt(bus);
            var remainder = currTime % iBus;

            if (remainder == 0) {
                waitTime = currTime;
                busId = iBus;
                break;
            }
        }

        if (waitTime == Integer.MAX_VALUE) {
            currTime++;
            return check(currTime, busses);
        }

        return new int[]{waitTime, busId};
    }

    static long solve2(String[] input) {
        var busses = input[1].split(",");
        var first = Integer.parseInt(busses[0]);
        return validate(busses, first);
    }

    private static long validate(String[] busses, long first) {
        var map = determineMap(busses);
        long jump = first;
        long timestamp = 0L;

        for (var curr : map.keySet()) {
            var index = map.get(curr);

            // searching for new timestamp where modulo of curr and previous checked busses meets zero
            while ((timestamp + index) % curr != 0) {
                timestamp += jump;
            }

            // jumps in multiples of curr * previous busses
            // total of jump will always can always be divided by all checked busses.
            jump *= curr;
        }

        return timestamp;
    }

    private static LinkedHashMap<Integer, Integer> determineMap(String[] busses) {
        var map = new LinkedHashMap<Integer, Integer>();

        // skip first; initially starting with jumps of first
        for (int i = 1; i < busses.length; i++) {
            if ("x".equals(busses[i])) continue;
            var curr = Integer.parseInt(busses[i]);
            map.put(curr, i);
        }
        return map;
    }
}
