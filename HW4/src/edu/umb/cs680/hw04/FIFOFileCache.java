package edu.umb.cs680.hw04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class FIFOFileCache extends FileCache {

    protected void cacheFile(Path path) {
        try {
            cache.put(path, Files.readString(path));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    protected void replace(Path path) {
        try {
            Map.Entry<Path, String> entry = cache.entrySet().iterator().next();
            cache.remove(entry.getKey());
            cache.put(path, Files.readString(path));
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }

}
