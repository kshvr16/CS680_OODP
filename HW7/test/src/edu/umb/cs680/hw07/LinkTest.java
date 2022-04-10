package edu.umb.cs680.hw07;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class LinkTest {

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
        Directory expected = home;
        FSElement actual = xLink.getTarget();
        assertEquals(expected, actual);
    }

    @Test
    public void verifyLinkY() {
        File expected = y;
        FSElement actual = yLink.getTarget();
        assertEquals(expected, actual);
    }

}
