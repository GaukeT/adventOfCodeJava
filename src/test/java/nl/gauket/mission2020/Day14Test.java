package nl.gauket.mission2020;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day14Test {
    @Test
    void part1() {
        var input = new String[]{
                "mask = XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X",
                "mem[8] = 11",
                "mem[7] = 101",
                "mem[8] = 0"
        };
        var expected = 165L;

        var result = Day14.solve(input, 1);
        assertEquals(expected, result);
    }

    @Test
    void setup() {
        /*
            mask = XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X
            mem[8] = 11
            mem[7] = 101
            mem[8] = 0
        */

        var result = 0L;
        var val = 0L;
        var mask = "";

        mask = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X";

        val = 11;
        result = Day14.applyMask(mask, val);
        assertEquals(73, result);

        val = 101;
        result = Day14.applyMask(mask, val);
        assertEquals(101, result);

        val = 0;
        result = Day14.applyMask(mask, val);
        assertEquals(64, result);
    }




}