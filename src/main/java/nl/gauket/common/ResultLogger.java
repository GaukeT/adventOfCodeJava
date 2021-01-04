package nl.gauket.common;

public class ResultLogger extends Asserter {
    public static void printResult(long part, long expected, long result) {
        if (!AssertEq(part, expected, result)) return;
        printResult(part, String.valueOf(result));
    }

    public static void printResult(long part, String expected, String result) {
        if (AssertEq(part, expected, result)) return;
        printResult(part, result);
    }

    public static void printResult(long part, String result) {
        System.out.printf("\tResult (part %d) : %s ", part, result);
    }

    // AOC 2019 TODO: refactor to new standard
    public static void printResult(int day, long expected, long result) {
        if (0L != expected) if (!AssertEq(0L, expected, result)) return;
        printResult(0L, String.valueOf(result));
    }
}
