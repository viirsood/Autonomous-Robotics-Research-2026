package org.firstinspires.ftc.teamcode.MotionProfiles;

import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.pedropathing.util.Timer;

public class LinearMotionProfile extends MotionProfile {
    public double maxV;
    public Timer derivative;
    public double lastVelocity;
    double position = 0;
    public LinearMotionProfile(Timer t, double ttot, double vmax) {
        super(t, ttot);
        this.maxV = vmax;
        this.derivative = new Timer();
        lastVelocity = 0;
    }
    @Override
    public double[] profile() {
        double acceleration = maxV / tTotal;
        double velocity = acceleration * t.getElapsedTimeSeconds();
        double dt = derivative.getElapsedTimeSeconds();
        derivative.resetTimer();
        position += (velocity - lastVelocity) * dt;
        lastVelocity = velocity;
        return new double[]{position, velocity, acceleration};
    }
}
