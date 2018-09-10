package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.common.AbstractAssembly;
import org.firstinspires.ftc.teamcode.common.Config;

/**
 * Created by Gregory on 9/10/18.
 */

/* ************************ */
/* ***** DO NOT EDIT ****** */
/* ************************ */

@TeleOp(name = "Main Robot", group = "Main")
public class Main extends OpMode {

    private AbstractAssembly[] assemblies = new AbstractAssembly[1];

    @Override
    public void init() {
        assemblies[0] = Config.Drive.NEW();

        for (AbstractAssembly assembly : assemblies) {
            assembly.resetStartTime();
            assembly.init(hardwareMap, telemetry);
        }
    }

    @Override
    public void start() {
        for (AbstractAssembly assembly : assemblies) {
            assembly.start();
        }
    }

    @Override
    public void loop() {
        for (AbstractAssembly assembly : assemblies) {
            assembly.loop(gamepad1, gamepad2, time);
        }
    }

    @Override
    public void stop() {
        for (AbstractAssembly assembly : assemblies) {
            assembly.stop();
        }
    }
}
