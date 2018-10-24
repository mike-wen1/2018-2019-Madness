package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class TeamMarker extends OpMode {
    public Servo servo;

    public void init() {
        servo = hardwareMap.servo.get(Config.Marker.MARKER_SERVO);
        servo.setPosition(0);
    }

    public void loop() {

    }


    public void dropMarker() {
        servo.setPosition(1);
    }
    public void holdMarker() {
        servo.setPosition(0);
    }
}
