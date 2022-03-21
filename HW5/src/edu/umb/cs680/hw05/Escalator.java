package edu.umb.cs680.hw05;

public class Escalator {

    private State state;
    private static Escalator escalator = null;

    private Escalator(State state) {
        this.state = state;
    }

    public static Escalator getInstance() {
        if(escalator == null) {
            State state = Stopped.getInstance();
            escalator = new Escalator(state);
        }
        return escalator;
    }

    public State getState() {
        return state;
    }

    public void changeState(State newState) {
        state = newState;
    }

    public void startButtonPushed() {
        state.startButtonPushed();
    }

    public void stopButtonPushed() {
        state.stopButtonPushed();
    }

    public void motionDetected() {
        state.motionDetected();
    }

    public void motionNotDetected() {
        state.motionNotDetected();
    }

    public void moveSteps() {
        System.out.println("Escalator steps movement has started!!!");
    }

    public void stopSteps() {
        System.out.println("Escalator steps movement has stopped!!!");
    }

    public void enableSensor() {
        System.out.println("Escalator sensor has been enabled!!!");
    }

    public void disableSensor() {
        System.out.println("Escalator sensor has been disabled!!!");
    }

    public static void main(String[] args) {
        System.out.println("Escalator Class has been implemented successfully!!!");
    }

}
