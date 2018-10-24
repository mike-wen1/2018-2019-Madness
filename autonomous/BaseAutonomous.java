package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Config;

public class BaseAutonomous extends LinearOpMode {
    private DcMotor frontLeft;
    private DcMotor frontRight;
    private DcMotor backLeft;
    private DcMotor backRight;
    private DcMotor winchMotor;

    private Servo servo;

    public void runOpMode() {}

    void initialize() {
        frontLeft = hardwareMap.dcMotor.get(Config.Drive.FRONT_LEFT);
        frontLeft.resetDeviceConfigurationForOpMode();
        frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);

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

        winchMotor = hardwareMap.dcMotor.get(Config.Lift.WINCH_MOTOR);
        winchMotor.resetDeviceConfigurationForOpMode();
        winchMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        winchMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        winchMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        servo = hardwareMap.servo.get(Config.Marker.MARKER_SERVO);
    }

    void moveBot(int time, int speed)  {
        frontLeft.setPower(-speed);
        frontRight.setPower(-speed);
        backLeft.setPower(-speed);
        backRight.setPower(-speed);
        sleep(time);
        frontRight.setPower(0);
        frontLeft.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
    }

    void turnBot(int time, int speed)  {
        frontLeft.setPower(-speed);
        backLeft.setPower(-speed);
        frontRight.setPower(speed);
        backRight.setPower(speed);
        sleep(time);
        frontRight.setPower(0);
        frontLeft.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
    }

    void testMotors(int time, int speed)  {
        frontLeft.setPower(speed);
        sleep(time);
        frontLeft.setPower(0);
        frontRight.setPower(speed);
        sleep(time);
        frontRight.setPower(0);
        backLeft.setPower(speed);
        sleep(time);
        backLeft.setPower(0);
        backRight.setPower(speed);
        sleep(time);
        backRight.setPower(0);
    }

    void lowerRobot(){
        winchMotor.setPower(-1);
        sleep(500);
        winchMotor.setPower(0);
    }

    void holdMarker() { servo.setPosition(0); }

    void dropMarker() { servo.setPosition(1); }

}
