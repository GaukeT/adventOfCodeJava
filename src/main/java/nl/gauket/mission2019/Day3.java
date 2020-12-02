package nl.gauket.mission2019;

import nl.gauket.common.Day;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

import static nl.gauket.common.ResultLogger.printResult;

public class Day3 extends Day {
    private static final int DAY = 3;

    public static void main(String[] args) {
        part1();
    }

    private static void part1() {
        start();

        String[] input = {"R75", "D30", "R83", "U83", "L12", "D49", "R71", "U7", "L72"};
        List<Point> pointsVisited = calculateRoute(input);

        printResult(DAY, "");
        stop();
    }

    private static List<Point> calculateRoute(String[] input) {
        // https://www.youtube.com/watch?v=H4vjv81SML4&ab_channel=TurkeyDev

        Point currentPosition = new Point(0, 0);

        Arrays.stream(input)
                .forEach(s -> {

                });

        return null;
    }


}
