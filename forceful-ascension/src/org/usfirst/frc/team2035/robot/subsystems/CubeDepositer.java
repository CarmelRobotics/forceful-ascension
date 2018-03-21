package org.usfirst.frc.team2035.robot.subsystems;

import org.usfirst.frc.team2035.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class CubeDepositer extends Subsystem{
	
	private Victor rollerR; //right side cube mechanism roller
	private Victor rollerL; //left side cube mechanism roller
	
	
	
	public CubeDepositer() {
		super("Arm");
		rollerR = new Victor(RobotMap.R_CUBEMECH_MOTOR_PWM);
		rollerL = new Victor(RobotMap.L_CUBEMECH_MOTOR_PWM);
	}
	
	
	
	public void rollIn() {
		//sets cube mech motors to positive speed
		rollerR.set(RobotMap.CUBEMECH_SPEED);
		rollerL.set(-RobotMap.CUBEMECH_SPEED);
	}
	
	/**
	 * Rolls cubes out of mechanism
	 */
	public void rollOut() {
		//sets cube mech motors to negative speed
		rollerR.set(-RobotMap.CUBEMECH_SPEED);
		rollerL.set(RobotMap.CUBEMECH_SPEED);
	}
	
	/**
	 * Stops rollers from moving
	 */
	public void stopRoll() {
		//stops cube mech motors
		rollerR.set(0.0);
		rollerL.set(0.0);
	}



	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
}
