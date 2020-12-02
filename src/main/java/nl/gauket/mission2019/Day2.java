package nl.gauket.mission2019;

import nl.gauket.common.Day;

import java.io.IOException;
import java.net.URISyntaxException;

import static nl.gauket.common.Calculator.add;
import static nl.gauket.common.Calculator.multiply;
import static nl.gauket.common.InputReader.readInputAsIntArray;
import static nl.gauket.common.ResultLogger.printResult;

public class Day2 extends Day {
    private static final int DAY = 2;

    public static void main(String[] args) throws IOException, URISyntaxException {
        part1();
        part2();
    }

    private static void part1() throws IOException, URISyntaxException {
        start();
        // part 1 // 4945026
        int[] input = readInputAsIntArray(YEAR19, DAY);
        input = runIntcodeProgram(input, 12, 2);

        printResult(DAY, input[0]);
        stop();
    }

    private static void part2() throws IOException, URISyntaxException {
        start();
        // part 2 // 19690720

        // constraint solver (z3)
        int[] input1 = readInputAsIntArray(YEAR19, DAY);
        int[] input2 = readInputAsIntArray(YEAR19, DAY);

        int r1 = runIntcodeProgram(input1, 12, 2)[0];
        int r2 = runIntcodeProgram(input2, 13, 2)[0];

        int c1 = 13 * r1 - 12 * r2 - 2;
        int c2 = r2 - r1;

        int val = 19690720 - c1;
        int v = val / c2;
        int n = val % c2;

        printResult(DAY, 100 * v + n);
        stop();
    }

    public static int[] runIntcodeProgram(int[] input, int noun, int verb) {
        replace(input, 1, noun); // noun
        replace(input, 2, verb); // verb
        return runIntcodeProgram(input);
    }

    public static int[] runIntcodeProgram(int[] input) {
        int instructionPointer = 0;
        while (true) {
            int opCode = input[instructionPointer];
            if (opCode == 99) break; // halt program

            int answer = 0;
            int x = getValueFromPos(input, instructionPointer + 1);
            int y = getValueFromPos(input, instructionPointer + 2);
            int resultAddress = input[instructionPointer + 3];

            if (opCode == 1) {
                answer = add(x, y);
            } else if (opCode == 2) {
                answer = multiply(x, y);
            }

            replace(input, resultAddress, answer);
            instructionPointer = stepForward(instructionPointer);
        }

        return input;
    }

    private static int getValueFromPos(int[] input, int position) {
        return input[input[position]];
    }

    private static void replace(int[] input, int position, int newVal) {
        input[position] = newVal;
    }

    private static int stepForward(int currentPos) {
        // Step forward 4 positions
        return currentPos != 0 ? currentPos + 4 : 4;
    }
}
