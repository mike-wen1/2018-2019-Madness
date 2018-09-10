package org.tka.robotics.Drive;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Predicate;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.tka.robotics.Annotations.Assembly;

/**
 * Created by Gregory on 9/10/18.
 */

@Assembly(OmniDrive.class)
public interface Drive {

    enum CoordinateSystem {
        RELATIVE, ABSOLUTE
    }

    // Initialize the motors and sensors required.
    // Please keep robot still while initializing.
    void init(HardwareMap hardwareMap, Telemetry telemetry);

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
    void moveDRS(int direction, int rotation, double speed, Predicate<Drive> condition);
    void moveDRS(int direction, int rotation, double speed, long distance);
    void moveDS(int direction, double speed, Predicate<Drive> condition);
    void moveDS(int direction, double speed, long distance);
    void moveDR(int direction, int rotation, Predicate<Drive> condition);
    void moveDR(int direction, int rotation, long distance);
    void moveRS(int rotation, double speed, Predicate<Drive> condition);
    void moveRS(int rotation, double speed, long distance);
    void moveD(int direction, Predicate<Drive> condition);
    void moveD(int direction, long distance);
    void moveR(int rotation, Predicate<Drive> condition);
    void moveR(int rotation, long distance);
    void moveS(double speed, Predicate<Drive> condition);
    void moveS(double speed, long distance);
}
