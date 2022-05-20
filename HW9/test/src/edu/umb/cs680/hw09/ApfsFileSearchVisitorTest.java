package edu.umb.cs680.hw09;

import edu.umb.cs680.hw09.apfs.ApfsDirectory;
import edu.umb.cs680.hw09.apfs.ApfsFile;
import edu.umb.cs680.hw09.apfs.ApfsLink;
import edu.umb.cs680.hw09.apfs.util.ApfsFileSearchVisitor;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class ApfsFileSearchVisitorTest {

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
                Integer.toString(file.getSize()), file.getCreationTime().toString(),
                file.getOwnerName(), file.getLastModifiedTime().toString()};

        return fileInfo;
    }

    @Test
    public void checkFileA() {
        ApfsFileSearchVisitor visitor = new ApfsFileSearchVisitor("a");
        String[] expected = { "true", "a", "pictures", "20", localTime.toString(), "S.Kona001", localTime.toString() };
        root.accept(visitor);
        ApfsFile actual = visitor.getFoundFiles().get(0);
        System.out.println(fileToStringArray(actual));
        assertArrayEquals(expected, fileToStringArray(actual));
    }

    @Test
    public void checkFileB() {
        ApfsFileSearchVisitor visitor = new ApfsFileSearchVisitor("b");
        String[] expected = { "true", "b", "pictures", "20", localTime.toString(), "S.Kona001", localTime.toString() };
        root.accept(visitor);
        ApfsFile actual = visitor.getFoundFiles().get(0);
        System.out.println(fileToStringArray(actual));
        assertArrayEquals(expected, fileToStringArray(actual));
    }
}
