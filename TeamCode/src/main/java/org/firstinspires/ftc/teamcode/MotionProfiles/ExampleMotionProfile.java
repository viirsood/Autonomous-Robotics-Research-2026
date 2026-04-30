package org.firstinspires.ftc.teamcode.MotionProfiles;

import com.pedropathing.util.Timer;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Control.Follower;
import org.firstinspires.ftc.teamcode.RobotSystem;

import java.util.Arrays;

@TeleOp(name = "Test")
public class ExampleMotionProfile extends LinearOpMode {
    public RobotSystem robot;
    public MotionProfile cruise;
    public MotionProfile accelerate;
    public PathChain path;
    public Follower follower;
    @Override
    public void runOpMode() throws InterruptedException {
        this.robot = new RobotSystem(hardwareMap, this);
        this.follower = new Follower(path, 0.01, 0.1, 0.05, robot);
        follower.setPath(path);
        waitForStart();
        while (opModeIsActive()) {
            follower.follow();
        }
    }
    public void initProfiles() {
        accelerate = new LinearMotionProfile(new Timer(), 6, 9);
        cruise = new TrapezoidalMotionProfile(1,5,3,5,new Timer(), 9);
    }
    public void initPaths() {
        path = new PathChain(Arrays.asList(cruise, accelerate));
    }
}
