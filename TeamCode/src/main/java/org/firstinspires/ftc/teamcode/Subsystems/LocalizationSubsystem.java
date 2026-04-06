package org.firstinspires.ftc.teamcode.Subsystems;
import org.firstinspires.ftc.teamcode.Filters.KalmanFilter;
import org.firstinspires.ftc.teamcode.Filters.LowPassFilter;
import org.firstinspires.ftc.teamcode.HardwareRobot;

public class LocalizationSubsystem {
    public HardwareRobot hardwareRobot;
    public KalmanFilter kalmanFilter;
    public LowPassFilter lowPassFilter;
}
