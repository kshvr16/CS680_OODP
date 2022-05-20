package edu.umb.cs680.hw09.apfs;

public interface ApfsFSVisitor {

    void visit(ApfsDirectory dir);
    void visit(ApfsFile file);
    void visit(ApfsLink link);

}
