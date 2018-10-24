package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.TankDrive;

@Autonomous
public class MotorTest extends LinearOpMode {
    public void runOpMode() throws InterruptedException {
        TankDrive tankDrive = new TankDrive();
        tankDrive.init();
        try {
            tankDrive.testMotors(1000, 1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
