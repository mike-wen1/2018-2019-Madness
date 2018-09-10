package org.firstinspires.ftc.teamcode.common;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * Created by Gregory on 9/10/18.
 */

public interface Assembly {
    // Initialize the motors and sensors required.
    // Please keep robot still while initializing.
    void init(HardwareMap hardwareMap, Telemetry telemetry);
}
