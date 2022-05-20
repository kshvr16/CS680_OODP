package edu.umb.cs680.hw12.APFS;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
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
        Collections.sort(this.children, new AlphabeticalComparator());
        return this.children;
    }

    public LinkedList<ApfsFSElement> getChildren(Comparator<ApfsFSElement> comparator) {
        Collections.sort(this.children, comparator);
        return this.children;
    }

    public void appendChild(ApfsFSElement child) {
        this.children.add(child);
        child.setParent(this);
        Collections.sort(this.children, new AlphabeticalComparator());
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
        Collections.sort(subDirectories, new AlphabeticalComparator());
        return subDirectories;
    }

    public LinkedList<ApfsDirectory> getSubDirectories(Comparator<ApfsFSElement> comparator) {
        LinkedList<ApfsDirectory> subDirectories = getSubDirectories();
        Collections.sort(subDirectories, comparator);
        return subDirectories;
    }

    public LinkedList<ApfsFile> getFiles() {
        LinkedList<ApfsFile> files = new LinkedList<>();
        for (ApfsFSElement apfsFSElement : getChildren()) {
            if (apfsFSElement instanceof ApfsFile)
                files.add((ApfsFile) apfsFSElement);
        }
        Collections.sort(files, new AlphabeticalComparator());
        return files;
    }

    public LinkedList<ApfsFile> getFiles(Comparator<ApfsFSElement> comparator) {
        LinkedList<ApfsFile> files = getFiles();
        Collections.sort(files, comparator);
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

}
