package nl.gauket.mission2021;

import nl.gauket.common.NewDay;

public class Day2 extends NewDay {
    @Override
    public long[] solvePart1() {
        var result = solveFirst(INPUT.clone());
        return new long[] {result, 2039256};
    }

    @Override
    public long[] solvePart2() {
        var result = solveSecond(INPUT.clone());
        return new long[] {result, 1856459736};
    }

    public static long solveFirst(String[] input) {
        var position = 0L;
        var depth = 0L;

        for (var cmds: input) {
            var cmd = cmds.split(" ");

            if (cmd[0].equals("forward")) {
                position += Integer.parseInt(cmd[1]);
            } else if (cmd[0].equals("down")) {
                depth += Integer.parseInt(cmd[1]);
            } else {
                depth -= Integer.parseInt(cmd[1]);
            }
        }

        return position * depth;
    }

    public static long solveSecond(String[] input) {
        var position = 0L;
        var depth = 0L;
        var aim = 0L;

        for (var cmds: input) {
            var cmd = cmds.split(" ");

            if (cmd[0].equals("forward")) {
                position += Integer.parseInt(cmd[1]);
                depth += aim * Integer.parseInt(cmd[1]);
            } else if (cmd[0].equals("down")) {
                aim += Integer.parseInt(cmd[1]);
            } else {
                aim -= Integer.parseInt(cmd[1]);
            }
        }

        return position * depth;
    }
}
