package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous
public class CubeSideEncoders extends BaseAutonomous {
    int turn360 = 6500;

    public void runOpMode() {

        initialize();

        holdMarker();

        waitForStart();

        /*setHeight(1000, 1);
        while (winchMotor.isBusy() && !isStopRequested()) {}

        moveBotEncoders(300, 1);
        while (frontLeft.isBusy() && !isStopRequested()) {};

        setHeight(-200, 1);
        while (winchMotor.isBusy() && !isStopRequested()) {};

        moveBotEncoders(-300, 1);
        while (frontLeft.isBusy() && !isStopRequested()) {};

        turnBotEncoders(turn360/4, 1);*/

        moveBotEncoders(1700, 1);
        while (frontLeft.isBusy() && !isStopRequested()) {
        }
        sleep(500);
        // Visual
        /*turnBotEncoders(turn360/4, -1);
        sleep(500);

        moveBotEncoders(500, -0.7);

        sleep(500);

        /*double waitUntil = System.nanoTime() + (1000 * 1000000);
        while (!seesGold() && (System.nanoTime() < waitUntil)) {
            moveBotEncoders(1000,0.7);
        }
        moveBotEncoders(400, 0.7);

        turnBotEncoders(turn360_7/4, 0.7);*/

        moveBotEncoders(3000, 1);
        while (frontLeft.isBusy() && !isStopRequested()) {
        }
        sleep(500);

        dropMarker();
        sleep(500);

        moveBotEncoders(-600, 1);
        while (frontLeft.isBusy() && !isStopRequested()) {
        }
        sleep(500);

        turnBotEncoders(turn360 / 8 * 3, 1);
        while (frontLeft.isBusy() && !isStopRequested()) {
        }
        sleep(6500);
        moveBotEncoders(8000, 1);
        while (frontLeft.isBusy() && !isStopRequested()) {
        }
    }
}