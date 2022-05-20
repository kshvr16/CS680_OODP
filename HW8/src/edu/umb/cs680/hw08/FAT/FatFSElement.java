package edu.umb.cs680.hw08.FAT;

import edu.umb.cs680.hw08.FSFoundation.FSElement;

import java.time.LocalDateTime;

public class FatFSElement extends FSElement {

    private FatDirectory parent;

    public FatFSElement(FatDirectory parent, String name, int size, LocalDateTime creationTime) {
        super(name, size, creationTime);
        this.parent = parent;
    }

    public FatDirectory getParent() {
        return this.parent;
    }

    public void setParent(FatDirectory parent) {
        this.parent = parent;
    }

}
