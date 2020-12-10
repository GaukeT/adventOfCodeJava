package nl.gauket.mission2020;

import nl.gauket.common.Day;
import nl.gauket.common.InputReader;
import nl.gauket.common.InputWriter;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;
import static java.lang.String.format;
import static java.util.regex.Pattern.compile;
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
        var result = solve(input, 1);

        stop();
        printResult(DAY, 242, result);
    }

    private static void part2() throws IOException, URISyntaxException {
        start();
        // part 2 //
        var input = InputReader.readInputAsStringList(YEAR20, DAY);
        var result = solve(input, 2);

        stop();
        printResult(DAY, 186, result); // result is 1 higher than expected
    }

    public static int solve(List<String> input, int part) {
        input.add(""); // hack to validate last passport also
        var count = 0;
        var validCounter = 0;
        var ppBuilder = new StringBuilder();

        for (var row : input) {
            // still belongs to same passport
            if (!"".equals(row)) {
                ppBuilder.append(row)
                        .append(" ");
            } else {
                var isValid = validatePassport(ppBuilder.toString(), part);
                if (isValid) validCounter++;

                ppBuilder = new StringBuilder(); // reset
            }
        }
        return validCounter;
    }

    private static boolean validatePassport(String pass, int part) {
        // required fields
        if (pass.contains("byr:") && // (Birth Year)
                pass.contains("iyr:") && // (Issue Year)
                pass.contains("eyr:") && // (Expiration Year)
                pass.contains("hgt:") && // (Height)
                pass.contains("hcl:") && // (Hair Color)
                pass.contains("ecl:") && // (Eye Color)
                pass.contains("pid:")) { // (Passport ID)

            if (part == 1) return true;

            return (validateBirthYear(pass, part) &&
                    validateIssueYear(pass, part) &&
                    validateExpirationYear(pass, part) &&
                    validateHeight(pass, part) &&
                    validateHairColor(pass, part) &&
                    validateEyeColor(pass, part) &&
                    validatePassportId(pass, part));
        }
        return false;
    }

    private static boolean validatePassportId(String pass, int part) {
        return validateRegex("pid:[0-9]{9} ", pass);
    }

    private static boolean validateEyeColor(String pass, int part) {
        return validateRegex("ecl:(amb|blu|brn|gry|grn|hzl|oth) ", pass);
    }

    private static boolean validateHairColor(String pass, int part) {
        return validateRegex("hcl:#[0-9|a-f]{6} ", pass);
    }

    private static boolean validateHeight(String pass, int part) {
        return validateRegex("hgt:((1[5-8]\\d|19[0-3])cm|(59|6\\d|7[0-6])in) ", pass);
    }

    private static boolean validateExpirationYear(String pass, int part) {
        return validateFourDigitsBetween(2020, 2030, pass, "eyr");
    }

    private static boolean validateIssueYear(String pass, int part) {
        return validateFourDigitsBetween(2010, 2020, pass, "iyr");
    }

    private static boolean validateBirthYear(String pass, int part) {
        return validateFourDigitsBetween(1920, 2002, pass, "byr");
    }

    private static boolean validateRegex(String regex, String pass) {
        Pattern pattern = compile(regex);
        Matcher matcher = pattern.matcher(pass);
        return matcher.find();
    }

    private static boolean validateFourDigitsBetween(int atLeast, int atMost, String pass, String part) {
        Pattern pattern = compile(format("%s:(\\d{4}) ", part));
        Matcher matcher = pattern.matcher(pass);
        if (matcher.find()) {
            var value = parseInt(matcher.group(1));
            return value >= atLeast && value <= atMost;
        }
        return false;
    }
}
