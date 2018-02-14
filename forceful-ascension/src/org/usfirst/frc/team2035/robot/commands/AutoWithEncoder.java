package org.usfirst.frc.team2035.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2035.robot.OI;
import org.usfirst.frc.team2035.robot.subsystems.*;
import org.usfirst.frc.team2035.robot.Robot;
import org.usfirst.frc.team2035.robot.AutoValues;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


/**
 * Autonomous for placing cube on switch and crossing line - modified from branch "Tyler's_Branch"
 */
public class AutoWithEncoder extends Command {

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
	private double tCurrent;
	private double cubeReleaseTime;
	//encoder stuff
	private Arm arm;
	Command releaseTheCube;
	Command autoSwitch2;
	
    public AutoWithEncoder(char whichSwitch, int startPos, char sidePass, boolean secondBox) {
        sw = whichSwitch;
        start = startPos;
        sd = sidePass;
        box = secondBox;
        driver = Robot.getDrivetrain();
        
        releaseTheCube = new CubeOut();
        cubeReleaseTime = 0.0;
        autoSwitch2 = new AutoSW2(sw, sd, box);
        //encoder stuff
        arm = Robot.getArm();
		requires(Robot.getArm());
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    	oi = new OI();
    	decideMovement();
    }
    
    //Set speed and rotation variables based upon which position we are in.
    
    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {

    	// First Movement (Forward)
    	while()
    		driver.drive(-spd1, 0.0);
    	tCurrent = sTimer.get();
    	
    	// Second Movement (Turn)
    	while()
    		driver.drive(0.0, rot1);
    	tCurrent = sTimer.get();
    	
    	// Third Movement (Forward)
    	while()
    		driver.drive(-spd2, 0.0);
    	tCurrent = sTimer.get();
    	
    	// Fourth Movement (Turn)
    	while()
    		driver.drive(0.0, rot2);
    	tCurrent = sTimer.get();
    	
    	// Fifth Movement (Forward)
    	while()
    		driver.drive(-spd3, 0.0);
    	
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
        		spd1 = AutoValues.S1_POS1_SWL_SPD1;
        		spd2 = AutoValues.S1_POS1_SWL_SPD2;
        		spd3 = AutoValues.S1_POS1_SWL_SPD3;
        		rot1 = AutoValues.S1_POS1_SWL_ROT1;
        		rot2 = AutoValues.S1_POS1_SWL_ROT2;
        		System.out.println("POSITION A");
        	}
        	else if (start == 1)
        	{
        		spd1 = AutoValues.S1_POS2_SWL_SPD1;
        		spd2 = AutoValues.S1_POS2_SWL_SPD2;
        		spd3 = AutoValues.S1_POS2_SWL_SPD3;
        		rot1 = AutoValues.S1_POS2_SWL_ROT1;
        		rot2 = AutoValues.S1_POS2_SWL_ROT2;
        		System.out.println("POSITION B");
        	}
        	else if (start == 2) {
        		spd1 = AutoValues.S1_POS3_SWL_SPD1;
        		spd2 = AutoValues.S1_POS3_SWL_SPD2;
        		spd3 = AutoValues.S1_POS3_SWL_SPD3;
        		rot1 = AutoValues.S1_POS3_SWL_ROT1;
        		rot2 = AutoValues.S1_POS3_SWL_ROT2;
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
        	}
        	else if (start == 1)
        	{
        		spd1 = AutoValues.S1_POS2_SWR_SPD1;
        		spd2 = AutoValues.S1_POS2_SWR_SPD2;
        		spd3 = AutoValues.S1_POS2_SWR_SPD3;
        		rot1 = AutoValues.S1_POS2_SWR_ROT1;
        		rot2 = AutoValues.S1_POS2_SWR_ROT2;
        	}
        	else if (start == 2) {
        		spd1 = AutoValues.S1_POS3_SWR_SPD1;
        		spd2 = AutoValues.S1_POS3_SWR_SPD2;
        		spd3 = AutoValues.S1_POS3_SWR_SPD3;
        		rot1 = AutoValues.S1_POS3_SWR_ROT1;
        		rot2 = AutoValues.S1_POS3_SWR_ROT2;
        	}
        }
    } 
    
   // private void ARMSOnTheNintendoSwitch() { //currently referencing code in branch "FangTaoTheRealOne"
    //	arm.armChangeAngle()
//    }
    
}