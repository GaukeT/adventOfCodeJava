package nl.gauket.mission2021;

import nl.gauket.common.InputService;
import nl.gauket.common.MyDay;

import java.util.HashMap;
import java.util.Map;

import static nl.gauket.common.ConsoleColors.CYAN_BOLD;
import static nl.gauket.common.ConsoleColors.RESET;
import static nl.gauket.common.ResultLogger.printResult;
import static nl.gauket.common.Timer.start;
import static nl.gauket.common.Timer.stop;

public class Y2021 {
    // config
    private static int DAY    = 1;
    private static final int YEAR   = 2021;

    // additional config
    private static final boolean RUN_ALL_DAYS = false;
    private static final boolean PREPARE_DAILY = true;

    public static void main(String[] args) {
        if (RUN_ALL_DAYS) runAll();
        if (PREPARE_DAILY) prepareDaily();
        run();
    }

    private static void runAll() {
        var start = System.currentTimeMillis();

        for (MyDay day : KNOWN_DAYS.values()) {
            run(day);
        }

        System.out.println("\n> Task :Y2020.runAll() " + CYAN_BOLD + "(" + (System.currentTimeMillis() - start) + "ms)" + RESET);
        System.exit(0);
    }

    private static void run() {
        MyDay day = KNOWN_DAYS.get(DAY);
        run(day);
    }

    private static void run(MyDay day) {
        if (null != day) {
            var className = day.getClass().getSimpleName();
            DAY = Integer.parseInt(className.replace("Day", ""));
            before(day);
            System.out.println("> Task :Day" + DAY + ".solve()");
            solve(day, 1);
            solve(day, 2);
        } else {
            System.out.println("> Task :Day" + DAY + " == null");
        }
    }

    private static void prepareDaily() {
        new InputService().prepareDailyInput(YEAR, DAY);
    }

    private static void before(MyDay day) {
        start();
        day.before(YEAR, DAY);
        System.out.println(); // new line between days
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

        var result = retval.length > 0 ? retval[0] : 0L;
        var expected = retval.length > 1 ? retval[1] : 0L;

        printResult((long) part, expected, result);
        stop();
    }

    // configure Day if implemented by MyDay interface
    private static final Map<Integer, MyDay> KNOWN_DAYS = new HashMap<>();

    static {
        KNOWN_DAYS.put(1, new Day1());
    }
}
