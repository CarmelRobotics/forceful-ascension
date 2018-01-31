/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2035.robot;

import org.usfirst.frc.team2035.robot.commands.CubeIn;
import org.usfirst.frc.team2035.robot.commands.CubeOut;
import org.usfirst.frc.team2035.robot.commands.GearshiftHigh;
import org.usfirst.frc.team2035.robot.commands.GearshiftLow;
import org.usfirst.frc.team2035.robot.commands.WingsOut;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//buttons, buttons, just buttons
	public static JoystickButton gearshiftHigh;
	public static JoystickButton gearshiftLow;
	public static JoystickButton cubeIn;
	public static JoystickButton cubeOut;
	public static JoystickButton wingsOut;
	
	public static void initialize() {
		/**
		 * Sets software buttons to hardware buttons
		 */
		gearshiftHigh = RobotMap.GEARSHIFT_HIGH;
		gearshiftLow = RobotMap.GEARSHIFT_LOW;
		cubeIn = RobotMap.CUBE_IN;
		cubeOut = RobotMap.CUBE_OUT;
		wingsOut = RobotMap.WINGS_OUT;
		System.out.print("")
		wingsOut.whenPressed(new WingsOut());
		
		gearshiftHigh.whileHeld(new GearshiftHigh());
		gearshiftLow.whileHeld(new GearshiftLow());
		cubeIn.whileHeld(new CubeIn());
		cubeOut.whileHeld(new CubeOut());
	}
}