package org.firstinspires.ftc.teamcode.visual;

/**
 * Created by Gregory on 9/14/18.
 */

public interface Visual {
    void init();
    void inspectFrame(boolean debug) throws InterruptedException;
    void stop();
}
