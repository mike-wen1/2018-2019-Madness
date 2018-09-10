package org.firstinspires.ftc.teamcode.drive;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.robotcore.external.navigation.Velocity;
import org.firstinspires.ftc.teamcode.common.AbstractAssembly;

/**
 * Created by Gregory on 9/10/18.
 */


// Write everything here that is common to all systems of driving
abstract class AbstractDrive extends AbstractAssembly implements Drive {

    // MAX_SPEED should be fine-tuned during the init function
    // so that all drive systems are approximately the same speed.
    private double MAX_SPEED = 1;

    private double defaultSpeed = MAX_SPEED;

    private double zeroPosition = 0;

    private CoordinateSystem system = CoordinateSystem.ABSOLUTE;

    private BNO055IMU imu;

    private void initIMU(HardwareMap hardwareMap) {
        //Init IMU with parameters and start integration
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit            = BNO055IMU.AngleUnit.DEGREES;

        imu = hardwareMap.get(BNO055IMU.class, "imu");
        imu.initialize(parameters);
        imu.startAccelerationIntegration(new Position(), new Velocity(), 50);
    }

    @Override
    public void setCoordinateSystem(CoordinateSystem system) {
        this.system = system;
    }

    @Override
    public void setDefaultSpeed(double defaultSpeed) {
        this.defaultSpeed = defaultSpeed;
    }

    private double getRawRotation() {
        return (AngleUnit.normalizeDegrees(imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.XYZ, AngleUnit.DEGREES).thirdAngle));
    }

    @Override
    public double getRotation() {
        return AngleUnit.normalizeDegrees(getRawRotation() - zeroPosition);
    }

    @Override
    public void resetGyro() {
        zeroPosition = getRawRotation();
    }

    public void moveDS(int direction, double speed, long distance) { moveDRS(direction, 0, speed, distance);    }
    public void moveDR(int direction, int rotation, long distance) { moveDRS(direction, rotation, 1, distance); }
    public void moveRS(int rotation, double speed, long distance)  { moveDRS(0, rotation, speed, distance);     }
    public void moveD(int direction, long distance)                { moveDRS(direction, 0, 1, distance);        }
    public void moveR(int rotation, long distance)                 { moveDRS(0, rotation, 1, distance);         }
    public void moveS(double speed, long distance)                 { moveDRS(0, 0, speed, distance);            }
}
