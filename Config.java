package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.OldFormat.visual.VisualImpl;

/**
 * Config: Configuration file to hold Motor Names and the current implementations of an assembly
 *
 * Create a new static final class for every assembly.
 * Ensure each Assembly class has a static NEW method that returns the active implementation as shown below.
 *
 * Created by Gregory on 9/10/18.
 */

public final class Config {
    public static final class Drive {     // Drive Assembly Configuration
        // Motor Constants
        public static final String FRONT_LEFT = "front left";
        public static final String BACK_RIGHT = "back right";
        public static final String BACK_LEFT = "back left";
        public static final String FRONT_RIGHT = "front right";
    }

    public static final class Mineral {

        // Motor Constant
        public static final String ARM_MOTOR = "arm motor";
    }

    public static final class Lift {

        // Motor Constant
        public static final String WINCH_MOTOR = "winch motor";
    }

    public static final class Marker {
        public static final String MARKER_SERVO = "marker servo";
    }

    public static final class Visual {    // Visual Assembly Configuration
        public static VisualImpl NEW(HardwareMap hardwareMap, Telemetry telemetry) { // Same as Drive, but doesn't require a HardwareMap.
            VisualImpl a = new VisualImpl(); // Create it
            a.telemetry = telemetry;         // Set the Hardware Map
            a.init();                        // Initialize
            return a;
        }
    }
}

