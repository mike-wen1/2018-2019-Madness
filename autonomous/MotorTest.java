package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;


@Autonomous
public class MotorTest extends BaseAutononomous {

    public void runOpMode()  {
        initialize();

        waitForStart();

        testMotors(1000, 1);
    }
}
