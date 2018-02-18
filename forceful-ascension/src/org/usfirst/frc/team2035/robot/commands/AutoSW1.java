package org.usfirst.frc.team2035.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team2035.robot.OI;

import org.usfirst.frc.team2035.robot.subsystems.*;

import edu.wpi.first.wpilibj.Timer;

import org.usfirst.frc.team2035.robot.Robot;
import org.usfirst.frc.team2035.robot.AutoValues;
import org.usfirst.frc.team2035.robot.AutoValuesBetter;


/**
 * Autonomous for placing cube on switch and crossing line - modified from branch "Tyler's_Branch"
 */
public class AutoSW1 extends Command {

	public static OI oi;
	public Timer sTimer;
	private Drivetrain driver;
	//private Arm arm;
	private char sw;
	private int start;
	private char sd;
	private boolean box;
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
	private double cubeReleaseTime;
	Command releaseTheCube;
	Command autoSwitch2;
	
    public AutoSW1(char whichSwitch, int startPos, char sidePass, boolean secondBox) {
        sw = whichSwitch;
        start = startPos;
        sd = sidePass;
        box = secondBox;
        driver = Robot.getDrivetrain();
        tCurrent = 0.0;
        releaseTheCube = new CubeOut();
        cubeReleaseTime = 0.0;
        autoSwitch2 = new AutoSW2(sw, sd, box);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    	oi = new OI();
    	sTimer = new Timer();
    	oldDecideMovement();
    	sTimer.start();
    	
    }
    
