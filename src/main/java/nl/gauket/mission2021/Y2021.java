package nl.gauket.mission2021;

import nl.gauket.common.NewDay;

import java.util.ArrayList;
import java.util.List;

public class Y2021 {
    private static final int YEAR   = 2021;

    public static void main(String[] args) {
        runAll();
    }

    private static void runAll() {
        for (var day : KNOWN_DAYS) {
            day.run(YEAR, true);
        }
    }

    // configure Day if implemented by MyDay interface
    private static final List<NewDay> KNOWN_DAYS = new ArrayList<>();

    static {
        KNOWN_DAYS.add(new Day1());
        KNOWN_DAYS.add(new Day2());
    }
}
