package nl.gauket.mission2020;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day13Test {
    @Test
    void part1() {
        var input = new String[]{
                "939",
                "7,13,x,x,59,x,31,19"
        };
        var expected = 295L;

        var result = Day13.solve(input);
        assertEquals(expected, result);
    }

    @Test
    void part2() {
        var input = new String[]{
                "ignore",
                "7,13,x,x,59,x,31,19"
        };
        var expected = 1068781L;

        var result = Day13.solve2(input);
        assertEquals(expected, result);
    }

    @Test
    void part2b() {
        var input = new String[]{
                "ignore",
                "17,x,13,19"
        };
        var expected = 3417L;

        var result = Day13.solve2(input);
        assertEquals(expected, result);
    }

    @Test
    void part2c() {
        var input = new String[]{
                "ignore",
                "67,7,59,61"
        };
        var expected = 754018L;

        var result = Day13.solve2(input);
        assertEquals(expected, result);
    }

    @Test
    void part2d() {
        var input = new String[]{
                "ignore",
                "67,x,7,59,61"
        };
        var expected = 779210L;

        var result = Day13.solve2(input);
        assertEquals(expected, result);
    }

    @Test
    void part2e() {
        var input = new String[]{
                "ignore",
                "67,7,x,59,61"
        };
        var expected = 1261476L;

        var result = Day13.solve2(input);
        assertEquals(expected, result);
    }

    @Test
    void part2f() {
        var input = new String[]{
                "ignore",
                "1789,37,47,1889"
        };
        var expected = 1202161486L;

        var result = Day13.solve2(input);
        assertEquals(expected, result);
    }
}