package edu.umb.cs680.hw02;

import edu.umb.cs680.hw02.Singleton;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SingletonTest {

    @Test
    public void getInstanceReturnsNonNull() {
        assertNotNull(Singleton.getInstance());
    }

    @Test
    public void getInstanceReturnsIdenticalInstance() {
        Singleton instanceOne = Singleton.getInstance();
        Singleton instanceTwo = Singleton.getInstance();
        Singleton instanceThree = Singleton.getInstance();
        assertEquals(instanceOne.hashCode(), instanceTwo.hashCode());
        assertSame(instanceTwo, instanceThree);
    }
}
