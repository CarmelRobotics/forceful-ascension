/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2035.robot.commands.auto;

import org.usfirst.frc.team2035.robot.OI;
import org.usfirst.frc.team2035.robot.Robot;
import org.usfirst.frc.team2035.robot.RobotMap;
import org.usfirst.frc.team2035.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.Command;

public class AutoArmChangePosition extends Command {
	
	private Arm arm;
	private double desiredPos;
	public static OI oi;
	
	public AutoArmChangePosition(double desiredPos) {
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
		arm.setAnglerPosition(-20275);
		oi = new OI();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		System.out.println("from auto arm: " + arm.getAnglerPosition());
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
		AutoSW.nextMove = true;
    	AutoSW.moveStep++;
    	System.out.print(AutoSW.moveStep);
		//arm.armChangeAngle(RobotMap.ARM_POSITION_0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		arm.armAnglerStop();
	}
}