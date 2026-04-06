package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Subsystems.CVSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.DriveSubsystem;

public class RobotSystem {
    public HardwareRobot hardwareRobot;
    public DriveSubsystem drive;
    public LocalizationSubsystem local;
    public CVSubsystem cv;
    public RobotSystem(HardwareMap hardwareMap) {
        this.hardwareRobot = new HardwareRobot(hardwareMap);
        this.drive = new DriveSubsystem(hardwareRobot.leftFront, hardwareRobot.rightFront, hardwareRobot.leftBack, hardwareRobot.rightBack);

    }
}
