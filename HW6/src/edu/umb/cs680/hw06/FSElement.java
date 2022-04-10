package edu.umb.cs680.hw06;

import java.time.LocalDateTime;

public class FSElement {

    protected String name;
    protected int size;
    protected LocalDateTime creationTime;
    protected Directory parent;

    public FSElement(Directory parent, String name, int size, LocalDateTime creationTime) {
        this.parent = parent;
        this.name = name;
        this.size = size;
        this.creationTime = creationTime;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public Directory getParent() {
        return parent;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public void setParent(Directory parent) {
        this.parent = parent;
    }

    public boolean isDirectory(){
        return false;
    }

    public boolean isFile() {
        return false;
    }

    public static void main(String[] args) {
        System.out.println("The FSElement class has been implemented Successfully");
    }

}
