package nl.gauket.common;

public class Day extends Timer {
    protected static final int YEAR19 = 2019;
    protected static final int YEAR20 = 2020;

    protected static boolean DEBUG = false;

    public static void prepareDaily(int year, int day) {
        new InputService().prepareDailyInput(year, day);
    }
}
