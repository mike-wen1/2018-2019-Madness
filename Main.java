package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.common.Config;

/**
 * Main TeleOp for Tournament
 *
 * Runs many Assemblies for the Tournament
 *
 * Created by Gregory on 9/10/18.
 */

/* ************************ */
/* ***** DO NOT EDIT ****** */
/* ************************ */

@TeleOp(name = "Main Robot", group = "Main")
public class Main extends OpMode {

    private OpMode[] assemblies = new OpMode[2];                  // Increase the size of the array for the amount of Assemblies

    @Override
    public void init() {
        assemblies[0] = Config.Drive.NEW(hardwareMap, telemetry); // Initialize all OpModes independently (Config.{Assembly}.NEW())
        assemblies[1] = Config.Mineral.NEW(hardwareMap, telemetry);
        assemblies[2] = Config.Lift.NEW(hardwareMap, telemetry);
    }

    @Override
    public void start() {
        for (OpMode assembly : assemblies) {                      // Start All Registered Assemblies in the Array
            assembly.start();
        }
    }

    @Override
    public void loop() {
        for (OpMode assembly : assemblies) {                      // Loop All Registered Assemblies in the Array
            assembly.gamepad1 = gamepad1;
            assembly.gamepad2 = gamepad2;
            assembly.loop();
        }
    }

    @Override
    public void stop() {
        for (OpMode assembly : assemblies) {                      // Stop All Registered Assemblies in the Array
            assembly.stop();
        }
    }
}
