package nl.gauket.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class InputWriter {

    private FileWriter fileWriter;

    public boolean checkIfInputExists(int year, int day) {
        String filename = String.format("%s/input%s.txt", year, day);
        return ClassLoader.getSystemResource(filename) != null;
    }

    private File createFile(String filename) {
        try {
            File newInput = new File(filename);
            newInput.createNewFile();
            return newInput;
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalStateException("File not created");
        }
    }

    public void writeToFile(int year, int day, BufferedReader br) throws IOException {
        String filename = String.format("src/main/resources/%s/input%s.txt", year, day);
        File file = createFile(filename);
        openFileWriter(file);

        var line = "";
        while (true) {
            line = br.readLine();
            if ("".equals(line) || null == line) {
                break;
            }
            writeLn(line + "\n");
        }

        closeFileWriter();
    }

    private FileWriter openFileWriter(File file) throws IOException {
        if (fileWriter == null) {
            fileWriter = new FileWriter(file);
        }
        return fileWriter;
    }

    private void closeFileWriter() throws IOException {

        fileWriter.close();
    }

    private void writeLn(String line) throws IOException {
        fileWriter.write(line);
    }
}
