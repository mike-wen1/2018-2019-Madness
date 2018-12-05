package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous
public class SphereSideEncoders extends BaseAutonomous {
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

        setHeight(start + 8000, 1);
        double waitUntil = time + 1.5;
        while (time < waitUntil && !isStopRequested()) {}

        moveEncoderVertical(-800, 1);
        while (frontLeft.isBusy() && !isStopRequested()) {}

        moveEncoderHorizontal(-4000, 1);
        while (frontLeft.isBusy() && !isStopRequested()) {}
        sleep(100);

        int startingEncoder = frontLeft.getCurrentPosition();
        telemetry.addData("Starting Pos", frontLeft.getCurrentPosition());
        telemetry.update();

        // Visual
        moveEncoderVertical(-3000, 1);
        while (frontLeft.isBusy() && !isStopRequested()) {}

        moveEncoderVertical(5500, 1);
        while (frontLeft.isBusy()) {
            if (seesGold()) {
                telemetry.addData("End", frontLeft.getCurrentPosition());
                telemetry.update();
                break;
            }
        }

        int endEncoder = frontLeft.getCurrentPosition();

        if (startingEncoder - endEncoder >= 1650) {
            telemetry.addLine("Left");
            telemetry.update();

            moveEncoderVertical(900, 1);
            while (frontLeft.isBusy() && !isStopRequested()) {}
        } else if (endEncoder - startingEncoder > 1500) {
            telemetry.addLine("Right");
            telemetry.update();
        } else {
            telemetry.addLine("Center");
            telemetry.update();
        }

        turnBotEncoders(-1 * turn360 / 4, 1);
        while (frontLeft.isBusy() && !isStopRequested()) {}

        moveEncoderVertical(3000, 1);
        while (frontLeft.isBusy() && !isStopRequested()) {}

        waitUntil = time + 2;
        while (time < waitUntil) {
            armMotor.setPower(1);
        }
        armMotor.setPower(0);
    }
}
