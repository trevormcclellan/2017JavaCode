package org.usfirst.frc.team5137.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.*;
import org.usfirst.frc.team5137.robot.*;
/**
 *
 */
public class Climber extends Subsystem {

	SpeedController climberMotor = RobotMap.climberMotor;
	
	public void climb() {
		climberMotor.set(1);
	}
	
	public void unRoll() {
		climberMotor.set(-1);
	}
	
	public void stop() {
		climberMotor.set(0);
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

