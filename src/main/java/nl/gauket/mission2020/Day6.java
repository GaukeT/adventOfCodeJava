package nl.gauket.mission2020;

import nl.gauket.common.Day;
import nl.gauket.common.InputReader;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static java.util.Arrays.asList;
import static nl.gauket.common.ResultLogger.printResult;

public class Day6 extends Day {
    private static final int DAY = 6;

    public static void main(String[] args) {
        prepareDaily(YEAR20, DAY);
        part1();
        part2();
    }

    private static void part1() {
        start();
        // part 1 //
        var input = InputReader.readInputAsStringList(YEAR20, DAY);
        var result = solve(input, 1);

        stop();
        printResult(DAY, 6703, result);
    }

    private static void part2() {
        start();
        // part 2 //
        var input = InputReader.readInputAsStringList(YEAR20, DAY);
        var result = solve(input, 2);

        stop();
        printResult(DAY, 3430, result);
    }

    public static int solve(List<String> input, int part) {
        input.add(""); // hack to validate last group also

        var total = 0;
        var questionsPerGroup = new HashSet<String>();
        var questionsPerPerson = new ArrayList<String>();

        for (var row : input) {
            if (!"".equals(row)) {
                // questions to which anyone answered "yes"
                questionsPerGroup.addAll(asList(row.split("")));

                if (part == 2) questionsPerPerson.add(row);
            } else {
                if (part == 2) {
                    var allYes = new HashSet<String>();

                    for (var question : questionsPerGroup) {
                        var yes = 0;
                        for (var person : questionsPerPerson) {
                            if (person.contains(question)) yes++;
                        }

                        if (yes == questionsPerPerson.size()) allYes.add(question);
                    }
                    questionsPerPerson = new ArrayList<>();
                    questionsPerGroup = allYes;
                }

                total += questionsPerGroup.size();
                questionsPerGroup = new HashSet<>();
            }
        }

        return total;
    }
}
