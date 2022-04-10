package edu.umb.cs680.hw07;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class FileTest {

    static LocalDateTime localTime = LocalDateTime.now();

    Directory root = new Directory(null, "root", 0, localTime);

    Directory apps = new Directory(root, "Apps", 0, localTime);
    File x = new File(apps, "x", 10, localTime);

    Directory bin = new Directory(root, "bin", 0, localTime);
    File y = new File(bin, "y", 15, localTime);

    Directory home = new Directory(root, "home", 0, localTime);
    Link xLink = new Link(home, "x", 0, localTime, home);

    Directory pictures = new Directory(home, "pictures", 0, localTime);
    File a = new File(pictures, "a", 20, localTime);
    File b = new File(pictures, "b", 20, localTime);
    Link yLink = new Link(pictures, "y", 0, localTime, y);

    File c = new File(home, "c", 25, localTime);

    private String[] fileToStringArray(File file) {
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
