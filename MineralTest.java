package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


/**
 * MineralTest: An example of an Autonomous Test program
 * Displays the mineral view onscreen to test the detection of minerals by the phone camera.
 *
 * Created by Gregory on 9/14/18.
 */

@Autonomous
public class MineralTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        Visual.DEBUG = true;
        Visual v = new Visual();
        v.hardwareMap = hardwareMap;
        v.telemetry = telemetry;
        v.init();

        waitForStart();                                       // Wait for Start

        while (!isStopRequested()) {
            //Thread.sleep(2000);
            v.isGoldMineral(false);
            telemetry.update();// Inspect the frame from the camera
            telemetry.clear();
        }
        v.stop();                                             // Stop the visual controller (close views...)
    }
}
