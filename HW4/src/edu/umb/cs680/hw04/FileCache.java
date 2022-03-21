package edu.umb.cs680.hw04;

import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class FileCache {

    protected Map<Path, String> cache = new LinkedHashMap<>();

    public String fetch(Path path) {
        if (!isCached(path)) {
            if (!isCacheFull()) {
                cacheFile(path);
            } else {
                replace(path);
            }
        }
        return cache.get(path);
    }

    protected boolean isCached(Path path) {
        return cache.containsKey(path);
    }

    protected boolean isCacheFull() {
        return cache.size() == 25; //Assuming that the maximum size of the cache is 25
    }

    protected abstract void cacheFile(Path path);

    protected abstract void replace(Path path);

    public static void main(String[] args) {
        System.out.println("FileCache class has been implemented successfully!!!");
    }

}
