package nl.gauket.mission2020;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day8Test {
    @Test
    void part1() {
        var input = new String[]{
                "nop +0",
                "acc +1",
                "jmp +4",
                "acc +3",
                "jmp -3",
                "acc -99",
                "acc +1",
                "jmp -4",
                "acc +6"
        };
        int expected = 5;

        int result = Day8.solve(input, 1);
        assertEquals(expected, result);
    }

    @Test
    void part2() {
        var input = new String[]{
                "nop +0",
                "acc +1",
                "jmp +4",
                "acc +3",
                "jmp -3",
                "acc -99",
                "acc +1",
                "jmp -4",
                "acc +6"
        };
        int expected = 8;

        int result = Day8.solve(input, 2);
        assertEquals(expected, result);
    }
}