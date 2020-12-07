package gauket.mission2019;

import nl.gauket.mission2019.Day3;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day3Test {

    @Test
    void runProgramExample1() {
        var r1 = "R75,D30,R83,U83,L12,D49,R71,U7,L72".split(",");
        var r2 = "U62,R66,U55,R34,D71,R55,D58,R83".split(",");
        String[][] input = {r1,r2};
        int expected = 159;

        int result = Day3.solve(input);
        assertEquals(expected, result);

    }

    @Test
    void runProgramExample2() {
        var r1 = "R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51".split(",");
        var r2 = "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7".split(",");
        String[][] input = {r1,r2};
        int expected = 135;

        int result = Day3.solve(input);
        assertEquals(expected, result);
    }
}