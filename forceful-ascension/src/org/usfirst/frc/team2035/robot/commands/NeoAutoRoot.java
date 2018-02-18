package org.usfirst.frc.team2035.robot.commands;

import org.usfirst.frc.team2035.robot.AutoValuesBetter;
import org.usfirst.frc.team2035.robot.OI;
import org.usfirst.frc.team2035.robot.Robot;
import org.usfirst.frc.team2035.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class NeoAutoRoot extends Command {
	
	private int autoRootStatus; //0 = start of auto
	private boolean endAuto; //when 1, end this autonomous process
	private char sw;
	private int pos;
	public OI oi;
	public Timer sTimer;
	private Drivetrain driver;
	private double tCurrent;
	Command bridge;
	Command side;
	
    public NeoAutoRoot(int startPos, char whichSwitch) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	sw = whichSwitch;
    	pos = startPos;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	oi = new OI();
    	sTimer = new Timer();
    	driver = Robot.getDrivetrain();
    	tCurrent = 0.0;
    	endAuto = false;
    	sTimer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	while (!endAuto) {
    		if (autoRootStatus == 1) {
    			while(sTimer.get() <= (AutoValuesBetter.START_BRIDGE_TIME))
    				driver.drive(-1*AutoValuesBetter.START_BRIDGE_SPD, 0.0);
    			tCurrent = sTimer.get();
    			//if (pos == 1 && sw == 'L')
    				
    			//else if (pos == 1 && sw == 'L')
    				
    			//if ((pos == 1 && sw == 'L'
    		}	
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
    
    //private void routingMovements() {
    	//if ()
    //}
}
