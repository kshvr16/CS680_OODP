package edu.umb.cs680.hw06;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class DirectoryTest {

    static LocalDateTime localTime = LocalDateTime.now();

    Directory root = new Directory(null, "root", 0, localTime);

    Directory apps = new Directory(root, "Apps", 0, localTime);
    File x = new File(apps, "x", 10, localTime);

    Directory bin = new Directory(root, "bin", 0, localTime);
    File y = new File(bin, "y", 15, localTime);

    Directory home = new Directory(root, "home", 0, localTime);

    Directory pictures = new Directory(home, "pictures", 0, localTime);
    File a = new File(pictures, "a", 20, localTime);
    File b = new File(pictures, "b", 20, localTime);

    File c = new File(home, "c", 25, localTime);

    private String[] dirToStringArray(Directory directory) {
        String parentName = null;
        Directory parent = directory.getParent();
        if (parent != null) {
            parentName = parent.getName();
        }
        String[] dirInfo = { Boolean.toString(directory.isDirectory()), directory.getName(),
                Integer.toString(directory.getSize()), directory.getCreationTime().toString(),parentName,
                Integer.toString(directory.countChildren()),Integer.toString(directory.getTotalSize()) };

        return dirInfo;
    }

    @Test
    public void verifyDirectoryEqualityRoot() {
        String[] expected = {"true", "root", "0", localTime.toString(), null, "3", "90"};
        Directory actual = root;
        assertArrayEquals(expected, dirToStringArray(actual));
    }

    @Test
    public void verifyDirectoryEqualityApps() {
        String[] expected = {"true", "Apps", "0", localTime.toString(), "root", "1", "10"};
        Directory actual = apps;
        assertArrayEquals(expected, dirToStringArray(actual));
    }

    @Test
    public void verifyDirectoryEqualityBin() {
        String[] expected = {"true", "bin", "0", localTime.toString(), "root", "1", "15"};
        Directory actual = bin;
        assertArrayEquals(expected, dirToStringArray(actual));
    }

    @Test
    public void verifyDirectoryEqualityHome() {
        String[] expected = {"true", "home", "0", localTime.toString(), "root", "2", "65"};
        Directory actual = home;
        assertArrayEquals(expected, dirToStringArray(actual));
    }

    @Test
    public void verifyDirectoryEqualityPictures() {
        String[] expected = {"true", "pictures", "0", localTime.toString(), "home", "2", "40"};
        Directory actual = pictures;
        assertArrayEquals(expected, dirToStringArray(actual));
    }

    @Test
    public void verifyGetChildrenForRoot() {
        LinkedList<FSElement> expected = new LinkedList<>();
        expected.add(apps);
        expected.add(bin);
        expected.add(home);
        assertEquals(expected, root.getChildren());
    }

    @Test
    public void verifyGetChildrenForApps() {
        LinkedList<FSElement> expected = new LinkedList<>();
        expected.add(x);
        assertEquals(expected, apps.getChildren());
    }

    @Test
    public void verifyGetChildrenForBin() {
        LinkedList<FSElement> expected = new LinkedList<>();
        expected.add(y);
        assertEquals(expected, bin.getChildren());
    }

    @Test
    public void verifyGetChildrenForHome() {
        LinkedList<FSElement> expected = new LinkedList<>();
        expected.add(pictures);
        expected.add(c);
        assertEquals(expected, home.getChildren());
    }

    @Test
    public void verifyGetChildrenForPictures() {
        LinkedList<FSElement> expected = new LinkedList<>();
        expected.add(a);
        expected.add(b);
        assertEquals(expected, pictures.getChildren());
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
