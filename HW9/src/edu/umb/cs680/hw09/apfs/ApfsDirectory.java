package edu.umb.cs680.hw09.apfs;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class ApfsDirectory extends ApfsFSElement {

    private LinkedList<ApfsFSElement> children;

    public ApfsDirectory(ApfsDirectory parent, String name, int size, LocalDateTime creationTime, String ownerName, LocalDateTime lastModifiedTime) {
        super(parent, name, size, creationTime, ownerName, lastModifiedTime);
        if(parent != null) {
            parent.appendChild(this);
        }
        this.children = new LinkedList<>();
    }

    public LinkedList<ApfsFSElement> getChildren() {
        return this.children;
    }

    public void appendChild(ApfsFSElement child) {
        this.children.add(child);
        child.setParent(this);
    }

    public int countChildren() {
        return getChildren().size();
    }

    public LinkedList<ApfsDirectory> getSubDirectories() {
        LinkedList<ApfsDirectory> subDirectories = new LinkedList<>();
        for (ApfsFSElement apfsFSElement : getChildren()) {
            if (apfsFSElement instanceof ApfsDirectory)
                subDirectories.add((ApfsDirectory) apfsFSElement);
        }
        return subDirectories;
    }

    public LinkedList<ApfsFile> getFiles() {
        LinkedList<ApfsFile> files = new LinkedList<>();
        for (ApfsFSElement apfsFSElement : getChildren()) {
            if (apfsFSElement instanceof ApfsFile)
                files.add((ApfsFile) apfsFSElement);
        }
        return files;
    }

    public LinkedList<ApfsLink> getLinks() {
        LinkedList<ApfsLink> links = new LinkedList<>();
        for (ApfsFSElement apfsFSElement : getChildren()) {
            if (apfsFSElement instanceof ApfsLink)
                links.add((ApfsLink) apfsFSElement);
        }
        return links;
    }

    public int getTotalSize() {
        int totalSize = 0;
        for (ApfsFSElement apfsFSElement : getChildren()) {
            if (apfsFSElement instanceof ApfsDirectory)
                totalSize += ((ApfsDirectory) apfsFSElement).getTotalSize();
            else
                totalSize += apfsFSElement.getSize();
        }
        return totalSize;
    }

    public boolean isDirectory() {
        return true;
    }

    public void accept(ApfsFSVisitor visitor) {
        visitor.visit(this);
        for(ApfsFSElement element : children) {
            element.accept(visitor);
        }
    }
}
