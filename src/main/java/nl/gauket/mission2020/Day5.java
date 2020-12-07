package nl.gauket.mission2020;

import nl.gauket.common.Day;

import static nl.gauket.common.ResultLogger.printResult;

public class Day5 extends Day {
    private static final int DAY = 5;

    public static void main(String[] args) {
        prepareDaily(YEAR20, DAY);
        part1();
        part2();
    }

    private static void part1() {
        start();
        // part 1 //
        var input = "";
        var result = solve();

        stop();
        printResult(DAY, 0, result);
    }

    private static void part2() {
        start();
        // part 2 //
        var input = "";
        var result = solve();

        stop();
        printResult(DAY, 0, result);
    }

    public static int solve() {
        return 0;
    }
}
