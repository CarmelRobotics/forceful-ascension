/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2035.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;
	
	public static final int L_CUBEMECH_MOTOR_PWM = 0;
	public static final int R_CUBEMECH_MOTOR_PWM = 0;
	public static final double CUBEMECH_IN_SPEED= 1.0;
	public static final double CUBEMECH_OUT_SPEED= -1.0;
	public static final int L_WINGS_MOTOR_PWM = 0;
	public static final int R_WINGS_MOTOR_PWM = 0;
	
	/* Joystick */
    public static final int USB = 0;
    public static final Joystick GENERIC = new Joystick(USB);
	
	/* Buttons */
	public static final JoystickButton CUBE_IN = new JoystickButton(GENERIC, 1);
	public static final JoystickButton CUBE_OUT = new JoystickButton(GENERIC, 1);
	public static final JoystickButton WINGS_OUT = new JoystickButton(GENERIC, 1);
	
	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
