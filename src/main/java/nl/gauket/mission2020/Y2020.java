package nl.gauket.mission2020;

import nl.gauket.common.NewDay;

import java.util.ArrayList;
import java.util.List;

public class Y2020 {
    private static final int YEAR   = 2020;

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
        KNOWN_DAYS.add(new Day4());
        KNOWN_DAYS.add(new Day5());
        KNOWN_DAYS.add(new Day6());
        KNOWN_DAYS.add(new Day7());
        KNOWN_DAYS.add(new Day8());
        KNOWN_DAYS.add(new Day9());
        KNOWN_DAYS.add(new Day10());
        KNOWN_DAYS.add(new Day11());
        KNOWN_DAYS.add(new Day12());
        KNOWN_DAYS.add(new Day13());
        KNOWN_DAYS.add(new Day14());
        KNOWN_DAYS.add(new Day15());
        KNOWN_DAYS.add(new Day16());
        KNOWN_DAYS.add(new Day17());
        KNOWN_DAYS.add(new Day18());
        KNOWN_DAYS.add(new Day19());
        KNOWN_DAYS.add(new Day20());
        KNOWN_DAYS.add(new Day21());
        KNOWN_DAYS.add(new Day22());
        KNOWN_DAYS.add(new Day23());
        KNOWN_DAYS.add(new Day24());
        KNOWN_DAYS.add(new Day25());
    }
}
