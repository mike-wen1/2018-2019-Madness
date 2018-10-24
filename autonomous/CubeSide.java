package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.LinearLift;
import org.firstinspires.ftc.teamcode.TankDrive;
import org.firstinspires.ftc.teamcode.TeamMarker;


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
public class CubeSide extends LinearOpMode {
    int turn360 = 2400;

    public void runOpMode() throws InterruptedException {   // This method is run by the OpMode Manager on init until the stop button is pressed.
        TankDrive tankDrive = new TankDrive(); // Initialize all Assemblies required during the Autonomous program by the interface
        TeamMarker teamMarker = new TeamMarker();
        LinearLift linearLift = new LinearLift();

        // Initializations2
        tankDrive.hardwareMap = hardwareMap;
        tankDrive.telemetry = telemetry;
        tankDrive.init();
        teamMarker.hardwareMap = hardwareMap;
        teamMarker.telemetry = telemetry;
        teamMarker.init();
        linearLift.hardwareMap = hardwareMap;
        linearLift.telemetry = telemetry;
        linearLift.init();

        teamMarker.holdMarker();

        waitForStart();                                                  // Wait for Start Button
        tankDrive.moveBot(500, 1);                      // Move the Robot
        sleep(5000);
        tankDrive.moveBot(850, 1);
        sleep(500);
        teamMarker.dropMarker();
        sleep(1500);
        tankDrive.turnBot(turn360 / 8 * 3, 1);
        tankDrive.moveBot(2500, 1);
    }
}
