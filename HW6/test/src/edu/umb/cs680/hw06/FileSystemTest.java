package edu.umb.cs680.hw06;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FileSystemTest {

    @Test
    public void verifyFileSystemInstance() {
        FileSystem instanceOne = FileSystem.getFileSystem();
        FileSystem instanceTwo = FileSystem.getFileSystem();
        assertSame(instanceOne, instanceTwo);
    }

}
