package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous
public class SphereSide extends BaseAutonomous {
    public void runOpMode() {
        initialize();

        holdMarker();

        waitForStart();

        moveBot(1000, 1);
    }
}
