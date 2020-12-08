package nl.gauket.mission2020;

import nl.gauket.common.Day;
import nl.gauket.common.InputReader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;
import static java.util.regex.Pattern.compile;
import static nl.gauket.common.ResultLogger.printResult;

public class Day7 extends Day {
    private static final int DAY = 7;

    private static HashMap<String, List<Bag>> bags = new HashMap<>();
    private static Set<String> bagSet = new HashSet<>();

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
        printResult(DAY, 197, result);
    }

    private static void part2() throws IOException, URISyntaxException {
        start();
        // part 2 //
        var input = InputReader.readInputAsStringArray(YEAR20, DAY);
        var result = solve(input, 2);

        stop();
        printResult(DAY, 0, result, false);
    }

    public static int solve(String[] input, int part) {
        if (part == 2) return 0;

        determineBagContents(input);
        findRecursive(bags.get("shiny gold"));

        return bagSet.size();
    }

    private static void findRecursive(List<Bag> bagList) {
        if (null != bagList && !bagList.isEmpty()) {
            for (var bag : bagList) {
                if (!bagSet.contains(bag.label)) {
                    bagSet.add(bag.label);
                    findRecursive(bags.get(bag.label));
                }
            }
        }
    }

    private static void determineBagContents(String[] input) {
        for (String row : input) {
            var bag = getStringValue("^(\\w+ \\w+)", row);
            var keys = getKeyPair(" ([0-9]) (\\w+ \\w+)", row);

            keys.forEach((k, v) -> putBagInBags(bag, k, v));
        }
    }

    private static void putBagInBags(String bag, String key, Integer value) {
        if (key == null) return;

        var b = new Bag(bag, value);

        if (bags.containsKey(key)) {
            bags.get(key).add(b);
        } else {
            var l = new ArrayList<Bag>();
            l.add(b);
            bags.put(key, l);
        }
    }

    private static String getStringValue(String regex, String bagInput) {
        var pattern = compile(regex);
        var matcher = pattern.matcher(bagInput);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    private static HashMap<String, Integer> getKeyPair(String regex, String bagInput) {
        var pattern = compile(regex);
        var matcher = pattern.matcher(bagInput);
        var keys = new HashMap<String, Integer>();

        while(matcher.find()) {
            var k = matcher.group(2);
            var v = parseInt(matcher.group(1));
            keys.put(k, v);
        }
        return keys;
    }

    static class Bag {
        String label;
        Integer amount;

        public Bag(String label, int amount) {
            this.label = label;
            this.amount = amount;
        }
    }
}
