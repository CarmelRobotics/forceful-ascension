package org.usfirst.frc.team2035.robot.commands;

import org.usfirst.frc.team2035.robot.OI;
import org.usfirst.frc.team2035.robot.Robot;
import org.usfirst.frc.team2035.robot.subsystems.Arm;
import org.usfirst.frc.team2035.robot.subsystems.CubeMech;

import edu.wpi.first.wpilibj.command.Command;



public class OpenHangerClaws extends Command{
	
	private CubeMech cm;
	
	public static OI oi;
	
	public OpenHangerClaws() {
		super("OpenHangerClaws");
		
		cm = Robot.getCubeMech();
		
		requires(Robot.getCubeMech());
		
	}
	
	@Override
	protected void initialize() {
		
		oi = new OI();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		cm.openHangerClaws();
		
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		cm.closeHangerClaws();
		
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		cm.closeHangerClaws();
		
	}

}
