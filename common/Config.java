package org.firstinspires.ftc.teamcode.common;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.drive.TankDrive;
import org.firstinspires.ftc.teamcode.visual.VisualImpl;

/**
 * Created by Gregory on 9/10/18.
 */

public final class Config {
    public static ElapsedTime time = new ElapsedTime();
    public static final class Drive {
        public static TankDrive NEW(HardwareMap hardwareMap, Telemetry telemetry) {
            TankDrive a = new TankDrive();
            a.hardwareMap = hardwareMap;
            a.telemetry = telemetry;
            a.init();
            return a;
        }
        public static final String FRONT_LEFT = "front left";
        public static final String BACK_RIGHT = "back right";
        public static final String BACK_LEFT = "back left";
        public static final String FRONT_RIGHT = "front right";
    }

    public static final class Visual {
        public static VisualImpl NEW(HardwareMap hardwareMap, Telemetry telemetry) {
            VisualImpl a = new VisualImpl();
            a.telemetry = telemetry;
            a.init();
            return a;
        }
    }
}

