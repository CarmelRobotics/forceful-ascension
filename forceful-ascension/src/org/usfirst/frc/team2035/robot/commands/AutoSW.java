package org.usfirst.frc.team2035.robot.commands;

import org.usfirst.frc.team2035.robot.AutoValues;
import org.usfirst.frc.team2035.robot.OI;
import org.usfirst.frc.team2035.robot.Robot;
import org.usfirst.frc.team2035.robot.RobotMap;

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
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	oi = new OI();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	if (start == 0) {
    		if (nextMove && moveStep == 0)
    			move(AutoValues.STARTPOS_SWITCHSIDE_INCHES, AutoValues.DEFAULT_MOVE_SPEED);
    		if (nextMove && moveStep == 1)
    			rotate(AutoValues.TURN90_RIGHT_INCHES, AutoValues.DEFAULT_TURN_SPEED);
    		if (nextMove && moveStep == 2)
    			move(AutoValues.SWITCHSIDE_APPROACH_INCHES, AutoValues.SLOW_MOVE_SPEED);
    		if (nextMove && moveStep == 3)
    			armPosition(RobotMap.ARM_POSITION_0);
    		if (nextMove && moveStep == 4)
    			releaseCube(2.0);
    		if (nextMove && moveStep == 5)
    			autoDone = true;
    	} 
    	
    	else if (start == 1 && sw == 'R') {
    		if (nextMove && moveStep == 0)
    			move(AutoValues.STARTPOS2_RIGHTSWITCHFRONT_INCHES, AutoValues.DEFAULT_MOVE_SPEED);
    		if (nextMove && moveStep == 1)
    			move(AutoValues.SWITCHFRONT_APPROACH_INCHES, AutoValues.DEFAULT_MOVE_SPEED);
    		if (nextMove && moveStep == 2)
    			armPosition(RobotMap.ARM_POSITION_0);
    		if (nextMove && moveStep == 3)
    			releaseCube(2.0);
    		if (nextMove && moveStep == 4)
    			autoDone = true;
    	} 
    	
    	else if (start == 1 && sw == 'L') {
    		if (nextMove && moveStep == 0)
    			move(AutoValues.STARTPOS2_RIGHTSWITCHFRONT_INCHES, AutoValues.DEFAULT_MOVE_SPEED);
    		if (nextMove && moveStep == 1)
    			rotate(AutoValues.TURN90_LEFT_INCHES, AutoValues.DEFAULT_TURN_SPEED);
    		if (nextMove && moveStep == 2)
    			move(AutoValues.RIGHTSWITCHFRONT_LEFTSWITCHFRONT_INCHES, AutoValues.DEFAULT_MOVE_SPEED);
    		if (nextMove && moveStep == 3)
    			rotate(AutoValues.TURN90_RIGHT_INCHES, AutoValues.DEFAULT_TURN_SPEED);
    		if (nextMove && moveStep == 4)
    			move(AutoValues.SWITCHFRONT_APPROACH_INCHES, AutoValues.DEFAULT_MOVE_SPEED);
    		if (nextMove && moveStep == 5)
    			armPosition(RobotMap.ARM_POSITION_0);
    		if (nextMove && moveStep == 6)
    			releaseCube(2.0);
    		if (nextMove && moveStep == 7)
    			autoDone = true;
    	} 
    	
    	else if (start == 2){
    		if (nextMove && moveStep == 0)
    			move(AutoValues.STARTPOS_SWITCHSIDE_INCHES, AutoValues.DEFAULT_MOVE_SPEED);
    		if (nextMove && moveStep == 1)
    			rotate(AutoValues.TURN90_LEFT_INCHES, AutoValues.DEFAULT_TURN_SPEED);
    		if (nextMove && moveStep == 2)
    			move(AutoValues.SWITCHSIDE_APPROACH_INCHES, AutoValues.SLOW_MOVE_SPEED);
    		if (nextMove && moveStep == 3)
    			armPosition(RobotMap.ARM_POSITION_0);
    		if (nextMove && moveStep == 4)
    			releaseCube(2.0);
    		if (nextMove && moveStep == 5)
    			autoDone = true;
    	}
    	
    	else {
    		//do nothing
    	}
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
    
    private void releaseCube(double time) {
    	arm = new AutoCubeOut(time);
    	arm.start();
    }
    
}
