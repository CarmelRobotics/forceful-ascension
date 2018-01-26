package org.usfirst.frc.team2035.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team2035.robot.OI;

import org.usfirst.frc.team2035.robot.subsystems.*;

import edu.wpi.first.wpilibj.Timer;

import org.usfirst.frc.team2035.robot.Robot;


/**
 *
 */
public class AutoSW_B extends Command {

	public static OI oi;
	public Timer sTimer;
	private Drivetrain driver;
	
	
    public AutoSW_B(char whichSwitch) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    	oi = new OI();
    	sTimer = new Timer();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    
    	// First Movement (Forward)
    	sTimer.start();
    	double loopStartTime = sTimer.get();
    	while(sTimer.get() <= (loopStartTime + 1))
    	{
    		driver.numericDrive(1.0, 0.0, false);
    	}
    	// Second Movement (Turn)
    	loopStartTime = sTimer.get();
    	while(sTimer.get() <= (loopStartTime + 1))
    	{
    		driver.numericDrive(1.0, 0.0, false);
    	}
    	// Third Movement (Forward)
    	loopStartTime = sTimer.get();
    	while(sTimer.get() <= (loopStartTime + 1))
    	{
    		driver.numericDrive(1.0, 0.0, false);
    	}
    	// Fourth Movement (Turn)
    	loopStartTime = sTimer.get();
    	while(sTimer.get() <= (loopStartTime + 1))
    	{
    		driver.numericDrive(1.0, 0.0, false);
    	}
    	// Fifth Movement (Forward)
    	loopStartTime = sTimer.get();
    	while(sTimer.get() <= (loopStartTime + 1))
    	{
    		driver.numericDrive(1.0, 0.0, false);
    	}
    	
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
