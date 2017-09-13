package org.usfirst.frc.team5137.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team5137.robot.commands.*;

/**
 *
 */
public class HopperAuto extends CommandGroup {

    public HopperAuto(int side) {
    	if (side == 0) {
        	addSequential(new DriveStraightAuto(-0.5, 1.5));
        	addSequential(new DriveSidewaysAuto(-0.5, 1));
        	addSequential(new Shoot());
    	}
    	
    	else if (side == 1) {
        	addSequential(new DriveStraightAuto(-0.5, 1.5));
        	addSequential(new DriveSidewaysAuto(0.5, 1));
        	addSequential(new Shoot());
    	}

        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
