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
        printResult(DAY, 186, result, false); // result is 1 higher than expected
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
                if (part == 2) debugPass(ppBuilder.toString(), isValid);
                count++;

                ppBuilder = new StringBuilder();
            }
        }
        return validCounter;
    }

    private static boolean validatePassport(String pass, int part) {
        // required fields
        return (validateBirthYear(pass, part) &&
                validateIssueYear(pass, part) &&
                validateExpirationYear(pass, part) &&
                validateHeight(pass, part) &&
                validateHairColor(pass, part) &&
                validateEyeColor(pass, part) &&
                validatePassportId(pass, part));

        // optional field
        // pass.contains("cid");  // (Country ID)
    }

    private static boolean validatePassportId(String pass, int part) {
        if (pass.contains("pid:")) {
            if (part == 1) return true;
            return validateRegex("pid:[0-9]{9}", pass);
        }
        return false;
    }

    private static boolean validateEyeColor(String pass, int part) {
        if (pass.contains("ecl:")) {
            if (part == 1) return true;
            return validateRegex("ecl:(amb|blu|brn|gry|grn|hzl|oth)", pass);
        }
        return false;
    }

    private static boolean validateHairColor(String pass, int part) {
        if (pass.contains("hcl:")) {
            if (part == 1) return true;
            return validateRegex("hcl:#[0-9|a-f]{6}", pass);
        }
        return false;
    }

    private static boolean validateHeight(String pass, int part) {
        if (pass.contains("hgt:")) {
            if (part == 1) return true;
            return validateRegex("hgt:((1[5-8]\\d|19[0-3])cm|(59|6\\d|7[0-6])in)", pass);
        }
        return false;
    }

    private static boolean validateExpirationYear(String pass, int part) {
        if (pass.contains("eyr:")) {
            if (part == 1) return true;
            return validateFourDigitsBetween(2020, 2030, pass, "eyr");
        }
        return false;
    }

    private static boolean validateIssueYear(String pass, int part) {
        if (pass.contains("iyr:")) {
            if (part == 1) return true;
            return validateFourDigitsBetween(2010, 2020, pass, "iyr");
        }
        return false;
    }

    private static boolean validateBirthYear(String pass, int part) {
        if (pass.contains("byr:")) {
            if (part == 1) return true;
            return validateFourDigitsBetween(1920, 2002, pass, "byr");
        }
        return false;
    }

    private static boolean validateRegex(String regex, String pass) {
        Pattern pattern = compile(regex);
        Matcher matcher = pattern.matcher(pass);
        return matcher.find();
    }

    private static boolean validateFourDigitsBetween(int atLeast, int atMost, String pass, String part) {
        Pattern pattern = compile(format("%s:(\\d{4})", part));
        Matcher matcher = pattern.matcher(pass);
        if (matcher.find()) {
            var value = parseInt(matcher.group(1));
            return value >= atLeast && value <= atMost;
        }
        return false;
    }


    // debug code
    private static void debugPass(String pass, boolean isValid) {
        var byr = getValue("byr:(\\d{4})", pass);
        var iyr = getValue("iyr:(\\d{4})", pass);
        var eyr = getValue("eyr:(\\d{4})", pass);
        var hgt = getValue("hgt:((1[5-8][0-9]|19[0-3])cm|(59|6[0-9]|7[0-6])in)", pass);
        var hcl = getValue("hcl:#[0-9|a-f]{6}", pass);
        var ecl = getValue("ecl:(amb|blu|brn|gry|grn|hzl|oth)", pass);
        var pid = getValue("pid:[0-9]{9}", pass);
        var cid = getValue("cid:[0-9]{0,9}", pass);

//        // --------------------------------------------------------
//        if (byr.length() != 8) System.out.println("byr ERROR: " + pass);
//        if (iyr.length() != 8) System.out.println("iyr ERROR: " + pass);
//        if (eyr.length() != 8) System.out.println("eyr ERROR: " + pass);
//        // --------------------------------------------------------
//        if (hgt.length() != 9 && hgt.length() != 8) System.out.println("hgt ERROR: " + pass);
//        // --------------------------------------------------------
//        if (hcl.length() != 11) System.out.println("hcl ERROR: " + pass);
//        if (ecl.length() != 7) System.out.println("ecl ERROR: " + pass);
//        if (pid.length() != 13) System.out.println("pid ERROR: " + pass);
//        // --------------------------------------------------------

        InputWriter.debug(format("%s %s %s %s %s %s %s %s Valid:%s", iyr, byr, eyr, cid, hcl, ecl, hgt, pid, isValid));
    }

    private static String getValue(String regex, String pass) {
        Pattern pattern = compile(regex);
        Matcher matcher = pattern.matcher(pass);
        if (matcher.find()) {
            return matcher.group(0);
        }
        return "null";
    }
}
