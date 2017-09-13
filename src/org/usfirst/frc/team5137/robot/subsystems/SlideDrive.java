package org.usfirst.frc.team5137.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team5137.robot.*;
import edu.wpi.first.wpilibj.*;
import org.usfirst.frc.team5137.robot.commands.*;

/**
 *
 */
public class SlideDrive extends Subsystem {
	SpeedController slideDriveMotor = RobotMap.slideDriveMotor;
	double xIn;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public void takeJoystickX(Joystick driveStick) {
		xIn = driveStick.getX();
		slideDriveMotor.set(xIn);
	}
	
	public void autoDrive(double driveSpeed) {
		slideDriveMotor.set(driveSpeed);
	}
	
	public void stop() {
		slideDriveMotor.set(0);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveSideways());
    	
    	
    }
}

