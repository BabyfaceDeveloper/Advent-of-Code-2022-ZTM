package solutions;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class Day {
    private final static String ROOT_PATH = Paths.get(System.getProperty("user.dir")).getParent().toString();
    protected final Path INPUT_FILE;

    public Day(String filename) {
        INPUT_FILE = Paths.get(ROOT_PATH, "inputs", filename);
    }

    public abstract void readFiles() throws IOException;
}
