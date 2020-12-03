package nl.gauket.common;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class InputReader {
    public static IntStream readInputAsIntStream(int year, int day) throws URISyntaxException, IOException {
        return Files.readAllLines(
                Paths.get(ClassLoader.getSystemResource(getFilename(year, day)).toURI()))
                .stream()
                .flatMapToInt(num -> IntStream.of(Integer.parseInt(num)));
    }

    public static int[] readInputAsIntArray(int year, int day) throws URISyntaxException, IOException {
        return Arrays.stream(Files.readString(
                Paths.get(ClassLoader.getSystemResource(getFilename(year, day)).toURI()))
                .split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static List<String> readInputAsStringList(int year, int day) throws URISyntaxException, IOException {
        return Files.readAllLines(
                Paths.get(ClassLoader.getSystemResource(getFilename(year, day)).toURI()));
    }

    public static String[] readInputAsStringArray(int year, int day) throws URISyntaxException, IOException {
        return readInputAsStringList(year, day).toArray(new String[]{});
    }

    public static char[][] readInputAsCharTwoDemencialArray(int year, int day) throws URISyntaxException, IOException {
        var input = readInputAsStringArray(year, day);

        var length = input.length;
        var rowLength = input[0].length();
        var retval = new char[length][rowLength];

        var i = 0;
        for (String row : input) {
            retval[i] = row.toCharArray();
            i++;
        }
        return retval;
    }

    private String[] convert(String values) {
        return values.split(",");
    }

    private static String getFilename(int year, int day) {
        return String.format("%s/input%s.txt", year, day);
    }
}
