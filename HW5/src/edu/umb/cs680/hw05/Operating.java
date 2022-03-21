package edu.umb.cs680.hw05;

public class Operating implements State {

    private static Operating instance = null;

    private Operating() {
    }

    public static Operating getInstance() {
        if(instance == null) {
            instance = new Operating();
        }
        return instance;
    }

    public void startButtonPushed() {
        // Does Nothing
        System.out.println("Does Nothing when the state is in Operating and Start Button is pressed");
    }

    public void stopButtonPushed() {
        // Stops moving steps and disables the motion sensor
        // State changes to Stopped
        escalator.stopSteps();
        escalator.disableSensor();
        escalator.changeState(Stopped.getInstance());
    }

    public void motionDetected() {
        // Does Nothing
        System.out.println("Does Nothing when the state is in Operating and motion is detected");
    }

    public void motionNotDetected() {
        // Stops moving steps
        // State changes to StandBy
        escalator.stopSteps();
        escalator.changeState(StandBy.getInstance());
    }

}
