package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous
public class SphereSideEncoders extends BaseAutonomous {
    public void runOpMode() {
        initialize();

        holdMarker();

        waitForStart();

        moveBot(1250, 1);
    }
}
