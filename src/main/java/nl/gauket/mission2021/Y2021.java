package nl.gauket.mission2021;

import nl.gauket.common.NewDay;

import java.util.ArrayList;
import java.util.List;

public class Y2021 {
    private static final int DAY = -1;
    private static final int YEAR = 2021;

    public static void main(String[] args) {
        runAll();
    }

    private static void runAll() {
        if (DAY > 0) {
            KNOWN_DAYS.get(DAY - 1).run(YEAR, true);
        } else {
            for (var day : KNOWN_DAYS) {
                day.run(YEAR, false);
            }
        }
    }

    // add day if extends NewDay abstract class
    private static final List<NewDay> KNOWN_DAYS = new ArrayList<>();

    static {
        KNOWN_DAYS.add(new Day1());
        KNOWN_DAYS.add(new Day2());
        KNOWN_DAYS.add(new Day3());
        KNOWN_DAYS.add(new Day4());
        KNOWN_DAYS.add(new Day5());
        KNOWN_DAYS.add(new Day6());
        KNOWN_DAYS.add(new Day7());
    }
}
