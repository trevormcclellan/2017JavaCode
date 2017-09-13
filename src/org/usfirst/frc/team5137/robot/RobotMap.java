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
	public static SpeedController shooterMotor;
	public static SpeedController feederMotor;
	public static SpeedController climberMotor;
	public static ADXRS450_Gyro gyro;
	public static AnalogInput rearUltraSonic;
	public static AnalogInput leftUltraSonic;
	public static AnalogInput frontUltraSonic;
	public static AnalogInput rightUltraSonic;
	
	public static void init() {
		driveBaseLeftMotor = new VictorSP(0);
		driveBaseRightMotor = new VictorSP(1);
		slideDriveMotor = new Spark(2);
		intakeRollerMotor = new Spark(6);
		shooterMotor = new Spark(3);
		feederMotor = new Spark(5);
		climberMotor = new Spark(4);
		driveBaseChassis = new RobotDrive(driveBaseLeftMotor, driveBaseRightMotor);
		gyro = new ADXRS450_Gyro();
		rearUltraSonic = new AnalogInput(0);
		leftUltraSonic = new AnalogInput(1);
		frontUltraSonic = new AnalogInput(2);
		rightUltraSonic = new AnalogInput(3);
		
		driveBaseChassis.setSafetyEnabled(true);
		driveBaseChassis.setExpiration(0.1);
		driveBaseChassis.setSensitivity(0.5);
		driveBaseChassis.setMaxOutput(1.0);
		driveBaseLeftMotor.setInverted(true);
		driveBaseRightMotor.setInverted(true);
	}

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
