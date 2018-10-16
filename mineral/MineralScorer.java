package org.firstinspires.ftc.teamcode.mineral;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.common.Config;

@TeleOp
public class MineralScorer extends Mineral {
    private DcMotor armMotor;

    @Override
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
