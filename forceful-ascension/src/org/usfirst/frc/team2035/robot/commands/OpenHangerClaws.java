package org.usfirst.frc.team2035.robot.commands;

import org.usfirst.frc.team2035.robot.Robot;
import org.usfirst.frc.team2035.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.Command;



public class OpenHangerClaws extends Command{
	
	private Arm arm;

	public OpenHangerClaws() {
		super("OpenHangerClaws");
		
		arm = Robot.getArm();
		
		requires(Robot.getArm());
		
	}
	
	@Override
	protected void initialize() {
		
		
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		arm.openHangerClaws();
		
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		arm.closeHangerClaws();
		
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		
		
	}

}
