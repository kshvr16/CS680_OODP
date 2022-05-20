package edu.umb.cs680.hw08;

import edu.umb.cs680.hw08.APFS.ApfsDirectory;
import edu.umb.cs680.hw08.APFS.ApfsFSElement;
import edu.umb.cs680.hw08.APFS.ApfsFile;
import edu.umb.cs680.hw08.APFS.ApfsLink;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class ApfsDirectoryTest {

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

    private String[] dirToStringArray(ApfsDirectory directory) {
        String parentName = null;
        ApfsDirectory parent = directory.getParent();
        if (parent != null) {
            parentName = parent.getName();
        }
        String[] dirInfo = { Boolean.toString(directory.isDirectory()), directory.getName(),
                Integer.toString(directory.getSize()), directory.getCreationTime().toString(),parentName,
                Integer.toString(directory.countChildren()),Integer.toString(directory.getTotalSize()), directory.getOwnerName(), directory.getLastModifiedTime().toString()};

        return dirInfo;
    }

    @Test
    public void verifyDirectoryEqualityRoot() {
        String[] expected = {"true", "root", "0", localTime.toString(), null, "3", "90", "S.Kona001", localTime.toString()};
        ApfsDirectory actual = root;
        assertArrayEquals(expected, dirToStringArray(actual));
    }

    @Test
    public void verifyDirectoryEqualityApps() {
        String[] expected = {"true", "Apps", "0", localTime.toString(), "root", "1", "10", "S.Kona001", localTime.toString()};
        ApfsDirectory actual = apps;
        assertArrayEquals(expected, dirToStringArray(actual));
    }

    @Test
    public void verifyDirectoryEqualityBin() {
        String[] expected = {"true", "bin", "0", localTime.toString(), "root", "1", "15", "S.Kona001", localTime.toString()};
        ApfsDirectory actual = bin;
        assertArrayEquals(expected, dirToStringArray(actual));
    }

    @Test
    public void verifyDirectoryEqualityHome() {
        String[] expected = {"true", "home", "0", localTime.toString(), "root", "3", "65", "S.Kona001", localTime.toString()};
        ApfsDirectory actual = home;
        assertArrayEquals(expected, dirToStringArray(actual));
    }

    @Test
    public void verifyDirectoryEqualityPictures() {
        String[] expected = {"true", "pictures", "0", localTime.toString(), "home", "3", "40", "S.Kona001", localTime.toString()};
        ApfsDirectory actual = pictures;
        assertArrayEquals(expected, dirToStringArray(actual));
    }

    @Test
    public void verifyGetChildrenForRoot() {
        LinkedList<ApfsFSElement> expected = new LinkedList<>();
        expected.add(apps);
        expected.add(bin);
        expected.add(home);
        assertEquals(expected, root.getChildren());
    }

    @Test
    public void verifyGetChildrenForApps() {
        LinkedList<ApfsFSElement> expected = new LinkedList<>();
        expected.add(x);
        assertEquals(expected, apps.getChildren());
    }

    @Test
    public void verifyGetChildrenForBin() {
        LinkedList<ApfsFSElement> expected = new LinkedList<>();
        expected.add(y);
        assertEquals(expected, bin.getChildren());
    }

    @Test
    public void verifyGetChildrenForHome() {
        LinkedList<ApfsFSElement> expected = new LinkedList<>();
        expected.add(xLink);
        expected.add(pictures);
        expected.add(c);
        assertEquals(expected, home.getChildren());
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
    public void verifyGetSubDirectories() {
        assertEquals(apps, root.getSubDirectories().get(0));
        assertEquals(bin, root.getSubDirectories().get(1));
        assertEquals(home, root.getSubDirectories().get(2));
        assertEquals(pictures, home.getSubDirectories().get(0));
    }

    @Test
    public void verifyGetFiles() {
        assertEquals(x, apps.getFiles().get(0));
        assertEquals(y, bin.getFiles().get(0));
        assertEquals(a, pictures.getFiles().get(0));
        assertEquals(b, pictures.getFiles().get(1));
        assertEquals(c, home.getFiles().get(0));
    }

}
