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
        var result = solve(INPUT.clone());
        return new long[]{result, 197};
    }

    @Override
    public long[] solvePart2() {
        var result = solve2(INPUT.clone());
        return new long[]{result, 85324};
    }

    public static long solve2(String[] input) {
        HashMap<String, List<Bag>> allBags = new HashMap<>();

        for (String row : input) {
            var bag = getStringValue(row);
            var keys = getKeyPair(row);

            keys.forEach((k, v) -> putBagInBags2(allBags, bag, k, v));
        }

        return solve2b(allBags, "shiny gold");
    }

    private static long solve2b(HashMap<String, List<Bag>> allBags, String label) {
        var map = new HashMap<String, Long>();

        var inner_bags = allBags.get(label);
        calc_sum(allBags, map, label, inner_bags, 1L);

        return map.values().stream().reduce(0L, Long::sum);
    }

    private static void calc_sum(HashMap<String, List<Bag>> allBags, HashMap<String, Long> map, String label, List<Bag> inner_bags, long outer_amount) {
        if (null == inner_bags) return;

        var inner_bag_count = 0L;
        for (var inner_bag : inner_bags) {
            var total = outer_amount * inner_bag.amount;
            inner_bag_count += total;
            calc_sum(allBags, map, inner_bag.label, allBags.get(inner_bag.label), total);
        }

        var bag_total = map.get(label);
        if (bag_total != null) {
            map.put(label, inner_bag_count + bag_total);
        } else {
            map.put(label, inner_bag_count);
        }
    }

    public static long solve(String[] input) {
        determineBagContents(input);
        findRecursive(bags.get("shiny gold"));

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

    private static void determineBagContents(String[] input) {
        for (String row : input) {
            var bag = getStringValue(row);
            var keys = getKeyPair(row);

            keys.forEach((k, v) -> putBagInBags(bags, bag, k, v));
        }
    }

    private static void putBagInBags(HashMap<String, List<Bag>> map, String bag, String key, Integer value) {
        if (key == null) return;

        var b = new Bag(bag, value);

        if (map.containsKey(key)) {
            map.get(key).add(b);
        } else {
            var l = new ArrayList<Bag>();
            l.add(b);
            map.put(key, l);
        }
    }

    private static void putBagInBags2(HashMap<String, List<Bag>> allBags, String bag, String key, Integer value) {
        if (key == null) return;

        var b = new Bag(key, value);

        if (allBags.containsKey(bag)) {
            allBags.get(bag).add(b);
        } else {
            var l = new ArrayList<Bag>();
            l.add(b);
            allBags.put(bag, l);
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
        long sum = 1L;

        public Bag(String label, int amount) {
            this.label = label;
            this.amount = amount;
        }
    }
}
