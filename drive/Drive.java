package org.firstinspires.ftc.teamcode.drive;

import org.firstinspires.ftc.teamcode.common.Assembly;

/**
 * Created by Gregory on 9/10/18.
 */

public interface Drive extends Assembly {
    enum CoordinateSystem {
        RELATIVE, ABSOLUTE
    }

    // Starts integration of the Gyro.
    // This position will be zero for the rest of the program.
    void start();

    // Resets the current position to now be zero for all rotation values.
    void resetGyro();

    // Sets the Drive coordinate system to relative or absolute
    void setCoordinateSystem(CoordinateSystem system);

    // Sets the default speed for all following movement calls
    // Default starts at one (max speed)
    void setDefaultSpeed(double speed);

    // Get the current rotation of the robot
    double getRotation();

    // Move the robot in a specified direction [-180, 180], ending with a specified rotation [-180, 180], at a specified speed [-1, 1]
    // Default direction is zero, rotation is zero, and speed is the default.
    void moveDRS(int direction, int rotation, double speed, long distance);
    void moveDS(int direction, double speed, long distance);
    void moveDR(int direction, int rotation, long distance);
    void moveRS(int rotation, double speed, long distance);
    void moveD(int direction, long distance);
    void moveR(int rotation, long distance);
    void moveS(double speed, long distance);
}
