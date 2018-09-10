package org.firstinspires.ftc.teamcode.common;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * Created by Gregory on 9/10/18.
 */

public abstract class AbstractAssembly extends OpMode implements Assembly {
    public void init(HardwareMap hardwareMap, Telemetry telemetry) {
        this.hardwareMap = hardwareMap;
        this.telemetry = telemetry;
        init();
    }

    public void loop(Gamepad gamepad1, Gamepad gamepad2, double time) {
        this.gamepad1 = gamepad1;
        this.gamepad2 = gamepad2;
        this.time = time;
    }

}
