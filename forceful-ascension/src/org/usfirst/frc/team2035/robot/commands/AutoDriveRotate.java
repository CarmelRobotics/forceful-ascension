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
public class AutoDriveRotate extends Command {

	public static OI oi;
	private final Drivetrain drt;
	private double in;
	private double spd;
	private double degrees;
	private double counter;
	
    public AutoDriveRotate(double inches, double speed) {
    	drt = Robot.getDrivetrain();
		requires(drt);
		in = inches;
		spd = speed;
		degrees = ((360*in)/(4.25*Math.PI));
		counter = 0.0; //test
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	oi = new OI();
    	drt.resetEncoderLeft();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	drt.drive(0.0, spd);
    	//if (counter % 30 == 0)
    	//	System.out.println(drt.currentDegreesLeft());
    	counter++;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (drt.currentDegreesLeft() >= degrees)
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
}
