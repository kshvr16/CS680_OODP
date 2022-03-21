package edu.umb.cs680.hw02;

public class Singleton {

    private static Singleton instance = null;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public static void main(String[] args) {
        System.out.println("Singleton Class has been implemented successfully!!!");
    }


}
