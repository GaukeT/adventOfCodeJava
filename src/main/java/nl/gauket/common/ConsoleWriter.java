package nl.gauket.common;

public class ConsoleWriter {
    private ConsoleWriter() {}

    public static void printGrid(char[][] grid) {
        for (char[] chars : grid) {
            for (char aChar : chars) {
                InputWriter.debug(aChar + " ", false);
            }
            InputWriter.debug("", true); // TODO: possible refactor/remove
        }
    }
}
