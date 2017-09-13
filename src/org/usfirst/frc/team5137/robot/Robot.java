
package org.usfirst.frc.team5137.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.I2C.*;
import edu.wpi.first.wpilibj.*;

import org.usfirst.frc.team5137.robot.commands.*;
import org.usfirst.frc.team5137.robot.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static UsbCamera camera;
	public static OI oi;
	public static DriveBase driveBase;
	public static SlideDrive slideDrive;
	public static IntakeRoller intakeRoller;
	public static Shooter shooter;
	public static Climber climber;
	DriverStation.Alliance color;
    public static I2C I2C;
    public static byte[] testByte;
    public String station;

	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		RobotMap.init();
		RobotMap.gyro.calibrate();  
		driveBase = new DriveBase();
		slideDrive = new SlideDrive();
		intakeRoller = new IntakeRoller();
		shooter = new Shooter();
		climber = new Climber();
		I2C = new I2C(edu.wpi.first.wpilibj.I2C.Port.kMXP ,84);
		camera = CameraServer.getInstance().startAutomaticCapture();
		camera.setResolution(320, 240);
		//camera.setFPS(10);
		color = DriverStation.getInstance().getAlliance();
		chooser.addDefault("Do Nothing", new ExampleCommand());
		chooser.addObject("Gear Auto", new GearAuto());
		chooser.addObject("Drive Forward", new DriveForward());
		chooser.addObject("Hopper Auto Blue", new HopperAuto(0));
		chooser.addObject("Hopper Auto Red", new HopperAuto(1));
		chooser.addObject("Low Goal Auto Blue", new LowGoalAutoBlue());
		chooser.addObject("Low Goal Auto Red", new LowGoalAutoRed());
		
		SmartDashboard.putData("Auto mode", chooser);
		SmartDashboard.putNumber("Rear Distance", RobotMap.rearUltraSonic.getVoltage());
		SmartDashboard.putNumber("Left Distance", RobotMap.leftUltraSonic.getVoltage());
		SmartDashboard.putNumber("Front Distance", RobotMap.frontUltraSonic.getVoltage());
		SmartDashboard.putNumber("Right Distance", RobotMap.rightUltraSonic.getVoltage());
        //testByte = new byte;
        // OI must be constructed after subsystems. If the OI creates Commands 
        //(which it very likely will), subsystems are not guaranteed to be 
        // constructed yet. Thus, their requires() statements may grab null 
        // pointers. Bad news. Don't move it.
		oi = new OI();

	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		I2C.write(84, 42);
		autonomousCommand = chooser.getSelected();
		//autonomousCommand = new HopperAuto();
		shooter.releaseGear();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();

	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();

		if(color == DriverStation.Alliance.Blue){
			SmartDashboard.putString(station, "Blue");
			//testByte[0] = 22;
			I2C.write(84, 22);
		}
		
		else if (color == DriverStation.Alliance.Red) {
			SmartDashboard.putString(station, "Red");
			//testByte[0] = 4;
			//I2C.writeBulk(testByte);
			I2C.write(84, 4);
		}
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
