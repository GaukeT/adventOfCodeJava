package nl.gauket.common;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class InputWriter {
    private InputWriter() {
    }

    public static void writeToFile(int year, int day, InputStream in) throws IOException {
        String filename = String.format("src/main/resources/%s/input%s.txt", year, day);
        String filename2 = String.format("build/resources/main/%s/input%s.txt", year, day);

        Files.copy(in, Paths.get(filename), StandardCopyOption.REPLACE_EXISTING);
        Files.copy(in, Paths.get(filename2), StandardCopyOption.REPLACE_EXISTING);
    }

    public static boolean checkIfInputExists(int year, int day) {
        String filename = String.format("%s/input%s.txt", year, day);
        return ClassLoader.getSystemResource(filename) != null;
    }

    public static void debug(String str, boolean newLine) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("debug.txt", true))) {
            writer.append(str);
            if (newLine) writer.append('\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void clearDebugfile() {
        try (FileWriter fwOb = new FileWriter("debug.txt", false)) {
            try (PrintWriter pwOb = new PrintWriter(fwOb, false)) {}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
