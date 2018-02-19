package org.usfirst.frc.team2035.robot.commands;

import org.usfirst.frc.team2035.robot.AutoValuesBest;
import org.usfirst.frc.team2035.robot.OI;
import org.usfirst.frc.team2035.robot.Robot;
import org.usfirst.frc.team2035.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoSWEncoder extends Command {

	public OI oi;
	private char sw;
	private int start;
	private Drivetrain drt;
	Command movement;
	
    public AutoSWEncoder(int startPos, char whichSwitch) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	sw = whichSwitch;
        start = startPos;
        drt = Robot.getDrivetrain();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	oi = new OI();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	if (start == 0) {
    		System.out.println("start auto");
    		move(AutoValuesBest.STARTPOS_SWITCHSIDE_INCHES, AutoValuesBest.DEFAULT_MOVE_SPEED);
    		//System.out.println("now starting to turn");
    		//rotate(AutoValuesBest.TURN90_RIGHT_INCHES, AutoValuesBest.DEFAULT_TURN_SPEED);
    		//System.out.println("approaching switch");
    		//move(AutoValuesBest.SWITCHSIDE_APPROACH_INCHES, AutoValuesBest.SLOW_MOVE_SPEED);
    		//System.out.println("done!");
    	} 
    	
    	/* 
    	 * 	Timer t = new Timer();
    		t.start();
    		while(t.get() < 10.0) {
    			drt.drive(0.8, 0.0);
    			//if (t.get() % 0.1 == 0)
    				//System.out.println("Left Encoder: " + drt.currentDegreesLeft() + "     Right Encoder: " + drt.currentDegreesRight());
    		}
    		
    	 */
    	
    	else if (start == 1 && sw == 'R') {
    		move(AutoValuesBest.STARTPOS2_RIGHTSWITCHFRONT_INCHES, AutoValuesBest.DEFAULT_MOVE_SPEED);
    		move(AutoValuesBest.SWITCHFRONT_APPROACH_INCHES, AutoValuesBest.DEFAULT_MOVE_SPEED);
    	} 
    	
    	else if (start == 1 && sw == 'L') {
    		move(AutoValuesBest.STARTPOS2_RIGHTSWITCHFRONT_INCHES, AutoValuesBest.DEFAULT_MOVE_SPEED);
    		rotate(AutoValuesBest.TURN90_LEFT_INCHES, AutoValuesBest.DEFAULT_TURN_SPEED);
    		move(AutoValuesBest.RIGHTSWITCHFRONT_LEFTSWITCHFRONT_INCHES, AutoValuesBest.DEFAULT_MOVE_SPEED);
    		rotate(AutoValuesBest.TURN90_RIGHT_INCHES, AutoValuesBest.DEFAULT_TURN_SPEED);
    		move(AutoValuesBest.SWITCHFRONT_APPROACH_INCHES, AutoValuesBest.DEFAULT_MOVE_SPEED);
    	} 
    	
    	else if (start == 2){
    		move(AutoValuesBest.STARTPOS_SWITCHSIDE_INCHES, AutoValuesBest.DEFAULT_MOVE_SPEED);
    		rotate(AutoValuesBest.TURN90_LEFT_INCHES, AutoValuesBest.DEFAULT_TURN_SPEED);
    		move(AutoValuesBest.SWITCHSIDE_APPROACH_INCHES, AutoValuesBest.SLOW_MOVE_SPEED);
    	}
    	
    	else {
    		//do nothing
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	//movement = new AutoDriveMove(1, 0);
    	//movement.start();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	//movement = new AutoDriveMove(1, 0);
    	//movement.start();
    }
    
    private void move(double inches, double speed) {
    	movement = new AutoDriveMove(inches, speed);
    	movement.start();
    }
    
    private void rotate(double inches, double speed) {
    	movement = new AutoDriveRotate(inches, speed);
    	movement.start();
    }
    
}
