package org.usfirst.frc.team2035.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team2035.robot.OI;

import org.usfirst.frc.team2035.robot.subsystems.*;

import edu.wpi.first.wpilibj.Timer;

import org.usfirst.frc.team2035.robot.Robot;
import org.usfirst.frc.team2035.robot.AutoValues;


/**
 * Autonomous for placing cube on middle switch after crossing line - modified from branch "Tyler's_Branch"
 */
public class AutoMID extends Command {

	public static OI oi;
	public Timer sTimer;
	private Drivetrain driver;
	private char sw;
	private char sd;
	private double spd1;
	private double spd2;
	private double spd3;
	private double rot1;
	private double rot2;
	private double t1;
	private double t2;
	private double t3;
	private double t4;
	private double t5;
	private double tCurrent;
	
    public AutoMID(char whichSide) {
        sd = whichSide;
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    	oi = new OI();
    	sTimer = new Timer();
    	decideMovement();
    	tCurrent = 0.0;
    	sTimer.start();
    }
    
    //Set speed and rotation variables based upon which position we are in.
    
    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    	
    	// First Movement (Backward)
    	while(sTimer.get() <= (t1)) {
    		driver.drive(-spd1, 0.0);
    	}
    	
    	tCurrent = sTimer.get();
    	// Second Movement (Turn)
    	while(sTimer.get() <= (tCurrent + t2)) {
    		driver.drive(0.0, rot1);
    	}

    	tCurrent = sTimer.get();
    	// Third Movement (Forward)
    	while(sTimer.get() <= (tCurrent + t3)) {
    		driver.drive(-spd2, 0.0);
    	}

    	tCurrent = sTimer.get();
    	// Fourth Movement (Turn)
    	while(sTimer.get() <= (tCurrent + t4))
    	{
    		driver.drive(0.0, rot2);
    	}

    	tCurrent = sTimer.get();
    	// Fifth Movement (Forward)
    	while(sTimer.get() <= (tCurrent + t5)) {
    		driver.drive(-spd3, 0.0);
    	}
    	
    	
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
    
    
    private void decideMovement() {
    	if (sw == 'L') // If switch is on the left
        {
    	 if (sd == 'L')
        	{
        		spd1 = AutoValues.S2_SWL_SDL_SPD1;
        		spd2 = AutoValues.S2_SWL_SDL_SPD2;
        		spd3 = AutoValues.S2_SWL_SDL_SPD3;
        		rot1 = AutoValues.S2_SWL_SDL_ROT1;
        		rot2 = AutoValues.S2_SWL_SDL_ROT2;
        		t1 = AutoValues.S2_SWL_SDL_T1;
        		t2 = AutoValues.S2_SWL_SDL_T2;
        		t3 = AutoValues.S2_SWL_SDL_T3;
        		t4 = AutoValues.S2_SWL_SDL_T4;
        		t5 = AutoValues.S2_SWL_SDL_T5;
        	}
    	 else if (sd == 'R')
        	{
        		spd1 = AutoValues.S2_SWL_SDR_SPD1;
        		spd2 = AutoValues.S2_SWL_SDR_SPD2;
        		spd3 = AutoValues.S2_SWL_SDR_SPD3;
        		rot1 = AutoValues.S2_SWL_SDR_ROT1;
        		rot2 = AutoValues.S2_SWL_SDR_ROT2;
        		t1 = AutoValues.S2_SWL_SDR_T1;
        		t2 = AutoValues.S2_SWL_SDR_T2;
        		t3 = AutoValues.S2_SWL_SDR_T3;
        		t4 = AutoValues.S2_SWL_SDR_T4;
        		t5 = AutoValues.S2_SWL_SDR_T5;
        	}
        }
        else if (sw == 'R') // If Switch is on the right
        {
        	if (sd == 'L')
        	{
        		spd1 = AutoValues.S2_SWR_SDL_SPD1;
        		spd2 = AutoValues.S2_SWR_SDL_SPD2;
        		spd3 = AutoValues.S2_SWR_SDL_SPD3;
        		rot1 = AutoValues.S2_SWR_SDL_ROT1;
        		rot2 = AutoValues.S2_SWR_SDL_ROT2;
        		t1 = AutoValues.S2_SWR_SDL_T1;
        		t2 = AutoValues.S2_SWR_SDL_T2;
        		t3 = AutoValues.S2_SWR_SDL_T3;
        		t4 = AutoValues.S2_SWR_SDL_T4;
        		t5 = AutoValues.S2_SWR_SDL_T5;
        	}
        	else if (sd == 'R')
        	{
        		spd1 = AutoValues.S2_SWR_SDR_SPD1;
        		spd2 = AutoValues.S2_SWR_SDR_SPD2;
        		spd3 = AutoValues.S2_SWR_SDR_SPD3;
        		rot1 = AutoValues.S2_SWR_SDR_ROT1;
        		rot2 = AutoValues.S2_SWR_SDR_ROT2;
        		t1 = AutoValues.S2_SWR_SDR_T1;
        		t2 = AutoValues.S2_SWR_SDR_T2;
        		t3 = AutoValues.S2_SWR_SDR_T3;
        		t4 = AutoValues.S2_SWR_SDR_T4;
        		t5 = AutoValues.S2_SWR_SDR_T5;
        	}
        }
    } 
}