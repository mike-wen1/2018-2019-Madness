package org.firstinspires.ftc.teamcode.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Config;

@TeleOp
public class MineralScorer extends OpMode {
    private DcMotor armMotor;
    private DcMotor extensionMotor;

    public void init() {
        armMotor = hardwareMap.dcMotor.get(Config.Mineral.ARM_MOTOR);
        armMotor.resetDeviceConfigurationForOpMode();
        armMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        armMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        extensionMotor = hardwareMap.dcMotor.get(Config.Mineral.EXTENSION_MOTOR);
        extensionMotor.resetDeviceConfigurationForOpMode();
        extensionMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        extensionMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void loop() {
        if (gamepad1.dpad_down || gamepad2.dpad_down) {
            armMotor.setPower(1);
        }
        else if (gamepad1.dpad_up || gamepad2.dpad_up) {
            armMotor.setPower(-1);
        }
        else {
            armMotor.setPower(0);
        }
        if (gamepad1.right_trigger > 0.05 || gamepad2.right_trigger > 0.05) {
            if (gamepad2.right_trigger < 0.05) {
                extensionMotor.setPower(gamepad1.right_trigger);
            } else {
                extensionMotor.setPower(gamepad2.right_trigger);
            }
        }
        else if (gamepad1.left_trigger > 0.05 || gamepad2.left_trigger > 0.05) {
            if (gamepad2.left_trigger < 0.05) {
                extensionMotor.setPower(-gamepad1.left_trigger);
            } else {
                extensionMotor.setPower(-gamepad2.left_trigger);
            }
        }
        else {
            extensionMotor.setPower(0);
        }
    }
}
