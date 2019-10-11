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
public class AutoDriveRotate extends Command {

	public static OI oi;
	private final Drivetrain drt;
	private double in;
	private double spd;
	private double degrees;
	private double counter;
	private int first;
	private double previousMovement;
	
    public AutoDriveRotate(double inches, double speed) {
    	drt = Robot.getDrivetrain();
		requires(drt);
		in = inches;
		spd = speed;
		degrees = ((360*in)/(4.25*Math.PI));
		counter = 0.0;
		first = 0;
		previousMovement = drt.currentDegreesLeft();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	oi = new OI();
    	System.out.println("Left Encoder Rotate Init: " + drt.currentDegreesLeft() + "                     Right Encoder Rotate Init: " + drt.currentDegreesRight());
    	double target = degrees + previousMovement;
    	System.out.println(target);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	drt.drive(0.0, -spd);
    	counter++;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if ((drt.currentDegreesLeft()) >= (degrees+previousMovement))
        	return true;
        else
        	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	AutoMain.nextMove = true;
    	AutoMain.moveStep++;
    	System.out.println(AutoMain.moveStep);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}