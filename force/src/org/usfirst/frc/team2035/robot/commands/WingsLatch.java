package org.usfirst.frc.team2035.robot.commands;

import org.usfirst.frc.team2035.robot.OI;
import org.usfirst.frc.team2035.robot.Robot;
import org.usfirst.frc.team2035.robot.subsystems.Wings;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Turns the solenoids keeping the wings up on. Keep this on until lifting robots.
 */
public class WingsLatch extends Command {

	public static OI oi;
	private final Wings wng;
	
	public WingsLatch() {
		wng = Robot.getWings();
		requires(wng);
	}

    // Called just before this Command runs the first time
	protected void initialize() {
    	oi = new OI();
    }

    // Called repeatedly when this Command is scheduled to run
	protected void execute() {
		wng.wingsSolenoidsOn();
    }

    // Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
    }

    // Called once after isFinished returns true
	protected void end() {
	}

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
	protected void interrupted() {
	}
}
