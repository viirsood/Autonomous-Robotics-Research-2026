package org.firstinspires.ftc.teamcode.MotionProfiles;


import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.pedropathing.util.Timer;

public class MotionProfile {
    public Timer t;
    public double tTotal;
    public MotionProfile(Timer t, double ttot) {
        this.t = new Timer();
        tTotal = ttot;
    }
    public double[] profile() {
        return new double[]{0.0};
    }
}
