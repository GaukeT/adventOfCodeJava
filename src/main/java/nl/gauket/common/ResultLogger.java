package nl.gauket.common;

public class ResultLogger extends Asserter {
    public static void printResult(int day, int expected, int result) {
        printResult(day, expected, result, "");
    }

    public static void printResult(int day, int expected, int result, String optionalPrint) {
        if (0 <= expected) AssertEq(expected, result);
        printResult(day, String.valueOf(result), optionalPrint);
    }

    public static void printResult(int day, long expected, long result) {
        printResult(day, expected, result, "");
    }

    public static void printResult(int day, long expected, long result, String optionalPrint) {
        if (0L < expected) AssertEq(expected, result);
        printResult(day, String.valueOf(result), optionalPrint);
    }

    public static void printResult(int day, String expected, String result, String optionalPrint) {
        if (!"".equals(expected)) AssertEq(expected, result);
        printResult(day, result, optionalPrint);
    }

    public static void printResult(int day, String result, String optionalPrint) {
        if (!"".equals(optionalPrint)) System.out.println("(" + optionalPrint + ") ");
        System.out.println("Result of Day " + day + ": " + result + " ");
    }
}
