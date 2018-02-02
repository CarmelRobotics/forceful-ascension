package org.usfirst.frc.team2035.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team2035.robot.OI;

import org.usfirst.frc.team2035.robot.subsystems.*;

import edu.wpi.first.wpilibj.Timer;

import org.usfirst.frc.team2035.robot.Robot;
import org.usfirst.frc.team2035.robot.AutoValues;


/**
 * Autonomous for placing cube on switch and crossing line - modified from branch "Tyler's_Branch"
 */
public class AutoSW2 extends Command {

	public static OI oi;
	public Timer sTimer;
	private Drivetrain driver;
	private char sw;
	private int start;
	private double spd4;
	private double spd5;
	private double spd6;
	private double rot3;
	private double rot4;
	private double rot5;
	private double t6;
	private double t7;
	private double t8;
	private double t9;
	private double t10;
	private double t11;
	
    public AutoSW2(char whichSwitch, int startPos) {
        sw = whichSwitch;
        start = startPos;
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    	oi = new OI();
    	sTimer = new Timer();
    	decideMovement();
    }
    
    //Set speed and rotation variables based upon which position we are in.
    
    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {

    	// Sixth Movement (Turn)
    	while(sTimer.get() <= (t6))
    	{
    		driver.drive(0.0, rot3);
    	}
    	
    	// Seventh Movement (Forward)
    	sTimer.start();
    	while(sTimer.get() <= (t7)) {
    		driver.drive(spd4, 0.0);
    	}
    	
    	// Eighth Movement (Turn)
    	while(sTimer.get() <= (t8)) {
    		driver.drive(0.0, rot4);
    	}
    	
    	// Ninth Movement (Forward)
    	while(sTimer.get() <= (t9)) {
    		driver.drive(spd5, 0.0);
    	}
    	
    	// Tenth Movement (Turn)
    	while(sTimer.get() <= (t10))
    	{
    		driver.drive(0.0, rot5);
    	}
    	
    	// Eleventh Movement (Forward)
    	while(sTimer.get() <= (t11)) {
    		driver.drive(spd6, 0.0);
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
    
    private void decideMovement() {
    	if (sw == 'L') // If switch is on the left
        {
        	if (start == 1)
        	{
        		spd4 = AutoValues.S_POS1_SWL_SPD4;
        		spd5 = AutoValues.S_POS1_SWL_SPD5;
        		spd6 = AutoValues.S_POS1_SWL_SPD6;
        		rot3 = AutoValues.S_POS1_SWL_ROT3;
        		rot4 = AutoValues.S_POS1_SWL_ROT4;
        		rot5 = AutoValues.S_POS1_SWL_ROT5;
        		t6 = AutoValues.S_POS1_SWL_T6;
        		t7 = AutoValues.S_POS1_SWL_T7;
        		t8 = AutoValues.S_POS1_SWL_T8;
        		t9 = AutoValues.S_POS1_SWL_T9;
        		t10 = AutoValues.S_POS1_SWL_T10;
        		t11 = AutoValues.S_POS1_SWL_T10;
        	}
        	if (start == 2)
        	{
        		spd4 = AutoValues.S_POS2_SWL_SPD4;
        		spd5 = AutoValues.S_POS2_SWL_SPD5;
        		spd6 = AutoValues.S_POS2_SWL_SPD6;
        		rot3 = AutoValues.S_POS2_SWL_ROT3;
        		rot4 = AutoValues.S_POS2_SWL_ROT4;
        		rot5 = AutoValues.S_POS2_SWL_ROT5;
        		t6 = AutoValues.S_POS2_SWL_T6;
        		t7 = AutoValues.S_POS2_SWL_T7;
        		t8 = AutoValues.S_POS2_SWL_T8;
        		t9 = AutoValues.S_POS2_SWL_T9;
        		t10 = AutoValues.S_POS2_SWL_T10;
        		t11 = AutoValues.S_POS2_SWL_T11;
        	}
        	if (start == 3) {
        		spd4 = AutoValues.S_POS3_SWL_SPD4;
        		spd5 = AutoValues.S_POS3_SWL_SPD5;
        		spd6 = AutoValues.S_POS3_SWL_SPD6;
        		rot3 = AutoValues.S_POS3_SWL_ROT3;
        		rot4 = AutoValues.S_POS3_SWL_ROT4;
        		rot5 = AutoValues.S_POS3_SWL_ROT5;
        		t6 = AutoValues.S_POS3_SWL_T6;
        		t7 = AutoValues.S_POS3_SWL_T7;
        		t8 = AutoValues.S_POS3_SWL_T8;
        		t9 = AutoValues.S_POS3_SWL_T9;
        		t10 = AutoValues.S_POS3_SWL_T10;
        		t11 = AutoValues.S_POS3_SWL_T11;
        	}
        }
        else if (sw == 'R') // If Switch is on the right
        {
        	if (start == 1)
        	{
        		spd4 = AutoValues.S_POS1_SWR_SPD4;
        		spd5 = AutoValues.S_POS1_SWR_SPD5;
        		spd6 = AutoValues.S_POS1_SWR_SPD6;
        		rot3 = AutoValues.S_POS1_SWR_ROT4;
        		rot4 = AutoValues.S_POS1_SWR_ROT4;
        		rot5 = AutoValues.S_POS1_SWR_ROT5;
        		t6 = AutoValues.S_POS1_SWR_T6;
        		t7 = AutoValues.S_POS1_SWR_T7;
        		t8 = AutoValues.S_POS1_SWR_T8;
        		t9 = AutoValues.S_POS1_SWR_T9;
        		t10 = AutoValues.S_POS1_SWR_T10;
        		t11 = AutoValues.S_POS1_SWR_T11;
        	}
        	if (start == 2)
        	{
        		spd4 = AutoValues.S_POS2_SWR_SPD4;
        		spd5 = AutoValues.S_POS2_SWR_SPD5;
        		spd6 = AutoValues.S_POS2_SWR_SPD6;
        		rot3 = AutoValues.S_POS2_SWR_ROT3;
        		rot4 = AutoValues.S_POS2_SWR_ROT4;
        		rot5 = AutoValues.S_POS2_SWR_ROT5;
        		t6 = AutoValues.S_POS2_SWR_T6;
        		t7 = AutoValues.S_POS2_SWR_T7;
        		t8 = AutoValues.S_POS2_SWR_T8;
        		t9 = AutoValues.S_POS2_SWR_T9;
        		t10 = AutoValues.S_POS2_SWR_T10;
        		t11 = AutoValues.S_POS2_SWR_T11;
        	}
        	if (start == 3) {
        		spd4 = AutoValues.S_POS3_SWR_SPD4;
        		spd5 = AutoValues.S_POS3_SWR_SPD5;
        		spd6 = AutoValues.S_POS3_SWR_SPD6;
        		rot3 = AutoValues.S_POS3_SWR_ROT3;
        		rot4 = AutoValues.S_POS3_SWR_ROT4;
        		rot5 = AutoValues.S_POS3_SWR_ROT5;
        		t6 = AutoValues.S_POS3_SWR_T6;
        		t7 = AutoValues.S_POS3_SWR_T7;
        		t8 = AutoValues.S_POS3_SWR_T8;
        		t9 = AutoValues.S_POS3_SWR_T9;
        		t10 = AutoValues.S_POS3_SWR_T10;
        		t11 = AutoValues.S_POS3_SWR_T11;
        	}
        }
    } 
}