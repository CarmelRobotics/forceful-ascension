/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2035.robot.subsystems;

import org.usfirst.frc.team2035.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Controls the cube intake and carrying mechanism.
 */
public class CubeMech extends Subsystem {
	
	
	private DoubleSolenoid cubeSolenoid;
	
	public CubeMech() {
		super("CubeMech");
		//sets roller variables to pins on Roborio
		
		cubeSolenoid = new DoubleSolenoid(RobotMap.CUBE_SOLENOID_OPEN, RobotMap.CUBE_SOLENOID_CLOSE);
	}

	/**
	 * Rolls cubes into mechanism
	 */
	
	
	public void openHangerClaws() {
		cubeSolenoid.set(DoubleSolenoid.Value.kForward);
		
	}
	
	public void closeHangerClaws() {
		cubeSolenoid.set(DoubleSolenoid.Value.kReverse);
		
	}
	
	public void initDefaultCommand() {
		
	}
}