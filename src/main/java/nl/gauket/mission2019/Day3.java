package nl.gauket.mission2019;

import nl.gauket.common.Day;
import nl.gauket.common.InputReader;

import java.awt.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;
import static java.util.regex.Pattern.compile;
import static nl.gauket.common.ResultLogger.printResult;

public class Day3 extends Day {
    private static final int DAY = 3;

    public static void main(String[] args) {
        prepareDaily(YEAR19, DAY);
        part1();
    }

    private static void part1() {
        start();
        // part 1 //
        var input = InputReader.readInputAsStringMatrix(YEAR19, DAY);
        var result = solve(input);

        printResult(DAY, 0, result);
        stop();
    }

    public static int solve(String[][] input) {
        int closest = Integer.MAX_VALUE;

        var line1 = calculatePointsVisited(input[0]);
        var line2 = calculatePointsVisited(input[1]);

        var intersections = determineIntersections(line1, line2);

        for (Point p : intersections) {
            int dist = CalculateManhattanDistance(1, p.x, 1, p.y);
            if (dist < closest) closest = dist;
        }

        return closest;
    }

    public static int CalculateManhattanDistance(int x1, int x2, int y1, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    private static ArrayList<Point> determineIntersections(ArrayList<Point> line1, ArrayList<Point> line2) {
        var intersections = new ArrayList<Point>();
        for (var p : line1) {
            if (line2.contains(p)) {
                intersections.add(p);
            }
        }
        return intersections;
    }

    private static ArrayList<Point> calculatePointsVisited(String[] input) {
        var points = new ArrayList<Point>();

        // starting positions...
        int x = 1;
        int y = 1;

        for (var command : input) {
            Matcher m = getPattern().matcher(command);

            if (m.find()) {
                var direction = getDirection(m);
                var steps = getSteps(m);
                for (int i = 1; i <= steps; i++) {
                    switch (direction) {
                        case "U":
                            y += 1;
                            points.add(new Point(x, y));
                            break;
                        case "D":
                            y -= 1;
                            points.add(new Point(x, y));
                            break;
                        case "L":
                            x -= 1;
                            points.add(new Point(x, y));
                            break;
                        case "R":
                            x += 1;
                            points.add(new Point(x, y));
                            break;
                        default:
                            break;
                    }
                }

            }
        }
        return points;
    }

    private static int getSteps(Matcher m) {
        return parseInt(m.group(2));
    }

    private static String getDirection(Matcher m) {
        return m.group(1);
    }

    private static Pattern getPattern() {
        return compile("^([URLD])(\\d.*)$");
    }
}
