package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Main Robot", group = "Main")
public class Main extends OpMode {

    private TankDrive tankDrive;
    private LinearLift linearLift;
    private MineralScorer mineralScorer;
    private TeamMarker teamMarker;

    Main() {
        tankDrive = new TankDrive();
        linearLift = new LinearLift();
        mineralScorer = new MineralScorer();
        teamMarker = new TeamMarker();
    }

    @Override
    public void init() {
        tankDrive.hardwareMap = hardwareMap;
        tankDrive.telemetry = telemetry;
        tankDrive.init();

        linearLift.hardwareMap = hardwareMap;
        linearLift.telemetry = telemetry;
        linearLift.init();

        mineralScorer.hardwareMap = hardwareMap;
        mineralScorer.telemetry = telemetry;
        mineralScorer.init();

        teamMarker.hardwareMap = hardwareMap;
        teamMarker.telemetry = telemetry;
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
