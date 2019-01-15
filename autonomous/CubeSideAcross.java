package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous
public class CubeSideAcross extends BaseAutonomous {
    int turn360 = 14000;
    int start;

    public void runOpMode() {

        initialize();

        holdMarker();

        waitForStart();

        start = winchMotor.getCurrentPosition();

        setHeight(start + 17500, 1);
        while (winchMotor.isBusy() && !isStopRequested()) {}

        moveEncoderVertical(800, 1);
        while (frontLeft.isBusy() && !isStopRequested()) {}

        moveEncoderHorizontal(-500, 1);
        while (frontLeft.isBusy() && !isStopRequested()) {}

        turnBotEncoders(turn360 / -6, 1);
        while (frontLeft.isBusy() && !isStopRequested()) {}

        moveEncoderVertical(2900, 1);
        while (frontLeft.isBusy() && !isStopRequested()) {}
        sleep(100);

        turnBotEncoders(turn360 / 6, 1);
        while (frontLeft.isBusy() && !isStopRequested()) {}

        int startingEncoder = frontLeft.getCurrentPosition();
        telemetry.addData("Starting Pos", frontLeft.getCurrentPosition());
        telemetry.update();

        moveEncoderVertical(-5500, 1);
        while (frontLeft.isBusy()) {
            if (seesGold()) {
                telemetry.addData("End", frontLeft.getCurrentPosition());
                telemetry.update();
                break;
            }
        }

        int endEncoder = frontLeft.getCurrentPosition();
        moveEncoderVertical(400, 1);
        while (frontLeft.isBusy() && !isStopRequested()) {}

        if (Math.abs(startingEncoder - endEncoder) <= 1000) {
            telemetry.addLine("Left");
            telemetry.update();

            moveEncoderVertical(1200, 1);
            while (frontLeft.isBusy() && !isStopRequested()) {}

            turnBotEncoders(turn360 / 16 * 3, 1);
            while (frontLeft.isBusy() && !isStopRequested()) {}
        } else if (startingEncoder - endEncoder >= 1650) {
            telemetry.addLine("Right");
            telemetry.update();

            turnBotEncoders(turn360 / 10 * 3, 1);
            while (frontLeft.isBusy() && !isStopRequested()) {}
        } else {
            telemetry.addLine("Center");
            telemetry.update();

            turnBotEncoders(turn360 / 4, 1);
            while (frontLeft.isBusy() && !isStopRequested()) {}
        }
        /*if (startingEncoder - endEncoder >= 1650) {
            telemetry.addLine("Left");
            telemetry.update();

            moveEncoderVertical(1300, 1);
            while (frontLeft.isBusy() && !isStopRequested()) {
            }

            turnBotEncoders(turn360 / 16 * 3, 1);
            while (frontLeft.isBusy() && !isStopRequested()) {
            }
        } else if (endEncoder - startingEncoder >= 1000) {
            telemetry.addLine("Right");
            telemetry.update();
            moveEncoderVertical(-1300, 1);
            while (frontLeft.isBusy() && !isStopRequested()) {}

            turnBotEncoders(turn360 / 10 * 3, 1);
            while (frontLeft.isBusy() && !isStopRequested()) {}

            moveEncoderVertical(-500, 1);
            while (frontLeft.isBusy() && !isStopRequested()) {}
        } else {
            telemetry.addLine("Center");
            telemetry.update();

            turnBotEncoders(turn360 / 4, 1);
            while (frontLeft.isBusy() && !isStopRequested()) {}
        }*/

        moveEncoderVertical(-7000, 1);
        while (frontLeft.isBusy() && !isStopRequested()) {}
        sleep(500);

        dropMarker();
        sleep(500);

        moveEncoderVertical(900, 1);
        while (frontLeft.isBusy() && !isStopRequested()) {}
        sleep(500);
    }
}