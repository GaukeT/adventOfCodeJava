package nl.gauket.common;

public class Asserter {
    public static void AssertEq(int expected, int actual) {
        AssertEq(String.valueOf(expected), String.valueOf(actual));
    }

    public static void AssertEq(String expected, String actual) {
        if (!expected.equals(actual))
            throw new IllegalArgumentException("Expected: " + expected + " differs from actual:" + actual);
    }
}
