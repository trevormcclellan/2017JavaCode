package org.usfirst.frc.team5137.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
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
	
	double Kp = 0.03;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void takeJoystickInput(Joystick driveStick) {
		chassis.arcadeDrive(driveStick);
	}
	
	public void drive(double speed, double turnRate) {
		chassis.drive(speed, turnRate);
	}
	
	public void driveStraight(double speed) {
		double angle = gyro.getAngle(); // get current heading
        chassis.drive(-1.0, -angle*Kp); // drive towards heading 0
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

