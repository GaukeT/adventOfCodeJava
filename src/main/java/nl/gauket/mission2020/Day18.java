package nl.gauket.mission2020;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

public class Day18 extends nl.gauket.common.MyDay {
    @Override
    public long[] solvePart1() {
        var result = solve(INPUT, false);
        return new long[]{result, 6_640_667_297_513L};
    }

    @Override
    public long[] solvePart2() {
        var result = solve(INPUT, true);;
        return new long[]{result, 451_589_894_841_552L};
    }

    static long solve(String[] input, boolean isAdvanced) {
        var sub_sum = compile("\\(\\d[^\\\\(]*?\\)");
        var sub_calc = compile("\\d+\\s\\+\\s\\d+");

        var running_row_total = 0L;

        for (var row : input) {
            var sub_match = sub_sum.matcher(row);
            if (DEBUG) System.out.println(row);
            row = matchAndReplace(sub_sum, row, sub_match, isAdvanced);

            if (isAdvanced) {
                if (row.contains("+")) {
                    row = matchAndReplace(sub_calc, row, sub_calc.matcher(row), false);
                }
            }

            running_row_total += calculateSum(row);
        }

        return running_row_total;
    }

    private static String matchAndReplace(Pattern pattern, String row, Matcher matcher, boolean isAdvanced) {
        var sub_calc = compile("\\d+\\s\\+\\s\\d+");

        while (matcher.find()) {
            var match = matcher.group();
            var repl_match = match;

            if (isAdvanced) {
                if (match.contains("+")) {
                    match = matchAndReplace(sub_calc, match, sub_calc.matcher(match), false);
                }
            }

            var sum = calculateSum(match);

            row = row.replace(repl_match, String.valueOf(sum));
            if (DEBUG) System.out.println(row);
            // re-evaluate sub matches
            matcher = pattern.matcher(row);
        }
        return row;
    }

    private static long calculateSum(String group) {
        var toCompute = group.replaceAll("[\\(\\)]", "").split(" ");

        // check if single number ends up here
        if (toCompute.length < 2) return Long.parseLong(toCompute[0]);

        var running_total = 0L;
        var left = Long.parseLong(toCompute[0]);
        var oparator = toCompute[1];

        for (int i = 2; i < toCompute.length; i++) {
            if      ("+".equals(toCompute[i])) oparator = "+";
            else if ("*".equals(toCompute[i])) oparator = "*";
            else {
                var digit = Long.parseLong(toCompute[i]);
                if      ("+".equals(oparator)) running_total = left + digit;
                else if ("*".equals(oparator)) running_total = left * digit;

                left = running_total;
            }
        }

        return running_total;
    }
}
