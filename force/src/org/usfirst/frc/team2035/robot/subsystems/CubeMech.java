/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2035.robot.subsystems;

import org.usfirst.frc.team2035.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Controls the cube intake and carrying mechanism.
 */
public class CubeMech extends Subsystem {
	
	private Victor rollerR; //right side cube mechanism roller
	private Victor rollerL; //left side cube mechanism roller
	
	public CubeMech() {
		//sets roller variables to pins on Roborio
		rollerR = new Victor(RobotMap.R_CUBEMECH_MOTOR_DIO);
		rollerL = new Victor(RobotMap.L_CUBEMECH_MOTOR_DIO);
	}

	/**
	 * Rolls cubes into mechanism
	 */
	public void rollIn() {
		//sets cube mech motors to positive speed
		rollerR.set(RobotMap.CUBEMECH_IN_SPEED);
		rollerL.set(RobotMap.CUBEMECH_IN_SPEED);
	}
	
	/**
	 * Rolls cubes out of mechanism
	 */
	public void rollOut() {
		//sets cube mech motors to negative speed
		rollerR.set(RobotMap.CUBEMECH_OUT_SPEED);
		rollerL.set(RobotMap.CUBEMECH_OUT_SPEED);
	}
	
	/**
	 * Stops rollers from moving
	 */
	public void stopRoll() {
		//stops cube mech motors
		rollerR.set(0.0);
		rollerL.set(0.0);
	}
	
	public void initDefaultCommand() {
		
	}
}
