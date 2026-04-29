package org.firstinspires.ftc.teamcode.Control;

import com.pedropathing.util.Timer;

import org.firstinspires.ftc.teamcode.MotionProfiles.MotionProfile;
import org.firstinspires.ftc.teamcode.MotionProfiles.PathChain;
import org.firstinspires.ftc.teamcode.RobotSystem;

import java.util.Arrays;
import java.util.List;

public class Follower {
    // the core idea here is that we can profile the robot's velocity when following a specified path of motin
    // which is defined by the bezier curves.
    // Following a velocity and acceleration profile - this class
    // following a position curve -
    public PathChain currentPath;
    public static int idx = 0;
    public double kS;
    public double kA;
    public double kV;
    public RobotSystem robot;
    public Timer t;
    public static double dt;
    public Follower(PathChain currentPath, double kV, double kA, double kS, RobotSystem robot) {
        this.kV = kV;
        this.kA = kA;
        this.kS = kS;
        this.currentPath = currentPath;
        this.robot = robot;
        this.t = new Timer();
        dt = 0;
    }

    public void follow() {
        MotionProfile prof = currentPath.profiles.get(idx);
        boolean isDone = false;
        double[] values = prof.profile();
        double power = calculate(values);
        robot.drive.driveRobotCentricPowers(power, 0,0);
        isDone = prof.t.getElapsedTimeSeconds() >= prof.tTotal;
        if (isDone) idx++;
    }

    public double calculate(double[] vals) {
        double p = vals[0];
        double v = vals[1];
        double a = vals[2];
        return kS * (1/v) + kA * a + kV * v;
    }
    public void setPath(PathChain path) {currentPath = path;}
}
