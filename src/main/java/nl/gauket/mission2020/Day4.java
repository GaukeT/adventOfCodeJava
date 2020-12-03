package nl.gauket.mission2020;

import nl.gauket.common.Day;

import static nl.gauket.common.ResultLogger.printResult;

public class Day4 extends Day {
    private static final int DAY = 4;

    public static void main(String[] args) {
        prepareDaily(args[0], YEAR20, DAY);
        part1();
        part2();
    }

    private static void part1() {
        start();
        // part 1 //
        var input = "";
        var result = solve();

        stop();
        printResult(DAY, result);
    }

    private static void part2() {
        start();
        // part 2 //
        var input = "";
        var result = solve();

        stop();
        printResult(DAY, result);
    }

    private static int solve() {
        return 0;
    }
}
