package edu.umb.cs680.hw08.FAT;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class FatDirectory extends FatFSElement {

    private LinkedList<FatFSElement> children;

    public FatDirectory(FatDirectory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime);
        if(parent != null) {
            parent.appendChild(this);
        }
        this.children = new LinkedList<>();
    }

    public LinkedList<FatFSElement> getChildren() {
        return this.children;
    }

    public void appendChild(FatFSElement child) {
        this.children.add(child);
        child.setParent(this);
    }

    public int countChildren() {
        return getChildren().size();
    }

    public LinkedList<FatDirectory> getSubDirectories() {
        LinkedList<FatDirectory> subDirectories = new LinkedList<>();
        for (FatFSElement fatFSElement : getChildren()) {
            if (fatFSElement instanceof FatDirectory)
                subDirectories.add((FatDirectory) fatFSElement);
        }
        return subDirectories;
    }

    public LinkedList<FatFile> getFiles() {
        LinkedList<FatFile> files = new LinkedList<>();
        for (FatFSElement fatFSElement : getChildren()) {
            if (fatFSElement instanceof FatFile)
                files.add((FatFile) fatFSElement);
        }
        return files;
    }

    public int getTotalSize() {
        int totalSize = 0;
        for (FatFSElement fatFSElement : getChildren()) {
            if (fatFSElement instanceof FatDirectory)
                totalSize += ((FatDirectory) fatFSElement).getTotalSize();
            else
                totalSize += fatFSElement.getSize();
        }
        return totalSize;
    }

    public boolean isDirectory() {
        return true;
    }

}
