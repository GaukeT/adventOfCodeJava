package nl.gauket.common;

import static java.lang.String.format;

public class Asserter {
    public static boolean AssertEq(long expected, long actual) {
        return AssertEq(String.valueOf(expected), String.valueOf(actual));
    }

    public static boolean AssertEq(String expected, String actual) {
        if (!expected.equals(actual)) {
            System.out.print((format("\tResult : ERROR -> \n\t\t Expected:\t%s \n\t\t Actual:\t%s \t", expected, actual)));
            return false;
        }
        return true;
    }
}
