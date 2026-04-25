package org.firstinspires.ftc.teamcode.Control;

import com.pedropathing.util.Timer;

import org.firstinspires.ftc.teamcode.MotionProfiles.PathChain;
import org.firstinspires.ftc.teamcode.RobotSystem;

public class Follower {
    public PathChain currentPath;
    public double kS;
    public double kA;
    public double kV;
    public RobotSystem robot;
    public Timer t;
    public Follower(PathChain currentPath, double kV, double kA, double kS, RobotSystem robot) {
        this.kV = kV;
        this.kA = kA;
        this.kS = kS;
        this.currentPath = currentPath;
        this.robot = robot;
        this.t = new Timer();
    }
    public void follow() {

    }
    public void calculate() {

    }
    public void setPath(PathChain path) {currentPath = path;}
}
