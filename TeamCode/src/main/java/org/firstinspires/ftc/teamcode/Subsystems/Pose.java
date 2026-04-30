package org.firstinspires.ftc.teamcode.Subsystems;

public class Pose {
    public double x;
    public double y;
    public double h;
    public Pose(double x, double y, double h) {
        this.x = x;
        this.y = y;
        this.h = h;
    }
    public void setPose(double x, double y, double h) {
        this.x = x;
        this.y = y;
        this.h = h;
    }
    public double getX(){return x;}
    public double getY(){return x;}
    public double getH(){return x;}

}
