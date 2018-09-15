package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.common.Config;
import org.firstinspires.ftc.teamcode.drive.Drive;
import org.firstinspires.ftc.teamcode.drive.OmniDrive;

/**
 * Created by Gregory on 9/10/18.
 */

@Autonomous(name = "Main Autonomous", group = "Autonomous")
public class MainAutonomous extends LinearOpMode{

    @Override
    public void runOpMode() throws InterruptedException {
        Drive d = Config.Drive.NEW();
        d.init(hardwareMap, telemetry);
        waitForStart();
        d.start();

        d.moveD(10, 10);

        if (d instanceof OmniDrive) {
            ((OmniDrive) d).specificOmniDrive();
        }
    }
}
