package nl.gauket.mission2020;

import nl.gauket.common.Day;
import nl.gauket.common.InputReader;

import java.io.IOException;
import java.net.URISyntaxException;

import static java.lang.Integer.parseInt;
import static java.lang.Math.abs;
import static nl.gauket.common.Calculator.add;
import static nl.gauket.common.ResultLogger.printResult;

public class Day12 extends Day {
    private static final int DAY = 12;

    public static void main(String[] args) throws IOException, URISyntaxException {
        prepareDaily(YEAR20, DAY);
        part1();
        part2();
    }

    private static void part1() throws IOException, URISyntaxException {
        start();
        // part 1 //
        var input = InputReader.readInputAsStringArray(YEAR20, DAY);
        var result = solve(input, 1);

        stop();
        printResult(DAY, 562, result);
    }

    private static void part2() throws IOException, URISyntaxException {
        start();
        // part 2 //
        var input = InputReader.readInputAsStringArray(YEAR20, DAY);
        var result = solve(input, 2);

        stop();
        printResult(DAY, 0, result); // 12592 - 72290  too low
    }

    public static int solve(String[] input, int part) {
        if (part == 1) return solve1(input);
        return solve2(input);
    }

    public static int solve1(String[] input) {
        var currDir = 'E';
        int x = 0, y = 0;       // ship position

        for (var row : input) {
            var instruction = row.charAt(0);
            var distance = parseInt(row.substring(1));

            if ('L' == instruction || 'R' == instruction) {
                currDir = determineShipDirection(currDir, instruction, distance);
            }
            // Action F means to move forward by the given value in the direction the
            else if ('F' == instruction) {
                instruction = currDir;
            }

            // Action N means to move north by the given value.
            // Action S means to move south by the given value.
            // Action E means to move east by the given value.
            // Action W means to move west by the given value.
            switch (instruction) {
                case 'N' -> y += distance;
                case 'S' -> y -= distance;
                case 'E' -> x += distance;
                case 'W' -> x -= distance;
            }

            if (DEBUG) System.out.println("x:" + x + " y:" + y);
        }

        return calculateManhattanDistance(x, y);
    }

    private static int solve2(String[] input) {
        int sx = 0, sy = 0;       // ship position
        int wx = 10, wy = 1;       // ship position

        for (var row : input) {
            var instruction = row.charAt(0);
            var distance = parseInt(row.substring(1));

            //Action L means to rotate the waypoint around the ship left (counter-clockwise) the given number of degrees.
            if ('L' == instruction) {
                var cx = wx;
                var cy = wy;

                if (90 == distance) {
                    wx = -cy;
                    wy = cx;
                } else if (180 == distance) {
                    wx = abs(cy);
                    wy = abs(cx);
                } else if (270 == distance) {
                    wx = cy;
                    wy = -cx;
                }
                continue;
            }

            //Action R means to rotate the waypoint around the ship right (clockwise) the given number of degrees.
            else if ('R' == instruction) {
                var cx = wx;
                var cy = wy;

                var t = distance / 90;

                if (90 == distance) {
                    wx = cy;
                    wy = -cx;
                } else if (180 == distance) {
                    wx = -cy;
                    wy = -cx;
                } else if (270 == distance) {
                    wx = -cy;
                    wy = cx;
                }
                continue;
            }

            //Action F means to move forward to the waypoint a number of times equal to the given value.
            else if ('F' == instruction) {
                sx += (wx * distance);
                sy += (wy * distance);
            } else {
                //Action N means to move the waypoint north by the given value.
                //Action S means to move the waypoint south by the given value.
                //Action E means to move the waypoint east by the given value.
                //Action W means to move the waypoint west by the given value.
                switch (instruction) {
                    case 'N' -> wy += distance;
                    case 'S' -> wy -= distance;
                    case 'E' -> wx += distance;
                    case 'W' -> wx -= distance;
                }
            }

            if (DEBUG) {
                System.out.println("sx:" + sx + " sy:" + sy);
                System.out.println("wx:" + wx + " wy:" + wy);
            }
        }

        return calculateManhattanDistance(sx, sy);
    }

    private static char determineShipDirection(char currDir, char instruction, int degree) {

        // Action L means to turn left the given number of degrees.
        if ('L' == instruction) {
            if ('N' == currDir) {
                if (90 == degree) return 'W';
                else if (180 == degree) return 'S';
                else if (270 == degree) return 'E';
            } else if ('E' == currDir) {
                if (90 == degree) return 'N';
                else if (180 == degree) return 'W';
                else if (270 == degree) return 'S';
            } else if ('S' == currDir) {
                if (90 == degree) return 'E';
                else if (180 == degree) return 'N';
                else if (270 == degree) return 'W';
            } else {
                if (90 == degree) return 'S';
                else if (180 == degree) return 'E';
                else if (270 == degree) return 'N';
            }
        }

        // Action R means to turn right the given number of degrees.
        else if ('R' == instruction) {
            if ('N' == currDir) {
                if (90 == degree) return 'E';
                else if (180 == degree) return 'S';
                else if (270 == degree) return 'W';
            } else if ('E' == currDir) {
                if (90 == degree) return 'S';
                else if (180 == degree) return 'W';
                else if (270 == degree) return 'N';
            } else if ('S' == currDir) {
                if (90 == degree) return 'W';
                else if (180 == degree) return 'N';
                else if (270 == degree) return 'E';
            } else {
                if (90 == degree) return 'N';
                else if (180 == degree) return 'E';
                else if (270 == degree) return 'S';
            }
        }

        throw new IllegalArgumentException("unknown instruction");
    }

    private static int calculateManhattanDistance(int x, int y) {
        return add(abs(x), abs(y));
    }
}
