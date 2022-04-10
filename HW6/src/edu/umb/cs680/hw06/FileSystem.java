package edu.umb.cs680.hw06;

import java.util.LinkedList;

public class FileSystem {

    private static FileSystem instance;
    private LinkedList<Directory> rootDirs;

    private FileSystem() {
        instance = null;
        rootDirs = new LinkedList<>();
    }

    public static FileSystem getFileSystem() {
        if(instance == null) {
            instance = new FileSystem();
        }
        return instance;
    }

    public LinkedList<Directory> getRootDirs() {
        return this.rootDirs;
    }

    public void appendRootDir(Directory root) {
        rootDirs.add(root);
    }

}
