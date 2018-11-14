package org.firstinspires.ftc.teamcode.autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous
public class Tester extends BaseAutonomous {
    public void runOpMode() {

        initialize();
        waitForStart();
        telemetry.addData("Init Pos", winchMotor.getCurrentPosition());
        telemetry.update();
        //release(1);
        turnBotEncoders(6500/4, 1);
    }
}