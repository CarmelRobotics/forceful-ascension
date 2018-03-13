package org.usfirst.frc.team2035.robot.commands;

import org.usfirst.frc.team2035.robot.OI;
import org.usfirst.frc.team2035.robot.Robot;
import org.usfirst.frc.team2035.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.Command;

public class ArmClimb extends Command {
	
	private Arm arm;
	
	public static OI oi;
	
	public ArmClimb() {
		// Use requires() here to declare subsystem dependencies
		super("ArmClimb");
		
		arm = Robot.getArm();
		
		requires(Robot.getArm());
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		oi = new OI();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		
		arm.climb();
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		arm.extendStop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		arm.extendStop();
	}
}
