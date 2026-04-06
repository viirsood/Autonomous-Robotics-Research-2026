package org.firstinspires.ftc.teamcode.Filters;

public class LowPassFilter {
    private double lastState;
    private double currentState;
    public double alpha;
    public LowPassFilter(double value, double alpha) {
        this.currentState = value;
        lastState = currentState;
        this.alpha = alpha;
    }
    public void update(double value) {
        lastState = value;
        currentState = lastState + alpha * (currentState - lastState);
    }
    public double getAlpha(){return alpha;}
    public double getState(){return lastState;}
}
