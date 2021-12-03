package nl.gauket.mission2021;

import nl.gauket.common.NewDay;

import java.util.Arrays;

public class Day3 extends NewDay {

    @Override
    public long[] solvePart1() {
        var result = solveFirst(INPUT.clone());
        return new long[]{result, 2250414};
    }

    @Override
    public long[] solvePart2() {
        var result = solveSecond(INPUT.clone());
        return new long[] {result, 6085575};
    }

    public static long solveFirst(String[] input) {
        StringBuilder sGamma = new StringBuilder();
        StringBuilder sEpsilon = new StringBuilder();

        var count = new int[input[0].split("").length];
        for (var str : input) {
            var splitted = str.split("");
            for (int j = 0; j < splitted.length; j++) {
                if (splitted[j].equals("0")) {
                    count[j] -= 1;
                } else {
                    count[j] += 1;
                }
            }
        }

        for (var x : count) {
            if (x > 0) {
                sGamma.append("1");
                sEpsilon.append("0");
            } else {
                sGamma.append("0");
                sEpsilon.append("1");
            }
        }

        var gamma = Long.parseLong(sGamma.toString(), 2);
        var epsilon = Long.parseLong(sEpsilon.toString(), 2);

        return gamma * epsilon;
    }

    public static long solveSecond(String[] input) {
        var inputOxy = input.clone();
        var inputScr = input.clone();

        var oxygen = 0L;
        var scrubber = 0L;

        for (int i = 0; i < 12; i++) {
            var most = findMostCommonAtIndex(inputOxy, i);
            inputOxy = filter(inputOxy, i, most);
            if (inputOxy.length <= 1) oxygen = Long.parseLong(inputOxy[0], 2);

            var least = findMostCommonAtIndex(inputScr, i) == '1' ? '0' : '1';
            inputScr = filter(inputScr, i, least);
            if (inputScr.length <= 1) scrubber = Long.parseLong(inputScr[0], 2);

            // break if all arrays filtered down to 1 item
            if (inputScr.length <= 1 && inputOxy.length <= 1) break;
        }

        return oxygen * scrubber;
    }

    private static String[] filter(String[] input, int index, char match) {
        if (input.length > 1) {
            return Arrays.stream(input)
                    .filter(str -> str.charAt(index) == match)
                    .toArray(String[]::new);
        }
        return input;
    }

    private static char findMostCommonAtIndex(String[] input, int index) {
        var retval = 0;

        for (var entry : input) {
            retval += entry.charAt(index) == '0' ? -1 : 1;
        }

        // negative value means more zeros
        // positive value means more ones
        // return '1' if equal amount of zeros and ones
        return retval >= 0 ? '1' : '0';
    }
}
