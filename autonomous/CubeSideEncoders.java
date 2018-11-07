package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous
public class CubeSideEncoders extends BaseAutonomous {
    int turn360 = 7000;

    public void runOpMode() {

        initialize();

        holdMarker();

        waitForStart();
        moveBotEncoders(1100, 1);
        while (frontLeft.isBusy() && !isStopRequested()) {
        }
        sleep(1000);
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

        moveBotEncoders(2500, 1);
        while (frontLeft.isBusy() && !isStopRequested()) {
        }
        sleep(1000);

        dropMarker();
        sleep(500);

        moveBotEncoders(-300, 1);
        while (frontLeft.isBusy() && !isStopRequested()) {
        }
        sleep(1500);

        turnBotEncoders(turn360 / 8 * 3, 1);
        while (frontLeft.isBusy() && !isStopRequested()) {
        }
        sleep(500);
        moveBotEncoders(6000, 1);
        while (frontLeft.isBusy() && !isStopRequested()) {
        }
    }
}