package org.usfirst.frc.team2035.robot.commands;

import org.usfirst.frc.team2035.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoEncoderTest extends Command {
	
	private WPI_TalonSRX driveL;
	private WPI_TalonSRX driveR;
	private char sideReturned;
	
    public AutoEncoderTest(char leftOrRight) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	driveL = new WPI_TalonSRX(RobotMap.LT_DRIVETRAIN_MOTOR);
    	driveR = new WPI_TalonSRX(RobotMap.RT_DRIVETRAIN_MOTOR);
    	sideReturned = leftOrRight;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if 
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
    
    public double currentDegreesLeft() {
    	return (driveL.getSelectedSensorPosition(0)/(4096/360));
    }
    
    public double currentDegreesRight() {
    	return (driveR.getSelectedSensorPosition(0)/(4096/360));
    }
}
