/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2035.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team2035.robot.OI;
import org.usfirst.frc.team2035.robot.Robot;
import org.usfirst.frc.team2035.robot.subsystems.Arm;
import org.usfirst.frc.team2035.robot.subsystems.CubeDepositer;
import org.usfirst.frc.team2035.robot.subsystems.CubeMech;

/**
 * Rolls the cube carrying mechanism's rollers in, taking in cubes.
 */
public class CubeIn extends Command {
	
	public static OI oi;
	private final CubeDepositer cbm;
	
	public CubeIn() {
		cbm = Robot.getCubeDepositer();
		requires(cbm);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		oi = new OI();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		cbm.rollIn();
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		cbm.stopRoll();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		cbm.stopRoll();
	}
}