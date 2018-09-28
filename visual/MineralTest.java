package org.firstinspires.ftc.teamcode.visual;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.common.Config;

/**
 * Created by Gregory on 9/14/18.
 */

@Autonomous
public class MineralTest extends LinearOpMode {

    private Visual v;

    @Override
    public void runOpMode() throws InterruptedException {
        v = Config.Visual.NEW(hardwareMap, telemetry);
        v.init();

        waitForStart();

        //int i = 0;
        while (!isStopRequested()) {
            v.inspectFrame(false);
        }
        v.stop();
    }
}
