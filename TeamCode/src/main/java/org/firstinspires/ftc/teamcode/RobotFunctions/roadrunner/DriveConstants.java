package org.firstinspires.ftc.teamcode.RobotFunctions.roadrunner;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.control.PIDCoefficients;
import com.acmerobotics.roadrunner.trajectory.constraints.DriveConstraints;
import com.qualcomm.hardware.motors.NeveRest40Gearmotor;
import com.qualcomm.robotcore.hardware.configuration.typecontainers.MotorConfigurationType;

/*
 * Constants shared between multiple drive types.
 */
@Config
public class DriveConstants {

    private DriveConstants() {

    }

    /*
     * TODO: Tune or adjust the following constants to fit your robot. Note that the non-final
     * fields may also be edited through the dashboard (connect to the robot's WiFi network and
     * navigate to https://192.168.49.1:8080/dash). Make sure to save the values here after you
     * adjust them in the dashboard; **config variable changes don't persist between app restarts**.
     */
    public static final MotorConfigurationType MOTOR_CONFIG =
            MotorConfigurationType.getMotorType(NeveRest40Gearmotor.class);
    private static final double TICKS_PER_REV = MOTOR_CONFIG.getTicksPerRev();

    public static PIDCoefficients TRANSLATIONAL_PID = new PIDCoefficients(0.15, 0, 0);
    public static PIDCoefficients HEADING_PID = new PIDCoefficients(0.01, 0, 0);

    public static double WHEEL_RADIUS = 2; // in
    public static double GEAR_RATIO = 2; // output/input
    public static double TRACK_WIDTH = 15; // 20.16 home drivetrain, 15.09 comp drivetrain, 7.63 comp drivetrain?

    public static DriveConstraints BASE_CONSTRAINTS = new DriveConstraints(20.0, 30.0, Math.PI / 2, Math.PI / 2);

    public static double kV = 0.016;
    public static double kA = 0;
    public static double kStatic = 0;


    public static double encoderTicksToInches(int ticks) {
        return WHEEL_RADIUS * 2 * Math.PI * GEAR_RATIO * ticks / TICKS_PER_REV;
    }

    public static double rpmToVelocity(double rpm) {
        return rpm * GEAR_RATIO * 2 * Math.PI * WHEEL_RADIUS / 60.0;
    }

    public static double getMaxRpm() {
        return MOTOR_CONFIG.getMaxRPM();
    }
}