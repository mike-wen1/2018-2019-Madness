package org.firstinspires.ftc.teamcode.OldFormat.common;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.OldFormat.drive.TankDrive;
import org.firstinspires.ftc.teamcode.OldFormat.lifter.LinearLift;
import org.firstinspires.ftc.teamcode.OldFormat.marker.TeamMarker;
import org.firstinspires.ftc.teamcode.OldFormat.mineral.MineralScorer;
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
        public static TankDrive NEW(HardwareMap hardwareMap, Telemetry telemetry) { // Return a TankDrive as the current Drive
            TankDrive a = new TankDrive(); // Create it
            a.hardwareMap = hardwareMap;   // Set the Hardware Map
            a.telemetry = telemetry;       // Set the telemetry
            a.init();                      // Initialize
            return a;
        }

        // Motor Constants
        public static final String FRONT_LEFT = "front left";
        public static final String BACK_RIGHT = "back right";
        public static final String BACK_LEFT = "back left";
        public static final String FRONT_RIGHT = "front right";
    }

    public static final class Mineral {
        public static MineralScorer NEW(HardwareMap hardwareMap, Telemetry telemetry) {
            MineralScorer a = new MineralScorer();
            a.hardwareMap = hardwareMap;
            a.telemetry = telemetry;
            a.init();
            return a;
        }

        // Motor Constant
        public static final String ARM_MOTOR = "arm motor";
    }

    public static final class Lift {
        public static LinearLift NEW(HardwareMap hardwareMap, Telemetry telemetry) {
            LinearLift a = new LinearLift();
            a.hardwareMap = hardwareMap;
            a.telemetry = telemetry;
            a.init();
            return a;
        }

        // Motor Constant
        public static final String WINCH_MOTOR = "winch motor";
    }

    public static final class Marker {
        public static TeamMarker NEW(HardwareMap hardwareMap, Telemetry telemetry) {
            TeamMarker a = new TeamMarker();
            a.hardwareMap = hardwareMap;
            a.telemetry = telemetry;
            a.init();
            return a;
        }

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

