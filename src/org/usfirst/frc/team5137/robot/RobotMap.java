package org.usfirst.frc.team5137.robot;

import edu.wpi.first.wpilibj.*;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;
	public static SpeedController driveBaseLeftMotor;
	public static SpeedController driveBaseRightMotor;
	public static SpeedController slideDriveMotor;
	public static RobotDrive driveBaseChassis;
	public static SpeedController intakeRollerMotor;
	
	public static void init() {
		driveBaseLeftMotor = new VictorSP(0);
		driveBaseRightMotor = new VictorSP(1);
		slideDriveMotor = new Spark(2);
		intakeRollerMotor = new Spark(3);
		driveBaseChassis = new RobotDrive(driveBaseLeftMotor, driveBaseRightMotor);
	}

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
