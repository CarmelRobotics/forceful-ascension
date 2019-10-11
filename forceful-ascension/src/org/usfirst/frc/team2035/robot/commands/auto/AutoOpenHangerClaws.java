package org.usfirst.frc.team2035.robot.commands.auto;

import org.usfirst.frc.team2035.robot.OI;
import org.usfirst.frc.team2035.robot.Robot;
import org.usfirst.frc.team2035.robot.subsystems.Arm;
import org.usfirst.frc.team2035.robot.subsystems.CubeMech;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;



public class AutoOpenHangerClaws extends Command{
	
	private CubeMech cm;
	
	public static OI oi;
	private double totalTime;
	Timer t;
	
	public AutoOpenHangerClaws(double time) {
		super("OpenHangerClaws");
		
		cm = Robot.getCubeMech();
		
		t = new Timer();
		totalTime = time;
		
		requires(Robot.getCubeMech());
		
	}
	
	@Override
	protected void initialize() {
		
		oi = new OI();
		t.start();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		cm.openHangerClaws();
		
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
		cm.closeHangerClaws();
		AutoMain.nextMove = true;
    	AutoMain.moveStep++;
    	System.out.print(AutoMain.moveStep);    
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		cm.closeHangerClaws();
		
	}

}