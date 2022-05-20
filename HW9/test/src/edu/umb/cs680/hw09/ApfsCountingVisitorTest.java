package edu.umb.cs680.hw09;

import edu.umb.cs680.hw09.apfs.ApfsDirectory;
import edu.umb.cs680.hw09.apfs.ApfsFile;
import edu.umb.cs680.hw09.apfs.ApfsLink;
import edu.umb.cs680.hw09.apfs.util.ApfsCountingVisitor;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class ApfsCountingVisitorTest {

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
    public void verifyVisitorForRoot() {
        ApfsCountingVisitor visitor = new ApfsCountingVisitor();
        root.accept(visitor);
        assertEquals(5,visitor.getDirNumber());
        assertEquals(5,visitor.getFileNumber());
        assertEquals(2,visitor.getLinkNumber());
    }

    @Test
    public void verifyVisitorForHome() {
        ApfsCountingVisitor visitor = new ApfsCountingVisitor();
        home.accept(visitor);
        assertEquals(2,visitor.getDirNumber());
        assertEquals(3,visitor.getFileNumber());
        assertEquals(2,visitor.getLinkNumber());
    }
    @Test
    public void verifyVisitorForBin() {
        ApfsCountingVisitor visitor = new ApfsCountingVisitor();
        bin.accept(visitor);
        assertEquals(1,visitor.getDirNumber());
        assertEquals(1,visitor.getFileNumber());
        assertEquals(0,visitor.getLinkNumber());
    }

}
