package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.OldFormat.visual.VisualImpl;

public final class Config {
    public static final class Drive {
        public static final String FRONT_LEFT = "front left";
        public static final String BACK_RIGHT = "back right";
        public static final String BACK_LEFT = "back left";
        public static final String FRONT_RIGHT = "front right";
    }

    public static final class Mineral {
        public static final String ARM_MOTOR = "arm motor";
    }

    public static final class Lift {
        public static final String WINCH_MOTOR = "winch motor";
    }

    public static final class Marker {
        public static final String MARKER_SERVO = "marker servo";
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

