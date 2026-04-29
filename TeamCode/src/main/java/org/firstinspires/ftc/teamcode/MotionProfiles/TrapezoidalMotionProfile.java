package org.firstinspires.ftc.teamcode.MotionProfiles;

import com.pedropathing.util.Timer;

public class TrapezoidalMotionProfile extends MotionProfile {
    //check for correct integration.
    public double tCruise;
    public double vMax;
    public double t1;
    public double t2;
    public Timer t;
    public Timer deriv;
    public static double dv = 0;
    public double lastVelocity = 0;
    public TrapezoidalMotionProfile(double t1, double vmax, double tCruise, double t2, Timer t, double ttot) {
        super(t, ttot);
        this.t1 = t1;
        this.t2 = t2;
        this.vMax = vmax;
        this.tCruise = tCruise;
        this.deriv = new Timer();
        tTotal = t1 + t2 + tCruise;
        deriv.resetTimer();
    }
    @Override
    public double[] profile() {
        double velocity = 0;
        double acceleration = 0;
        double position = 0;
        double time = t.getElapsedTimeSeconds();
        double dt = deriv.getElapsedTimeSeconds();
        dv = lastVelocity - velocity;
        deriv.resetTimer();
        if (time < t1) {
            acceleration = (vMax) / t1;
            velocity = t.getElapsedTimeSeconds() * acceleration;
            position += dt * dv;
        } else if (time >= t1 && time <= t1 + tCruise) {
            velocity = vMax;
            acceleration = 0;
            position += dt * dv;
        } else if (time > t1 + tCruise) {
            velocity = - (vMax / (t2)) * (t.getElapsedTimeSeconds() - t2 - tCruise - t1);
            acceleration = (vMax) / t2;
            position += dt * dv;
        }
        lastVelocity = velocity;
        return new double[]{position, velocity, acceleration};
    }
}
