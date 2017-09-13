
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
	SpeedController feederMotor = RobotMap.feederMotor;
	public int counter = 0;
	public int gearCounter = 0;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public void shoot() {
		counter ++;
		shooterMotor.set(1);
		if (counter >= 75) {
			feederMotor.set(-1);
		}
	}
		
	public void lowGoalShoot() {
			counter ++;
			shooterMotor.set(0.5);
			if (counter >= 75) {
				feederMotor.set(-1);
			}
	}
		
	public void releaseGear() {
		gearCounter ++;
		shooterMotor.set(0.3);
		Timer.delay(0.5);
		shooterMotor.set(0);
		
	}
	
	public void stop() {
		shooterMotor.set(0);
		feederMotor.set(0);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

