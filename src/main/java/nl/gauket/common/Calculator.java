package nl.gauket.common;

import java.util.Arrays;

public class Calculator {

    public static int multiply(int... ints) {
        return Arrays.stream(ints).reduce(1, (i, j) -> i*j);
    }

    public static int add(int... ints) {
        return Arrays.stream(ints).sum();
    }

}
