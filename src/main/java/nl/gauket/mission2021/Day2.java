package nl.gauket.mission2021;

import nl.gauket.common.NewDay;

public class Day2 extends NewDay {
    @Override
    public long[] solvePart1() {
        var position = 0;
        var depth = 0;

        for (var cmds: INPUT) {
            var cmd = cmds.split(" ");

            if (cmd[0].equals("forward")) {
                position += Integer.parseInt(cmd[1]);
            } else if (cmd[0].equals("down")) {
                depth += Integer.parseInt(cmd[1]);
            } else {
                depth -= Integer.parseInt(cmd[1]);
            }
        }

        var result = position * depth;

        return new long[] {result, 2039256};
    }

    @Override
    public long[] solvePart2() {
        var position = 0;
        var depth = 0;
        var aim = 0;

        for (var cmds: INPUT) {
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

        var result = position * depth;

        return new long[] {result, 1856459736};
    }
}
