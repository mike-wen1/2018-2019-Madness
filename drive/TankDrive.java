package org.firstinspires.ftc.teamcode.drive;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.common.AbstractAssembly;
import org.firstinspires.ftc.teamcode.common.Config;

/**
 * Created by Gregory on 9/10/18.
 */

public class TankDrive extends AbstractAssembly implements Drive {
    public DcMotor[] motors = new DcMotor[7];

    public static int FRONT_LEFT = 2;
    public static int BACK_RIGHT = 3;
    public static int BACK_LEFT = 4;
    public static int FRONT_RIGHT = 5;
    
    @Override
    public void init() {
        motors[FRONT_LEFT] = hardwareMap.dcMotor.get(Config.Drive.FRONT_LEFT);
        motors[FRONT_LEFT].resetDeviceConfigurationForOpMode();
        motors[FRONT_LEFT].setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motors[FRONT_LEFT].setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        motors[BACK_RIGHT] = hardwareMap.dcMotor.get(Config.Drive.BACK_RIGHT);
        motors[BACK_RIGHT].resetDeviceConfigurationForOpMode();
        motors[BACK_RIGHT].setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motors[BACK_RIGHT].setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        motors[BACK_LEFT] = hardwareMap.dcMotor.get(Config.Drive.BACK_LEFT);
        motors[BACK_LEFT].resetDeviceConfigurationForOpMode();
        motors[BACK_LEFT].setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motors[BACK_LEFT].setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        motors[FRONT_RIGHT] = hardwareMap.dcMotor.get(Config.Drive.FRONT_RIGHT);
        motors[FRONT_RIGHT].resetDeviceConfigurationForOpMode();
        motors[FRONT_RIGHT].setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motors[FRONT_RIGHT].setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
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
