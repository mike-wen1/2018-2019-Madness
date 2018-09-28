package org.firstinspires.ftc.teamcode.drive;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.common.AbstractAssembly;
import org.firstinspires.ftc.teamcode.common.Config;

/**
 * Created by Gregory on 9/10/18.
 */

public class TankDrive extends AbstractAssembly implements Drive {
    private DcMotor frontLeftMotor;
    private DcMotor frontRightMotor;
    private DcMotor backLeftMotor;
    private DcMotor backRightMotor;
    
    @Override
    public void init() {
        frontLeftMotor = hardwareMap.dcMotor.get(Config.Drive.FRONT_LEFT);
        frontLeftMotor.resetDeviceConfigurationForOpMode();
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        frontRightMotor = hardwareMap.dcMotor.get(Config.Drive.BACK_RIGHT);
        frontRightMotor.resetDeviceConfigurationForOpMode();
        frontRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        backLeftMotor = hardwareMap.dcMotor.get(Config.Drive.BACK_LEFT);
        backLeftMotor.resetDeviceConfigurationForOpMode();
        backLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        backRightMotor = hardwareMap.dcMotor.get(Config.Drive.FRONT_RIGHT);
        backRightMotor.resetDeviceConfigurationForOpMode();
        backRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    @Override
    public void loop() {

    }

    @Override
    public void move() {
        
    }

    @Override
    public void moveBot() {

    }
}
