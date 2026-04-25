package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.sparkfun.SparkFunOTOS;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;
import org.firstinspires.ftc.teamcode.Subsystems.CVSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.LocalizationSubsystem;

public class RobotSystem {
    public HardwareRobot hardwareRobot;
    public DriveSubsystem drive;
    public LocalizationSubsystem local;
    public CVSubsystem cv;
    public RobotSystem(HardwareMap hardwareMap, LinearOpMode opMode) {
        this.hardwareRobot = new HardwareRobot(hardwareMap);
        this.drive = new DriveSubsystem(hardwareRobot.leftFront, hardwareRobot.rightFront, hardwareRobot.leftBack, hardwareRobot.rightBack);
        this.cv = new CVSubsystem(hardwareRobot.webcam, opMode, 3);
        this.local = new LocalizationSubsystem(opMode, hardwareMap, 1, 1, 1, 1, new Pose2D(DistanceUnit.INCH, 1, 1, AngleUnit.DEGREES, 30));
    }
}
