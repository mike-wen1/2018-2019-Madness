package org.firstinspires.ftc.teamcode.OldFormat.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.OldFormat.common.Config;
import org.firstinspires.ftc.teamcode.OldFormat.drive.Drive;

@Autonomous
public class MotorTest extends LinearOpMode {
    public void runOpMode() throws InterruptedException {
        Drive d = Config.Drive.NEW(hardwareMap, telemetry);

        d.testMotors(1500, 1);
    }
}
