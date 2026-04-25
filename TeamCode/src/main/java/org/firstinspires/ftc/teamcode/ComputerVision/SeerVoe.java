package org.firstinspires.ftc.teamcode.ComputerVision;

import com.bylazar.configurables.annotations.Configurable;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
@Configurable
@TeleOp(name = "Servo Test")
public class SeerVoe extends LinearOpMode {
    public Servo servo;
    public static double val = 0;
    @Override
    public void runOpMode() throws InterruptedException {
        this.servo = hardwareMap.get(Servo.class, "servo");
        waitForStart();
        while (opModeIsActive()) {
           servo.setPosition(val);
        }
    }
}
