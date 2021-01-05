package nl.gauket.mission2020;

import nl.gauket.common.InputReader;
import nl.gauket.common.MyDay;

import static nl.gauket.common.Calculator.multiply;

public class Day3 extends MyDay {
    @Override
    public void before(int year, int day) {
        INPUT_CH_MATRIX = InputReader.readInputAsCharMatrix(year, day);
    }

    @Override
    public long[] solvePart1() {
        var result = solve(INPUT_CH_MATRIX.clone(), 3, 1);
        return new long[]{result, 237L};
    }

    @Override
    public long[] solvePart2() {
        var result = solve2(INPUT_CH_MATRIX.clone());
        return new long[]{result, 2106818610L};
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
            right = right % fieldWith;

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
