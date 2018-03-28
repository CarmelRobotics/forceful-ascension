package org.usfirst.frc.team2035.robot.commands;

import org.usfirst.frc.team2035.robot.Robot;
import org.usfirst.frc.team2035.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ToggleInverseMovement extends Command {

	Drivetrain drt;
	private boolean inverse;
	
    public ToggleInverseMovement() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	drt = Robot.getDrivetrain();
    	inverse = drt.driveInverse;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (inverse)
    		inverse = false;
    	else
    		inverse = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
