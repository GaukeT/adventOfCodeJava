package nl.gauket.common;

import static java.lang.String.format;

public class Asserter {
    public static void AssertEq(int expected, int actual) {
        AssertEq(String.valueOf(expected), String.valueOf(actual));
    }

    public static void AssertEq(long expected, long actual) {
        AssertEq(String.valueOf(expected), String.valueOf(actual));
    }

    public static void AssertEq(String expected, String actual) {
        if (!expected.equals(actual))
            System.out.println((format("ERROR --> Expected: %s Actual: %s <--", expected, actual)));
    }
}
