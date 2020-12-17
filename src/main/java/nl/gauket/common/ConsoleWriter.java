package nl.gauket.common;

public class ConsoleWriter {
    public static void printGrid(char[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                InputWriter.debug(String.valueOf(grid[i][j]) + " ", false);
            }
            InputWriter.debug("", true);
        }
    }
}
