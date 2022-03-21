package edu.umb.cs680.hw05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class EscalatorTest {

    @Test
    public void verifyEscalator() {
        Escalator escalator = Escalator.getInstance();

        State expected = Operating.getInstance();
        assertEquals(expected, escalator.getState());

        escalator.startButtonPushed();
        expected = Operating.getInstance();
        assertEquals(expected, escalator.getState());

        escalator.motionDetected();
        expected = Operating.getInstance();
        assertEquals(expected, escalator.getState());

        escalator.stopButtonPushed();
        expected = Stopped.getInstance();
        assertEquals(expected, escalator.getState());

    }

    @Test
    public void EscalatorStandByWhenStartButtonPressedWhileStopped() {
        Escalator escalatorTwo = Escalator.getInstance();
        escalatorTwo.startButtonPushed();
        State expected = Operating.getInstance();
        assertEquals(expected, escalatorTwo.getState());
    }

    @Test
    public void EscalatorOperatingWhenStartButtonPressedWhileStandBy() {
        Escalator escalatorThree = Escalator.getInstance();
        escalatorThree.changeState(StandBy.getInstance());
        escalatorThree.startButtonPushed();
        State expected = Operating.getInstance();
        assertEquals(expected, escalatorThree.getState());
    }

}
