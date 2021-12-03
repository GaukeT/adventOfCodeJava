package nl.gauket.common;

import static java.lang.String.format;
import static nl.gauket.common.ConsoleColors.RED;
import static nl.gauket.common.ConsoleColors.RESET;

public class Asserter {
    public static boolean assertEq(long part, long expected, long actual) {
        if (0L == expected) {
            printErrorMessage(part, String.valueOf(expected), String.valueOf(actual));
            return false;
        }
        return assertEq(part, String.valueOf(expected), String.valueOf(actual));
    }

    public static boolean assertEq(long part, String expected, String actual) {
        if (!expected.equals(actual)) {
            printErrorMessage(part, expected, actual);
            return false;
        }
        return true;
    }

    private static void printErrorMessage(long part, String expected, String actual) {
        var message = "ERROR";
        if ("".equals(expected) || "0".equals(expected)) message = "TODO";

        message = RED + message + " ->" + RESET;
        System.out.print((format("\tResult (part %d) : %s\n\t\t Expected:\t%s \n\t\t Actual:\t%s \t", part, message, expected, actual)));
    }
}
