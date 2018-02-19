package org.usfirst.frc.team2035.robot.commands;

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
	
    public AutoDriveMove(double inches, double speed) {
    	drt = Robot.getDrivetrain();
		requires(drt);
		in = inches;
		spd = speed;
		degrees = ((360*in)/(4.25*Math.PI));
		System.out.println("in constrcut" + degrees);
		counter = 0;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	oi = new OI();
    	drt.resetEncoderLeft();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	drt.driveCurve(-spd, 0.0, true);
    	
    		System.out.println("Current from Move: " + -drt.currentDegreesLeft());
    		System.out.println("in ex" + degrees);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	System.out.println("Target from Move: " + degrees);
        if (-drt.currentDegreesLeft() >= degrees)
        	return true;
        else
        	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	drt.drive(0.0, 0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	drt.drive(0.0, 0.0);
    }
}
