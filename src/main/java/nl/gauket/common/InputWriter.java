package nl.gauket.common;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
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

    public static void debug(String str) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("debug.txt", true));
            writer.append(str);
            writer.append('\n');
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
