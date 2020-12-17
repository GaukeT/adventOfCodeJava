package nl.gauket.mission2020;

import nl.gauket.common.Calculator;
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
        printResult(DAY, 0, result);
    }

    private static void part2() throws IOException, URISyntaxException {
        start();
        // part 2 //
        var input = InputReader.readInputAsStringArray(YEAR20, DAY);
        var result = solve(input, 2);

        stop();
        printResult(DAY, 0, result);
    }

    public static int solve(String[] input, int part) {
        var currDir = 'E';

        int x = 0, y = 0;

        /*
            N = y++;
            E = x++;
            S = y--;
            W = x--;
         */

        for (var row : input) {
            var instruction = row.charAt(0);
            var distance = parseInt(row.substring(1));


            // Action L means to turn left the given number of degrees.
            if ('L' == instruction) {
                if ('N' == currDir) {
                    if (90 == distance) currDir = 'W';
                    if (180 == distance) currDir = 'S';
                    if (270 == distance) currDir = 'E';
                } else if ('E' == currDir) {
                    if (90 == distance) currDir = 'N';
                    if (180 == distance) currDir = 'W';
                    if (270 == distance) currDir = 'S';
                } else if ('S' == currDir) {
                    if (90 == distance) currDir = 'E';
                    if (180 == distance) currDir = 'N';
                    if (270 == distance) currDir = 'W';
                } else {
                    if (90 == distance) currDir = 'S';
                    if (180 == distance) currDir = 'E';
                    if (270 == distance) currDir = 'N';
                }
                continue;
            }

            // Action R means to turn right the given number of degrees.
            else if ('R' == instruction) {
                if ('N' == currDir) {
                    if (90 == distance) currDir = 'E';
                    if (180 == distance) currDir = 'S';
                    if (270 == distance) currDir = 'W';
                } else if ('E' == currDir) {
                    if (90 == distance) currDir = 'S';
                    if (180 == distance) currDir = 'W';
                    if (270 == distance) currDir = 'N';
                } else if ('S' == currDir) {
                    if (90 == distance) currDir = 'W';
                    if (180 == distance) currDir = 'N';
                    if (270 == distance) currDir = 'E';
                } else {
                    if (90 == distance) currDir = 'N';
                    if (180 == distance) currDir = 'E';
                    if (270 == distance) currDir = 'S';
                }
                continue;
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

            System.out.println("x:" + x + " y:" + y);
        }

        return calculateManhattanDistance(x, y);
    }

    private static int calculateManhattanDistance(int x, int y) {
        return add(abs(x), abs(y));
    }
}
