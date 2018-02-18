package org.usfirst.frc.team2035.robot.commands;

import org.usfirst.frc.team2035.robot.AutoValuesBetter;
import org.usfirst.frc.team2035.robot.OI;
import org.usfirst.frc.team2035.robot.Robot;
import org.usfirst.frc.team2035.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class NeoAutoBridge extends Command {
	
	private int begin;
	private int end;
	private boolean goSwitch;
	private Drivetrain driver;
	public OI oi;
	
    public NeoAutoBridge(int routeBeginPos, int routeEndPos, boolean switchApproach) {
        /*
         * for routeBeginPos and routeEndPos (goes from left to right):
         * 0: very left side; in front of startPos 0
         * 1: in front of left switch
         * 2: middle; in front of boxes
         * 3: in front of startPos 1
         * 4: in front of right switch
         * 5: very right side; in front of startPos 2
         */
    	begin = routeBeginPos;
    	end = routeEndPos;
    	goSwitch = switchApproach;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	oi = new OI();
    	driver = Robot.getDrivetrain();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	if (goSwitch) {
    		if (begin > end) {
    			while(NeoAutoRoot.autoTimer.get() <= (NeoAutoRoot.getTimerCurrent() + AutoValuesBetter.TURN_LEFT_TIME))
    				driver.drive(-1*AutoValuesBetter.TURN_LEFT_SPD, 0.0);
    			NeoAutoRoot.setTimerCurrent(NeoAutoRoot.autoTimer.get());
    		} else {
    			while(NeoAutoRoot.autoTimer.get() <= (NeoAutoRoot.getTimerCurrent() + AutoValuesBetter.TURN_RIGHT_TIME))
    				driver.drive(-1*AutoValuesBetter.TURN_RIGHT_SPD, 0.0);
    			NeoAutoRoot.setTimerCurrent(NeoAutoRoot.autoTimer.get());
    		}
    	}
    	
    	double time = 0.0;
    	if (begin > end) {
    		for (int pos = begin; pos == end; pos--) {
    			if (pos == 1)
    				time = AutoValuesBetter.BRIDGE_0_1_TIME;
    			else if (pos == 2)
    				time = AutoValuesBetter.BRIDGE_1_2_TIME;
    			else if (pos == 3)
    				time = AutoValuesBetter.BRIDGE_2_3_TIME;
    			else if (pos == 4)
    				time = AutoValuesBetter.BRIDGE_3_4_TIME;
    			else if (pos == 5)
    				time = AutoValuesBetter.BRIDGE_4_5_TIME;
    			
    			while(NeoAutoRoot.autoTimer.get() <= (NeoAutoRoot.getTimerCurrent() + time))
    				driver.drive(-1*AutoValuesBetter.BRIDGE_SPD, 0.0);
    		}
    	} else if (begin < end) {
    		for (int pos = begin; pos == end; pos--) {
    			if (pos == 0)
    				time = AutoValuesBetter.BRIDGE_0_1_TIME;
    			else if (pos == 1)
    				time = AutoValuesBetter.BRIDGE_1_2_TIME;
    			else if (pos == 2)
    				time = AutoValuesBetter.BRIDGE_2_3_TIME;
    			else if (pos == 3)
    				time = AutoValuesBetter.BRIDGE_3_4_TIME;
    			else if (pos == 4)
    				time = AutoValuesBetter.BRIDGE_4_5_TIME;
    			
    			while(NeoAutoRoot.autoTimer.get() <= (NeoAutoRoot.getTimerCurrent() + time))
        			driver.drive(-1*AutoValuesBetter.BRIDGE_SPD, 0.0);
    		}
    	} else {
    		//do nothing
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
