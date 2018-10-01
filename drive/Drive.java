package org.firstinspires.ftc.teamcode.drive;

/**
 * Drive: The control interface for the Drive Train
 *
 * Created by Gregory on 9/10/18.
 */

public interface Drive {
    void init(); // Initialize Motors
    void moveBot(int distance, int speed) throws InterruptedException; // Move the robot for distance rotations? at speed.
}

