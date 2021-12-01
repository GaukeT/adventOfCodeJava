package nl.gauket.mission2021;

import nl.gauket.common.InputReader;

public class Day1 extends nl.gauket.common.MyDay {
    @Override
    public void before(int year, int day) {
        INPUT_INT = InputReader.readInputAsIntStream(year, day).toArray();
    }

    @Override
    public long[] solvePart1() {
        var result = 0;
        var prev = INPUT_INT[0];
        for (int i = 1; i < INPUT_INT.length; i++) {
            var m = INPUT_INT[i];
            if (m > prev) result++;
            prev = m;
        }

        return new long[] {result, 1466};
    }

    @Override
    public long[] solvePart2() {
        var result = 0;
        var prev = getSumOfWindowAtIndex(0);
        for (int i = 1; i < INPUT_INT.length-2; i++) {
            var m = getSumOfWindowAtIndex(i);
            if (m > prev) result++;
            prev = m;
        }

        return new long[] {result, 1491};
    }

    private int getSumOfWindowAtIndex(int i) {
        return INPUT_INT[i] + INPUT_INT[i+1] + INPUT_INT[i+2];
    }
}
