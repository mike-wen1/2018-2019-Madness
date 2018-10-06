package org.firstinspires.ftc.teamcode.drive;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

/**
 * Drive: The control interface for the Drive Train
 *
 * Created by Gregory on 9/10/18.
 */

public abstract class Drive extends OpMode {
    public abstract void init(); // Initialize Motors
    public abstract void moveBot(int time, int speed) throws InterruptedException; // Move the robot for distance rotations? at speed.
}

