package nl.gauket.common;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class InputReader {
    private InputReader() {
    }

    public static IntStream readInputAsIntStream(int year, int day) {
        return filesReadAllLines(year, day)
                .stream()
                .flatMapToInt(num -> IntStream.of(Integer.parseInt(num)));
    }

    public static int[] readInputAsIntArray(int year, int day, String splitBy) {
        return Arrays.stream(filesReadString(year, day)
                .split(splitBy))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static long[] readInputAsLongArray(int year, int day, String splitBy) {
        return Arrays.stream(filesReadString(year, day)
                .split(splitBy))
                .mapToLong(Long::parseLong)
                .toArray();
    }

    public static List<String> readInputAsStringList(int year, int day) {
        return filesReadAllLines(year, day);
    }

    public static String[] readInputAsStringArray(int year, int day) {
        return readInputAsStringList(year, day).toArray(new String[]{});
    }

    public static String[][] readInputAsStringMatrix(int year, int day) {
        var input = readInputAsStringArray(year, day);

        var length = input.length;
        var rowLength = input[0].length();
        var retval = new String[length][rowLength];

        var i = 0;
        for (String row : input) {
            retval[i] = convert(row);
            i++;
        }
        return retval;
    }

    public static char[][] readInputAsCharMatrix(int year, int day) {
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

    public static URI getInputURI(int year, int day) {
        try {
            return ClassLoader.getSystemResource(getFilename(year, day)).toURI();
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(e.getMessage(), e.getCause());
        }
    }

    private static String filesReadString(int year, int day) {
        try {
            return Files.readString(Paths.get(getInputURI(year, day)));
        } catch (IOException e) {
            throw new IllegalArgumentException(e.getMessage(), e.getCause());
        }
    }

    private static List<String> filesReadAllLines(int year, int day) {
        try {
            return Files.readAllLines(Paths.get(getInputURI(year, day)));
        } catch (IOException e) {
            throw new IllegalArgumentException(e.getMessage(), e.getCause());
        }
    }

    private static String[] convert(String values) {
        return values.split(",");
    }

    private static String getFilename(int year, int day) {
        return String.format("%s/input%s.txt", year, day);
    }
}
