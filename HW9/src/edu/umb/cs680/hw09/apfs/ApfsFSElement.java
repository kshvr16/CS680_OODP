package edu.umb.cs680.hw09.apfs;

import edu.umb.cs680.hw09.fs.FSElement;

import java.time.LocalDateTime;

public class ApfsFSElement extends FSElement {

    private String ownerName;
    private LocalDateTime lastModifiedTime;
    private ApfsDirectory parent;

    public ApfsFSElement(ApfsDirectory parent, String name, int size, LocalDateTime creationTime, String ownerName, LocalDateTime lastModifiedTime) {
        super(name, size, creationTime);
        this.parent = parent;
        this.ownerName = ownerName;
        this.lastModifiedTime = lastModifiedTime;
    }

    public String getOwnerName() {
        return this.ownerName;
    }

    public LocalDateTime getLastModifiedTime() {
        return this.lastModifiedTime;
    }

    public ApfsDirectory getParent() {
        return this.parent;
    }

    public void setParent(ApfsDirectory parent) {
        this.parent = parent;
    }

    public boolean isLink() {
        return false;
    }

    public void accept(ApfsFSVisitor visitor) {

    }

}
