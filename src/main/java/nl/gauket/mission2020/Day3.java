package nl.gauket.mission2020;

import nl.gauket.common.Day;
import nl.gauket.common.InputReader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static nl.gauket.common.Calculator.multiply;
import static nl.gauket.common.ResultLogger.printResult;

public class Day3 extends Day {
    private static final int DAY = 3;

    public static void main(String[] args) throws IOException, URISyntaxException {
        prepareDaily(args[0], YEAR20, DAY);
        part1();
        part2();
    }

    private static void part1() throws IOException, URISyntaxException {
        start();
        // part 1 //
        var input = InputReader.readInputAsCharTwoDemencialArray(YEAR20, DAY);
        var result = solve(input, 3, 1);

        stop();
        printResult(DAY, result);
        AssertEq(237, result);
    }

    private static void part2() throws IOException, URISyntaxException {
        start();
        // part 2 //
        var input = InputReader.readInputAsCharTwoDemencialArray(YEAR20, DAY);
        var result = solve2(input);

        stop();
        printResult(DAY, result);
        AssertEq(2106818610, result);
    }

    private static int solve2(char[][] input) {
        var slope1 = solve(input, 1, 1);
        var slope2 = solve(input, 3, 1);
        var slope3 = solve(input, 5, 1);
        var slope4 = solve(input, 7, 1);
        var slope5 = solve(input, 1, 2);
        return multiply(slope1, slope2, slope3, slope4, slope5);
    }

    private static int solve(char[][] input, int right, int down) {
        var stepDown = down;
        var stepRight = right;

        var treeCounter = 0;
        var fieldWith = 31;

        while (down < input.length) {
            if (right >= fieldWith) right -= fieldWith;

            var tree = input[down][right];
            if (isTree(tree)) treeCounter++;

            down += stepDown;
            right += stepRight;
        }
        return treeCounter;
    }

    private static boolean isTree(char position) {
        return '#' == position;
    }

}
