package edu.umb.cs680.hw12.APFS;

import java.util.Comparator;

public class TimeStampComparator implements Comparator<ApfsFSElement> {

    public int compare(ApfsFSElement objectOne, ApfsFSElement objectTwo) {
        return objectTwo.getLastModifiedTime().compareTo(objectOne.getLastModifiedTime());
    }

}
