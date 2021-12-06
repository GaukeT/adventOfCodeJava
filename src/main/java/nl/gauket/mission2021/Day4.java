package nl.gauket.mission2021;

import nl.gauket.common.NewDay;

import java.util.ArrayList;

public class Day4 extends NewDay {
    @Override
    public long[] solvePart1() {
        var result = solveFirst(INPUT.clone(), 1);
        return new long[]{result, 33462};
    }

    @Override
    public long[] solvePart2() {
        var result = solveFirst(INPUT.clone(), 2);
        return new long[]{result}; // 13056 -> too low
    }

    public static int solveFirst(String[] in, int part) {
        var turns = in[0].split(",");
        var input = in;

        var result = 0;
        var resultList = new ArrayList<Integer>();
        for (var turn : turns) {
            var winner = false;
            var row = 0;

            if (input.length <= 2) break;
            for (int i = 2; i < input.length; i++) {
                if (input[i].equals("")) {
                    winner = isWinner(input, winner, i);
                    row = 0;
                }

                if (!winner) {
                    var rTurn = turn.length() < 2 ? " " + turn : turn;
                    if (input[i].contains(" " + rTurn)) {
                        input[i] = input[i].replace(" " + rTurn, " X");
                    } else if (input[i].contains(rTurn + " ")) {
                        input[i] = input[i].replace(rTurn + " ", " X ");
                    }

                    // check winner row
                    if (input[i].equals(" X X X X X")) {
                        winner = true;
                        result = calculateResult(input, turn, i + (6 - row));

                        if (part == 2) {
                            resultList.add(result);
                            winner = false;
                            input = slice(input, i + (5 - row));
                        }

                        if (part == 1) break;
                    }
                    row++;
                } else {
                    result = calculateResult(input, turn, i);

                    if (part == 2) {
                        resultList.add(result);
                        winner = false;
                        input = slice(input, i + (row == 0 ? -1 : (5 - row)));
                    }

                    if (part == 1) break;
                }
            }

            if (winner) break;
        }

        if (part == 2) result = resultList.get(resultList.size()-1);

        return result;
    }

    private static String[] slice(String[] input, int i) {
        var retval = new String[input.length-6];
        var min = i-5;

        for (int j = 0; j < retval.length; j++) {
            if (j >= min) {
                retval[j] = input[j+6];
            } else {
                retval[j] = input[j];
            }
        }

        return retval;
    }

    private static int calculateResult(String[] input, String turn, int i) {
        int result;
        var sum = 0;
        sum = calcSumForRow(input[i - 5], sum);
        sum = calcSumForRow(input[i - 4], sum);
        sum = calcSumForRow(input[i - 3], sum);
        sum = calcSumForRow(input[i - 2], sum);
        sum = calcSumForRow(input[i - 1], sum);

        result = Integer.parseInt(turn) * sum;
        return result;
    }

    private static boolean isWinner(String[] input, boolean winner, int i) {
        if (input[i - 5].contains("X") && input[i - 4].contains("X") && input[i - 3].contains("X") && input[i - 2].contains("X") && input[i - 1].contains("X")) {
            var sums = new int[5];
            determineIndexFor(input[i - 5], sums);
            determineIndexFor(input[i - 4], sums);
            determineIndexFor(input[i - 3], sums);
            determineIndexFor(input[i - 2], sums);
            determineIndexFor(input[i - 1], sums);
            for (int sum : sums) {
                if (sum == 5) {
                    winner = true;
                    break;
                }
            }
        }
        return winner;
    }

    private static void determineIndexFor(String in, int[] sums) {
        String[] split = in.split(" ");
        var correction = 0;
        for (int j = 0; j < split.length; j++) {
            String v = split[j];
            if (v.equals("")) {
                correction++;
                continue;
            }
            if (v.equals("X")) sums[j - correction] += 1;
        }
    }

    private static int calcSumForRow(String in, int sum) {
        String[] split = in.split(" ");
        for (String v : split) {
            if (v.equals(" ") || v.equals("") || v.equals("X")) {
                continue;
            }
            sum += Integer.parseInt(v);
        }
        return sum;
    }
}
