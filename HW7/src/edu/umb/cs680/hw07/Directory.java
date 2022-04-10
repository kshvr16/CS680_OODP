package edu.umb.cs680.hw07;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Directory extends FSElement {

    private final LinkedList<FSElement> children = new LinkedList<>();
    private final LinkedList<Directory> directoryList = new LinkedList<>();
    private final LinkedList<File> fileList = new LinkedList<>();

    public Directory(Directory parent, String name, int size, LocalDateTime createdTime) {
        super(parent, name, size, createdTime);
        if(parent != null) {
            parent.appendChild(this);
        }
    }

    public LinkedList<FSElement> getChildren() {
        return children;
    }

    public void appendChild(FSElement child) {
        this.children.add(child);
        child.setParent(this);
    }

    public int countChildren() {
        return getChildren().size();
    }

    public LinkedList<Directory> getSubDirectories() {
        for (FSElement fsElement : getChildren()) {
            if (fsElement instanceof Directory)
                directoryList.add((Directory) fsElement);
        }
        return directoryList;
    }

    public LinkedList<File> getFiles() {
        for (FSElement fsElement : getChildren()) {
            if (fsElement instanceof File) {
                fileList.add((File) fsElement);
            }
        }
        return fileList;
    }

    public int getTotalSize() {
        int totalSize = 0;
        for (FSElement fsElement : getChildren()) {
            if (fsElement instanceof Directory)
                totalSize += ((Directory) fsElement).getTotalSize();
            else
                totalSize += fsElement.getSize();
        }
        return totalSize;
    }

    public boolean isDirectory() {
        return true;
    }

}
