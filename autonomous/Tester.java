package org.firstinspires.ftc.teamcode.autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous
public class Tester extends BaseAutonomous {
    public void runOpMode() {

        initialize();
        waitForStart();
        frontLeft.setTargetPosition(frontLeft.getCurrentPosition() - 2000);
        telemetry.addData("TargetPos: ", frontLeft.getCurrentPosition() - 2000);
        telemetry.update();
        sleep(5000);
        frontLeft.setPower(1);
        while (frontLeft.isBusy() && !isStopRequested()) {
            int currPos = frontLeft.getCurrentPosition();
            telemetry.addData("Curr Position: ", currPos);
            telemetry.update();
        }
    }
}