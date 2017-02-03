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
	double zIn;
	
	public void takeZAxis(Joystick driveStick2) {
		zIn = driveStick2.getZ();
		intakeRollerMotor.set(zIn);
	}
	
	public void intake() {
		intakeRollerMotor.set(-0.5);
	}
	
	public void stop() {
		intakeRollerMotor.set(0);
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	//setDefaultCommand(new Intake());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

