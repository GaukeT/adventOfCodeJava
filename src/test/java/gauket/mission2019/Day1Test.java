package gauket.mission2019;

import nl.gauket.mission2019.Day1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day1Test {

    @Test
    void calculateTotalFuelAtMassOf12() {
        int result = Day1.calculateFuelBy(12);
        assertEquals(2, result);
    }

    @Test
    void calculateTotalFuelAtMassOf14() {
        int result = Day1.calculateFuelBy(14);
        assertEquals(2, result);
    }

    @Test
    void calculateTotalFuelAtMassOf1969() {
        int result = Day1.calculateFuelBy(1969);
        assertEquals(654, result);
    }

    @Test
    void calculateTotalFuelAtMassOf100756() {
        int result = Day1.calculateFuelBy(100756);
        assertEquals(33583, result);
    }
}