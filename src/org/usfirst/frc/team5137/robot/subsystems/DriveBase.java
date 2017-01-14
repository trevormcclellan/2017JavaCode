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
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void takeJoystickInput(Joystick driveStick) {
		chassis.arcadeDrive(driveStick);
	}
	
	public void stop() {
		chassis.drive(0, 0);
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new Drive());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

