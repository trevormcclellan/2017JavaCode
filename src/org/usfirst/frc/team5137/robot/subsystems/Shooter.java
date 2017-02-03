package org.usfirst.frc.team5137.robot.subsystems;

import org.usfirst.frc.team5137.robot.RobotMap;
import org.usfirst.frc.team5137.robot.commands.*;
import edu.wpi.first.wpilibj.*;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {
	SpeedController shooterMotor = RobotMap.shooterMotor;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public void shoot() {
		shooterMotor.set(1);
	}
	
	public void stop() {
		shooterMotor.set(0);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

