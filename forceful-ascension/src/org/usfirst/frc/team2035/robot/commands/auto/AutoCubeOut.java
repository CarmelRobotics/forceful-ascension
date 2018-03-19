/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2035.robot.commands.auto;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team2035.robot.OI;
import org.usfirst.frc.team2035.robot.Robot;
import org.usfirst.frc.team2035.robot.subsystems.CubeMech;

/**
 * Rolls the cube carrying mechanism's rollers out, rejecting cubes.
 */
public class AutoCubeOut extends Command {
	
	public static OI oi;
	private final CubeMech cbm;
	private double totalTime;
	Timer t;
	
	public AutoCubeOut(double time) {
		cbm = Robot.getCubeMech();
		t = new Timer();
		totalTime = time;
		requires(cbm);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		oi = new OI();
		t.start();
	}
	
	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		cbm.rollOut();
	}
	
	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		if (t.get() < totalTime)
			return false;
		else
			return true;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		cbm.stopRoll();
		AutoSW.nextMove = true;
    	AutoSW.moveStep++;
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		cbm.stopRoll();
	}
}