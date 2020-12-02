package nl.gauket.common;

public class Day extends Timer {
    protected static final int YEAR19 = 2019;
    protected static final int YEAR20 = 2020;

    public static void prepareDaily(String session, int year, int day) {
        new InputService(session).prepareDailyInput(year, day);
    }
}
