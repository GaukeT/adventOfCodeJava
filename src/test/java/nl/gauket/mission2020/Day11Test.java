package nl.gauket.mission2020;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day11Test {

    @Test
    void part1() {
        char[][] input = {
                {'L','.','L','L','.','L','L','.','L','L'},
                {'L','L','L','L','L','L','L','.','L','L'},
                {'L','.','L','.','L','.','.','L','.','.'},
                {'L','L','L','L','.','L','L','.','L','L'},
                {'L','.','L','L','.','L','L','.','L','L'},
                {'L','.','L','L','L','L','L','.','L','L'},
                {'.','.','L','.','L','.','.','.','.','.'},
                {'L','L','L','L','L','L','L','L','L','L'},
                {'L','.','L','L','L','L','L','L','.','L'},
                {'L','.','L','L','L','L','L','.','L','L'}
        };
        int expected = 37;

        int result = Day11.solve(input, 1);
        assertEquals(expected, result);

    }

}