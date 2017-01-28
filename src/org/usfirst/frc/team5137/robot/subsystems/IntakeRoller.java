package org.usfirst.frc.team5137.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team5137.robot.*;
import edu.wpi.first.wpilibj.*;
import org.usfirst.frc.team5137.robot.commands.*;

/**
 *
 */
public class IntakeRoller extends Subsystem {
	SpeedController intakeRollerMotor = RobotMap.intakeRollerMotor;
	
	public void intake() {
		intakeRollerMotor.set(1);
	}
	
	public void stop() {
		intakeRollerMotor.set(0);
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	setDefaultCommand(new RollIntake());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

