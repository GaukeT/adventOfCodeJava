package nl.gauket.mission2020;

import nl.gauket.common.Day;
import nl.gauket.common.InputReader;

import java.util.ArrayList;
import java.util.Collections;

import static java.lang.Math.ceil;
import static java.lang.Math.floor;
import static nl.gauket.common.ResultLogger.printResult;

public class Day5 extends Day {
    private static final int DAY = 5;

    public static void main(String[] args) {
        prepareDaily(YEAR20, DAY);
        part1();
        part2();
    }

    private static void part1() {
        start();
        // part 1 //
        var input = InputReader.readInputAsStringArray(YEAR20, DAY);
        var result = solve(input, 1);

        stop();
        printResult(DAY, 883, result);
    }

    private static void part2() {
        start();
        // part 2 //
        var input = InputReader.readInputAsStringArray(YEAR20, DAY);
        var result = solve(input, 2);

        stop();
        printResult(DAY, 532, result);
    }

    public static int solve(String[] input, int part) {
        ArrayList<Integer> seats = determineListOfPlaneSeats(input);
        Collections.sort(seats);

        if (part == 1) {
            // part 1
            return seats.get(seats.size() - 1);
        } else {
            // part 2
            var mySeat = 0;
            for (int i = 1; i < seats.size() - 1; i++) {
                var nextL = seats.get(i + 1);
                var my = seats.get(i);

                if (nextL - 1 != my && nextL - 2 == my) {
                    mySeat = my + 1;
                    break;
                }
            }
            return mySeat;
        }
    }

    private static ArrayList<Integer> determineListOfPlaneSeats(String[] input) {
        var seats = new ArrayList<Integer>();

        for (var inputRow : input) {
            String[] partition = inputRow.split("");

            // trough plane rows
            var lowerRow = 0;
            var upperRow = 127;

            for (int i = 0; i < 7; i++) {
                var l = partition[i];

                if ("F".equals(l)) {
                    upperRow -= (int) ceil((upperRow - lowerRow) / 2) + 1;
                } else if ("B".equals(l)) {
                    lowerRow += (int) floor((upperRow - lowerRow) / 2) + 1;
                }
            }

            // check if row is chosen
            if (lowerRow != upperRow) throw new IllegalStateException("Not a possible state");

            // trough plane seats in a row
            var lowerSeat = 0;
            var upperSeat = 7;

            for (int i = 7; i < 10; i++) {
                String l = partition[i];

                if ("L".equals(l)) {
                    upperSeat -= (int) ceil((upperSeat - lowerSeat) / 2) + 1;
                } else if ("R".equals(l)) {
                    lowerSeat += (int) floor((upperSeat - lowerSeat) / 2) + 1;
                }
            }

            // check if seat is chosen
            if (lowerSeat != upperSeat) throw new IllegalStateException("Not a possible state");

            var seatId = calculateSeatId(lowerRow, lowerSeat);
            seats.add(seatId);

        }
        return seats;
    }

    private static int calculateSeatId(int row, int column) {
        return (row * 8) + column;
    }
}
