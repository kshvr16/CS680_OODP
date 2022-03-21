package edu.umb.cs680.hw05;

public class Stopped implements State {

    private static Stopped instance = null;

    private Stopped() {

    }

    public static Stopped getInstance() {
        if(instance == null) {
            instance = new Stopped();
        }
        return instance;
    }

    public void startButtonPushed() {
        // Enables the motion sensor and stand-by
        // State changes to StandBy
        escalator.enableSensor();
        escalator.changeState(StandBy.getInstance());
    }

    public void stopButtonPushed() {
        // Does Nothing
        System.out.println("Does Nothing when the state is in Stopped and stop button is pushed");
    }

    public void motionDetected() {
        // Does Nothing
        System.out.println("Does Nothing when the state is in Stopped and motion is detected");
    }

    public void motionNotDetected() {
        // Does Nothing
        System.out.println("Does Nothing when the state is in Stopped and motion is not detected");
    }

}
