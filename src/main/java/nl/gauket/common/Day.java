package nl.gauket.common;

public class Day {
    protected static final int YEAR19 = 2019;
    protected static final int YEAR20 = 2020;

    private static long start;

    public static void start(int year, int day) {
        new adventOfCodeService().prepareDailyInput(year, day);

        startTimer();
    }

    public static void startTimer() {
        start = System.currentTimeMillis();
    }

    public static void stopTimer() {
        System.out.println("Took " + (System.currentTimeMillis() - start) + "ms");
        start = 0L;
    }

}
