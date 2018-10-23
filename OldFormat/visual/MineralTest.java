package org.firstinspires.ftc.teamcode.OldFormat.visual;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.OldFormat.common.Config;

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
        Visual v = Config.Visual.NEW(hardwareMap, telemetry); // Initialize the Visual Assembly

        waitForStart();                                       // Wait for Start

        while (!isStopRequested()) {
            v.inspectFrame(false);                     // Inspect the frame from the camera
        }

        v.stop();                                             // Stop the visual controller (close views...)
    }
}
