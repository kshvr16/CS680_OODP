package edu.umb.cs680.hw09.apfs.util;

import edu.umb.cs680.hw09.apfs.ApfsDirectory;
import edu.umb.cs680.hw09.apfs.ApfsFSVisitor;
import edu.umb.cs680.hw09.apfs.ApfsFile;
import edu.umb.cs680.hw09.apfs.ApfsLink;

public class ApfsCountingVisitor implements ApfsFSVisitor {

    private int dirNumber;
    private int fileNumber;
    private int linkNumber;

    public ApfsCountingVisitor() {
        dirNumber = 0;
        fileNumber = 0;
        linkNumber = 0;
    }

    public void visit(ApfsDirectory dir) {
        this.dirNumber ++;
    }

    public void visit(ApfsFile file) {
        this.fileNumber ++;
    }

    public void visit(ApfsLink link) {
        this.linkNumber ++;
    }

    public int getDirNumber() {
        return this.dirNumber;
    }

    public int getFileNumber() {
        return this.fileNumber;
    }

    public int getLinkNumber() {
        return this.linkNumber;
    }

}
