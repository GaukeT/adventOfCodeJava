package nl.gauket.mission2020;

import nl.gauket.common.InputReader;
import nl.gauket.common.NewDay;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static java.util.Arrays.asList;

public class Day6 extends NewDay {
    @Override
    public void before(int year, int day) {
        INPUT_STR_LIST = InputReader.readInputAsStringList(year, day);
    }

    @Override
    public long[] solvePart1() {
        var result = (long) solve(INPUT_STR_LIST, 1);
        return new long[]{result, 6703};
    }

    @Override
    public long[] solvePart2() {
        var result = (long) solve(INPUT_STR_LIST, 2);
        return new long[]{result, 3430};
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
