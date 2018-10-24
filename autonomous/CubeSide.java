package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;


/**
 * Main Autonomous: The main autonomous program that will be run during the tournament if we start on the side where we deposit the cubes.
 *
 * In order for this to be runnable from the Driver Station, it must extend either OpMode or LinearOpMode and be annotated with @Autonomous.
 * Because this will run linearly and not in a constant loop like a normal OpMode, we chose LinearOpMode.
 *
 * This should not directly interface with motors (except maybe Visual Signaling Devices).
 * All interfacing with motors should be done in the appropriate Assembly.
 *
 * To sleep, use Thread.sleep.
 *
 * If you need to use a loop, add a condition if Thread.currentThread().isInterrupted() then you must exit immediately to prevent App Crash.
 *
 * Created by Ivy on 10/09/18.
 */

@Autonomous                                                 // Comment out annotation to remove from list on Driver Station
public class CubeSide extends BaseAutononomous {
    int turn360 = 2500;

    public void runOpMode() {

        initialize();

        holdMarker();

        waitForStart();

        moveBot(500, 1);
        sleep(5000);
        moveBot(700, 1);
        sleep(500);

        dropMarker();

        sleep(1500);

        turnBot(turn360 / 8 * 3, 1);
        moveBot(2500, 1);

    }


}
