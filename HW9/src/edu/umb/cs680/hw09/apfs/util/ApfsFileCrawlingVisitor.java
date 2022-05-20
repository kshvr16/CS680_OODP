package edu.umb.cs680.hw09.apfs.util;

import edu.umb.cs680.hw09.apfs.ApfsDirectory;
import edu.umb.cs680.hw09.apfs.ApfsFSVisitor;
import edu.umb.cs680.hw09.apfs.ApfsFile;
import edu.umb.cs680.hw09.apfs.ApfsLink;

import java.util.LinkedList;

public class ApfsFileCrawlingVisitor implements ApfsFSVisitor {

    private LinkedList<ApfsFile> fileList;

    public ApfsFileCrawlingVisitor() {
        fileList = new LinkedList<>();
    }

    public void visit(ApfsDirectory dir) {

    }

    public void visit(ApfsFile file) {
        fileList.add(file);
    }

    public void visit(ApfsLink link) {

    }

    public LinkedList<ApfsFile> getFiles() {
        return fileList;
    }

}
