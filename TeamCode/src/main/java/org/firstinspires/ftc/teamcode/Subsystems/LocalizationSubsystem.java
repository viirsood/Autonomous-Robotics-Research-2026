package org.firstinspires.ftc.teamcode.Subsystems;
import com.acmerobotics.roadrunner.util.Angle;
import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;
import org.firstinspires.ftc.robotcore.external.navigation.Pose3D;
import org.firstinspires.ftc.teamcode.Filters.KalmanFilter;
import org.firstinspires.ftc.teamcode.Filters.LowPassFilter;
import org.firstinspires.ftc.teamcode.HardwareRobot;

public class LocalizationSubsystem {
    public HardwareRobot hardwareRobot;
    public CVSubsystem cv;
    public KalmanFilter kalmanFilter;
    public LowPassFilter lowPassFilter;
    public double rX;
    public double rY;
    public double rH;
    public Pose2D pose;
    public GoBildaPinpointDriver pinpoint;
    public LocalizationSubsystem(LinearOpMode opmode, HardwareMap hardwareMap, double variance, double covariance, double startlowpass, double alpha, Pose2D startPose) {
        this.hardwareRobot = new HardwareRobot(hardwareMap);
        this.kalmanFilter = new KalmanFilter(variance, covariance);
        this.lowPassFilter = new LowPassFilter(startlowpass, alpha);
        this.pose = startPose;
        rX = pose.getX(DistanceUnit.INCH);
        rY = pose.getY(DistanceUnit.INCH);
        rH = pose.getHeading(AngleUnit.DEGREES);
        this.pinpoint = hardwareRobot.pinpoint;
        //update viewcontainer
        this.cv = new CVSubsystem(hardwareRobot.webcam, opmode, 3);
        initOdom();
    }
    //Tune orientation and offsets
    public void initOdom() {
        pinpoint.resetPosAndIMU();
        pinpoint.setEncoderResolution(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD);
        pinpoint.setEncoderDirections(GoBildaPinpointDriver.EncoderDirection.FORWARD, GoBildaPinpointDriver.EncoderDirection.FORWARD);
        pinpoint.setOffsets(1, 1, DistanceUnit.INCH);
        pinpoint.setPosition(new Pose2D(DistanceUnit.INCH, pose.getX(DistanceUnit.INCH), pose.getY(DistanceUnit.INCH), AngleUnit.DEGREES, pose.getHeading(AngleUnit.DEGREES)));
        pinpoint.setHeading(pose.getHeading(AngleUnit.DEGREES), AngleUnit.DEGREES);
    }
    public void update() {
        //use kalman with april tag and low pass on heading data

    }
    public double getX() {return rX;}
    public double getY(){return rY;}
    public double getH(){return rH;}
}
