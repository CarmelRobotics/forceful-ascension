package org.usfirst.frc.team2035.robot.commands;

import org.usfirst.frc.team2035.robot.OI;
import org.usfirst.frc.team2035.robot.Robot;
import org.usfirst.frc.team2035.robot.RobotMap;
import org.usfirst.frc.team2035.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.Command;

public class ArmChangePosition extends Command {
	
	private Arm arm;
	private double desiredPos;
	public static OI oi;
	
	public ArmChangePosition(double desiredPos) {
		// Use requires() here to declare subsystem dependencies
		super("ArmChangePosition");
		
		arm = Robot.getArm();
		this.desiredPos = desiredPos;
		System.out.println("hi from acp");
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
		System.out.println("hi from acp");
		//arm.armChangeAngle(desiredPos);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return arm.armChangeAngle(desiredPos);
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		arm.armAnglerStop();
		//arm.armChangeAngle(RobotMap.ARM_POSITION_0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		arm.armAnglerStop();
	}
}
