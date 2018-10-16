package org.firstinspires.ftc.teamcode.lifter;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.common.Config;
import org.firstinspires.ftc.teamcode.drive.Drive;

/**
 * TankDrive: A simple Drive implementation for a tank-drive robot.
 *
 * Created by Gregory on 9/10/18.
 */

@TeleOp
public class LinearLift extends Lift {

    // Declare Motors
    // DO NOT assign them to anything yet because hardwareMap is not necessarily defined until init runs.
    private DcMotor winchThing;

    @Override
    public void init() {
        winchThing = hardwareMap.dcMotor.get(Config.Lift.WINCH_MOTOR);    // Retrieve the motor from the hardwareMap with the name set in the Config class
        winchThing.resetDeviceConfigurationForOpMode();                   // Reset the motor
        winchThing.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);          // Set the runMode
        winchThing.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE); // Set the motor to brake when stopped as opposed to coast.
        winchThing.setDirection(DcMotorSimple.Direction.REVERSE);         // Reverse the left motors because they are facing the opposite direction.
    }

    @Override
    public void loop() {
        winchThing.setPower(gamepad1.left_stick_y);

    }


}