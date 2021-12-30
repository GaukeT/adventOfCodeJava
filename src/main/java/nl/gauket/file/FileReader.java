package nl.gauket.file;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static java.lang.String.format;

public class FileReader {
    private FileReader() {
    }

    public static InputStream read(int year, int day, FileType fileType) throws IOException {
        var srcPath = format(fileType.path, year);
        var filename = format(fileType.filename, day);

        FileInputStream inputStream = new FileInputStream(format("%s%s", srcPath, filename));
        return Files.newInputStream(Paths.get(format("%s%s", srcPath, filename)), StandardOpenOption.READ);
    }
}
