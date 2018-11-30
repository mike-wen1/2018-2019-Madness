package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

@Autonomous
@Disabled
public class CubeSide extends BaseAutonomous {
    int turn360_1 = 2500;
    int turn360_7 = 3540;

    public void runOpMode() {

        /* Encoders
        initialize();

        holdMarker();

        waitForStart();

        moveBot(1000, 1);
        sleep(5000);*/
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

        /*moveBot(1500,1);
        sleep(1000);

        dropMarker();
        sleep(500);

        moveBot(300, -1);

        sleep(1500);

        turnBot(turn360_1 / 8 * 3, 1);
        moveBot(6000,1);
        */

        initialize();

        holdMarker();

        waitForStart();

        moveBot(500, 1);
        sleep(500);

        moveBot(1200,1);
        sleep(1000);

        dropMarker();
        sleep(1500);

        moveBot(200, -1);

        sleep(1000);

        turnBot(turn360_1 / 8 * 3, 1);
        moveBot(2500,1);

    }
}
