package edu.umb.cs680.hw08.FAT;

import java.time.LocalDateTime;

public class FatFile extends FatFSElement {

    public FatFile(FatDirectory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime);
        if(parent != null) {
            parent.appendChild(this);
        }
    }

    public boolean isFile() {
        return true;
    }

}
