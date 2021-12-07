package nl.gauket.common;

import java.util.List;
import java.util.stream.IntStream;

import static nl.gauket.common.ResultLogger.printResult;
import static nl.gauket.common.Timer.start;
import static nl.gauket.common.Timer.stop;

public abstract class NewDay implements iDay {
    protected static boolean DEBUG = false;

    protected String[] INPUT;
    protected List<String> INPUT_STR_LIST;
    protected String[][] INPUT_STR_MATRIX;
    protected char[][] INPUT_CH_MATRIX;
    protected int[] INPUT_INT;
    protected long[] INPUT_LONG;
    protected IntStream INPUT_INTSTREAM;

    public final void run(int year, boolean prepareDaily) {
        var className = this.getClass().getSimpleName();
        var day = Integer.parseInt(className.replace("Day", ""));

        // download input from Advent of code server if not already done
        if (prepareDaily) {
            new InputService().prepareDailyInput(year, day);
        }

        // by default load input in string array. Can be overridden in subclass
        start();
        this.before(year, day);
        stop(className + ".before()");

        System.out.println("> Task :" + className + ".solve()");
        // solve part 1
        start();
        this.after(this.solvePart1(), 1);
        stop();

        // solve part 2
        start();
        this.after(this.solvePart2(), 2);
        stop();
    }

    @Override
    public void before(int year, int day) {
        INPUT = InputReader.readInputAsStringArray(year, day);
    }

    private void after(long[] retval, int part) {
        var result = retval.length > 0 ? retval[0] : 0L;
        var expected = retval.length > 1 ? retval[1] : 0L;

        printResult((long) part, expected, result);
    }

    public static void print(String str) {
        if (DEBUG) System.out.println(str);
    }
}
