package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous
public class CubeSide extends BaseAutonomous {
    int turn360_1 = 2600;
    int turn360_7 = 3540;

    public void runOpMode() {

        initialize();

        holdMarker();

        waitForStart();

        moveBot(500, 1);
        sleep(500);
        // Visual
        /*turnBot(turn360_1/4, -1);
        sleep(500);

        moveBot(500, -0.7);
        sleep(500);

        double waitUntil = System.nanoTime() + (1000 * 1000000);
        while (!seesGold() && (System.nanoTime() < waitUntil)) {
            moveBot(1000,0.7);
        }
        moveBot(400, 0.7);

        turnBot(turn360_7/4, 0.7);*/

        moveBot(1200,1);
        sleep(1000);

        dropMarker();

        sleep(1500);

        turnBot(turn360_1 / 8 * 3, 1);
        moveBot(2500,1);
    }
}
