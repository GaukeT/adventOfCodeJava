package nl.gauket.mission2020;

import nl.gauket.common.Day;
import nl.gauket.common.InputReader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;
import static java.lang.String.format;
import static java.util.regex.Pattern.compile;
import static nl.gauket.common.ResultLogger.printResult;

public class Day2 extends Day {
    private static final int DAY = 2;
    private static final Pattern p = compile("^(\\d{1,2})-(\\d{1,2}) (\\D): (\\D.*)$");

    public static void main(String[] args) throws IOException, URISyntaxException {
        part1();
        part2();
    }

    private static void part1() throws IOException, URISyntaxException {
        start(YEAR20, DAY);
        // part 1 // 396
        var input = InputReader.readInputAsStringList(YEAR20, DAY);
        var result = solve(input, 1);

        stopTimer();
        printResult(DAY, result);
    }

    private static void part2() throws IOException, URISyntaxException {
        start(YEAR20, DAY);        // part 2 // 428
        var input = InputReader.readInputAsStringList(YEAR20, DAY);
        var result = solve(input, 2);

        stopTimer();
        printResult(DAY, result);
    }

    public static int solve(List<String> input, int part) {
        int validpasswords = 0;

        for (String s : input) {
            Matcher m = p.matcher(s);

            if (m.find()) {
                var min = getMin(m);
                var max = getMax(m);
                var letter = getLetter(m);
                var pw = getPW(m);

                var isValid = validatePassword(min, max, letter, pw, part);

                if (isValid) {
                    validpasswords++;
                }
            }
        }

        return validpasswords;
    }

    private static boolean validatePassword(int min, int max, String letter, String pw, int part) {
        if (part == 1) {
            var count = countOccurences(letter, pw);
            return count >= min && count <= max;
        } else {
            var first = String.valueOf(pw.charAt(min-1));
            var second = String.valueOf(pw.charAt(max-1));

            return letter.equals(first) ^ letter.equals(second);
        }
    }

    private static int countOccurences(String letter, String pw) {
        Pattern pattern = compile(format("[^%s]*%s", letter, letter));
        Matcher matcher = pattern.matcher(pw);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    private static int getMin(Matcher m) {
        return parseInt(m.group(1));
    }

    private static int getMax(Matcher m) {
        return parseInt(m.group(2));
    }

    private static String getLetter(Matcher m) {
        return m.group(3);
    }

    private static String getPW(Matcher m) {
        return m.group(4);
    }
}
