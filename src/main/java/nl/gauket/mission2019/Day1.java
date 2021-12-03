package nl.gauket.mission2019;

import nl.gauket.common.InputReader;
import nl.gauket.common.NewDay;

public class Day1 extends NewDay {
    @Override
    public void before(int year, int day) {
        INPUT_INTSTREAM = InputReader.readInputAsIntStream(year, day);
    }

    @Override
    public long[] solvePart1() {
        var result = INPUT_INTSTREAM.reduce(0, (t, m) -> t + calculateFuelBy(m));
        return new long[] {result, 3318604};
    }

    @Override
    public long[] solvePart2() {
        return new long[0];
    }

    public static int calculateFuelBy(int mass) {
        return mass / 3 - 2;
    }
}
