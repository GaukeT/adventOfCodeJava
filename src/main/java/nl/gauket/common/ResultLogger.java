package nl.gauket.common;

import static nl.gauket.common.ConsoleColors.BLACK_BOLD_BRIGHT;
import static nl.gauket.common.ConsoleColors.RESET;

public class ResultLogger extends Asserter {
    public static void printResult(long part, long expected, long result) {
        if (!assertEq(part, expected, result)) return;
        printResult(part, String.valueOf(result));
    }

    public static void printResult(long part, String expected, String result) {
        if (assertEq(part, expected, result)) return;
        printResult(part, result);
    }

    public static void printResult(long part, String result) {
        System.out.printf("\tResult (part %d) :%s %s %s ", part, BLACK_BOLD_BRIGHT, result, RESET);
    }

    // AOC 2019 TODO: refactor to new standard
    public static void printResult(int day, long expected, long result) {
        if (0L != expected) if (!assertEq(0L, expected, result)) return;
        printResult(0L, String.valueOf(result));
    }
}
