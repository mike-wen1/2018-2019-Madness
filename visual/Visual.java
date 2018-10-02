package org.firstinspires.ftc.teamcode.visual;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * Created by Gregory on 9/14/18.
 */

public abstract class Visual {
    public Telemetry telemetry;
    public abstract void init();
    public abstract void inspectFrame(boolean debug) throws InterruptedException;
    public abstract void stop();
}
