package edu.umb.cs680.hw09.apfs.util;

import edu.umb.cs680.hw09.apfs.ApfsDirectory;
import edu.umb.cs680.hw09.apfs.ApfsFSVisitor;
import edu.umb.cs680.hw09.apfs.ApfsFile;
import edu.umb.cs680.hw09.apfs.ApfsLink;

import java.util.LinkedList;

public class ApfsFileSearchVisitor implements ApfsFSVisitor {

    private String fileName;
    private LinkedList<ApfsFile> foundFiles;

    public ApfsFileSearchVisitor(String fileName) {
        this.fileName = fileName;
        foundFiles = new LinkedList<>();
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void visit(ApfsDirectory dir) {

    }

    public void visit(ApfsFile file) {
        if(file.getName().equals(fileName)) {
            foundFiles.add(file);
        }
    }

    public void visit(ApfsLink link) {

    }

    public LinkedList<ApfsFile> getFoundFiles() {
        return this.foundFiles;
    }

}
