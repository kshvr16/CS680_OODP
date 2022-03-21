package edu.umb.cs680.hw04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class LRUFileCache extends FileCache{

    @Override
    protected void cacheFile(Path path) {
        try {
            cache.put(path, Files.readString(path));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    protected void replace(Path path) {
        try {
            cache.remove(cache.keySet().iterator().next());
            cache.put(path, Files.readString(path));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
