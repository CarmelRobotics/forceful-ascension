package org.usfirst.frc.team2035.robot.commands.auto;

import org.usfirst.frc.team2035.robot.OI;
import org.usfirst.frc.team2035.robot.Robot;
import org.usfirst.frc.team2035.robot.RobotMap;
import org.usfirst.frc.team2035.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.Command;

/**
 * This command and its associated commands are a structure for a 
 * sequential autonomous system. The sample code uses encoders to check for the
 * length of commands but this can easily be swapped out for a time-based autonomous.
 * Additionally, this class's constructor takes an int and a char as parameters as needed
 * for FIRST's 2018 game POWER UP.
 * 
 * This system can be edited at will; there is a structure that can be repeatedly used to
 * perform actions. This structure is outlined below.
 */

public class AutoMain extends Command {

	public OI oi;
	
	/*
	 * Initializes finals whose values are obtained from the constructor's parameters 
	 * and are used to determine which autonomous sequence of the many available below
	 * to use.
	 */
	private final char SWITCH;
	private final int START;
	
	/*
	 * Used to represent the commands that are run in the autonomous code so
	 * that the start() method can be called for each action.
	 */
	Command autoCommand;
	
	/*
	 * These keep track of what part of the autonomous sequence is being run
	 * so that only one action can occur at one time.
	 */
	public static boolean nextMove;
	public static int moveStep;
	private boolean autoDone;
	
	/*
	 * startPos and whichSwitch are parameters that are used to determine which
	 * sequence of autonomous actions to run. For example, in the 2018 game POWER UP,
	 * if startPos, a variable obtained from the position of a rotary switch on the robot,
	 * was 0 and whichSwitch, a variable obtained from running charAt() on a character string
	 * provided from the driver station's Game Data text  entry, was 'L', then the robot would attempt
	 * to move from starting position 0 to the left switch.
	 */
    public AutoMain(int startPos, char whichSwitch) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	SWITCH = whichSwitch;
        START = startPos;
        
        //setting the autonomous tracking variables to their default values
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
    	
    	/*
    	 * If nextMove is true, the code will find the next autonomous command to perform and run it.
    	 * When an autonomous command is run, nextMove is immediately set to false, preventing any other
    	 * actions from running until nextMove is set to false at the end of an autonomous command's runtime.
    	 */
    	if (nextMove) {
    		
    		/*
    		 * Each of these if statements checks which one of the following blocks of autonomous commands to run in sequence.
    		 * Every time a new command is needed, only one of these blocks will ever be accessed as the start and sw variables,
    		 * both set in the constructor to the two corresponding parameters, are never changed.
    		 */
	    	if (START == 0 && SWITCH == 'L') {
	    		
	    		/*
	    		 * Based on what step of the sequence the autonomous code has reached, a certain
	    		 * command is run. Each step represents one command for each sequence, with the
	    		 * exception of simultaneous commands; information about those is available below the sequence blocks.
	    		 * 
	    		 * Autonomous commands:
	    		 * move() moves the robot forward or backward. First parameter is desired length in inches (+/- for forwards and backwards. -1 to 1), second is desired speed (0 to 1).
	    		 * rotate() rotates the robot. First parameter is desired rotation length in inches (+/- for left and right, -1 to 1), second is desired speed (0 to 1).
	    		 * armPosition() sets the position of the robot arm. Parameter is desired arm position in degrees (defaults in RobotMap.java as finals).
	    		 * rollCubeOut() rolls the arm's cube rollers outwards. Parameter is the amount of time that the rollers roll for.
	    		 * letCubeGo() opens the arm's hanger claws. Parameter is the amount of time that the claws are open for.
	    		 * wait() does nothing. Parameter is the amount of time that nothing is done for.
	    		 * 
	    		 */
	    		
	    		if (moveStep == 0)
	    			move(AutoValues.STARTPOS_SWITCHSIDE_INCHES, AutoValues.DEFAULT_MOVE_SPEED); //AutoValues.STARTPOS_SWITCHSIDE_INCHES
	    		else if (moveStep == 1)
	    			rotate(AutoValues.TURN90_RIGHT_INCHES, AutoValues.DEFAULT_TURN_SPEED);
	    		else if (moveStep == 2)
	    			armPosition(RobotMap.ARM_POSITION_1);
	    		else if (moveStep == 3) {
	    			rollCubeOut(1.0);
	    		}
	    		else if (moveStep == 4)
	    			autoDone = true;
	    	}
	    	
	    	else if (START == 0 && SWITCH == 'R') {
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
		    	}
		    	else if (moveStep == 7)
		    		autoDone = true;
		    		
	    	}
	    	
	    	else if (START == 1 && SWITCH == 'R') {
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
	    	
	    	else if (START == 1 && SWITCH == 'L') {
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
	    	
	    	else if (START == 2 && SWITCH == 'R') {
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
	    	
	    	else if (START == 2 && SWITCH == 'L') {
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
	    	}
	    	
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
    	autoCommand = new AutoDriveMove(inches, speed);
    	autoCommand.start();
    }
    
    private void rotate(double inches, double speed) {
    	autoCommand = new AutoDriveRotate(inches, speed);
    	autoCommand.start();
    }
    
    private void armPosition(double position) {
    	autoCommand = new AutoArmChangePosition(position);
    	autoCommand.start();
    }
    
    private void rollCubeOut(double time) {
    	autoCommand = new AutoCubeOut(time);
    	autoCommand.start();
    }
    
    private void letCubeGo(double time) {
    	autoCommand = new AutoOpenHangerClaws(time);
    	autoCommand.start();
    }
    
    private void wait(double time) {
    	autoCommand = new AutoWait(time);
    	autoCommand.start();
    }
    
}