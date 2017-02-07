package org.usfirst.frc.team5137.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5137.robot.*;

/**
 *
 */
public class AimShooter extends Command {

    public AimShooter() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveBase);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveBase.centerX();
    	if (Robot.driveBase.isXCentered) {
    		Robot.driveBase.centerY();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (Robot.driveBase.isXCentered && Robot.driveBase.isYCentered) {
        	return true;
        }
        
        else {
        	return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveBase.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
