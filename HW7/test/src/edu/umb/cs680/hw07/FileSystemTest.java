package edu.umb.cs680.hw07;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

public class FileSystemTest {

    @Test
    public void verifyFileSystemInstance() {
        FileSystem instanceOne = FileSystem.getFileSystem();
        FileSystem instanceTwo = FileSystem.getFileSystem();
        assertSame(instanceOne, instanceTwo);
    }

}
