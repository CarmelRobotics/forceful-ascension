package org.usfirst.frc.team2035.robot.commands;

import org.usfirst.frc.team2035.robot.Robot;
import org.usfirst.frc.team2035.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.Command;

public class ArmChangePosition extends Command {
	
	private Arm arm;
	private double desiredPos;
	private boolean adjustmentFinished;
	
	
	public ArmChangePosition(double desiredPos) {
		// Use requires() here to declare subsystem dependencies
		super("ArmChangePosition");
		
		arm = Robot.getArm();
		adjustmentFinished = false;
		
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
		//System.out.println(arm.armChangeAngle(desiredPos));
		if(adjustmentFinished || arm.armChangeAngle(desiredPos)) //if we have decided the adjustment is finished
		{
				System.out.println("Somehow, AF is about to become true");
				adjustmentFinished = true;
		}
		
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		arm.armAnglerStop();
		adjustmentFinished = false;
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		arm.armAnglerStop();
		adjustmentFinished = false;
	}

}
