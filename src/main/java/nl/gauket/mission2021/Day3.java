package nl.gauket.mission2021;

import nl.gauket.common.NewDay;

import java.util.Arrays;

public class Day3 extends NewDay {

    @Override
    public long[] solvePart1() {
        StringBuilder sGamma = new StringBuilder();
        StringBuilder sEpsilon = new StringBuilder();

        var count = new int[12];
        for (var str : INPUT) {
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

        long result = gamma * epsilon;

        return new long[]{result, 2250414};
    }

    @Override
    public long[] solvePart2() {
        var inputOxy = INPUT.clone();
        var inputScr = INPUT.clone();

        var oxygen = 0L;
        var scrubber = 0L;

        for (int i = 0; i < 12; i++) {
            int finalI = i;

            var most = findMostCommonAtIndex(inputOxy, i);
            if (inputOxy.length > 1) {
                inputOxy = Arrays.stream(inputOxy)
                        .filter(str -> str.charAt(finalI) == most)
                        .toArray(String[]::new);

                if (inputOxy.length <= 1) oxygen = Long.parseLong(inputOxy[0], 2);
            }

            var least = findMostCommonAtIndex(inputScr, i) == '1' ? '0' : '1';
            if (inputScr.length > 1) {
                inputScr = Arrays.stream(inputScr)
                        .filter(str -> str.charAt(finalI) == least)
                        .toArray(String[]::new);

                if (inputScr.length <= 1) scrubber = Long.parseLong(inputScr[0], 2);
            }

            if (inputScr.length <= 1 && inputOxy.length <= 1) break;
        }

        var result = oxygen * scrubber;
        return new long[] {result, 6085575};
    }

    private char findMostCommonAtIndex(String[] input, int index) {
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
