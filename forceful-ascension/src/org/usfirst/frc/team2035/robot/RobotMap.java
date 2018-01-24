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
	
	/* PWM */
	public static final int LF_DRIVETRAIN_MOTOR_PWM = 0;
	public static final int LB_DRIVETRAIN_MOTOR_PWM = 0;
	public static final int RF_DRIVETRAIN_MOTOR_PWM = 0;
	public static final int RB_DRIVETRAIN_MOTOR_PWM = 0;
	public static final int R_CUBEMECH_MOTOR_PWM = 0;
	public static final int L_CUBEMECH_MOTOR_PWM = 0;
	
	/* DIO */
	public static final int LIMITSWITCH_L = 0;
	public static final int LIMITSWITCH_R = 0;
	
	/* Motor Speeds */
	public static final double CUBEMECH_IN_SPEED= 1.0;
	public static final double CUBEMECH_OUT_SPEED= -1.0;

	/* Solenoids */
	public static final int L_WINGS = 0;
	public static final int R_WINGS = 0;
	public static final int SOLE_GEARSHIFT_ID = 0;
	public static final int SOLE_GEARSHIFT_HIGH = 0;
	public static final int SOLE_GEARSHIFT_LOW = 0;
	
	/* Joystick */
    public static final int JOY_DRIVE_USB = 0;
    public static final Joystick JOY_DRIVE = new Joystick(JOY_DRIVE_USB);
	
	/* Buttons */
    public static final JoystickButton GEARSHIFT_HIGH = new JoystickButton(JOY_DRIVE, 1);
    public static final JoystickButton GEARSHIFT_LOW = new JoystickButton(JOY_DRIVE, 1);
	public static final JoystickButton CUBE_IN = new JoystickButton(JOY_DRIVE, 1);
	public static final JoystickButton CUBE_OUT = new JoystickButton(JOY_DRIVE, 1);
	public static final JoystickButton WINGS_OUT = new JoystickButton(JOY_DRIVE, 1);
}