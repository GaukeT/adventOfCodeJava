package nl.gauket.mission2019;

import nl.gauket.common.NewDay;

import java.util.ArrayList;
import java.util.List;

public class Y2019 {
    private static final int YEAR   = 2019;

    public static void main(String[] args) {
        runAll();
    }

    private static void runAll() {
        for (var day : KNOWN_DAYS) {
            day.run(YEAR, true);
        }
    }

    // add day if extends NewDay abstract class
    private static final List<NewDay> KNOWN_DAYS = new ArrayList<>();

    static {
        KNOWN_DAYS.add(new Day1());
        KNOWN_DAYS.add(new Day2());
        KNOWN_DAYS.add(new Day3());
    }
}
