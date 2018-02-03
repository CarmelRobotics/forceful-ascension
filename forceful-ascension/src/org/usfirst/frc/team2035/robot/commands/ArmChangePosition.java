package org.usfirst.frc.team2035.robot.commands;

import org.usfirst.frc.team2035.robot.Robot;
import org.usfirst.frc.team2035.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.Command;

public class ArmChangePosition extends Command {
	
	private Arm arm;
	private double desiredPos;
	
	
	public ArmChangePosition(double desiredPos) {
		// Use requires() here to declare subsystem dependencies
		super("ArmChangePosition");
		
		arm = Robot.getArm();
		this.desiredPos = desiredPos;
		requires(Robot.getArm());
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		
		arm.armChangeAngle(desiredPos);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return true;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		arm.armAnglerStop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		arm.armAnglerStop();
	}
}
