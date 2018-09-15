package org.firstinspires.ftc.teamcode.common;

import org.firstinspires.ftc.teamcode.drive.OmniDrive;
import org.firstinspires.ftc.teamcode.visual.VisualImpl;

/**
 * Created by Gregory on 9/10/18.
 */

public final class Config {
    public static final class Drive {
        public static OmniDrive NEW() {
            return new OmniDrive();
        }                        // FL––G––FR
        public static final String FRONT_LEFT = "front left";      // |U+   -R|
        public static final String BACK_RIGHT = "back right";      // J       |
        public static final String BACK_LEFT = "back left";        // |L+   -D|
        public static final String FRONT_RIGHT = "front right";    // BL-----BR
    }

    public static final class Visual {
        public static VisualImpl NEW() {
            return new VisualImpl();
        }
    }
}

