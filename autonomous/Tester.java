package org.firstinspires.ftc.teamcode.autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous
public class Tester extends BaseAutonomous {
    public void runOpMode() {

        initialize();
        waitForStart();
        moveBotEncoders(1000, 1);
    }
}