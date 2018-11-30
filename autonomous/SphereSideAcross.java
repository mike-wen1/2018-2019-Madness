package org.firstinspires.ftc.teamcode.autonomous;

public class SphereSideAcross extends BaseAutonomous {
    public void runOpMode() {
        initialize();

        holdMarker();

        waitForStart();

        moveBot(1250, 1);
    }
}
