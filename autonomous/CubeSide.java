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
        sleep(5000);
        moveBot(700, 1);
        sleep(500);

        dropMarker();

        sleep(1500);

        turnBot(turn360 / 8 * 3, 1);
        moveBot(2500, 1);
    }
}
