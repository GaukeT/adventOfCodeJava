package nl.gauket.mission2021;

import nl.gauket.common.InputReader;
import nl.gauket.common.NewDay;

public class Day3 extends NewDay {

    @Override
    public void before(int year, int day) {
        INPUT_CH_MATRIX = InputReader.readInputAsCharMatrix(year, day);
    }

    @Override
    public long[] solvePart1() {
        StringBuilder sGamma = new StringBuilder();
        StringBuilder sEpsilon = new StringBuilder();

        var count = new int[12];
        for (char[] input_ch_matrix : INPUT_CH_MATRIX) {
            for (int j = 0; j < input_ch_matrix.length; j++) {
                if (input_ch_matrix[j] == '0') {
                    count[j] -= 1;
                } else {
                    count[j] += 1;
                }
            }
        }

        for (var x: count) {
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

        return new long[] {result, 2250414};
    }

    @Override
    public long[] solvePart2() {
        var result = 0;
        return new long[] {result};
    }

    private int findMostCommonAtIndex(char[][] input, int index) {
        var retval = 0;

        for(var entry: input) {
            retval += entry[index] == '0' ? -1 : 1;
        }

        return retval;
    }
}
