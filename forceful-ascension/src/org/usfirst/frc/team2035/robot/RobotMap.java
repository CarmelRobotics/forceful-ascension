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
	public static final int LB_DRIVETRAIN_MOTOR_PWM = 5;
	public static final int RF_DRIVETRAIN_MOTOR_PWM = 4;
	public static final int RB_DRIVETRAIN_MOTOR_PWM = 3;
	public static final int R_CUBEMECH_MOTOR_PWM = 2;
	public static final int L_CUBEMECH_MOTOR_PWM = 1;
	
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
	
	/* Buttons */
	public static final JoystickButton GEARSHIFT_HIGH = new JoystickButton(JOY_DRIVE, 6);
	public static final JoystickButton GEARSHIFT_LOW = new JoystickButton(JOY_DRIVE, 2);
	public static final JoystickButton CUBE_IN = new JoystickButton(JOY_DRIVE, 3);
	public static final JoystickButton CUBE_OUT = new JoystickButton(JOY_DRIVE, 2);
	public static final JoystickButton WINGS_OUT = new JoystickButton(JOY_DRIVE, 5);
	public static final JoystickButton ENC = new JoystickButton(JOY_DRIVE, 2);
	
	
	
	/*AutoSW Speeds and Rotations*/
		/* Autonomous Speeds...S = switch routing, POS1 = position 1, SWL = switch left, SP1 = speed 1*/
		public static final double S_POS1_SWL_SPD1 = 0.0;
		public static final double S_POS1_SWL_SPD2 = 0.0;
		public static final double S_POS1_SWL_SPD3 = 0.0;
		public static final double S_POS2_SWL_SPD1 = 0.0;
		public static final double S_POS2_SWL_SPD2 = 0.0;
		public static final double S_POS2_SWL_SPD3 = 0.0;
		public static final double S_POS3_SWL_SPD1 = 0.0;
		public static final double S_POS3_SWL_SPD2 = 0.0;
		public static final double S_POS3_SWL_SPD3 = 0.0;
		
		public static final double S_POS1_SWR_SPD1 = 0.0;
		public static final double S_POS1_SWR_SPD2 = 0.0;
		public static final double S_POS1_SWR_SPD3 = 0.0;
		public static final double S_POS2_SWR_SPD1 = 0.0;
		public static final double S_POS2_SWR_SPD2 = 0.0;
		public static final double S_POS2_SWR_SPD3 = 0.0;
		public static final double S_POS3_SWR_SPD1 = 0.0;
		public static final double S_POS3_SWR_SPD2 = 0.0;
		public static final double S_POS3_SWR_SPD3 = 0.0;
		
		/* Autonomous Rotations...S = switch routing, POS1 = position 1, SWL = switch left, SP1 = rotation 1*/
		public static final double S_POS1_SWL_ROT1 = 0.0;
		public static final double S_POS1_SWL_ROT2 = 0.0;
		public static final double S_POS2_SWL_ROT1 = 0.0;
		public static final double S_POS2_SWL_ROT2 = 0.0;
		public static final double S_POS3_SWL_ROT1 = 0.0;
		public static final double S_POS3_SWL_ROT2 = 0.0;
		
		public static final double S_POS1_SWR_ROT1 = 0.0;
		public static final double S_POS1_SWR_ROT2 = 0.0;
		public static final double S_POS2_SWR_ROT1 = 0.0;
		public static final double S_POS2_SWR_ROT2 = 0.0;
		public static final double S_POS3_SWR_ROT1 = 0.0;
		public static final double S_POS3_SWR_ROT2 = 0.0;
		
		/* Autonomous Times...S = switch routing, POS1 = position 1, SWL = switch left, T1 = time length 1*/
		public static final double S_POS1_SWL_T1 = 0.0;
		public static final double S_POS1_SWL_T2 = 0.0;
		public static final double S_POS1_SWL_T3 = 0.0;
		public static final double S_POS1_SWL_T4 = 0.0;
		public static final double S_POS1_SWL_T5 = 0.0;
		public static final double S_POS2_SWL_T1 = 0.0;
		public static final double S_POS2_SWL_T2 = 0.0;
		public static final double S_POS2_SWL_T3 = 0.0;
		public static final double S_POS2_SWL_T4 = 0.0;
		public static final double S_POS2_SWL_T5 = 0.0;
		public static final double S_POS3_SWL_T1 = 0.0;
		public static final double S_POS3_SWL_T2 = 0.0;
		public static final double S_POS3_SWL_T3 = 0.0;
		public static final double S_POS3_SWL_T4 = 0.0;
		public static final double S_POS3_SWL_T5 = 0.0;
		
		public static final double S_POS1_SWR_T1 = 0.0;
		public static final double S_POS1_SWR_T2 = 0.0;
		public static final double S_POS1_SWR_T3 = 0.0;
		public static final double S_POS1_SWR_T4 = 0.0;
		public static final double S_POS1_SWR_T5 = 0.0;
		public static final double S_POS2_SWR_T1 = 0.0;
		public static final double S_POS2_SWR_T2 = 0.0;
		public static final double S_POS2_SWR_T3 = 0.0;
		public static final double S_POS2_SWR_T4 = 0.0;
		public static final double S_POS2_SWR_T5 = 0.0;
		public static final double S_POS3_SWR_T1 = 0.0;
		public static final double S_POS3_SWR_T2 = 0.0;
		public static final double S_POS3_SWR_T3 = 0.0;
		public static final double S_POS3_SWR_T4 = 0.0;
		public static final double S_POS3_SWR_T5 = 0.0;
		
		
		
	/*AutoCL Speeds and Rotations*/
		/* Autonomous Speeds...C = cross line only routing, POS1 = position 1, SWL = switch left, SP1 = speed 1*/
		public static final double C_POS1_SWL_SPD1 = 0.0;
		public static final double C_POS1_SWL_SPD2 = 0.0;
		public static final double C_POS1_SWL_SPD3 = 0.0;
		public static final double C_POS2_SWL_SPD1 = 0.0;
		public static final double C_POS2_SWL_SPD2 = 0.0;
		public static final double C_POS2_SWL_SPD3 = 0.0;
		public static final double C_POS3_SWL_SPD1 = 0.0;
		public static final double C_POS3_SWL_SPD2 = 0.0;
		public static final double C_POS3_SWL_SPD3 = 0.0;
	
		public static final double C_POS1_SWR_SPD1 = 0.0;
		public static final double C_POS1_SWR_SPD2 = 0.0;
		public static final double C_POS1_SWR_SPD3 = 0.0;
		public static final double C_POS2_SWR_SPD1 = 0.0;
		public static final double C_POS2_SWR_SPD2 = 0.0;
		public static final double C_POS2_SWR_SPD3 = 0.0;
		public static final double C_POS3_SWR_SPD1 = 0.0;
		public static final double C_POS3_SWR_SPD2 = 0.0;
		public static final double C_POS3_SWR_SPD3 = 0.0;
		
		/* Autonomous Rotations...C = cross line only routing, POS1 = position 1, SWL = switch left, SP1 = rotation 1*/
		public static final double C_POS1_SWL_ROT1 = 0.0;
		public static final double C_POS1_SWL_ROT2 = 0.0;
		public static final double C_POS2_SWL_ROT1 = 0.0;
		public static final double C_POS2_SWL_ROT2 = 0.0;
		public static final double C_POS3_SWL_ROT1 = 0.0;
		public static final double C_POS3_SWL_ROT2 = 0.0;
		
		public static final double C_POS1_SWR_ROT1 = 0.0;
		public static final double C_POS1_SWR_ROT2 = 0.0;
		public static final double C_POS2_SWR_ROT1 = 0.0;
		public static final double C_POS2_SWR_ROT2 = 0.0;
		public static final double C_POS3_SWR_ROT1 = 0.0;
		public static final double C_POS3_SWR_ROT2 = 0.0;
}