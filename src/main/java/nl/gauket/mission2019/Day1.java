package nl.gauket.mission2019;

import nl.gauket.common.Day;
import nl.gauket.common.InputReader;

import java.io.IOException;
import java.net.URISyntaxException;

import static nl.gauket.common.ResultLogger.printResult;

public class Day1 extends Day {
    private static final int DAY = 1;

    public static void main(String[] args) throws IOException, URISyntaxException {
        start(YEAR19, DAY);
        int result = InputReader.readInputAsIntStream(YEAR19, DAY)
                        .reduce(0, (t, m) -> t + calculateFuelBy(m));

        stopTimer();
        printResult(DAY, result);
    }

    public static int calculateFuelBy(int mass) {
        return mass / 3 - 2;
    }
}
