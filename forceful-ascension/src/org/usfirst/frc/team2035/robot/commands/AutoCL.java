package org.usfirst.frc.team2035.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team2035.robot.OI;

import org.usfirst.frc.team2035.robot.subsystems.*;

import edu.wpi.first.wpilibj.Timer;

import org.usfirst.frc.team2035.robot.Robot;
import org.usfirst.frc.team2035.robot.AutoValues;


/**
 * Autonomous for only crossing line - modified from branch "Tyler's_Branch"
 */
public class AutoCL extends Command {

	public static OI oi;
	public Timer sTimer;
	private Drivetrain driver;
	//private Arm arm;
	private char side;
	private int start;
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
	private double cubeReleaseTime;
	Command releaseTheCube;
	Command autoSwitch2;
	
    public AutoCL(char whichSide, int startS_POS) {
        side = whichSide;
        start = startS_POS;
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
    
    	// First Movement (Forward)
    	sTimer.start();
    	while(sTimer.get() <= (t1)) {
    		driver.drive(spd1, 0.0);
    	}
    	
    	// Second Movement (Turn)
//    	while(sTimer.get() <= (t2)) {
//    		driver.drive(0.0, rot1);
 //   	}
//    
//    	// Third Movement (Forward)
//    	while(sTimer.get() <= (t3)) {
//    		driver.drive(spd2, 0.0);
 //   	}
 //   	
 //   	// Fourth Movement (Turn)
//    	while(sTimer.get() <= (t4))
 //   	{
//    		driver.drive(0.0, rot2);
 //   	}
  // 	
 //   	// Fifth Movement (Forward)
//    	while(sTimer.get() <= (t5)) {
//    		driver.drive(spd3, 0.0);
//    	}
 //   	
 //   	//Cube Release
 //   	while(sTimer.get() <= (cubeReleaseTime)) {
//    		releaseTheCube.start();
 //   	}
//    	autoSwitch2.start();
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
    	if (side == 'L') // If switch is on the left
        {
        	if (start == 1)
        	{
        		spd1 = AutoValues.S_POS1_SWL_SPD1;
        		spd2 = AutoValues.S_POS1_SWL_SPD2;
        		spd3 = AutoValues.S_POS1_SWL_SPD3;
        		rot1 = AutoValues.S_POS1_SWL_ROT1;
        		rot2 = AutoValues.S_POS1_SWL_ROT2;
        		t1 = AutoValues.S_POS1_SWL_T1;
        		t2 = AutoValues.S_POS1_SWL_T2;
        		t3 = AutoValues.S_POS1_SWL_T3;
        		t4 = AutoValues.S_POS1_SWL_T4;
        		t5 = AutoValues.S_POS1_SWL_T5;
        	}
        	if (start == 2)
        	{
        		spd1 = AutoValues.S_POS2_SWL_SPD1;
        		spd2 = AutoValues.S_POS2_SWL_SPD2;
        		spd3 = AutoValues.S_POS2_SWL_SPD3;
        		rot1 = AutoValues.S_POS2_SWL_ROT1;
        		rot2 = AutoValues.S_POS2_SWL_ROT2;
        		t1 = AutoValues.S_POS2_SWL_T1;
        		t2 = AutoValues.S_POS2_SWL_T2;
        		t3 = AutoValues.S_POS2_SWL_T3;
        		t4 = AutoValues.S_POS2_SWL_T4;
        		t5 = AutoValues.S_POS2_SWL_T5;
        	}
        	if (start == 3) {
        		spd1 = AutoValues.S_POS3_SWL_SPD1;
        		spd2 = AutoValues.S_POS3_SWL_SPD2;
        		spd3 = AutoValues.S_POS3_SWL_SPD3;
        		rot1 = AutoValues.S_POS3_SWL_ROT1;
        		rot2 = AutoValues.S_POS3_SWL_ROT2;
        		t1 = AutoValues.S_POS3_SWL_T1;
        		t2 = AutoValues.S_POS3_SWL_T2;
        		t3 = AutoValues.S_POS3_SWL_T3;
        		t4 = AutoValues.S_POS3_SWL_T4;
        		t5 = AutoValues.S_POS3_SWL_T5;
        	}
        }
        else if (side == 'R') // If Switch is on the right
        {
        	if (start == 1)
        	{
        		spd1 = AutoValues.S_POS1_SWR_SPD1;
        		spd2 = AutoValues.S_POS1_SWR_SPD2;
        		spd3 = AutoValues.S_POS1_SWR_SPD3;
        		rot1 = AutoValues.S_POS1_SWR_ROT1;
        		rot2 = AutoValues.S_POS1_SWR_ROT2;
        		t1 = AutoValues.S_POS1_SWR_T1;
        		t2 = AutoValues.S_POS1_SWR_T2;
        		t3 = AutoValues.S_POS1_SWR_T3;
        		t4 = AutoValues.S_POS1_SWR_T4;
        		t5 = AutoValues.S_POS1_SWR_T5;
        	}
        	if (start == 2)
        	{
        		spd1 = AutoValues.S_POS2_SWR_SPD1;
        		spd2 = AutoValues.S_POS2_SWR_SPD2;
        		spd3 = AutoValues.S_POS2_SWR_SPD3;
        		rot1 = AutoValues.S_POS2_SWR_ROT1;
        		rot2 = AutoValues.S_POS2_SWR_ROT2;
        		t1 = AutoValues.S_POS2_SWR_T1;
        		t2 = AutoValues.S_POS2_SWR_T2;
        		t3 = AutoValues.S_POS2_SWR_T3;
        		t4 = AutoValues.S_POS2_SWR_T4;
        		t5 = AutoValues.S_POS2_SWR_T5;
        	}
        	if (start == 3) {
        		spd1 = AutoValues.S_POS3_SWR_SPD1;
        		spd2 = AutoValues.S_POS3_SWR_SPD2;
        		spd3 = AutoValues.S_POS3_SWR_SPD3;
        		rot1 = AutoValues.S_POS3_SWR_ROT1;
        		rot2 = AutoValues.S_POS3_SWR_ROT2;
        		t1 = AutoValues.S_POS3_SWR_T1;
        		t2 = AutoValues.S_POS3_SWR_T2;
        		t3 = AutoValues.S_POS3_SWR_T3;
        		t4 = AutoValues.S_POS3_SWR_T4;
        		t5 = AutoValues.S_POS3_SWR_T5;
        	}
        }
    } 
   // private void ARMSOnTheNintendoSwitch() { //currently referencing code in branch "FangTaoTheRealOne"
    //	arm.armChangeAngle()
//    }
    
}