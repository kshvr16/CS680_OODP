package edu.umb.cs680.hw14;

import edu.umb.cs680.hw14.APFS.ApfsDirectory;
import edu.umb.cs680.hw14.APFS.ApfsFSElement;
import edu.umb.cs680.hw14.APFS.ApfsFile;
import edu.umb.cs680.hw14.APFS.ApfsLink;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    public void verifyGetChildrenForRootInAlphabeticalComparator() {
        LinkedList<ApfsFSElement> expected = new LinkedList<>();
        expected.add(apps);
        expected.add(bin);
        expected.add(home);
        assertEquals(expected, root.getChildren());
    }

    @Test
    public void verifyGetChildrenForRootInReverseAlphabeticalComparator() {
        LinkedList<ApfsFSElement> expected = new LinkedList<>();
        expected.add(home);
        expected.add(bin);
        expected.add(apps);
        assertEquals(expected, root.getChildren(Comparator.comparing(ApfsFSElement::getName, Comparator.reverseOrder())));
    }

    @Test
    public void verifyGetChildrenForRootInTimeStampComparator() {
        LinkedList<ApfsFSElement> expected = new LinkedList<>();
        expected.add(apps);
        expected.add(bin);
        expected.add(home);
        assertEquals(expected, root.getChildren(Comparator.comparing(ApfsFSElement::getLastModifiedTime)));
    }

    @Test
    public void verifyGetChildrenForAppsInAlphabeticalComparator() {
        LinkedList<ApfsFSElement> expected = new LinkedList<>();
        expected.add(x);
        assertEquals(expected, apps.getChildren());
    }

    @Test
    public void verifyGetChildrenForBinInAlphabeticalComparator() {
        LinkedList<ApfsFSElement> expected = new LinkedList<>();
        expected.add(y);
        assertEquals(expected, bin.getChildren());
    }

    @Test
    public void verifyGetChildrenForHomeInAlphabeticalComparator() {
        LinkedList<ApfsFSElement> expected = new LinkedList<>();
        expected.add(c);
        expected.add(pictures);
        expected.add(xLink);
        assertEquals(expected, home.getChildren());
    }

    @Test
    public void verifyGetChildrenForHomeInReverseAlphabeticalComparator() {
        LinkedList<ApfsFSElement> expected = new LinkedList<>();
        expected.add(xLink);
        expected.add(pictures);
        expected.add(c);
        assertEquals(expected, home.getChildren(Comparator.comparing(ApfsFSElement::getName, Comparator.reverseOrder())));
    }

    @Test
    public void verifyGetSubDirectoriesForRootInAlphabeticalComparator() {
        LinkedList<ApfsDirectory> expected = new LinkedList<>();
        expected.add(apps);
        expected.add(bin);
        expected.add(home);
        assertEquals(expected, root.getSubDirectories());
    }

    @Test
    public void verifyGetSubDirectoriesForRootInReverseAlphabeticalComparator() {
        LinkedList<ApfsDirectory> expected = new LinkedList<>();
        expected.add(home);
        expected.add(bin);
        expected.add(apps);
        assertEquals(expected, root.getSubDirectories(Comparator.comparing(ApfsFSElement::getName, Comparator.reverseOrder())));
    }

    @Test
    public void verifyGetFilesForPicturesInAlphabeticalComparator() {
        LinkedList<ApfsFile> expected = new LinkedList<>();
        expected.add(a);
        expected.add(b);
        assertEquals(expected, pictures.getFiles());
    }

    @Test
    public void verifyGetFilesForPicturesInReverseAlphabeticalComparator() {
        LinkedList<ApfsFile> expected = new LinkedList<>();
        expected.add(b);
        expected.add(a);
        assertEquals(expected, pictures.getFiles(Comparator.comparing(ApfsFSElement::getName, Comparator.reverseOrder())));
    }

    @Test
    public void verifyGetFilesForPicturesInTimeStampComparator() {
        LinkedList<ApfsFile> expected = new LinkedList<>();
        expected.add(a);
        expected.add(b);
        assertEquals(expected, pictures.getFiles(Comparator.comparing(ApfsFSElement::getLastModifiedTime)));
    }

}
