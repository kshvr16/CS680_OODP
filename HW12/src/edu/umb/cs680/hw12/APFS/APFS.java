package edu.umb.cs680.hw12.APFS;

import edu.umb.cs680.hw12.FSFoundation.FSElement;
import edu.umb.cs680.hw12.FSFoundation.FileSystem;

import java.time.LocalDateTime;

public class APFS extends FileSystem {

    private static APFS instance = null;

    public static APFS getInstance() {
        if(instance == null) {
            instance = new APFS();
        }
        return instance;
    }

    protected FSElement createDefaultRoot() {
        return new ApfsDirectory(null, "root", 0, LocalDateTime.now(), "S.Kona001", LocalDateTime.now());
    }

    public ApfsDirectory getRootDir() {
        return (ApfsDirectory) getRootDirs().get(0);
    }

    public static void main(String[] args) {
        System.out.println("The APFS File System has been implemented Successfully ");
    }

}
