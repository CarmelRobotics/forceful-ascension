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
/* Autonomous Speeds...S = switch routing, POS1 = position 1, SWL = switch left, SP1 = speed 1*/
/* Autonomous Rotations...S = switch routing, POS1 = position 1, SWL = switch left, SP1 = rotation 1*/
/* Autonomous Times...S = switch routing, POS1 = position 1, SWL = switch left, T1 = time length 1*/
	
	/*AutoSW1 Speeds, Rotations, Times*/
		/*Position 1 to Left Switch*/
			public static final double S1_POS1_SWL_SPD1 = 0.0;
			public static final double S1_POS1_SWL_SPD2 = 0.0;
			public static final double S1_POS1_SWL_SPD3 = 0.0;
			public static final double S1_POS1_SWL_ROT1 = 0.6;
			public static final double S1_POS1_SWL_ROT2 = 0.0;
			public static final double S1_POS1_SWL_T1 = 0.0;
			public static final double S1_POS1_SWL_T2 = 0.9;
			public static final double S1_POS1_SWL_T3 = 0.0;
			public static final double S1_POS1_SWL_T4 = 0.0;
			public static final double S1_POS1_SWL_T5 = 0.0;
			
		/*Position 2 to Left Switch*/
			public static final double S1_POS2_SWL_SPD1 = 0.0;
			public static final double S1_POS2_SWL_SPD2 = 0.0;
			public static final double S1_POS2_SWL_SPD3 = 0.0;
			public static final double S1_POS2_SWL_ROT1 = 0.0;
			public static final double S1_POS2_SWL_ROT2 = 0.0;
			public static final double S1_POS2_SWL_T1 = 0.0;
			public static final double S1_POS2_SWL_T2 = 0.0;
			public static final double S1_POS2_SWL_T3 = 0.0;
			public static final double S1_POS2_SWL_T4 = 0.0;
			public static final double S1_POS2_SWL_T5 = 0.0;
			
		/*Position 3 to Left Switch*/
			public static final double S1_POS3_SWL_SPD1 = 0.0;
			public static final double S1_POS3_SWL_SPD2 = 0.0;
			public static final double S1_POS3_SWL_SPD3 = 0.0;
			public static final double S1_POS3_SWL_ROT1 = 0.0;
			public static final double S1_POS3_SWL_ROT2 = 0.0;
			public static final double S1_POS3_SWL_T1 = 0.0;
			public static final double S1_POS3_SWL_T2 = 0.0;
			public static final double S1_POS3_SWL_T3 = 0.0;
			public static final double S1_POS3_SWL_T4 = 0.0;
			public static final double S1_POS3_SWL_T5 = 0.0;
			
			
			
		/*Position 1 to Right Switch*/
			public static final double S1_POS1_SWR_SPD1 = 0.0;
			public static final double S1_POS1_SWR_SPD2 = 0.0;
			public static final double S1_POS1_SWR_SPD3 = 0.0;
			public static final double S1_POS1_SWR_ROT1 = 0.0;
			public static final double S1_POS1_SWR_ROT2 = 0.0;
			public static final double S1_POS1_SWR_T1 = 0.0;
			public static final double S1_POS1_SWR_T2 = 0.0;
			public static final double S1_POS1_SWR_T3 = 0.0;
			public static final double S1_POS1_SWR_T4 = 0.0;
			public static final double S1_POS1_SWR_T5 = 0.0;
			
		/*Position 2 to Right Switch*/
			public static final double S1_POS2_SWR_SPD1 = 0.0;
			public static final double S1_POS2_SWR_SPD2 = 0.0;
			public static final double S1_POS2_SWR_SPD3 = 0.0;
			public static final double S1_POS2_SWR_ROT1 = 0.0;
			public static final double S1_POS2_SWR_ROT2 = 0.0;
			public static final double S1_POS2_SWR_T1 = 0.0;
			public static final double S1_POS2_SWR_T2 = 0.0;
			public static final double S1_POS2_SWR_T3 = 0.0;
			public static final double S1_POS2_SWR_T4 = 0.0;
			public static final double S1_POS2_SWR_T5 = 0.0;
			
		/*Position 3 to Right Switch*/
			public static final double S1_POS3_SWR_SPD1 = 0.0;
			public static final double S1_POS3_SWR_SPD2 = 0.0;
			public static final double S1_POS3_SWR_SPD3 = 0.0;
			public static final double S1_POS3_SWR_ROT1 = 0.0;
			public static final double S1_POS3_SWR_ROT2 = 0.0;
			public static final double S1_POS3_SWR_T1 = 0.0;
			public static final double S1_POS3_SWR_T2 = 0.0;
			public static final double S1_POS3_SWR_T3 = 0.0;
			public static final double S1_POS3_SWR_T4 = 0.0;
			public static final double S1_POS3_SWR_T5 = 0.0;

