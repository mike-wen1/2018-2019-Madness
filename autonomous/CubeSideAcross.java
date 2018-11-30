package org.firstinspires.ftc.teamcode.autonomous;

public class CubeSideAcross extends BaseAutonomous {
    int turn360 = 14000;
    int start;

    public void runOpMode() {

        initialize();

        holdMarker();

        waitForStart();

        start = winchMotor.getCurrentPosition();

        setHeight(start + 14500, 1);
        while (winchMotor.isBusy() && !isStopRequested()) {}

        moveEncoderVertical(800, 1);
        while (frontLeft.isBusy() && !isStopRequested()) {}

        setHeight(start, 1);
        double waitUntil = time + 1.5;
        while (time < waitUntil && !isStopRequested()) {}

        moveEncoderVertical(-800, 1);
        while (frontLeft.isBusy() && !isStopRequested()) {}

        //turnBotEncoders(-turn360/4, 1);
        //while (frontLeft.isBusy() && !isStopRequested()) {}

        moveEncoderHorizontal(-4000, 1);
        while (frontLeft.isBusy() && !isStopRequested()) {}
        sleep(1000);

        int startingEncoder = frontLeft.getCurrentPosition();
        telemetry.addData("Starting Pos", frontLeft.getCurrentPosition());
        telemetry.update();

        // Visual
        moveEncoderVertical(-2000, 1);
        while (frontLeft.isBusy() && !isStopRequested()) {}

        waitUntil = time + 8;
        while (!seesGold() && (time < waitUntil)) {
            moveEncoderVertical(200,1);
            telemetry.addData("Starting Pos", startingEncoder);
            telemetry.addData("Current Encoder", frontLeft.getCurrentPosition());
            telemetry.update();
        }
        int endEncoder = frontLeft.getCurrentPosition();
        moveEncoderVertical(400, 1);
        while (frontLeft.isBusy() && !isStopRequested()) {}

        if (startingEncoder - endEncoder >= 1650) {
            moveEncoderVertical(700, 1);
            while (frontLeft.isBusy() && !isStopRequested()) {}

            turnBotEncoders(turn360 / 8 * 3, 1);
            while (frontLeft.isBusy() && !isStopRequested()) {}
        } else {
            turnBotEncoders(turn360 / 4, 1);
            while (frontLeft.isBusy() && !isStopRequested()) {
            }
        }

        moveEncoderVertical(-7000, 1);
        while (frontLeft.isBusy() && !isStopRequested()) {}
        sleep(500);

        dropMarker();
        sleep(500);

        moveEncoderVertical(900, 1);
        while (frontLeft.isBusy() && !isStopRequested()) {}
        sleep(500);

        turnBotEncoders(turn360 / 8 * 3, 1);
        while (frontLeft.isBusy() && !isStopRequested()) {}

        moveEncoderVertical(-15000, 1);
        while (frontLeft.isBusy() && !isStopRequested()) {}
    }
}
