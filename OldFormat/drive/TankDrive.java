package org.firstinspires.ftc.teamcode.OldFormat.drive;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.OldFormat.common.Config;

/**
 * TankDrive: A simple Drive implementation for a tank-drive robot.
 *
 * Created by Gregory on 9/10/18.
 */

@TeleOp
public class TankDrive extends Drive {

    // Declare Motors
    // DO NOT assign them to anything yet because hardwareMap is not necessarily defined until init runs.
    private DcMotor frontLeft;
    private DcMotor frontRight;
    private DcMotor backLeft;
    private DcMotor backRight;

    @Override
    public void init() {
        frontLeft = hardwareMap.dcMotor.get(Config.Drive.FRONT_LEFT);    // Retrieve the motor from the hardwareMap with the name set in the Config class
        frontLeft.resetDeviceConfigurationForOpMode();                   // Reset the motor
        frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);          // Set the runMode
        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE); // Set the motor to brake when stopped as opposed to coast.
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);         // Reverse the left motors because they are facing the opposite direction.

        backRight = hardwareMap.dcMotor.get(Config.Drive.BACK_RIGHT);
        backRight.resetDeviceConfigurationForOpMode();
        backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        backLeft = hardwareMap.dcMotor.get(Config.Drive.BACK_LEFT);
        backLeft.resetDeviceConfigurationForOpMode();
        backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        frontRight = hardwareMap.dcMotor.get(Config.Drive.FRONT_RIGHT);
        frontRight.resetDeviceConfigurationForOpMode();
        frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    @Override
    public void loop() {
        frontLeft.setPower(-gamepad1.right_stick_y);
        frontRight.setPower(-gamepad1.left_stick_y);
        backLeft.setPower(-gamepad1.right_stick_y);
        backRight.setPower(-gamepad1.left_stick_y);
    }

    @Override
    public void moveBot(int time, int speed) throws InterruptedException {

        frontLeft.setPower(-speed);
        frontRight.setPower(-speed);
        backLeft.setPower(-speed);
        backRight.setPower(-speed);
        Thread.sleep(time);
        frontRight.setPower(0);
        frontLeft.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
    }

    @Override
    public void turnBot(int time, int speed) throws InterruptedException {
        frontLeft.setPower(-speed);
        backLeft.setPower(-speed);
        frontRight.setPower(speed);
        backRight.setPower(speed);
        Thread.sleep(time);
        frontRight.setPower(0);
        frontLeft.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
    }

    @Override
    public void testMotors(int time, int speed) throws InterruptedException {
        frontLeft.setPower(speed);
        Thread.sleep(time);
        frontLeft.setPower(0);
        frontRight.setPower(speed);
        Thread.sleep(time);
        frontRight.setPower(0);
        backLeft.setPower(speed);
        Thread.sleep(time);
        backLeft.setPower(0);
        backRight.setPower(speed);
        Thread.sleep(time);
        backRight.setPower(0);
    }
}