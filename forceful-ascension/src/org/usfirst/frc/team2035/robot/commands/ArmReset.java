package org.usfirst.frc.team2035.robot.commands;

import org.usfirst.frc.team2035.robot.OI;
import org.usfirst.frc.team2035.robot.Robot;
import org.usfirst.frc.team2035.robot.RobotMap;
import org.usfirst.frc.team2035.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ArmReset extends Command {
	public static OI oi;
	
	private Arm arm;
    public ArmReset() {
    	super("ArmReset");
    	arm = Robot.getArm();
    	
        requires(Robot.getArm());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
   
    	oi = new OI();
     	arm.setAnglerPosition(0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return arm.armChangeAngle(RobotMap.ARM_POSITION_3);
    }

    // Called once after isFinished returns true
    protected void end() {
    	arm.setAnglerPosition(-20275);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
