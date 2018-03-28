package org.usfirst.frc.team2035.robot.commands.auto;

import org.usfirst.frc.team2035.robot.AutoValues;
import org.usfirst.frc.team2035.robot.OI;
import org.usfirst.frc.team2035.robot.Robot;
import org.usfirst.frc.team2035.robot.RobotMap;
import org.usfirst.frc.team2035.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoSW extends Command {

	public OI oi;
	private char sw;
	private int start;
	Command movement;
	Command arm;
	Arm a;
	public static boolean nextMove;
	public static int moveStep;
	private boolean autoDone;
	
    public AutoSW(int startPos, char whichSwitch) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	sw = whichSwitch;
        start = startPos;
        nextMove = true;
        moveStep = 0;
        autoDone = false;
        a = Robot.getArm();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	oi = new OI();
    	a.setAnglerPosition(0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	//move(4.25*(Math.PI), 0.5);
    	//rotate(AutoValues.TURN90_RIGHT_INCHES, 0.7);
    	//autoDone = true;
    	
    	if (nextMove) {
    	
    		System.out.println("weeeee got it");
    		
    		
    		if (moveStep == 0)
    			move(350, AutoValues.DEFAULT_MOVE_SPEED); //AutoValues.STARTPOS_SWITCHSIDE_INCHES
    		//else if (moveStep == 1)
    			//armPosition(RobotMap.ARM_POSITION_1);
    		//else if (moveStep == 2)
    			//rollCubeOut(1.0);
    		else if (moveStep == 1)
    			autoDone = true;
    		    	//hello world
    		/*
    		if (moveStep == 0) {
    			System.out.println("Forward");
    			move(350, AutoValues.DEFAULT_MOVE_SPEED);
    		}//AutoValues.STARTPOS_SWITCHSIDE_INCHES
    		else if (moveStep == 1) {
    			System.out.println("Rotate");
    			if (sw == 'L' && start == 0) {
    				rotate(AutoValues.TURN90_RIGHT_INCHES, AutoValues.DEFAULT_TURN_SPEED); 
    				System.out.println("successful");
    						}
    			//else if (sw == 'R' && start == 2)
    				//rotate(AutoValues.TURN90_LEFT_INCHES, AutoValues.DEFAULT_TURN_SPEED);
    			//else
    				//rotate(2, AutoValues.DEFAULT_TURN_SPEED);
    		}
    		else if (moveStep == 2) {
    			System.out.println("Stop");
    			//armPosition(RobotMap.ARM_POSITION_1);
    			autoDone = true;
    		}
    		else if (moveStep == 3) {
    			//autoDone = true;
    		}
    		*/
    		/*
	    	if (start == 0 && sw == 'L') {
	    		if (moveStep == 0)
	    			move(AutoValues.STARTPOS_SWITCHSIDE_INCHES+20, AutoValues.DEFAULT_MOVE_SPEED); //AutoValues.STARTPOS_SWITCHSIDE_INCHES
	    		else if (moveStep == 1)
	    			rotate(AutoValues.TURN90_RIGHT_INCHES, AutoValues.DEFAULT_TURN_SPEED);
	    		else if (moveStep == 2)
	    			armPosition(RobotMap.ARM_POSITION_1);
	    		else if (moveStep == 3) {
	    			rollCubeOut(1.0);
	    			//letCubeGo(1.0);
	    		}
	    		else if (moveStep == 4)
	    			autoDone = true;
	    	}
	    	
	    	else if (start == 0 && sw == 'R') {
		    	if (AutoValues.COMPLEX_AUTO) {	
	    			if (moveStep == 0)
		    			move(AutoValues.STARTPOS2_RIGHTSWITCHFRONT_INCHES, AutoValues.DEFAULT_MOVE_SPEED); //AutoValues.STARTPOS_SWITCHSIDE_INCHES
		    		else if (moveStep == 1)
		    			rotate(AutoValues.TURN90_RIGHT_INCHES, AutoValues.DEFAULT_TURN_SPEED);
		    		else if (moveStep == 2)
			    		move(AutoValues.POSITIONFRONT_OPPOSITESWITCHFRONT_INCHES, AutoValues.DEFAULT_MOVE_SPEED);
		    		else if (moveStep == 3)
		    			rotate(AutoValues.TURN90_LEFT_INCHES, AutoValues.DEFAULT_TURN_SPEED);
		    		else if (moveStep == 4)
			    		move(AutoValues.SWITCHFRONT_APPROACH_INCHES, AutoValues.DEFAULT_MOVE_SPEED);
		    		else if (moveStep == 5)
		    			armPosition(RobotMap.ARM_POSITION_1);
		    		else if (moveStep == 6) {
		    			rollCubeOut(1.0);
		    			//letCubeGo(1.0);
		    		}
		    		else if (moveStep == 7)
		    			autoDone = true;
		    	}
		    	else {
		    		if (moveStep == 0)
		    			move(AutoValues.STARTPOS_SWITCHSIDE_INCHES+20, AutoValues.DEFAULT_MOVE_SPEED);
		    		else if (moveStep == 1)
		    			autoDone = true;
		    	}
		    		
	    	}
	    	
	    	else if (start == 1 && sw == 'R') {
	    		System.out.println("made it");
	    		if (moveStep == 0)
	    			move(AutoValues.STARTPOS2_RIGHTSWITCHFRONT_INCHES, AutoValues.DEFAULT_MOVE_SPEED);
	    		else if (moveStep == 1)
	    			move(AutoValues.SWITCHFRONT_APPROACH_INCHES+10, AutoValues.DEFAULT_MOVE_SPEED);
	    		else if (moveStep == 2)
	    			armPosition(RobotMap.ARM_POSITION_1);
	    		else if (moveStep == 3) {
	    			rollCubeOut(1.0);
	    			//letCubeGo(2.0);
	    		}
	    		else if (moveStep == 4)
	    			autoDone = true;
	    	} 
	    	
	    	else if (start == 1 && sw == 'L') {
	    		if (moveStep == 0)
	    			move(AutoValues.STARTPOS2_RIGHTSWITCHFRONT_INCHES, AutoValues.DEFAULT_MOVE_SPEED);
	    		else if (moveStep == 1)
	    			rotate(AutoValues.TURN90_LEFT_INCHES, AutoValues.DEFAULT_TURN_SPEED);
	    		else if (moveStep == 2)
	    			move(AutoValues.RIGHTSWITCHFRONT_LEFTSWITCHFRONT_INCHES, AutoValues.DEFAULT_MOVE_SPEED);
	    		else if (moveStep == 3)
	    			rotate(AutoValues.TURN90_RIGHT_INCHES, AutoValues.DEFAULT_TURN_SPEED);
	    		else if (moveStep == 4)
	    			move(AutoValues.SWITCHFRONT_APPROACH_INCHES, AutoValues.DEFAULT_MOVE_SPEED);
	    		else if (moveStep == 5)
	    			armPosition(RobotMap.ARM_POSITION_1);
	    		else if (moveStep == 6) {
	    			rollCubeOut(1.0);
	    			//letCubeGo(1.0);
	    		}
	    		else if (moveStep == 7)
	    			autoDone = true;
	    	} 
	    	
	    	else if (start == 2 && sw == 'R') {
	    		if (moveStep == 0)
	    			move(AutoValues.STARTPOS_SWITCHSIDE_INCHES, AutoValues.DEFAULT_MOVE_SPEED); //AutoValues.STARTPOS_SWITCHSIDE_INCHES
	    		else if (moveStep == 1)
	    			rotate(AutoValues.TURN90_LEFT_INCHES, AutoValues.DEFAULT_TURN_SPEED);
	    		else if (moveStep == 2)
	    			armPosition(RobotMap.ARM_POSITION_1);
	    		else if (moveStep == 3) {
	    			rollCubeOut(1.0);
	    			//letCubeGo(1.0);
	    		}
	    		else if (moveStep == 4)
	    			autoDone = true;
	    	}
	    	
	    	else if (start == 2 && sw == 'L') {
		    	if (AutoValues.COMPLEX_AUTO) {	
	    			if (moveStep == 0)
		    			move(AutoValues.STARTPOS2_RIGHTSWITCHFRONT_INCHES, AutoValues.DEFAULT_MOVE_SPEED); //AutoValues.STARTPOS_SWITCHSIDE_INCHES
		    		else if (moveStep == 1)
		    			rotate(AutoValues.TURN90_LEFT_INCHES, AutoValues.DEFAULT_TURN_SPEED);
		    		else if (moveStep == 2)
			    		move(AutoValues.POSITIONFRONT_OPPOSITESWITCHFRONT_INCHES, AutoValues.DEFAULT_MOVE_SPEED);
		    		else if (moveStep == 3)
		    			rotate(AutoValues.TURN90_RIGHT_INCHES, AutoValues.DEFAULT_TURN_SPEED);
		    		else if (moveStep == 4)
			    		move(AutoValues.SWITCHFRONT_APPROACH_INCHES, AutoValues.DEFAULT_MOVE_SPEED);
		    		else if (moveStep == 5)
		    			armPosition(RobotMap.ARM_POSITION_1);
		    		else if (moveStep == 6) {
		    			rollCubeOut(1.0);
		    			//letCubeGo(1.0);
		    		}
		    		else if (moveStep == 7)
		    			autoDone = true;
		    	}
		    	else {
		    		if (moveStep == 0)
		    			move(AutoValues.STARTPOS_SWITCHSIDE_INCHES+20, AutoValues.DEFAULT_MOVE_SPEED);
		    		else if (moveStep == 1)
		    			autoDone = true;
		    	}
		    		
	    	}
	    	
	    	else {
	    		//do nothing
	    	} */
	    	
	    	nextMove = false;
	    	
    	}
    	//simultaneous actions can be placed here as new 'if' blocks
    	 
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (autoDone)
        	return true;
        else
        	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    
    private void move(double inches, double speed) {
    	movement = new AutoDriveMove(inches, speed);
    	movement.start();
    }
    
    private void rotate(double inches, double speed) {
    	movement = new AutoDriveRotate(inches, speed);
    	movement.start();
    }
    
    private void armPosition(double position) {
    	arm = new AutoArmChangePosition(position);
    	arm.start();
    }
    
    private void rollCubeOut(double time) {
    	arm = new AutoCubeOut(time);
    	arm.start();
    }
    
    private void letCubeGo(double time) {
    	arm = new AutoOpenHangerClaws(time);
    	arm.start();
    }
    
}