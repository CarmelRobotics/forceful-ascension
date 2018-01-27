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
public class TeleopDrive extends Command {

	public static OI oi;
	private final Drivetrain drt;
	private final Joystick stk;
	
    public TeleopDrive() {
    	drt = Robot.getDrivetrain();
    	stk = RobotMap.JOY_DRIVE;
		requires(drt);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	oi = new OI();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	drt.drive(stk.getY(), stk.getX());
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
