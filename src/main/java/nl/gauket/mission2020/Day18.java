package nl.gauket.mission2020;

import static java.util.regex.Pattern.compile;

public class Day18 extends nl.gauket.common.MyDay {
    @Override
    public long[] solvePart1() {
        var result = solve(INPUT);
        return new long[]{result, 6_640_667_297_513L};
    }

    @Override
    public long[] solvePart2() {
        var result = 0L;
        return new long[]{result, 0L};
    }

    static long solve(String[] input) {
        var sub_sum = compile("\\(\\d[^\\\\(]*?\\)");
        var running_row_total = 0L;

        for (var row : input) {
            var sub_match = sub_sum.matcher(row);
            if (DEBUG) System.out.println(row);

            while (sub_match.find()) {
                var match = sub_match.group();
                var sum = calculateSum(match);

                row = row.replace(match, String.valueOf(sum));
                if (DEBUG) System.out.println(row);
                // re-evaluate sub matches
                sub_match = sub_sum.matcher(row);
            }

            running_row_total += calculateSum(row);
        }

        return running_row_total;
    }

    private static long calculateSum(String group) {
        var toCompute = group.replaceAll("[\\(\\)]", "").split(" ");

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
