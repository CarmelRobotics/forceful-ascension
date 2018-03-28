package org.usfirst.frc.team2035.robot.commands.auto;

import org.usfirst.frc.team2035.robot.OI;
import org.usfirst.frc.team2035.robot.Robot;
import org.usfirst.frc.team2035.robot.RobotMap;
import org.usfirst.frc.team2035.robot.subsystems.CubeMech;
import org.usfirst.frc.team2035.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoDriveMove extends Command {

	public static OI oi;
	private final Drivetrain drt;
	private double in;
	private double spd;
	private double degrees;
	private int counter;
	private double previousMovement;
	
    public AutoDriveMove(double inches, double speed) {
    	drt = Robot.getDrivetrain();
		requires(drt);
		in = inches;
		spd = speed;
		degrees = ((360*in)/(4.25*Math.PI));
		counter = 0;
		//previousMovement = drt.currentDegreesLeft();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	oi = new OI();
    	System.out.println(degrees);
    	drt.resetLeft();
    	drt.resetRight();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//slows movement to 70% of desired speed once destination is 1000 degrees away
    	//if (drt.currentDegreesLeft() >= degrees - 1000)
    		//drt.drive(-(spd * 0.7), -0.05);
    	//else
    		drt.drive(-spd, -0.05);
    	//if (counter % 30 == 0)
    		//System.out.println(drt.currentDegreesLeft());
    	counter++;
    	//System.out.println("Left Encoder: " + drt.currentDegreesLeft() + "      Right Encoder: " + drt.currentDegreesRight());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//System.out.println(drt.currentDegreesLeft() + "   " + degrees);
    	if (drt.currentDegreesLeft() >= degrees) {//degrees)
        	//drt.drive(0, 0);
    		return true; 
        	}
        else
        	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	AutoSW.nextMove = true;
    	AutoSW.moveStep++;
    	System.out.print(AutoSW.moveStep);    
    	}

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}



/*
 * package org.usfirst.frc.team2035.robot.commands.auto;

import org.usfirst.frc.team2035.robot.OI;
import org.usfirst.frc.team2035.robot.Robot;
import org.usfirst.frc.team2035.robot.RobotMap;
import org.usfirst.frc.team2035.robot.subsystems.CubeMech;
import org.usfirst.frc.team2035.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
public class AutoDriveMove extends Command {

	public static OI oi;
	private final Drivetrain drt;
	private double in;
	private double spd;
	private double degrees;
	private int counter;
	private double previousMovement;
	
    public AutoDriveMove(double inches, double speed) {
    	drt = Robot.getDrivetrain();
		requires(drt);
		in = inches;
		spd = speed;
		degrees = ((360*in)/(4.25*Math.PI));
		counter = 0;
		previousMovement = drt.currentDegreesLeft();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	oi = new OI();
    	System.out.println(degrees);
    	//drt.resetLeft();
    	//drt.resetRight();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//slows movement to 70% of desired speed once destination is 1000 degrees away
    	//if (drt.currentDegreesLeft() >= degrees - 1000)
    		//drt.drive(-(spd * 0.7), -0.05);
    	//else
    		drt.drive(-spd, -0.05);
    	//if (counter % 30 == 0)
    		//System.out.println(drt.currentDegreesLeft());
    	counter++;
    	//System.out.println("Left Encoder: " + drt.currentDegreesLeft() + "      Right Encoder: " + drt.currentDegreesRight());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//System.out.println(drt.currentDegreesLeft() + "   " + degrees);
    	if ((drt.currentDegreesLeft()) >= (degrees+previousMovement)) {//degrees)
        	//drt.drive(0, 0);
    		return true; 
        	}
        else
        	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	AutoSW.nextMove = true;
    	AutoSW.moveStep++;
    	System.out.print(AutoSW.moveStep);    
    	}

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
*/