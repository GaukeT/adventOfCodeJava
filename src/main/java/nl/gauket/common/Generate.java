package nl.gauket.common;

import java.io.FileOutputStream;
import java.io.IOException;

public class Generate {

    private Generate() {
    }

    public static void newDay(int year, int day) {
        var filename = "src/main/java/nl/gauket/mission%s/Day%s.java";
        writeToFile(template(year, day), String.format(filename, year, day));
    }

    private static void writeToFile(String template, String filename) {
        try (FileOutputStream outputStream = new FileOutputStream(filename)) {
            byte[] strToBytes = template.getBytes();
            outputStream.write(strToBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String template(int year, int day) {
        return String.format("""
                package nl.gauket.mission%d;
                
                import nl.gauket.common.NewDay;
                
                public class Day%d extends NewDay {
                    @Override
                    public long[] solvePart1() {
                        var result = 0;
                        return new long[] {result};
                    }
                
                    @Override
                    public long[] solvePart2() {
                        var result = 0;
                        return new long[] {result};
                    }
                }""", year, day);
    }
}
