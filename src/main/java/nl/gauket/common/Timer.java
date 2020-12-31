package nl.gauket.common;

public class Timer {
    private static long start;

    public static void start() {
        start = System.nanoTime();
    }

    public static void stop() {
        var diff = (double) (System.nanoTime() - start) / 1_000_000;
        System.out.print("(" + diff + "ms) : ");
        start = 0L;
    }

    public static void stop(String customMessage) {
        var diff = (double) (System.nanoTime() - start) / 1_000_000;
        System.out.println("> Task :" + customMessage + " (" + diff + "ms)");
        System.out.println();
        start = 0L;
    }
}

