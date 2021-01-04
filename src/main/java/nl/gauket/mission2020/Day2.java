package nl.gauket.mission2020;

import nl.gauket.common.InputReader;
import nl.gauket.common.MyDay;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;
import static java.lang.String.format;
import static java.util.regex.Pattern.compile;

public class Day2 extends MyDay {
    @Override
    public void before(int year, int day) {
        INPUT_STR_LIST = InputReader.readInputAsStringList(year, day);
    }

    @Override
    public long[] solvePart1() {
        var result = (long) solve(INPUT_STR_LIST, 1);
        return new long[]{result, 396};
    }

    @Override
    public long[] solvePart2() {
        var result = (long) solve(INPUT_STR_LIST, 2);
        return new long[]{result, 428};
    }

    public static int solve(List<String> input, int part) {
        var p = compile("^(\\d{1,2})-(\\d{1,2}) (\\D): (\\D.*)$");
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
            var first = String.valueOf(pw.charAt(min - 1));
            var second = String.valueOf(pw.charAt(max - 1));

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
