package org.firstinspires.ftc.teamcode.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.Config;

@TeleOp
public class LinearLift extends OpMode {

    private DcMotor winchMotor;

    public void init() {
        winchMotor = hardwareMap.dcMotor.get(Config.Lift.WINCH_MOTOR);
        winchMotor.resetDeviceConfigurationForOpMode();
        winchMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        winchMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        winchMotor.setDirection(DcMotorSimple.Direction.REVERSE);
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