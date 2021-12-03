package nl.gauket.mission2019;

import nl.gauket.common.InputReader;
import nl.gauket.common.NewDay;

import static nl.gauket.common.Calculator.add;
import static nl.gauket.common.Calculator.multiply;

public class Day2 extends NewDay {
    @Override
    public void before(int year, int day) {
        INPUT_INT = InputReader.readInputAsIntArray(year, day, ",");
    }

    @Override
    public long[] solvePart1() {
        var result = runIntcodeProgram(INPUT_INT.clone(), 12, 2)[0];
        return new long[] {result, 4945026};
    }

    @Override
    public long[] solvePart2() {
        var input1 = INPUT_INT.clone();
        var input2 = INPUT_INT.clone();

        // constraint solver (z3)
        int r1 = runIntcodeProgram(input1, 12, 2)[0];
        int r2 = runIntcodeProgram(input2, 13, 2)[0];

        int c1 = 13 * r1 - 12 * r2 - 2;
        int c2 = r2 - r1;

        int val = 19690720 - c1;
        int v = val / c2;
        int n = val % c2;

        var result = 100 * v + n;
        return new long[] {result, 5296};
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
