package nl.gauket.mission2020;

import nl.gauket.common.Day;
import nl.gauket.common.InputReader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.Long.toBinaryString;
import static java.util.regex.Pattern.compile;
import static nl.gauket.common.ResultLogger.printResult;

public class Day14 extends Day {
    private static final int DAY = 14;

    public static void main(String[] args) throws IOException, URISyntaxException {
        prepareDaily(YEAR20, DAY);
        part1();
        part2();
    }

    private static void part1() throws IOException, URISyntaxException {
        start();
        // part 1 //
        var input = InputReader.readInputAsStringArray(YEAR20, DAY);
        var result = solve(input, 1);

        stop();
        printResult(DAY, 0, result);
    }

    private static void part2() throws IOException, URISyntaxException {
        start();
        // part 2 //
        var input = InputReader.readInputAsStringArray(YEAR20, DAY);
        var result = solve(input, 2);

        stop();
        printResult(DAY, 0, result);
    }

    public static long solve(String[] input, int part) {
        var result = 0;

        var memoryAddressSpace = new HashMap<Long, Long>();

        var mask = "";
        var memLoc = 0L;
        var val = 0L;

        for (var row : input) {
            if (row.startsWith("mask")) {
                mask = determineMask(row);
            } else {
                memLoc = determineMemLocation(row);
                val = determineValue(row);

                val = applyMask(mask, val);
                memoryAddressSpace.put(memLoc, val);
            }
        }

        return getSumOfValues(memoryAddressSpace);
    }

    public static long getSumOfValues(HashMap<Long, Long> memoryAddressSpace) {
        return memoryAddressSpace.values().stream()
                .reduce(0L, Long::sum);
    }

    private static long determineValue(String row) {
        return parseInt(row.substring(row.indexOf("=") + 2));
    }

    private static int determineMemLocation(String row) {
        Pattern pattern = compile("^mem\\[(\\d.*)\\] = (\\d.*)$");
        Matcher matcher = pattern.matcher(row);
        if (matcher.find()) {
            return parseInt(matcher.group(1));
        }
        throw new IllegalArgumentException("unknown instruction");
    }

    private static String determineMask(String row) {
        return row.replace("mask = ", "").strip();
    }

    public static long applyMask(String mask, long val) {
        var maskArr = mask.split("");
        var valAsArr = applyFixedSize(toBinaryString(val), maskArr.length).split("");
        var retArr = new char[mask.length()];

        for (int i = 0; i < maskArr.length; i++) {
            if (!"X".equals(maskArr[i])) {
                retArr[i] = maskArr[i].charAt(0);
            } else if (!"X".equals(valAsArr[i])) {
                retArr[i] = valAsArr[i].charAt(0);
            } else {
                retArr[i] = '0';
            }
        }

        var retval = String.valueOf(retArr);
        return parseLong(retval, 2);
    }

    private static String applyFixedSize(String str, int length) {
        return new StringBuilder()
                .append("X".repeat(Math.max(0, length - str.length())))
                .append(str)
                .toString();
    }

}
