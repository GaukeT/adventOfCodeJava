package nl.gauket.common;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class InputWriter {
    public static void writeToFile(int year, int day, InputStream in) throws IOException {
        String filename = String.format("src/main/resources/%s/input%s.txt", year, day);
        Files.copy(in, Paths.get(filename), StandardCopyOption.REPLACE_EXISTING);
    }

    public static boolean checkIfInputExists(int year, int day) {
        String filename = String.format("%s/input%s.txt", year, day);
        return ClassLoader.getSystemResource(filename) != null;
    }
}
