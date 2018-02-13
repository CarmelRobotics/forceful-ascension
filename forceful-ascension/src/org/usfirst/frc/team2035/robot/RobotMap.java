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
	
	/*Autonomous Choices*/
	public static final int ROUTING = 0; //choose between nearest switch (0), only cross line (1), and high switch (2)
	public static final char SIDE = 'L'; //choose which side to use to cross line or get to middle switch ('L' or 'R')
	public static final boolean SECOND_BOX = false; //choose whether to obtain another box after placing first box
	
	//Arm (Tyler and Fang's Code)
		public static final int ARM_ANGLE_SPEED = 1;
		public static final int ARM_EXTEND_SPEED = 1;
		public static final int ARM_STARTING_POSITION = 30; //temp
		
	/* PWM (Ari's Code)*/
	public static final int LF_DRIVETRAIN_MOTOR_PWM = 0;
	//public static final int LM_DRIVETRAIN_MOTOR_PWM = 1;
	public static final int LB_DRIVETRAIN_MOTOR_PWM = 1;
	public static final int RF_DRIVETRAIN_MOTOR_PWM = 3;
	//public static final int RM_DRIVETRAIN_MOTOR_PWM = 4;
	public static final int RB_DRIVETRAIN_MOTOR_PWM = 6;
	public static final int R_CUBEMECH_MOTOR_PWM = 6;
	public static final int L_CUBEMECH_MOTOR_PWM = 7;
	
	//switch to angle measurements later (Tyler/Fang's Code)
	public static final double ARM_POSITION_0 = 0; 
	public static final double ARM_POSITION_1 = 15;
	public static final double ARM_POSITION_2 = 30;
	public static final double ARM_POSITION_3 = 60; //temp
	public static final double ARM_POSITION_4 = 90;
	
	// PWM (Tyler/Fang's Code)
	public static final int LEFT_ARM_ANGLE = 4;
	public static final int RIGHT_ARM_ANGLE = 5; 
	public static final int ARM_EXTEND_1 = 6; 
	public static final int ARM_EXTEND_2 = 7; 
	public static final int ARM_EXTEND_3 = 8; 
	
	/* DIO */
	public static final int LIMITSWITCH_L = 0;
	public static final int LIMITSWITCH_R = 1;
	
	/* Motor Speeds */
	public static final double CUBEMECH_IN_SPEED= 0.6;
	public static final double CUBEMECH_OUT_SPEED= -0.6;

	/* Solenoids */
	public static final int L_WINGS = 0;
	public static final int R_WINGS = 1;
	public static final int SOLE_GEARSHIFT_ID = 2;
	public static final int SOLE_GEARSHIFT_HIGH = 3;
	public static final int SOLE_GEARSHIFT_LOW = 4;
	
	/* Joystick */
	public static final int JOY_DRIVE_USB = 0;
	public static final Joystick JOY_DRIVE = new Joystick(JOY_DRIVE_USB);
	public static final int JOY_ARM_USB = 1;
	public static final Joystick JOY_ARM = new Joystick(JOY_ARM_USB);
	/* Joystick (Fang/Tyler's) */
	//public static final int JOYSTICK_A_USB_NUMBER = 0;
    //public static final Joystick DRIVER_JOYSTICK_A = new Joystick(JOYSTICK_A_USB_NUMBER);
    

	//Encoder channel
	public static final int ANGLER_ID = 4;
	
	/* Buttons (Ari's)*/ 
	public static final JoystickButton GEARSHIFT_HIGH = new JoystickButton(JOY_DRIVE, 12);
	public static final JoystickButton GEARSHIFT_LOW = new JoystickButton(JOY_DRIVE, 11);
	public static final JoystickButton CUBE_IN = new JoystickButton(JOY_DRIVE, 10);
	public static final JoystickButton CUBE_OUT = new JoystickButton(JOY_DRIVE, 9);
	public static final JoystickButton WINGS_OUT = new JoystickButton(JOY_DRIVE, 8);
	public static final JoystickButton ENC = new JoystickButton(JOY_DRIVE, 7);
	/* Buttons (Tyler's/Fang's) */
    public static final JoystickButton CHANGE_ARM_ANGLE_0 = new JoystickButton(JOY_DRIVE,1); //change later
	public static final JoystickButton CHANGE_ARM_ANGLE_1 = new JoystickButton(JOY_DRIVE,2);//change later
	public static final JoystickButton CHANGE_ARM_ANGLE_2 = new JoystickButton(JOY_DRIVE,3);//change later
	public static final JoystickButton CHANGE_ARM_ANGLE_3 = new JoystickButton(JOY_DRIVE,4);//change later
	public static final JoystickButton CHANGE_ARM_ANGLE_4 = new JoystickButton(JOY_DRIVE,5);//change later
	public static final JoystickButton RESET_ARM_ANGLE = new JoystickButton(JOY_DRIVE,6);//change later 
	  
	
	//CAN (Tyler and Fang's Code
		public static final int ARM_SOLENOID = 0;
}