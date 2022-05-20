package edu.umb.cs680.hw08;

import edu.umb.cs680.hw08.FAT.FatDirectory;
import edu.umb.cs680.hw08.FAT.FatFile;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class FATFileTest {

    static LocalDateTime localTime = LocalDateTime.now();

    FatDirectory root = new FatDirectory(null, "root", 0, localTime);

    FatDirectory apps = new FatDirectory(root, "Apps", 0, localTime);
    FatFile x = new FatFile(apps, "x", 10, localTime);

    FatDirectory bin = new FatDirectory(root, "bin", 0, localTime);
    FatFile y = new FatFile(bin, "y", 15, localTime);

    FatDirectory home = new FatDirectory(root, "home", 0, localTime);

    FatDirectory pictures = new FatDirectory(home, "pictures", 0, localTime);
    FatFile a = new FatFile(pictures, "a", 20, localTime);
    FatFile b = new FatFile(pictures, "b", 20, localTime);

    FatFile c = new FatFile(home, "c", 25, localTime);

    private String[] fileToStringArray(FatFile file) {
        String[] fileInfo = {Boolean.toString(file.isFile()), file.getName(), file.getParent().getName(),
                Integer.toString(file.getSize()), file.getCreationTime().toString()};

        return fileInfo;
    }

    @Test
    public void verifyDirectories() {
        assertTrue(root.isDirectory());
        assertTrue(apps.isDirectory());
        assertTrue(bin.isDirectory());
        assertTrue(home.isDirectory());
        assertTrue(pictures.isDirectory());
        assertFalse(x.isDirectory());
        assertFalse(y.isDirectory());
        assertFalse(a.isDirectory());
        assertFalse(b.isDirectory());
        assertFalse(c.isDirectory());
    }

    @Test
    public void verifyFiles() {
        assertFalse(root.isFile());
        assertFalse(apps.isFile());
        assertFalse(bin.isFile());
        assertFalse(home.isFile());
        assertFalse(pictures.isFile());
        assertTrue(x.isFile());
        assertTrue(y.isFile());
        assertTrue(a.isFile());
        assertTrue(b.isFile());
        assertTrue(c.isFile());
    }

    @Test
    public void verifyFileX() {
        String[] expected = {"true", "x", "Apps", "10", localTime.toString()};
        String[] actual = fileToStringArray(x);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void verifyFileY() {
        String[] expected = {"true", "y", "bin", "15", localTime.toString()};
        String[] actual = fileToStringArray(y);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void verifyFileA() {
        String[] expected = {"true", "a", "pictures", "20", localTime.toString()};
        String[] actual = fileToStringArray(a);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void verifyFileB() {
        String[] expected = {"true", "b", "pictures", "20", localTime.toString()};
        String[] actual = fileToStringArray(b);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void verifyFileC() {
        String[] expected = {"true", "c", "home", "25", localTime.toString()};
        String[] actual = fileToStringArray(c);
        assertArrayEquals(expected, actual);
    }


}
