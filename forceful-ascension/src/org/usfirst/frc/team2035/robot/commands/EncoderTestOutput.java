package org.usfirst.frc.team2035.robot.commands;

import org.usfirst.frc.team2035.robot.OI;
import org.usfirst.frc.team2035.robot.Robot;
import org.usfirst.frc.team2035.robot.subsystems.EncoderTest;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Command;

public class EncoderTestOutput extends Command {
	private EncoderTest test;
	public static OI oi;
	public EncoderTestOutput() {
		// Use requires() here to declare subsystem dependencies
		
		test = Robot.getEncoderTest();
		requires(test);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		oi = new OI(); 
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		System.out.println("hi from command");
		test.test();
		
	}

	
	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		test.endTest();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		test.endTest();
	}
}



