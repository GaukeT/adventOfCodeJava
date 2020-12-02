package nl.gauket.common;

public class ResultLogger {
    public static void printResult(int day, int result) {
        printResult(day, String.valueOf(result));
    }

    public static void printResult(int day, String result) {
        System.out.println("Result of Day " + day + ": " + result);
    }
}
