package nl.gauket.common;

public class ResultLogger extends Asserter {
    public static void printResult(long expected, long result) {
        if (0L != expected) if (!AssertEq(expected, result)) return;
        printResult(String.valueOf(result));
    }

    public static void printResult(String expected, String result) {
        if (!"".equals(expected)) if (AssertEq(expected, result)) return;
        printResult(result);
    }

    public static void printResult(String result) {
        System.out.print("\tResult : " + result + " ");
    }

    // AOC 2019
    public static void printResult(int day, long expected, long result) {
        if (0L != expected) if (!AssertEq(expected, result)) return;
        printResult(String.valueOf(result));
    }
}
