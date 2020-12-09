package nl.gauket.common;

public class ResultLogger extends Asserter {

    public static void printResult(int day, int result) {
        printResult(day, 0, result, false);
    }

    public static void printResult(int day, int expected, int result) {
        printResult(day, expected, result, true);
    }

    public static void printResult(int day, int expected, int result, boolean checkResult) {
        if (checkResult && 0 != expected) AssertEq(expected, result);
        printResult(day, String.valueOf(result));
    }

    public static void printResult(int day, String result) {
        printResult(day, "", result, false);
    }

    public static void printResult(int day, String expected, String result) {
        printResult(day, expected, result, true);
    }

    public static void printResult(int day, String expected, String result, boolean checkResult) {
        if (checkResult && !"".equals(expected)) AssertEq(expected, result);
        System.out.println("Result of Day " + day + ": " + result);
    }
}
