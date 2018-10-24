package org.firstinspires.ftc.teamcode.OldFormat.marker;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

@Disabled
public abstract class Marker extends OpMode {
    public abstract void init();
    public abstract void dropMarker();
    public abstract void holdMarker();
}
