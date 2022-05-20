package edu.umb.cs680.hw08.FAT;

import edu.umb.cs680.hw08.FSFoundation.FSElement;
import edu.umb.cs680.hw08.FSFoundation.FileSystem;

import java.time.LocalDateTime;

public class FAT extends FileSystem {

    private static FAT instance = null;

    public static FAT getInstance() {
        if(instance == null) {
            instance = new FAT();
        }
        return instance;
    }

    protected FSElement createDefaultRoot() {
        return new FatDirectory(null, "root", 0, LocalDateTime.now());
    }

    public void addRootDir(FatDirectory dir) {
        getRootDirs().add(dir);
    }

    public FatDirectory getRootDir() {
        return (FatDirectory) getRootDirs().get(0);
    }

    public static void main(String[] args) {
        System.out.println("The FAT File System has been implemented Successfully");
    }

}
