package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous
public class CubeSide extends BaseAutonomous {
    int turn360 = 2500;

    public void runOpMode() {

        initialize();

        holdMarker();

        waitForStart();

        moveBot(500, 1);
        sleep(500);
        turnBot(turn360/4, -1);
        sleep(500);

        moveBot(100, 1);

        double waitUntil = System.nanoTime() + (1000 * 1000000);
        while (!seesGold() || (System.nanoTime() < waitUntil)) {
            moveBot(1000,1);
        }

        turnBot(turn360/4, 1);

        moveBot(1200,1);
        sleep(1000);

        dropMarker();

        sleep(1500);

        turnBot(turn360 / 8 * 3, 1);
        moveBot(2500,1);
    }
}
