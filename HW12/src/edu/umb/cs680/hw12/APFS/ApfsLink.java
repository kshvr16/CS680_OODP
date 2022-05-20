package edu.umb.cs680.hw12.APFS;

import java.time.LocalDateTime;

public class ApfsLink extends ApfsFSElement {

    private ApfsFSElement target;

    public ApfsLink(ApfsDirectory parent, String name, int size, LocalDateTime creationTime, String ownerName, LocalDateTime lastModifiedTime, ApfsFSElement target) {
        super(parent, name, size, creationTime, ownerName, lastModifiedTime);
        this.target = target;
        parent.appendChild(this);
    }

    public ApfsFSElement getTarget() {
        return this.target;
    }

    public boolean isLink() {
        return true;
    }

}
