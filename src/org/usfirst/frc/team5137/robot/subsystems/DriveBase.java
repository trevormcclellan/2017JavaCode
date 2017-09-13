package org.usfirst.frc.team5137.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import org.usfirst.frc.team5137.robot.*;
import edu.wpi.first.wpilibj.*;
import org.usfirst.frc.team5137.robot.commands.*;

/**
 *
 */
public class DriveBase extends Subsystem {
	SpeedController leftMotor = RobotMap.driveBaseLeftMotor;
	SpeedController rightMotor = RobotMap.driveBaseRightMotor;
	RobotDrive chassis = RobotMap.driveBaseChassis;
	ADXRS450_Gyro gyro = RobotMap.gyro;
	NetworkTable aimingTable = NetworkTable.getTable("SmartDashboard");
	public boolean isXCentered = false;
	public boolean isYCentered = false;
	private static double xCoord;
	private static double yCoord;
	double centerX = 158;
	double centerY = 86;
	
	double Kp = 0.03;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void takeJoystickInput(Joystick driveStick) {
		chassis.arcadeDrive(driveStick);
	}
	
	public void drive(double speed, double turnRate) {
		chassis.drive(speed, turnRate);
	}
	
    public void autoDrive(double speed, double turn) {
    	chassis.drive(speed, turn);
    }
	
	public void driveStraight(double speed) {
		double angle = gyro.getAngle(); // get current heading
        chassis.drive(speed, -angle*Kp); // drive towards heading 0
	}
	
	public void pivotLeft() {
		leftMotor.set(-0.3);
		rightMotor.set(0.3);
	}
	
	public void pivotRight() {
		leftMotor.set(0.3);
		rightMotor.set(-0.3);
	}

	public void centerX() {
		isXCentered = false;
		xCoord = aimingTable.getNumber("COG_X", 0);
		if (xCoord == 0) {
			stop();
		} 
		else if (xCoord > centerX + 2) {
			pivotRight();
		}
		else if (xCoord < centerX - 2) {
			pivotLeft();
		}
		else {
			isXCentered = true;
			stop();
		}
	}
	
	public void centerY() {
		isYCentered = false;
		yCoord = aimingTable.getNumber("COG_y", 0);
		if (yCoord == 0) {
			stop();
		}
		else if (yCoord > centerY + 2) {
			driveStraight(0.3);
		}
		else if (yCoord < centerY - 2) {
			driveStraight(-0.3);
		}
		else {
			isYCentered = true;
			stop();
		}
	}

	public void stop() {
		chassis.drive(0, 0);
		gyro.reset();
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new Drive());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

