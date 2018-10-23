package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Main TeleOp for Tournament
 *
 * Runs many Assemblies for the Tournament
 *
 * Created by Gregory on 9/10/18.
 */

/* ************************ */
/* ***** DO NOT EDIT ****** */
/* ************************ */

@TeleOp(name = "Main Robot2", group = "Main")
public class Main extends OpMode {

    private OpMode[] assemblies = new OpMode[4];                  // Increase the size of the array for the amount of Assemblies
    TankDrive tankDrive;
    LinearLift linearLift;
    MineralScorer mineralScorer;
    TeamMarker teamMarker;

    Main() {
        tankDrive = new TankDrive();
        tankDrive.hardwareMap = hardwareMap;
        tankDrive.telemetry = telemetry;

        linearLift = new LinearLift();
        linearLift.hardwareMap = hardwareMap;
        linearLift.telemetry = telemetry;

        mineralScorer = new MineralScorer();
        mineralScorer.hardwareMap = hardwareMap;
        mineralScorer.telemetry = telemetry;

        teamMarker = new TeamMarker();
        teamMarker.hardwareMap = hardwareMap;
        teamMarker.telemetry = telemetry;

    }
    @Override
    public void init() {
        tankDrive.init();
        linearLift.init();
        mineralScorer.init();
        teamMarker.init();

    }

    @Override
    public void start() {
        tankDrive.start();
        linearLift.start();
        mineralScorer.start();
        teamMarker.start();

    }

    @Override
    public void loop() {

        tankDrive.gamepad1 = gamepad1;
        tankDrive.gamepad2 = gamepad2;
        tankDrive.loop();

        linearLift.gamepad1 = gamepad1;
        linearLift.gamepad2 = gamepad2;
        linearLift.loop();

        mineralScorer.gamepad1 = gamepad1;
        mineralScorer.gamepad2 = gamepad2;
        mineralScorer.loop();

        teamMarker.gamepad1 = gamepad1;
        teamMarker.gamepad2 = gamepad2;
        teamMarker.loop();

    }

    @Override
    public void stop() {
        tankDrive.stop();
        linearLift.stop();
        mineralScorer.stop();
        teamMarker.stop();
    }
}
