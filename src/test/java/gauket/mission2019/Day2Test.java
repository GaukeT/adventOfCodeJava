package gauket.mission2019;

import nl.gauket.mission2019.Day2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Day2Test {

    @Test
    void runProgramExample1() {
        int[] input = {1, 0, 0, 0, 99};
        int[] expected = {2, 0, 0, 0, 99};

        int[] result = Day2.runIntcodeProgram(input);
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    void runProgramExample2() {
        int[] input = {2, 3, 0, 3, 99};
        int[] expected = {2, 3, 0, 6, 99};

        int[] result = Day2.runIntcodeProgram(input);
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    void runProgramExample3() {
        int[] input = {2, 4, 4, 5, 99, 0};
        int[] expected = {2, 4, 4, 5, 99, 9801};

        int[] result = Day2.runIntcodeProgram(input);
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    void runProgramExample4() {
        int[] input = {1, 1, 1, 4, 99, 5, 6, 0, 99};
        int[] expected = {30, 1, 1, 4, 2, 5, 6, 0, 99};

        int[] result = Day2.runIntcodeProgram(input);
        Assertions.assertArrayEquals(expected, result);
    }
}