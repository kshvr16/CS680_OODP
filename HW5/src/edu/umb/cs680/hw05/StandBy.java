package edu.umb.cs680.hw05;

public class StandBy implements State {

    private static StandBy instance = null;

    private StandBy() {

    }

    public static StandBy getInstance() {
        if(instance == null) {
            instance = new StandBy();
        }
        return instance;
    }

    public void startButtonPushed() {
        // Starts moving steps
        // State changes to Operating
        escalator.moveSteps();
        escalator.changeState(Operating.getInstance());
    }

    public void stopButtonPushed() {
        // Disables the motion sensor and stops the escalator moving
        // State changes to Stopped
        escalator.disableSensor();
        escalator.stopSteps();
        escalator.changeState(Stopped.getInstance());
    }

    public void motionDetected() {
        // Starts moving steps
        // State changes to Operating
        escalator.moveSteps();
        escalator.changeState(Operating.getInstance());
    }

    public void motionNotDetected() {
        // Does Nothing
        System.out.println("Does Nothing when the state is in StandBy and motion is not detected");
    }

}
