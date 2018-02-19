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
	
	//Autonomous Choices
	public static final int ROUTING = 0; //choose between nearest switch (0), only cross line (1), and high switch (2)
	public static final char SIDE = 'L'; //choose which side to use to cross line or get to middle switch ('L' or 'R')
	public static final boolean SECOND_BOX = false; //choose whether to obtain another box after placing first box
	
	//Arm 
	public static final int ARM_ANGLE_SPEED = 1;
	public static final double ARM_EXTEND_SPEED = 1.0;
	public static final int ARM_STARTING_POSITION = 540; //temp
	public static final double ARM_POSITION_0 = 0; // 0 degrees on arm gear
	public static final double ARM_POSITION_1 = 540; // 20 degrees on arm gear
	public static final double ARM_POSITION_2 = 1485; // 55 degrees on arm gear
	public static final double ARM_POSITION_3 = 1755; // 65 degrees on arm gear
	public static final double ARM_POSITION_4 = 2430; // 90 degrees on arm gear
		
	// PWM  

	public static final int ARM_EXTEND_1 = 1; 
	public static final int ARM_EXTEND_2 = 2; 
	public static final int ARM_EXTEND_3 = 3; 
		
	public static final int LB_DRIVETRAIN_MOTOR_PWM = 4; // LB - left bottom	4
	public static final int RB_DRIVETRAIN_MOTOR_PWM = 0; // 0
	public static final int R_CUBEMECH_MOTOR_PWM = 6;
	public static final int L_CUBEMECH_MOTOR_PWM = 9;

	
	/* DIO */
	public static final int LIMITSWITCH_L = 0;
	public static final int LIMITSWITCH_R = 1;
	
	/* Motor Speeds */
	public static final double CUBEMECH_IN_SPEED = 0.6;
	public static final double CUBEMECH_OUT_SPEED = -0.6;

	/* Solenoids */
	
	public static final int COMPRESSOR_PCM_ID = 0;

	public static final int SOLE_GEARSHIFT_HIGH = 0;
	public static final int SOLE_GEARSHIFT_LOW = 1;
	public static final int WINGS = 2;
	public static final int ARM_SOLENOID = 5;
	
	

	//CAN Network
	
	public static final int LT_DRIVETRAIN_MOTOR = 1; //1
	public static final int RT_DRIVETRAIN_MOTOR = 2; //2
	public static final int ANGLER_ID = 3;
	
	/* Joystick */
	public static final int JOY_DRIVE_USB = 0;
	public static final Joystick JOY_DRIVE = new Joystick(JOY_DRIVE_USB);
	public static final int JOY_ARM_USB = 2;
	public static final Joystick JOY_ARM = new Joystick(JOY_ARM_USB);
	
    
	
	/* Buttons (Ari's)*/ 
	public static final JoystickButton GEARSHIFT_HIGH = new JoystickButton(JOY_DRIVE, 5);
	public static final JoystickButton GEARSHIFT_LOW = new JoystickButton(JOY_DRIVE, 4);
	public static final JoystickButton CUBE_IN = new JoystickButton(JOY_DRIVE, 3);
	public static final JoystickButton CUBE_OUT = new JoystickButton(JOY_DRIVE, 2);
	public static final JoystickButton WINGS_OUT = new JoystickButton(JOY_DRIVE, 1);
	
	public static final JoystickButton ARM_REVERSE = new JoystickButton(JOY_ARM,2);
	public static final JoystickButton ARM_EXTEND = new JoystickButton(JOY_ARM,3);
	public static final JoystickButton ARM_TEST = new JoystickButton(JOY_ARM,4);
    public static final JoystickButton CHANGE_ARM_ANGLE_0 = new JoystickButton(JOY_ARM,6); 
	public static final JoystickButton CHANGE_ARM_ANGLE_1 = new JoystickButton(JOY_ARM,7);
	public static final JoystickButton CHANGE_ARM_ANGLE_2 = new JoystickButton(JOY_ARM,8);
	public static final JoystickButton CHANGE_ARM_ANGLE_3 = new JoystickButton(JOY_ARM,9);
	public static final JoystickButton CHANGE_ARM_ANGLE_4 = new JoystickButton(JOY_ARM,10);
	public static final JoystickButton RESET_ARM_ANGLE = new JoystickButton(JOY_ARM,11);
	
}