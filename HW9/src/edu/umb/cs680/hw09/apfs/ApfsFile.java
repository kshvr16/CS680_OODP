package edu.umb.cs680.hw09.apfs;

import java.time.LocalDateTime;

public class ApfsFile extends ApfsFSElement {

    public ApfsFile(ApfsDirectory parent, String name, int size, LocalDateTime creationTime, String ownerName, LocalDateTime lastModifiedTime) {
        super(parent, name, size, creationTime, ownerName, lastModifiedTime);
        parent.appendChild(this);
    }

    public boolean isFile() {
        return true;
    }

    public void accept(ApfsFSVisitor visitor) {
        visitor.visit(this);
    }

}
