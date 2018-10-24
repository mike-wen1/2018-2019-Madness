package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


@TeleOp
public class MineralScorer extends OpMode {
    public DcMotor armMotor;

    public void init() {
        armMotor = hardwareMap.dcMotor.get(Config.Mineral.ARM_MOTOR);
        armMotor.resetDeviceConfigurationForOpMode();
        armMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        armMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void loop() {
        if (gamepad1.dpad_down) {
            armMotor.setPower(-1);
        }
        else if (gamepad1.dpad_up) {
            armMotor.setPower(1);
        }
        else {
            armMotor.setPower(0);
        }
    }
}
