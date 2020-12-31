package nl.gauket.mission2020;

import nl.gauket.common.InputService;
import nl.gauket.common.MyDay;

import java.util.HashMap;
import java.util.Map;

import static nl.gauket.common.ResultLogger.printResult;
import static nl.gauket.common.Timer.start;
import static nl.gauket.common.Timer.stop;

public class Y2020 {
    private static final int DAY = 1;
    private static final int YEAR = 2020;

    public static void main(String[] args) {
        prepareDaily();
        run();
    }

    private static void run() {
        MyDay day = KNOWN_DAYS.get(DAY);
        if (null != day) {
            before(day);
            solve(day, 1);
            solve(day, 2);
        }
    }

    private static void prepareDaily() {
        new InputService().prepareDailyInput(YEAR, DAY);
    }

    private static void before(MyDay day) {
        start();
        day.before(YEAR, DAY);
        stop(day.getClass().getSimpleName() + ".before()");
    }

    public static void solve(MyDay day, int part) {
        start();
        long[] retval;

        switch (part) {
            case 1 -> retval = day.solvePart1();
            case 2 -> retval = day.solvePart2();
            default -> throw new IllegalStateException("Unexpected part: " + part);
        }

        stop();
        var result = retval.length > 0 ? retval[0] : 0L;
        var expected = retval.length > 1 ? retval[1] : 0L;
        printResult(DAY, expected, result);
    }

    // configure Day if implemented by MyDay interface
    private static final Map<Integer, MyDay> KNOWN_DAYS = new HashMap<>();

    static {
        KNOWN_DAYS.put(1, new Day1());
        KNOWN_DAYS.put(2, new Template());
        KNOWN_DAYS.put(3, new Template());
        KNOWN_DAYS.put(4, new Template());
        KNOWN_DAYS.put(5, new Template());
        KNOWN_DAYS.put(6, new Template());
        KNOWN_DAYS.put(7, new Template());
        KNOWN_DAYS.put(8, new Template());
        KNOWN_DAYS.put(9, new Template());
        KNOWN_DAYS.put(10, new Template());
        KNOWN_DAYS.put(11, new Template());
        KNOWN_DAYS.put(12, new Template());
        KNOWN_DAYS.put(13, new Template());
        KNOWN_DAYS.put(14, new Template());
        KNOWN_DAYS.put(15, new Day15());
    }
}
