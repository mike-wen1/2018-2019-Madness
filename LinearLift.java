package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;




@TeleOp
public class LinearLift extends OpMode {

    // Declare Motors
    // DO NOT assign them to anything yet because hardwareMap is not necessarily defined until init runs.
    private DcMotor winchMotor;


    public void init() {
        winchMotor = hardwareMap.dcMotor.get(Config.Lift.WINCH_MOTOR);    // Retrieve the motor from the hardwareMap with the name set in the Config class
        winchMotor.resetDeviceConfigurationForOpMode();                   // Reset the motor
        winchMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);          // Set the runMode
        winchMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE); // Set the motor to brake when stopped as opposed to coast.
        winchMotor.setDirection(DcMotorSimple.Direction.REVERSE);         // Reverse the left motors because they are facing the opposite direction.
    }

    public void lowerRobot(){
        winchMotor.setPower(-1);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        winchMotor.setPower(0);
    }

    public void loop() {
        if (gamepad1.left_bumper){
            winchMotor.setPower(1);
        }
        else if (gamepad1.right_bumper){
            winchMotor.setPower(-1);
        }
        else {
            winchMotor.setPower(0);
        }
    }


}