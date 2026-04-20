package org.firstinspires.ftc.teamcode.Control;


import com.pedropathing.util.Timer;

public class PIDFController {
    public Timer t;
    public double kP;
    public double kD;
    public double kI;
    public double kF;
    public double et;
    public double lastEt;
    public double sp;
    double dt;
    public double integral;
    public double lastT;
    public PIDFController(double kP, double kD, double kI, double setpoint, double kF) {
        this.kP = kP;
        this.kD = kD;
        this.kI = kI;
        this.kF = kF;
        t = new Timer();
        et = 0;
        lastEt = 0;
        sp = setpoint;
        dt = 0;
        integral = 0;
        lastT = t.getElapsedTimeSeconds();
    }
    public void update(double measurement) {
        et = measurement - sp;
        dt = t.getElapsedTimeSeconds() - lastT;
        integral += et * dt;
    }
    public double calculate(double refAngle) {
        double p = et * kP + ((et - lastEt) / dt) * kD + integral * kI + kF * Math.cos(refAngle);
        return p;
    }
    public void updateVariables() {
        lastEt = et;
        lastT = t.getElapsedTimeSeconds();
    }
    public void resetTimer(){t.resetTimer();}
    public double getkP(){return kP;}
    public double getkD(){return kD;}
    public double getkI(){return kI;}
    public void setkP(double val){kP = val;}
    public void setkD(double val){kD = val;}
    public void setkI(double val){kI = val;}
}
