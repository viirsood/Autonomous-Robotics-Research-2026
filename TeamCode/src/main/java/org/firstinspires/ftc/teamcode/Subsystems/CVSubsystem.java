package org.firstinspires.ftc.teamcode.Subsystems;

import android.graphics.Camera;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.hardware.camera.controls.ExposureControl;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;
import org.firstinspires.ftc.vision.VisionPortal;

import android.graphics.Color;
import android.util.Size;

import com.acmerobotics.roadrunner.util.Angle;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;
import org.openftc.easyopencv.OpenCvPipeline;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CVSubsystem {
    public VisionPortal vp;
    public AprilTagProcessor aprilTagProcessor;
    private final Size CAMERA_RESOLUTION = new Size(640, 480);
    public CVSubsystem (WebcamName cameraName, LinearOpMode opMode, int viewcontainerid) {
        this.aprilTagProcessor = new AprilTagProcessor.Builder()
                .setDrawAxes(true)
                .setDrawTagID(true)
                .setDrawTagOutline(true)
                .setDrawCubeProjection(true)
                .build();
        this.vp = new VisionPortal.Builder()
                .setCamera(cameraName)
                .enableLiveView(true)
                .setCameraResolution(CAMERA_RESOLUTION)
                .addProcessor(aprilTagProcessor)
                .setAutoStartStreamOnBuild(true)
                .setStreamFormat(VisionPortal.StreamFormat.YUY2)
                .setLiveViewContainerId(viewcontainerid)
                .build();
        vp.setProcessorEnabled(aprilTagProcessor, true);
        while ((opMode.opModeInInit() || opMode.opModeIsActive()) && vp.getCameraState() != VisionPortal.CameraState.STREAMING);

        updateExposure(vp);
    }
    public void updateExposure(VisionPortal visionPortal) {
        ExposureControl exposureControl = visionPortal.getCameraControl(ExposureControl.class);
        exposureControl.setMode(ExposureControl.Mode.Manual);
        exposureControl.setExposure(15, TimeUnit.MILLISECONDS);  //adjust
    }
    public List<AprilTagDetection> getDetections() {
        List<AprilTagDetection> detections = aprilTagProcessor.getDetections();
        return detections;
    }
    public Pose2D aprilTagPose() {
        List<AprilTagDetection> detections = getDetections();
        if (detections.isEmpty()) return null;
        AprilTagDetection tag = detections.get(0);
        return new Pose2D(DistanceUnit.INCH, tag.robotPose.getPosition().x + 72, tag.robotPose.getPosition().y + 72, AngleUnit.DEGREES, tag.robotPose.getOrientation().getYaw(AngleUnit.DEGREES));
    }
}