/*--------------------------------------------------------------------------------------------------------------------*/
			
/* Autonomous Speeds...S = switch routing, POS1 = position 1, SWL = switch left, SP1 = speed 1*/
/* Autonomous Rotations...S = switch routing, POS1 = position 1, SWL = switch left, SP1 = rotation 1*/
/* Autonomous Times...S = switch routing, POS1 = position 1, SWL = switch left, T1 = time length 1*/		
			
	/*AutoSW2 Speeds, Rotations, Times*/
		/*Left Switch to Left Side*/
			public static final double S2_SWL_SDL_SPD1 = 0.0;
			public static final double S2_SWL_SDL_SPD2 = 0.0;
			public static final double S2_SWL_SDL_SPD3 = 0.0;
			public static final double S2_SWL_SDL_ROT1 = 0.0;
			public static final double S2_SWL_SDL_ROT2 = 0.0;
			public static final double S2_SWL_SDL_T1 = 0.0;
			public static final double S2_SWL_SDL_T2 = 0.0;
			public static final double S2_SWL_SDL_T3 = 0.0;
			public static final double S2_SWL_SDL_T4 = 0.0;
			public static final double S2_SWL_SDL_T5 = 0.0;
			
		/*Left Switch to Right Side*/
			public static final double S2_SWL_SDR_SPD1 = 0.0;
			public static final double S2_SWL_SDR_SPD2 = 0.0;
			public static final double S2_SWL_SDR_SPD3 = 0.0;
			public static final double S2_SWL_SDR_ROT1 = 0.0;
			public static final double S2_SWL_SDR_ROT2 = 0.0;
			public static final double S2_SWL_SDR_T1 = 0.0;
			public static final double S2_SWL_SDR_T2 = 0.0;
			public static final double S2_SWL_SDR_T3 = 0.0;
			public static final double S2_SWL_SDR_T4 = 0.0;
			public static final double S2_SWL_SDR_T5 = 0.0;
			
			
			
		/*Right Switch to Left Side*/
			public static final double S2_SWR_SDL_SPD1 = 0.0;
			public static final double S2_SWR_SDL_SPD2 = 0.0;
			public static final double S2_SWR_SDL_SPD3 = 0.0;
			public static final double S2_SWR_SDL_ROT1 = 0.0;
			public static final double S2_SWR_SDL_ROT2 = 0.0;
			public static final double S2_SWR_SDL_T1 = 0.0;
			public static final double S2_SWR_SDL_T2 = 0.0;
			public static final double S2_SWR_SDL_T3 = 0.0;
			public static final double S2_SWR_SDL_T4 = 0.0;
			public static final double S2_SWR_SDL_T5 = 0.0;
			
		/*Right Switch to Right Side*/
			public static final double S2_SWR_SDR_SPD1 = 0.0;
			public static final double S2_SWR_SDR_SPD2 = 0.0;
			public static final double S2_SWR_SDR_SPD3 = 0.0;
			public static final double S2_SWR_SDR_ROT1 = 0.0;
			public static final double S2_SWR_SDR_ROT2 = 0.0;
			public static final double S2_SWR_SDR_T1 = 0.0;
			public static final double S2_SWR_SDR_T2 = 0.0;
			public static final double S2_SWR_SDR_T3 = 0.0;
			public static final double S2_SWR_SDR_T4 = 0.0;
			public static final double S2_SWR_SDR_T5 = 0.0;	

/*--------------------------------------------------------------------------------------------------------------------*/
	
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