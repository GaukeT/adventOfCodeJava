package nl.gauket.mission2019;

import nl.gauket.common.Day;
import nl.gauket.common.InputReader;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import static nl.gauket.common.ResultLogger.printResult;

public class Day3 extends Day {
    private static final int DAY = 3;

    public static void main(String[] args) throws IOException, URISyntaxException {
        prepareDaily(args[0], YEAR19, DAY);
        part1();
    }

    private static void part1() throws IOException, URISyntaxException {
        start();

        var in = InputReader.readInputAsStringList(YEAR19, DAY);

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
