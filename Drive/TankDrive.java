package org.tka.robotics.Drive;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Predicate;

/**
 * Created by Gregory on 9/10/18.
 */

public class TankDrive extends AbstractDrive implements Drive {

    @Override
    protected void init(HardwareMap hardwareMap) {

    }

    @Override
    protected void loop(Gamepad gamepad1, Gamepad gamepad2, double time) {

    }

    @Override
    public void moveDRS(int direction, int rotation, double speed, Predicate<Drive> condition) {

    }

    @Override
    public void moveDRS(int direction, int rotation, double speed, long distance) {

    }
}
