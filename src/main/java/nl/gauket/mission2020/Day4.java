package nl.gauket.mission2020;

import nl.gauket.common.Day;
import nl.gauket.common.InputReader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static nl.gauket.common.ResultLogger.printResult;

public class Day4 extends Day {
    private static final int DAY = 4;

    public static void main(String[] args) throws IOException, URISyntaxException {
        prepareDaily(YEAR20, DAY);
        part1();
        part2();
    }

    private static void part1() throws IOException, URISyntaxException {
        start();
        // part 1 //
        var input = InputReader.readInputAsStringList(YEAR20, DAY);
        input.add(""); // hack to validate last passport also
        var result = solve(input);

        stop();
        printResult(DAY, 242, result);
    }

    private static void part2() {
        start();
        // part 2 //
        var input = new ArrayList<String>();
        var result = solve(input);

        stop();
        printResult(DAY, 0, result);
    }

    public static int solve(List<String> input) {
        var validCounter = 0;
        var ppBuilder = new StringBuilder();

        for (var row : input) {
            // still belongs to same passport
            if (!"".equals(row)) {
                ppBuilder.append(row)
                         .append(" ");
            } else {
                var isValid = validatePassport(ppBuilder.toString());

                if (isValid) validCounter++;
                ppBuilder = new StringBuilder();
            }
        }
        return validCounter;
    }

    private static boolean validatePassport(String pass) {

        // required fields
        if (pass.contains("byr:") && // (Birth Year)
            pass.contains("iyr:") && // (Issue Year)
            pass.contains("eyr:") && // (Expiration Year)
            pass.contains("hgt:") && // (Height)
            pass.contains("hcl:") && // (Hair Color)
            pass.contains("ecl:") && // (Eye Color)
            pass.contains("pid:")) { // (Passport ID)

            return true;
        }

        // optional field
        // pass.contains("cid");  // (Country ID)
        return false;
    }


}
