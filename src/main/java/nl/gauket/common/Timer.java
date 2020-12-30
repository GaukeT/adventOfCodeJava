package nl.gauket.common;

public class Timer {
    private static long start;

    public static void start() {
        start = System.currentTimeMillis();
    }

    public static void stop() {
        System.out.println("(" + (System.currentTimeMillis() - start) + "ms)");
        start = 0L;
    }

    public static void stop(String customMessage) {
        System.out.println("" + customMessage + " (" + (System.currentTimeMillis() - start) + "ms)");
        start = 0L;
    }
}
