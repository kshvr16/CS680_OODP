package edu.umb.cs680.hw08;

import edu.umb.cs680.hw08.APFS.ApfsDirectory;
import edu.umb.cs680.hw08.APFS.ApfsFSElement;
import edu.umb.cs680.hw08.APFS.ApfsFile;
import edu.umb.cs680.hw08.APFS.ApfsLink;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class ApfsLinkTest {

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
    public void verifyLinkX() {
        ApfsDirectory expected = home;
        ApfsFSElement actual = xLink.getTarget();
        assertEquals(expected, actual);
    }

    @Test
    public void verifyLinkY() {
        ApfsFile expected = y;
        ApfsFSElement actual = yLink.getTarget();
        assertEquals(expected, actual);
    }

}
