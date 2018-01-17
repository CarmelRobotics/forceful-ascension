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
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class CubeMech extends Subsystem {
	
	private Victor rollerR; //right side cube mechanism roller
	private Victor rollerL; //left side cube mechanism roller
	
	public CubeIntake() {
		rollerR = new Victor(RobotMap.R_CUBEINTAKE_MOTOR_PWM);
		rollerL = new Victor(RobotMap.L_CUBEINTAKE_MOTOR_PWM);
	}

	/**
	 * Rolls cubes into mechanism
	 */
	public void rollIn() {
		rollerR.set(RobotMap.INTAKE_SPEED);
		rollerL.set(RobotMap.INTAKE_SPEED);
	}
	
	/**
	 * Rolls cubes out of mechanism
	 */
	public void rollOut() {
		rollerR.set(-1*RobotMap.INTAKE_SPEED);
		rollerL.set(-1*RobotMap.INTAKE_SPEED);
	}
	
	/**
	 * Stops rollers from moving
	 */
	public void stopRoll() {
		rollerR.set(0.0);
		rollerL.set(0.0);
	}
	
	public void initDefaultCommand() {
		
	}
}
