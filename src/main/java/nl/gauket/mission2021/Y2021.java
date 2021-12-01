package nl.gauket.mission2021;

import nl.gauket.common.NewDay;

import java.util.HashMap;
import java.util.Map;

public class Y2021 {
    private static final int YEAR   = 2021;
    private static final boolean prepareDaily = true;

    public static void main(String[] args) {
        runAll();
    }

    private static void runAll() {
        for (var day : KNOWN_DAYS.values()) {
            day.run(YEAR, prepareDaily);
        }
    }

    // configure Day if implemented by MyDay interface
    private static final Map<Integer, NewDay> KNOWN_DAYS = new HashMap<>();

    static {
        KNOWN_DAYS.put(1, new Day1());
    }
}
