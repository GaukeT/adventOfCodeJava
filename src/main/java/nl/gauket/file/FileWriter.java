package nl.gauket.file;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import static java.lang.String.format;

public class FileWriter {
    private FileWriter() {
    }

    public static void write(int year, int day, FileType fileType, OutputStream out) throws IOException {
        var srcPath = format(fileType.path, year);
        var filename = format(fileType.filename, day);

        // Create file and copy
        Files.createDirectories(Paths.get(srcPath));
        Files.copy(Paths.get(format("%s%s", srcPath, filename)), out);
    }
}


