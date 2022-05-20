package edu.umb.cs680.hw12.APFS;

import java.util.Comparator;

public class AlphabeticalComparator implements Comparator<ApfsFSElement> {

    public int compare(ApfsFSElement objectOne, ApfsFSElement objectTwo) {
        return objectOne.getName().compareTo(objectTwo.getName());
    }

}