    //Set speed and rotation variables based upon which position we are in.
    
    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {

    	// First Movement (Forward)
    	while(sTimer.get() <= (t1))
    		driver.drive(-spd1, AutoValues.CURVE_ERROR_COUNTERACT);
    	tCurrent = sTimer.get();
    	
    	// Second Movement (Turn)
    	while(sTimer.get() <= (tCurrent + t2))
    		driver.drive(0.0, rot1);
    	tCurrent = sTimer.get();
    	
    	// Third Movement (Forward)
    	while(sTimer.get() <= (tCurrent + t3))
    		driver.drive(-spd2, AutoValues.CURVE_ERROR_COUNTERACT);
    	tCurrent = sTimer.get();
    	
    	// Fourth Movement (Turn)
    	while(sTimer.get() <= (tCurrent + t4))
    		driver.drive(0.0, rot2);
    	tCurrent = sTimer.get();
    	
    	// Fifth Movement (Forward)
    	while(sTimer.get() <= (tCurrent + t5))
    		driver.drive(-spd3, 0.0);
    	tCurrent = sTimer.get();
    	
    	//Cube Release
    	//while(sTimer.get() <= (tCurrent + cubeReleaseTime))
    		//releaseTheCube.start();
    	
    	//autoSwitch2.start();
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
        	if (start == 0)
        	{
        		spd1 = AutoValuesBetter.START_SWITCHSIDE_SPD;
        		spd2 = AutoValuesBetter.SWITCHSIDE_SHORTAPPROACH_SPD;
        		spd3 = 0.0;
        		rot1 = AutoValuesBetter.TURN_RIGHT_SPD;
        		t1 = AutoValuesBetter.START_SWITCHSIDE_TIME;
        		t2 = AutoValuesBetter.TURN_RIGHT_SPD;
        		t3 = AutoValuesBetter.SWITCHSIDE_SHORTAPPROACH_TIME;
        		t4 = 0.0;
        		t5 = 0.0;
        	}
        	else if (start == 1) {
        		spd1 = AutoValuesBetter.START_BRIDGE_SPD;
        		spd2 = AutoValuesBetter.BRIDGEPOS2_LEFTSHORT_SPD;
        		spd3 = AutoValuesBetter.BRIDGE_SWITCHFRONT_SPD;
        		rot1 = AutoValuesBetter.TURN_LEFT_SPD;
        		rot2 = AutoValuesBetter.TURN_RIGHT_SPD;
        		t1 = AutoValuesBetter.START_BRIDGE_TIME;
        		t2 = AutoValuesBetter.TURN_LEFT_TIME;
        		t3 = AutoValuesBetter.BRIDGEPOS2_LEFTSHORT_TIME;
        		t4 = AutoValuesBetter.TURN_RIGHT_TIME;
        		t5 = AutoValuesBetter.BRIDGE_SWITCHFRONT_TIME;
        	}
        	else if (start == 2) {
        		spd1 = AutoValuesBetter.START_BRIDGE_SPD;
        		spd2 = AutoValuesBetter.BRIDGESIDE_CROSSSWITCH_SPD;
        		spd3 = AutoValuesBetter.BRIDGE_SWITCHFRONT_SPD;
        		rot1 = AutoValuesBetter.TURN_LEFT_SPD;
        		rot2 = AutoValuesBetter.TURN_RIGHT_SPD;
        		t1 = AutoValuesBetter.START_BRIDGE_TIME;
        		t2 = AutoValuesBetter.TURN_LEFT_TIME;
        		t3 = AutoValuesBetter.BRIDGESIDE_CROSSSWITCH_TIME;
        		t4 = AutoValuesBetter.TURN_RIGHT_TIME;
        		t5 = AutoValuesBetter.BRIDGE_SWITCHFRONT_TIME;
        	}
        }
        else if (sw == 'R') // If Switch is on the right
        {
        	if (start == 0) {
        		spd1 = AutoValuesBetter.START_BRIDGE_SPD;
        		spd2 = AutoValuesBetter.BRIDGESIDE_CROSSSWITCH_SPD;
        		spd3 = AutoValuesBetter.BRIDGE_SWITCHFRONT_SPD;
        		rot1 = AutoValuesBetter.TURN_RIGHT_SPD;
        		rot2 = AutoValuesBetter.TURN_LEFT_SPD;
        		t1 = AutoValuesBetter.START_BRIDGE_TIME;
        		t2 = AutoValuesBetter.TURN_RIGHT_TIME;
        		t3 = AutoValuesBetter.BRIDGESIDE_CROSSSWITCH_TIME;
        		t4 = AutoValuesBetter.TURN_LEFT_TIME;
        		t5 = AutoValuesBetter.BRIDGE_SWITCHFRONT_TIME;
        	}
        	else if (start == 1) {
        		spd1 = AutoValuesBetter.START_BRIDGE_SPD;
        		spd2 = AutoValuesBetter.BRIDGEPOS2_LEFTSHORT_SPD;
        		spd3 = AutoValuesBetter.BRIDGE_SWITCHFRONT_SPD;
        		rot1 = AutoValuesBetter.TURN_RIGHT_SPD;
        		rot2 = AutoValuesBetter.TURN_LEFT_SPD;
        		t1 = AutoValuesBetter.START_BRIDGE_TIME;
        		t2 = AutoValuesBetter.TURN_LEFT_TIME;
        		t3 = AutoValuesBetter.BRIDGEPOS2_LEFTSHORT_TIME;
        		t4 = AutoValuesBetter.TURN_RIGHT_TIME;
        		t5 = AutoValuesBetter.BRIDGE_SWITCHFRONT_TIME;
        	}
        	else if (start == 2) {
        		spd1 = AutoValuesBetter.START_SWITCHSIDE_SPD;
        		spd2 = AutoValuesBetter.SWITCHSIDE_SHORTAPPROACH_SPD;
        		spd3 = 0.0;
        		rot1 = AutoValuesBetter.TURN_LEFT_SPD;
        		rot2 = 0.0;
        		t1 = AutoValuesBetter.START_BRIDGE_TIME;
        		t2 = AutoValuesBetter.TURN_LEFT_TIME;
        		t3 = AutoValuesBetter.SWITCHSIDE_SHORTAPPROACH_TIME;
        		t4 = 0.0;
        		t5 = 0.0;
        	}
        }
    } 
    private void oldDecideMovement() {
    	if (sw == 'L') // If switch is on the left
        {
        	if (start == 0)
        	{
        		spd1 = AutoValues.S1_POS1_SWL_SPD1;
        		spd2 = AutoValues.S1_POS1_SWL_SPD2;
        		spd3 = AutoValues.S1_POS1_SWL_SPD3;
        		rot1 = AutoValues.S1_POS1_SWL_ROT1;
        		rot2 = AutoValues.S1_POS1_SWL_ROT2;
        		t1 = AutoValues.S1_POS1_SWL_T1;
        		t2 = AutoValues.S1_POS1_SWL_T2;
        		t3 = AutoValues.S1_POS1_SWL_T3;
        		t4 = AutoValues.S1_POS1_SWL_T4;
        		t5 = AutoValues.S1_POS1_SWL_T5;
        		System.out.println("POSITION A");
        	}
        	else if (start == 1)
        	{
        		spd1 = AutoValues.S1_POS2_SWL_SPD1;
        		spd2 = AutoValues.S1_POS2_SWL_SPD2;
        		spd3 = AutoValues.S1_POS2_SWL_SPD3;
        		rot1 = AutoValues.S1_POS2_SWL_ROT1;
        		rot2 = AutoValues.S1_POS2_SWL_ROT2;
        		t1 = AutoValues.S1_POS2_SWL_T1;
        		t2 = AutoValues.S1_POS2_SWL_T2;
        		t3 = AutoValues.S1_POS2_SWL_T3;
        		t4 = AutoValues.S1_POS2_SWL_T4;
        		t5 = AutoValues.S1_POS2_SWL_T5;
        		System.out.println("POSITION B");
        	}
        	else if (start == 2) {
        		spd1 = AutoValues.S1_POS3_SWL_SPD1;
        		spd2 = AutoValues.S1_POS3_SWL_SPD2;
        		spd3 = AutoValues.S1_POS3_SWL_SPD3;
        		rot1 = AutoValues.S1_POS3_SWL_ROT1;
        		rot2 = AutoValues.S1_POS3_SWL_ROT2;
        		t1 = AutoValues.S1_POS3_SWL_T1;
        		t2 = AutoValues.S1_POS3_SWL_T2;
        		t3 = AutoValues.S1_POS3_SWL_T3;
        		t4 = AutoValues.S1_POS3_SWL_T4;
        		t5 = AutoValues.S1_POS3_SWL_T5;
        		System.out.println("POSITION C");
        	}
        }
        else if (sw == 'R') // If Switch is on the right
        {
        	if (start == 0)
        	{
        		spd1 = AutoValues.S1_POS1_SWR_SPD1;
        		spd2 = AutoValues.S1_POS1_SWR_SPD2;
        		spd3 = AutoValues.S1_POS1_SWR_SPD3;
        		rot1 = AutoValues.S1_POS1_SWR_ROT1;
        		rot2 = AutoValues.S1_POS1_SWR_ROT2;
        		t1 = AutoValues.S1_POS1_SWR_T1;
        		t2 = AutoValues.S1_POS1_SWR_T2;
        		t3 = AutoValues.S1_POS1_SWR_T3;
        		t4 = AutoValues.S1_POS1_SWR_T4;
        		t5 = AutoValues.S1_POS1_SWR_T5;
        	}
        	else if (start == 1)
        	{
        		spd1 = AutoValues.S1_POS2_SWR_SPD1;
        		spd2 = AutoValues.S1_POS2_SWR_SPD2;
        		spd3 = AutoValues.S1_POS2_SWR_SPD3;
        		rot1 = AutoValues.S1_POS2_SWR_ROT1;
        		rot2 = AutoValues.S1_POS2_SWR_ROT2;
        		t1 = AutoValues.S1_POS2_SWR_T1;
        		t2 = AutoValues.S1_POS2_SWR_T2;
        		t3 = AutoValues.S1_POS2_SWR_T3;
        		t4 = AutoValues.S1_POS2_SWR_T4;
        		t5 = AutoValues.S1_POS2_SWR_T5;
        	}
        	else if (start == 2) {
        		spd1 = AutoValues.S1_POS3_SWR_SPD1;
        		spd2 = AutoValues.S1_POS3_SWR_SPD2;
        		spd3 = AutoValues.S1_POS3_SWR_SPD3;
        		rot1 = AutoValues.S1_POS3_SWR_ROT1;
        		rot2 = AutoValues.S1_POS3_SWR_ROT2;
        		t1 = AutoValues.S1_POS3_SWR_T1;
        		t2 = AutoValues.S1_POS3_SWR_T2;
        		t3 = AutoValues.S1_POS3_SWR_T3;
        		t4 = AutoValues.S1_POS3_SWR_T4;
        		t5 = AutoValues.S1_POS3_SWR_T5;
        	}
        }
    } 
   // private void ARMSOnTheNintendoSwitch() { //currently referencing code in branch "FangTaoTheRealOne"
    //	arm.armChangeAngle()
//    }
    
}