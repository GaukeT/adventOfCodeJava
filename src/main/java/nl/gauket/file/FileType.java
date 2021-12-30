package nl.gauket.file;

public enum FileType {
    INPUT("src/main/resources/%s", "/input%s.txt"),
    NEWDAY("src/main/java/nl/gauket/mission%s", "/Day%s.java");

    public final String path;
    public final String filename;

    FileType(String path, String filename) {
        this.path = path;
        this.filename = filename;
    }
}
