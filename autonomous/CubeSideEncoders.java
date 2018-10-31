package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous
public class CubeSideEncoders extends BaseAutonomous {
    int turn360_1 = 2500;
    int turn360_7 = 3540;

    public void runOpMode() {

        initialize();

        holdMarker();

        waitForStart();

        moveBotEncoders(1000, 1);
        sleep(5000);
        // Visual
        /*turnBotEncoders(turn360_1/4, -1);
        sleep(500);

        moveBotEncoders(500, -0.7);
        sleep(500);

        /*double waitUntil = System.nanoTime() + (1000 * 1000000);
        while (!seesGold() && (System.nanoTime() < waitUntil)) {
            moveBotEncoders(1000,0.7);
        }
        moveBotEncoders(400, 0.7);

        turnBotEncoders(turn360_7/4, 0.7);*/

        moveBotEncoders(1500, 1);
        sleep(1000);

        dropMarker();
        sleep(500);

        moveBotEncoders(300, -1);

        sleep(1500);

        turnBotEncoders(turn360_1 / 8 * 3, 1);
        moveBotEncoders(6000, 1);
    }
}