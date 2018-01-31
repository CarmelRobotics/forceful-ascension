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
public class AutoValues {
	
	/*AutoSW Speeds, Rotations, Times (Part One: Going to the Switch)*/
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
		
		

/*AutoSW Speeds, Rotations, Times (Part Two: From the Switch to the Line)*/
	/* Autonomous Speeds...S = switch routing, POS1 = position 1, SWL = switch left, SP1 = speed 1*/
		public static final double S_POS1_SWL_SPD4 = 0.0;
		public static final double S_POS1_SWL_SPD5 = 0.0;
		public static final double S_POS1_SWL_SPD6 = 0.0;
		public static final double S_POS2_SWL_SPD4 = 0.0;
		public static final double S_POS2_SWL_SPD5 = 0.0;
		public static final double S_POS2_SWL_SPD6 = 0.0;
		public static final double S_POS3_SWL_SPD4 = 0.0;
		public static final double S_POS3_SWL_SPD5 = 0.0;
		public static final double S_POS3_SWL_SPD6 = 0.0;
		
		public static final double S_POS1_SWR_SPD4 = 0.0;
		public static final double S_POS1_SWR_SPD5 = 0.0;
		public static final double S_POS1_SWR_SPD6 = 0.0;
		public static final double S_POS2_SWR_SPD4 = 0.0;
		public static final double S_POS2_SWR_SPD5 = 0.0;
		public static final double S_POS2_SWR_SPD6 = 0.0;
		public static final double S_POS3_SWR_SPD4 = 0.0;
		public static final double S_POS3_SWR_SPD5 = 0.0;
		public static final double S_POS3_SWR_SPD6 = 0.0;
		
		/* Autonomous Rotations...S = switch routing, POS1 = position 1, SWL = switch left, SP1 = rotation 1*/
		public static final double S_POS1_SWL_ROT4 = 0.0;
		public static final double S_POS1_SWL_ROT5 = 0.0;
		public static final double S_POS1_SWL_ROT6 = 0.0;
		public static final double S_POS2_SWL_ROT4 = 0.0;
		public static final double S_POS2_SWL_ROT5 = 0.0;
		public static final double S_POS2_SWL_ROT6 = 0.0;
		public static final double S_POS3_SWL_ROT4 = 0.0;
		public static final double S_POS3_SWL_ROT5 = 0.0;
		public static final double S_POS3_SWL_ROT6 = 0.0;
		
		public static final double S_POS1_SWR_ROT4 = 0.0;
		public static final double S_POS1_SWR_ROT5 = 0.0;
		public static final double S_POS1_SWR_ROT6 = 0.0;
		public static final double S_POS2_SWR_ROT4 = 0.0;
		public static final double S_POS2_SWR_ROT5 = 0.0;
		public static final double S_POS2_SWR_ROT6 = 0.0;
		public static final double S_POS3_SWR_ROT4 = 0.0;
		public static final double S_POS3_SWR_ROT5 = 0.0;
		public static final double S_POS3_SWR_ROT6 = 0.0;
		
		/* Autonomous Times...S = switch routing, POS1 = position 1, SWL = switch left, T1 = time length 1*/
		public static final double S_POS1_SWL_T6 = 0.0;
		public static final double S_POS1_SWL_T7 = 0.0;
		public static final double S_POS1_SWL_T8 = 0.0;
		public static final double S_POS1_SWL_T9 = 0.0;
		public static final double S_POS1_SWL_T10 = 0.0;
		public static final double S_POS1_SWL_T11 = 0.0;
		public static final double S_POS2_SWL_T6 = 0.0;
		public static final double S_POS2_SWL_T7 = 0.0;
		public static final double S_POS2_SWL_T8 = 0.0;
		public static final double S_POS2_SWL_T9 = 0.0;
		public static final double S_POS2_SWL_T10 = 0.0;
		public static final double S_POS2_SWL_T11 = 0.0;
		public static final double S_POS3_SWL_T6 = 0.0;
		public static final double S_POS3_SWL_T7 = 0.0;
		public static final double S_POS3_SWL_T8 = 0.0;
		public static final double S_POS3_SWL_T9 = 0.0;
		public static final double S_POS3_SWL_T10 = 0.0;
		public static final double S_POS3_SWL_T11 = 0.0;
		
		public static final double S_POS1_SWR_T6 = 0.0;
		public static final double S_POS1_SWR_T7 = 0.0;
		public static final double S_POS1_SWR_T8 = 0.0;
		public static final double S_POS1_SWR_T9 = 0.0;
		public static final double S_POS1_SWR_T10 = 0.0;
		public static final double S_POS1_SWR_T11 = 0.0;
		public static final double S_POS2_SWR_T6 = 0.0;
		public static final double S_POS2_SWR_T7 = 0.0;
		public static final double S_POS2_SWR_T8 = 0.0;
		public static final double S_POS2_SWR_T9 = 0.0;
		public static final double S_POS2_SWR_T10 = 0.0;
		public static final double S_POS2_SWR_T11 = 0.0;
		public static final double S_POS3_SWR_T6 = 0.0;
		public static final double S_POS3_SWR_T7 = 0.0;
		public static final double S_POS3_SWR_T8 = 0.0;
		public static final double S_POS3_SWR_T9 = 0.0;
		public static final double S_POS3_SWR_T10 = 0.0;
		public static final double S_POS3_SWR_T11 = 0.0;
	
		
		
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