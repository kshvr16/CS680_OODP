package edu.umb.cs680.hw04;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class FileCacheTest {

    private FileCache fileCache;

    @Test
    public void fetchWithFIFOFileCache() throws IOException {
        fileCache = new FIFOFileCache();
        Path path = Paths.get("forTest\\test");
        assertEquals(Files.readString(path), fileCache.fetch(path));
    }

    @Test
    public void fetchWithLRUFileCache() throws IOException {
        fileCache = new LRUFileCache();
        Path path = Paths.get("forTest\\test");
        assertEquals(Files.readString(path), fileCache.fetch(path));
    }

}
