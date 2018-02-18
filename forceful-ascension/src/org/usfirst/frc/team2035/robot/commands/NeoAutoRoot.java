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
	public static Timer autoTimer;
	private Drivetrain driver;
	private static double timerCurrent;
	private int routeBeginPos;
	private int routeEndPos;
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
    	autoTimer = new Timer();
    	driver = Robot.getDrivetrain();
    	setTimerCurrent(0.0);
    	endAuto = false;
    	routeBeginPos = 0;
    	routeEndPos = 1;
    	autoTimer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	while (!endAuto) {
    		
    		if (autoRootStatus == 1) {
    			
    			while(autoTimer.get() <= (getTimerCurrent() + AutoValuesBetter.START_BRIDGE_TIME))
    				driver.drive(-1*AutoValuesBetter.START_BRIDGE_SPD, 0.0);
    			setTimerCurrent(autoTimer.get());
    			
    			if (pos == 0 && sw == 'L') {
    				side = new NeoAutoSide(true, sw);
    				side.start();
    			} else if (pos == 2 && sw == 'R') {
    				side = new NeoAutoSide(true, sw);
    				side.start();
    			} else {
    				setStartPosRouteBegin(pos);
    				setSwitchRouteEnd(pos);
    				bridge = new NeoAutoBridge(pos, sw, true);
    				bridge.start();
    			}
    				
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
    
    private void setStartPosRouteBegin(int pos) {
    	if (pos == 0)
    		routeBeginPos = 0;
    	else if (pos == 1)
    		routeBeginPos = 3;
    	else if (pos == 1)
    		routeBeginPos = 5;
    	else
    		routeBeginPos = 0;
    }
    
    private void setStartPosRouteEnd(int pos) {
    	if (pos == 0)
    		routeEndPos = 0;
    	else if (pos == 1)
    		routeEndPos = 3;
    	else if (pos == 1)
    		routeEndPos = 5;
    	else
    		routeEndPos = 0;
    }
    
    private void setSwitchRouteBegin(int sw) { //if setStart is true, set switch values to the beginning of the route; else if false, set for end of route
    	if (sw == 'L')
    		routeBeginPos = 1;
    	else if (sw == 'R')
    		routeBeginPos = 4;
    	else
    		routeBeginPos = 0;
    }
    
    private void setSwitchRouteEnd(int sw) { //if setStart is true, set switch values to the beginning of the route; else if false, set for end of route
    	if (sw == 'L')
    		routeEndPos = 1;
    	else if (sw == 'R')
    		routeEndPos = 4;
    	else
    		routeEndPos = 0;
    }

	public static double getTimerCurrent() {
		return timerCurrent;
	}

	public static void setTimerCurrent(double timerCurrent) {
		NeoAutoRoot.timerCurrent = timerCurrent;
	}
    
    //private void routingMovements() {
    	//if ()
    //}
}
