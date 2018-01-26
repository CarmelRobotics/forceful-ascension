package org.usfirst.frc.team2035.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team2035.robot.OI;

import org.usfirst.frc.team2035.robot.subsystems.*;

import edu.wpi.first.wpilibj.Timer;

import org.usfirst.frc.team2035.robot.Robot;


/**
 *
 */
public class AutoSW_A extends Command {

	public static OI oi;
	public Timer sTimer;
	private Drivetrain driver;
	
    public AutoSW_A(char whichSwitch) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    	oi = new OI();
    	sTimer = new Timer();
    }
    
    //Set speed and rotation variables based upon which position we are in.
    if (whichSwitch == 'L') // If switch is on the left
    {
    	if (TEMPPOSITION == 1)
    	{
    		speed1 = POS_L1_SPEED1
    		speed2 = POS_L1_SPEED2
    		speed3 = POS_L1_SPEED3
    		rotation1 = POS_L1_ROTATION1
    		rotation2 = POS_L1_ROTATION2
    		
    	}
    	if (TEMPPOSITION == 2)
    	{
    		speed1 = POS_L2_SPEED1
    	    speed2 = POS_L2_SPEED2
    	    speed3 = POS_L2_SPEED3
    	    rotation1 = POS_L2_ROTATION1
    		rotation2 = POS_L2_ROTATION2
    	}
    	if (TEMPPOSITION == 3) {
    		speed1 = POS_L3_SPEED1
    	    speed2 = POS_L3_SPEED2
    	    speed3 = POS_L3_SPEED3
    	    rotation1 = POS_L3_ROTATION1
    	    rotation2 = POS_L3_ROTATION2
    	}
    
    }
    else if (whichSwitch == 'R') // If Switch is on the right
    {
    	if (TEMPPOSITION == 1)
    	{
    		speed1 = POS_R1_SPEED1
    	    speed2 = POS_R1_SPEED2
    	    speed3 = POS-R1_SPEED3
    	    rotation1 = POS_R1_ROTATION1
    	    rotation2 = POS_R1_ROTATION2
    	}
    	if (TEMPPOSITION == 2)
    	{
    		speed1 = POS_R2_SPEED1
    	    speed2 = POS_R2_SPEED2
    	    speed3 = POS_R2_SPEED3
    	    rotation1 = POS_R2_ROTATION1
    	    rotation2 = POS_R2_ROTATION2
    		
    	}
    	if (TEMPPOSITION == 3) {
    		speed1 = POS_R3_SPEED1
    	    speed2 = POS_R3_SPEED2
    	    speed3 = POS_R3_SPEED3
    	    rotation1 = POS_R3_ROTATION1
    	    rotation2 = POS_R3_ROTATION2
    	}
    }
    
    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    
    	// First Movement (Forward)
    	sTimer.start();
    	double loopStartTime = sTimer.get();
    	while(sTimer.get() <= (loopStartTime + 1))
    	{
    		driver.numericDrive(speed1, 0.0, false);
    	}
    	
    	// Second Movement (Turn)
    	loopStartTime = sTimer.get();
    	while(sTimer.get() <= (loopStartTime + 1))
    	{
    		driver.numericDrive(0.0, rotation1, true);
    	}
    	
    	// Third Movement (Forward)
    	loopStartTime = sTimer.get();
    	while(sTimer.get() <= (loopStartTime + 1))
    	{
    		driver.numericDrive(speed2, 0.0, false);
    	}
    	
    	// Fourth Movement (Turn)
    	loopStartTime = sTimer.get();
    	while(sTimer.get() <= (loopStartTime + 1))
    	{
    		driver.numericDrive(0.0, rotation2, true);
    	}
    	
    	// Fifth Movement (Forward)
    	loopStartTime = sTimer.get();
    	while(sTimer.get() <= (loopStartTime + 1))
    	{
    		driver.numericDrive(speed3, 0.0, false);
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
