package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous
public class SphereSideAcross extends BaseAutonomous {
    int turn360 = 14000;
    int start;

    public void runOpMode() {
        initialize();

        holdMarker();

        waitForStart();

        start = winchMotor.getCurrentPosition();

        // Lower bot
        setHeight(start + 17500, 1);
        while (winchMotor.isBusy() && !isStopRequested()) {}

        // Move to minerals
        moveEncoderVertical(800, 1);
        while (frontLeft.isBusy() && !isStopRequested()) {}

        turnBotEncoders(turn360 / 8, 1);
        while (frontLeft.isBusy() && !isStopRequested()) {}

        moveEncoderVertical(-4200, 1);
        while (frontLeft.isBusy() && !isStopRequested()) {}

        turnBotEncoders(turn360 / -8, 1);
        while (frontLeft.isBusy() && !isStopRequested()) {}

        int startingEncoder = frontLeft.getCurrentPosition();
        telemetry.addData("Starting Pos", frontLeft.getCurrentPosition());
        telemetry.update();

        // Visual (Mineral recognition)
        boolean seeMineral = false;

        moveEncoderVertical(5500, 1);
        while (frontLeft.isBusy() && !isStopRequested()) {
            if (seesGold()) {
                telemetry.addData("End", frontLeft.getCurrentPosition());
                telemetry.update();
                seeMineral = true;
                break;
            }
        }

        int endEncoder = frontLeft.getCurrentPosition();

        // Keeps track of where the mineral is
        int dir = 0;

        moveEncoderVertical(300, 1);
        while (frontLeft.isBusy() && !isStopRequested()) {}
        if (seeMineral) {
            if (endEncoder - startingEncoder >= 1650) {
                telemetry.addLine("Left");
                telemetry.update();

                dir = 1;
                moveEncoderVertical(900, 1);
                while (frontLeft.isBusy() && !isStopRequested()) {
                }
            } else if (endEncoder - startingEncoder < 1250) {
                telemetry.addLine("Right");
                telemetry.update();

                moveEncoderVertical(900, 1);
                while (frontLeft.isBusy() && !isStopRequested()) {}
                dir = 3;
            } else {
                moveEncoderVertical(1000, 1);
                while (frontLeft.isBusy() && !isStopRequested()) {
                }

                dir = 2;
                telemetry.addLine("Center");
                telemetry.update();
            }
        } else {
            moveEncoderVertical(1000, 1);
            while (frontLeft.isBusy() && !isStopRequested()) {
            }
        }

        // Knock off mineral
        turnBotEncoders(turn360 / 4, 1);
        while (frontLeft.isBusy() && !isStopRequested()) {}

        moveEncoderVertical(-1300, 1);
        while (frontLeft.isBusy() && !isStopRequested()) {}

        // Move back after moving mineral
        moveEncoderVertical(1000, 1);
        while (frontLeft.isBusy() && !isStopRequested()) {}

        // Crash into wall
        turnBotEncoders(turn360 / 4, 1);
        while (frontLeft.isBusy() && !isStopRequested()) {}

        if (dir == 3) {
            moveEncoderVertical(-10000, 1);
        } else if (dir == 2) {
            moveEncoderVertical(-7500, 1);
        } else {
            moveEncoderVertical(-5000, 1);
        }
        while (frontLeft.isBusy() && !isStopRequested()) {}

        // Go to depot and deposit marker
        turnBotEncoders(turn360 / 8, 1);
        while (frontLeft.isBusy() && !isStopRequested()) {}

        moveEncoderVertical(-8000, 1);
        while (frontLeft.isBusy() && !isStopRequested()) {}

        dropMarker();
        double waitUntil = time + 0.5;
        while (time < waitUntil) {}

        telemetry.addData("Dropped", dir);
        telemetry.update();

        // Go back to crater
        moveEncoderVertical(8000, 1); {}
        armMotor.setPower(1);
        waitUntil = time + 2;
        while (time < waitUntil) {}
        extensionMotor.setPower(1);
        waitUntil = time + 2;
        while (time < waitUntil) {}
        extensionMotor.setPower(0);
        armMotor.setPower(0);
        while (frontLeft.isBusy() && !isStopRequested()) {}
    }
}
