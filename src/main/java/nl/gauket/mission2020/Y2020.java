package nl.gauket.mission2020;

import nl.gauket.common.InputReader;
import nl.gauket.common.InputService;
import nl.gauket.common.iDay;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import static nl.gauket.common.ResultLogger.printResult;
import static nl.gauket.common.Timer.start;
import static nl.gauket.common.Timer.stop;

public class Y2020 {
    private static final int DAY = 15;
    private static final int YEAR20 = 2020;

    private static final Map<Integer, iDay> KNOWN_DAYS = new HashMap<>();
    {
        KNOWN_DAYS.put(15, new Day15());
    }

    public static void main(String[] args) {
        prepareDaily();
        run();
    }

    private static void run() {
        iDay iDay = KNOWN_DAYS.getOrDefault(DAY, new Template());
        if (null != iDay) {
            var input = getInput();
            if (null != input) {
                solve(input.clone(), iDay, 1);
                solve(input.clone(), iDay, 2);
            }
        }
    }

    private static void prepareDaily() {
        new InputService().prepareDailyInput(YEAR20, DAY);
    }

    private static String[] getInput() {
        try {
            return InputReader.readInputAsStringArray(YEAR20, DAY);
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void solve(String[] input, iDay day, int part) {
        start();
        var retval = new long[2];

        switch (part) {
            case 1 -> retval = day.solvePart1(input);
            case 2 -> retval = day.solvePart2(input);
        }

        var result = retval.length > 0 ? retval[1] : 0L;
        var expected = retval.length > 1 ? retval[1] : 0L;

        printResult(DAY, expected, result);
        stop();
    }
}
