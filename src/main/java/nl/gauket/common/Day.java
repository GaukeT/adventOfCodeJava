package nl.gauket.common;

public class Day {
    protected static final int YEAR19 = 2019;
    protected static final int YEAR20 = 2020;

    private static long start;

    public static void prepareDaily(String session, int year, int day) {
        new InputService(session).prepareDailyInput(year, day);
    }

    public static void start() {
        start = System.currentTimeMillis();
    }

    public static void stop() {
        System.out.println("Took " + (System.currentTimeMillis() - start) + "ms");
        start = 0L;
    }

}
