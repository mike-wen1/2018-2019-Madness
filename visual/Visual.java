package org.firstinspires.ftc.teamcode.visual;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * Created by Gregory on 9/14/18.
 */

public interface Visual {
    void init(Telemetry telemetry);
    void inspectFrame(boolean debug) throws InterruptedException;
    void stop();
}
