package nl.gauket.common;

public class ResultLogger extends Asserter {

    public static void printResult(int day, int result) {
        printResult(day, String.valueOf(result));
    }

    public static void printResult(int day, int expected, int result) {
        AssertEq(expected, result);
        printResult(day, String.valueOf(result));
    }

    public static void printResult(int day, String result) {
        System.out.println("Result of Day " + day + ": " + result);
    }

    public static void printResult(int day, String expected, String result) {
        AssertEq(expected, result);
        System.out.println("Result of Day " + day + ": " + result);
    }
}
