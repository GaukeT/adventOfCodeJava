package nl.gauket.common;

import static nl.gauket.common.ConsoleColors.CYAN_BOLD;
import static nl.gauket.common.ConsoleColors.RESET;

public class Timer {
    private Timer() {}

    private static long start;

    public static void start() {
        start = System.nanoTime();
    }

    public static void stop() {
        var diff = (double) (System.nanoTime() - start) / 1_000_000;
        System.out.println(CYAN_BOLD + "(" + diff + "ms)" + RESET);
        start = 0L;
    }

    public static void stop(String customMessage) {
        var diff = (double) (System.nanoTime() - start) / 1_000_000;
        System.out.println("> Task :" + customMessage + CYAN_BOLD + " (" + diff + "ms)" + RESET);
        start = 0L;
    }
}

