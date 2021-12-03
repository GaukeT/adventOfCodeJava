package nl.gauket.mission2020;

import nl.gauket.common.ConsoleWriter;
import nl.gauket.common.InputReader;
import nl.gauket.common.InputWriter;
import nl.gauket.common.NewDay;

import java.util.Arrays;

import static nl.gauket.common.Calculator.add;

public class Day11 extends NewDay {
    @Override
    public void before(int year, int day) {
        INPUT_CH_MATRIX = InputReader.readInputAsCharMatrix(year, day);
    }

    @Override
    public long[] solvePart1() {
        var result = solve(INPUT_CH_MATRIX.clone(), 1);
        return new long[]{result, 2319L};
    }

    @Override
    public long[] solvePart2() {
        var result = solve(INPUT_CH_MATRIX.clone(), 2);
        return new long[]{result, 0L};
    }

    public static int solve(char[][] input, int part) {
        var rounds = 1;
        var occupiedSeats = 0;
        var copy = new char[][]{};
        printRun(input, rounds);

        while (true) {
            copy = copyInput(input);

            for (int i = 0; i < input.length; i++) {
                for (int j = 0; j < input[i].length; j++) {
                    if (!isFloor(input[i][j])) {

                        // If a seat is empty (L) and there are no occupied seats adjacent to it, the seat becomes occupied.
                        if (isEmpty(input[i][j])) {
                            var adjacentSeats = countAdjacentSeats(input, i, j);
                            if (adjacentSeats == 0) copy[i][j] = '#';
                        }

                        // If a seat is occupied (#) and four or more seats adjacent to it are also occupied, the seat becomes empty
                        else if (isTaken(input[i][j])) {
                            var adjacentSeats = countAdjacentSeats(input, i, j);
                            if (adjacentSeats >= 4) copy[i][j] = 'L';
                        }
                    }
                }
            }

            if (!Arrays.deepEquals(copy, input)) {
                if (DEBUG) {
                    // debug.txt
                    InputWriter.clearDebugfile();
                    printRun(input, rounds); // before
                }

                rounds++;
                input = copyInput(copy);

                if (DEBUG) printRun(input, rounds); // after
            } else {
                input = copyInput(copy);
                occupiedSeats = countOccupiedSeats(input);
                break;
            }
        }

        return occupiedSeats;
    }

    private static int countOccupiedSeats(char[][] input) {
        var retval = 0;
        for (var row : input) {
            for (var seat : row) {
                if ('#' == seat) retval++;
            }
        }
        return retval;
    }

    public static void printRun(char[][] input, int rounds) {
        InputWriter.debug("------------------------", true);
        InputWriter.debug("ROUND: " + rounds, true);
        InputWriter.debug("------------------------", true);
        ConsoleWriter.printGrid(input);
    }

    private static int countAdjacentSeats(char[][] input, int i, int j) {
        int N = 0, NE = 0, NW = 0;
        int S = 0, SE = 0, SW = 0;

        if (hasNorthNeighbour(i)) {
            N = isTaken(input[i - 1][j]) ? 1 : 0;
            NE = hasEastNeighbour(j, input[i - 1].length) ? isTaken(input[i - 1][j + 1]) ? 1 : 0 : 0;
            NW = hasWestNeighbour(j) ? isTaken(input[i - 1][j - 1]) ? 1 : 0 : 0;
        }

        if (hasSouthNeighbour(i, input.length)) {
            S = isTaken(input[i + 1][j]) ? 1 : 0;
            SE = hasEastNeighbour(j, input[i + 1].length) ? isTaken(input[i + 1][j + 1]) ? 1 : 0 : 0;
            SW = hasWestNeighbour(j) ? isTaken(input[i + 1][j - 1]) ? 1 : 0 : 0;
        }

        int E = hasEastNeighbour(j, input[i].length) ? isTaken(input[i][j + 1]) ? 1 : 0 : 0;
        int W = hasWestNeighbour(j) ? isTaken(input[i][j - 1]) ? 1 : 0 : 0;

        return add(N, NE, E, SE, S, SW, W, NW);
    }

    private static char[][] copyInput(char[][] input) {
        return Arrays.stream(input).map(char[]::clone).toArray(char[][]::new);
    }

    private static boolean isFloor(char pos) {
        return '.' == pos;
    }

    private static boolean isTaken(char pos) {
        return '#' == pos;
    }

    private static boolean isEmpty(char pos) {
        return 'L' == pos;
    }

    private static boolean hasNorthNeighbour(int i) {
        return 0 != i;
    }

    private static boolean hasSouthNeighbour(int i, int length) {
        return length - 1 != i;
    }

    private static boolean hasEastNeighbour(int j, int rowLength) {
        return j < rowLength - 1;
    }

    private static boolean hasWestNeighbour(int j) {
        return 0 != j;
    }
}
