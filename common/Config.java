package org.firstinspires.ftc.teamcode.common;

import org.firstinspires.ftc.teamcode.drive.TankDrive;
import org.firstinspires.ftc.teamcode.visual.VisualImpl;

/**
 * Created by Gregory on 9/10/18.
 */

public final class Config {
    public static final class Drive {
        public static TankDrive NEW() {
            return new TankDrive();
        }
        public static final String FRONT_LEFT = "front left";
        public static final String BACK_RIGHT = "back right";
        public static final String BACK_LEFT = "back left";
        public static final String FRONT_RIGHT = "front right";
    }

    public static final class Visual {
        public static VisualImpl NEW() {
            return new VisualImpl();
        }
    }
}

