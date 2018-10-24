package org.firstinspires.ftc.teamcode.OldFormat.visual;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * Created by Gregory on 9/14/18.
 */
@Disabled
public abstract class Visual {
    public Telemetry telemetry;
    public abstract void init();
    public abstract void inspectFrame(boolean debug) throws InterruptedException;
    public abstract void stop();
}
