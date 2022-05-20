package edu.umb.cs680.hw08;

import edu.umb.cs680.hw08.APFS.ApfsDirectory;
import edu.umb.cs680.hw08.APFS.ApfsFile;
import edu.umb.cs680.hw08.APFS.ApfsLink;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class ApfsFileTest {

    static LocalDateTime localTime = LocalDateTime.now();

    ApfsDirectory root = new ApfsDirectory(null, "root", 0, localTime, "S.Kona001", localTime);

    ApfsDirectory apps = new ApfsDirectory(root, "Apps", 0, localTime, "S.Kona001", localTime);
    ApfsFile x = new ApfsFile(apps, "x", 10, localTime, "S.Kona001", localTime);

    ApfsDirectory bin = new ApfsDirectory(root, "bin", 0, localTime, "S.Kona001", localTime);
    ApfsFile y = new ApfsFile(bin, "y", 15, localTime, "S.Kona001", localTime);

    ApfsDirectory home = new ApfsDirectory(root, "home", 0, localTime, "S.Kona001", localTime);
    ApfsLink xLink = new ApfsLink(home, "x", 0, localTime, "S.Kona001", localTime,home);

    ApfsDirectory pictures = new ApfsDirectory(home, "pictures", 0, localTime, "S.Kona001", localTime);
    ApfsFile a = new ApfsFile(pictures, "a", 20, localTime, "S.Kona001", localTime);
    ApfsFile b = new ApfsFile(pictures, "b", 20, localTime, "S.Kona001", localTime);
    ApfsLink yLink = new ApfsLink(pictures, "y", 0, localTime, "S.Kona001", localTime, y);

    ApfsFile c = new ApfsFile(home, "c", 25, localTime, "S.Kona001", localTime);

    private String[] fileToStringArray(ApfsFile file) {
        String[] fileInfo = {Boolean.toString(file.isFile()), file.getName(), file.getParent().getName(),
                Integer.toString(file.getSize()), file.getCreationTime().toString(), file.getOwnerName(), file.getLastModifiedTime().toString()};

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
        assertFalse(xLink.isDirectory());
        assertFalse(yLink.isDirectory());
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
        assertFalse(xLink.isDirectory());
        assertFalse(yLink.isDirectory());
    }

    @Test
    public void verifyLinks() {
        assertFalse(root.isLink());
        assertFalse(apps.isLink());
        assertFalse(bin.isLink());
        assertFalse(home.isLink());
        assertFalse(pictures.isLink());
        assertFalse(x.isLink());
        assertFalse(y.isLink());
        assertFalse(a.isLink());
        assertFalse(b.isLink());
        assertFalse(c.isLink());
        assertTrue(xLink.isLink());
        assertTrue(yLink.isLink());
    }

    @Test
    public void verifyFileX() {
        String[] expected = {"true", "x", "Apps", "10", localTime.toString(), "S.Kona001", localTime.toString()};
        String[] actual = fileToStringArray(x);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void verifyFileY() {
        String[] expected = {"true", "y", "bin", "15", localTime.toString(), "S.Kona001", localTime.toString()};
        String[] actual = fileToStringArray(y);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void verifyFileA() {
        String[] expected = {"true", "a", "pictures", "20", localTime.toString(), "S.Kona001", localTime.toString()};
        String[] actual = fileToStringArray(a);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void verifyFileB() {
        String[] expected = {"true", "b", "pictures", "20", localTime.toString(), "S.Kona001", localTime.toString()};
        String[] actual = fileToStringArray(b);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void verifyFileC() {
        String[] expected = {"true", "c", "home", "25", localTime.toString(), "S.Kona001", localTime.toString()};
        String[] actual = fileToStringArray(c);
        assertArrayEquals(expected, actual);
    }

}
