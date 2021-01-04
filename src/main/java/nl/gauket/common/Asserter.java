package nl.gauket.common;

import static java.lang.String.format;

public class Asserter {
    public static boolean AssertEq(long part, long expected, long actual) {
        if (0L == expected) {
            printErrorMessage(part, String.valueOf(expected), String.valueOf(actual));
            return false;
        }
        return AssertEq(part, String.valueOf(expected), String.valueOf(actual));
    }

    public static boolean AssertEq(long part, String expected, String actual) {
        if (!expected.equals(actual)) {
            printErrorMessage(part, expected, actual);
            return false;
        }
        return true;
    }

    private static void printErrorMessage(long part, String expected, String actual) {
        final String RED = "\033[0;31m";
        final String RESET = "\033[0m";

        var message = "ERROR";
        if ("".equals(expected) || "0".equals(expected)) message = "TODO";

        message = RED + message + " ->" + RESET;
        System.out.print((format("\tResult (part %d) : %s\n\t\t Expected:\t%s \n\t\t Actual:\t%s \t", part, message, expected, actual)));
    }
}
