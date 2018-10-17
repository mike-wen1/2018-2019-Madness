package org.firstinspires.ftc.teamcode.marker;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.common.Config;

@TeleOp
public class TeamMarker extends Marker {
    private Servo servo;

    public void init() {
        servo = hardwareMap.servo.get(Config.Marker.MARKER_SERVO);
    }

    @Override
    public void loop() {

    }

    @Override
    public void dropMarker() {
        servo.setPosition(0);
    }
}
