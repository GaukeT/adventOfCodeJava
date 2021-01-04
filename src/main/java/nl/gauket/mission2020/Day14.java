package nl.gauket.mission2020;

import nl.gauket.common.MyDay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.Long.toBinaryString;
import static java.util.regex.Pattern.compile;

public class Day14 extends MyDay {
    @Override
    public long[] solvePart1() {
        var result = solve(INPUT.clone(), 1);
        return new long[]{result, 17765746710228L};
    }

    @Override
    public long[] solvePart2() {
        var result = solve(INPUT.clone(), 2);
        return new long[]{result, 4401465949086L};
    }

    public static long solve(String[] input, int part) {
        if (part == 2) return solve2(input);
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

    private static long solve2(String[] input) {
        var memoryAddressSpace = new HashMap<Long, Long>();
        short maskCounter = 0;

        var mask = "";
        var memLoc = 0L;
        var val = 0L;

        for (var row : input) {
            if (row.startsWith("mask")) {
                mask = determineMask(row);
                maskCounter++;
            } else {
                memLoc = determineMemLocation(row);
                val = determineValue(row);

                var memLocs = applyMask2(mask, memLoc);
                for (var loc : memLocs) {
                    memoryAddressSpace.put(parseLong(loc, 2), val);
                }

                if (DEBUG) System.out.println("running mask " + maskCounter);
            }
        }

        return getSumOfValues(memoryAddressSpace);
    }

    private static List<String> applyMask2(String mask, long memloc) {
        var retStrings = new ArrayList<String>();

        var maskArray = mask.split("");
        var valueArray = applyFixedSize(toBinaryString(memloc), maskArray.length).split("");
        var maskedValue = new char[mask.length()];

        for (int i = 0; i < maskArray.length; i++) {
            if ("1".equals(maskArray[i]) || "X".equals(maskArray[i])) {
                maskedValue[i] = maskArray[i].charAt(0);
            } else if (!"X".equals(valueArray[i])) {
                maskedValue[i] = valueArray[i].charAt(0);
            } else {
                maskedValue[i] = '0';
            }
        }

        if (DEBUG) System.out.println(new String(maskedValue));

        for (int i = 0; i < maskedValue.length; i++) {
            if ('X' == (maskedValue[i])) {
                if (retStrings.isEmpty()) {
                    maskedValue[i] = '0';
                    retStrings.add(new String(maskedValue));
                    maskedValue[i] = '1';
                    retStrings.add(new String(maskedValue));
                } else {
                    var retStringSize = retStrings.size();
                    for (int j = 0; j < retStringSize; j++) {
                        String opt = retStrings.get(j);
                        var tmp = opt.toCharArray();
                        tmp[i] = '0';
                        retStrings.add(new String(tmp));
                        tmp[i] = '1';
                        retStrings.set(j, new String(tmp));
                    }
                }
            }
        }

        return retStrings;
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

    private static String printArrAsString(String[] strings) {
        var stringBuilder = new StringBuilder();
        for (var str : strings) {
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }
}
