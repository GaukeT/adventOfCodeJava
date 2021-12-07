package nl.gauket.mission2021;

import nl.gauket.common.NewDay;

import java.util.Arrays;

public class Day5 extends NewDay {
    @Override
    public long[] solvePart1() {
        var result = solve(INPUT.clone(), false);
        return new long[] {result, 6005};
    }

    @Override
    public long[] solvePart2() {
        var result = solve(INPUT.clone(), true);
        return new long[] {result, 23864};
    }

    public static long solve(String[] input, boolean inclDiagonals) {
        var grid = new int[1000][1000];

        for (var row: input) {
            var vent = row.split(" -> ");
            var vent1 = Arrays.stream(vent[0].split(",")).mapToInt(Integer::parseInt).toArray();
            var vent2 = Arrays.stream(vent[1].split(",")).mapToInt(Integer::parseInt).toArray();

            if (isStraightLine(vent1, vent2)) {
                var xs = Math.min(vent1[0], vent2[0]);
                var xl = Math.max(vent1[0], vent2[0]);
                var ys = Math.min(vent1[1], vent2[1]);
                var yl = Math.max(vent1[1], vent2[1]);

                for (int i = ys; i <= yl; i++) {
                    for (int j = xs; j <= xl; j++) {
                        grid[i][j]++;
                    }
                }
            } else if (inclDiagonals) {
                print("-----------------------");
                var xs = vent1[0];
                var xl = vent2[0];

                var ys = vent1[1];
                var yl = vent2[1];

                if (ys < yl) { // negative slope on y-axes
                    for (int i = ys; i <= yl; i++) {
                        if (xs <= xl) {
                            print("x=" + xs + " y=" + i);
                            grid[i][xs]++;
                            xs++;
                        } else {
                            print("x=" + xs + " y=" + i);
                            grid[i][xs]++;
                            xs--;
                        }
                    }
                } else {
                    for (int i = ys; i >= yl; i--) {
                        if (xs <= xl) {
                            print("x=" + xs + " y=" + i);
                            grid[i][xs]++;
                            xs++;
                        } else {
                            print("x=" + xs + " y=" + i);
                            grid[i][xs]++;
                            xs--;
                        }
                    }
                }
            }
        }
        return countOverlap(grid);
    }

    private static boolean isStraightLine(int[] vent1, int[] vent2) {
        return vent1[0] == vent2[0] || vent1[1] == vent2[1];
    }

    private static long countOverlap(int[][] grid) {
        var retval = 0;
        for (int[] col : grid) {
            for (int row : col) {
                if (row > 1) retval++;
            }
        }
        return retval;
    }
}
