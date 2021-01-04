package nl.gauket.mission2020;

import nl.gauket.common.MyDay;

import java.util.*;

import static java.lang.Integer.parseInt;
import static java.util.regex.Pattern.compile;

public class Day7 extends MyDay {
    private static final HashMap<String, List<Bag>> bags = new HashMap<>();
    private static final Set<String> bagSet = new HashSet<>();

    private static final List<Integer> content = new ArrayList<>();
    private static int bagsNeeded = 0;

    @Override
    public long[] solvePart1() {
        var result = (long) solve(INPUT.clone(), 1);
        return new long[]{result, 197};
    }

    @Override
    public long[] solvePart2() {
        var result = (long) solve(INPUT.clone(), 2);
        return new long[]{result};

        // 572 to low
        // 696155468 to high
    }

    public static int solve(String[] input, int part) {
        determineBagContents(input, part);
        findRecursive(bags.get("shiny gold"));

        if (part == 2) {
            var c = content.stream().reduce(Integer::sum);
            return c.orElse(0);
        }
        return bagSet.size();
    }

    private static void findRecursive(List<Bag> bagList) {
        if (null != bagList && !bagList.isEmpty()) {
            for (var bag : bagList) {
                if (!bagSet.contains(bag.label)) {
                    bagSet.add(bag.label);

                    if (bagsNeeded == 0) {
                        bagsNeeded += bag.amount;
                    } else {
                        bagsNeeded = (bagsNeeded * bag.amount);
                    }

                    content.add(bagsNeeded);
                    findRecursive(bags.get(bag.label));
                }
            }
        }
    }

    private static void determineBagContents(String[] input, int part) {
        for (String row : input) {
            var bag = getStringValue(row);
            var keys = getKeyPair(row);

            if (part == 1)
                keys.forEach((k, v) -> putBagInBags(bag, k, v));
            if (part == 2)
                keys.forEach((k, v) -> putBagInBags2(bag, k, v));
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

    private static void putBagInBags2(String bag, String key, Integer value) {
        if (key == null) return;

        var b = new Bag(key, value);

        if (bags.containsKey(bag)) {
            bags.get(bag).add(b);
        } else {
            var l = new ArrayList<Bag>();
            l.add(b);
            bags.put(bag, l);
        }
    }

    private static String getStringValue(String bagInput) {
        var pattern = compile("^(\\w+ \\w+)");
        var matcher = pattern.matcher(bagInput);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    private static HashMap<String, Integer> getKeyPair(String bagInput) {
        var pattern = compile(" ([0-9]) (\\w+ \\w+)");
        var matcher = pattern.matcher(bagInput);
        var keys = new HashMap<String, Integer>();

        while (matcher.find()) {
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
