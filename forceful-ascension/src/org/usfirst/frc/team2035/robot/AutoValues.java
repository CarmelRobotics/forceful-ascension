/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2035.robot;

/**
 * AutoValues stores speeds, rotations, and time lengths used in the autonomous commands of the robot.
 * 
 * THE SYSTEM:
 * 
 * Typically, the format of the variables in this class are as follows:
 * 		"routingGroup_startPositionOfRoute_endPositionOfRoute_specificValueStored"
 * For example, S1_POS1_SWL_SP1 stores a value for AutoSW1 for a routing that goes from starting position 1 to the left
 * switch; the variable is the first speed value used in that routing. A glossary for this class is below:
 * 
 * AutoSW1 (represented by S1): first part of autonomous routing group that directs bot to place box on nearest switch; this part pilots bot from starting
 * 		position to a switch and places a cube on one (6 TOTAL ROUTES)
 * 
 * 
 */
public class AutoValues { 
	
	/*AutoSW1 Speeds, Rotations, Times*/
		/*Position 1 to Left Switch*/
			public static final double S1_POS1_SWL_SPD1 = 0.5;
			public static final double S1_POS1_SWL_SPD2 = 0.6;
			public static final double S1_POS1_SWL_SPD3 = 0.5;
			public static final double S1_POS1_SWL_ROT1 = 0.6;
			public static final double S1_POS1_SWL_ROT2 = 0.4;
			public static final double S1_POS1_SWL_T1 = 1.0;
			public static final double S1_POS1_SWL_T2 = 2.9;
			public static final double S1_POS1_SWL_T3 = 3.5;
			public static final double S1_POS1_SWL_T4 = 1.2;
			public static final double S1_POS1_SWL_T5 = 2.5;
			
		/*Position 2 to Left Switch*/
			public static final double S1_POS2_SWL_SPD1 = 0.1;
			public static final double S1_POS2_SWL_SPD2 = 0.2;
			public static final double S1_POS2_SWL_SPD3 = 0.1;
			public static final double S1_POS2_SWL_ROT1 = 0.7;
			public static final double S1_POS2_SWL_ROT2 = 1.0;
			public static final double S1_POS2_SWL_T1 = 0.5;
			public static final double S1_POS2_SWL_T2 = 0.4;
			public static final double S1_POS2_SWL_T3 = 3.0;
			public static final double S1_POS2_SWL_T4 = 5.0;
			public static final double S1_POS2_SWL_T5 = 0.2;
			
		/*Position 3 to Left Switch*/
			public static final double S1_POS3_SWL_SPD1 = 0.5;
			public static final double S1_POS3_SWL_SPD2 = 0.5;
			public static final double S1_POS3_SWL_SPD3 = 0.5;
			public static final double S1_POS3_SWL_ROT1 = 0.2;
			public static final double S1_POS3_SWL_ROT2 = 0.2;
			public static final double S1_POS3_SWL_T1 = 1.0;
			public static final double S1_POS3_SWL_T2 = 1.0;
			public static final double S1_POS3_SWL_T3 = 1.0;
			public static final double S1_POS3_SWL_T4 = 1.0;
			public static final double S1_POS3_SWL_T5 = 1.0;
			
			
			
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
			
	/*AutoBOXSW Speeds, Rotations, Times*/
		/*Left Switch to Left Side*/
			public static final double BXS_SWL_SDL_SPD1 = 0.0;
			public static final double BXS_SWL_SDL_SPD2 = 0.0;
			public static final double BXS_SWL_SDL_SPD3 = 0.0;
			public static final double BXS_SWL_SDL_SPD4 = 0.0;
			public static final double BXS_SWL_SDL_ROT1 = 0.0;
			public static final double BXS_SWL_SDL_ROT2 = 0.0;
			public static final double BXS_SWL_SDL_ROT3 = 0.0;
			public static final double BXS_SWL_SDL_T1 = 0.0;
			public static final double BXS_SWL_SDL_T2 = 0.0;
			public static final double BXS_SWL_SDL_T3 = 0.0;
			public static final double BXS_SWL_SDL_T4 = 0.0;
			public static final double BXS_SWL_SDL_T5 = 0.0;
			public static final double BXS_SWL_SDL_T6 = 0.0;
			public static final double BXS_SWL_SDL_T7 = 0.0;
				
	/*Left Switch to Right Side*/
			public static final double BXS_SWL_SDR_SPD1 = 0.0;
			public static final double BXS_SWL_SDR_SPD2 = 0.0;
			public static final double BXS_SWL_SDR_SPD3 = 0.0;
			public static final double BXS_SWL_SDR_SPD4 = 0.0;
			public static final double BXS_SWL_SDR_ROT1 = 0.0;
			public static final double BXS_SWL_SDR_ROT2 = 0.0;
			public static final double BXS_SWL_SDR_ROT3 = 0.0;
			public static final double BXS_SWL_SDR_T1 = 0.0;
			public static final double BXS_SWL_SDR_T2 = 0.0;
			public static final double BXS_SWL_SDR_T3 = 0.0;
			public static final double BXS_SWL_SDR_T4 = 0.0;
			public static final double BXS_SWL_SDR_T5 = 0.0;
			public static final double BXS_SWL_SDR_T6 = 0.0;
			public static final double BXS_SWL_SDR_T7 = 0.0;
					
					
					
		/*Right Switch to Left Side*/
			public static final double BXS_SWR_SDL_SPD1 = 0.0;
			public static final double BXS_SWR_SDL_SPD2 = 0.0;
			public static final double BXS_SWR_SDL_SPD3 = 0.0;
			public static final double BXS_SWR_SDL_SPD4 = 0.0;
			public static final double BXS_SWR_SDL_ROT1 = 0.0;
			public static final double BXS_SWR_SDL_ROT2 = 0.0;
			public static final double BXS_SWR_SDL_ROT3 = 0.0;
			public static final double BXS_SWR_SDL_T1 = 0.0;
			public static final double BXS_SWR_SDL_T2 = 0.0;
			public static final double BXS_SWR_SDL_T3 = 0.0;
			public static final double BXS_SWR_SDL_T4 = 0.0;
			public static final double BXS_SWR_SDL_T5 = 0.0;
			public static final double BXS_SWR_SDL_T6 = 0.0;
			public static final double BXS_SWR_SDL_T7 = 0.0;
					
		/*Right Switch to Right Side*/
			public static final double BXS_SWR_SDR_SPD1 = 0.0;
			public static final double BXS_SWR_SDR_SPD2 = 0.0;
			public static final double BXS_SWR_SDR_SPD3 = 0.0;
			public static final double BXS_SWR_SDR_SPD4 = 0.0;
			public static final double BXS_SWR_SDR_ROT1 = 0.0;
			public static final double BXS_SWR_SDR_ROT2 = 0.0;
			public static final double BXS_SWR_SDR_ROT3 = 0.0;
			public static final double BXS_SWR_SDR_T1 = 0.0;
			public static final double BXS_SWR_SDR_T2 = 0.0;
			public static final double BXS_SWR_SDR_T3 = 0.0;
			public static final double BXS_SWR_SDR_T4 = 0.0;
			public static final double BXS_SWR_SDR_T5 = 0.0;
			public static final double BXS_SWR_SDR_T6 = 0.0;
			public static final double BXS_SWR_SDR_T7 = 0.0;			

/*--------------------------------------------------------------------------------------------------------------------*/
	
	/*AutoCL Speeds and Rotations*/
		/*Position 1 to Left Side*/
			public static final double C_POS1_SDL_SPD1 = 0.0;
			public static final double C_POS1_SDL_SPD2 = 0.0;
			public static final double C_POS1_SDL_SPD3 = 0.0;
			public static final double C_POS1_SDL_ROT1 = 0.6;
			public static final double C_POS1_SDL_ROT2 = 0.0;
			public static final double C_POS1_SDL_T1 = 0.0;
			public static final double C_POS1_SDL_T2 = 0.9;
			public static final double C_POS1_SDL_T3 = 0.0;
			public static final double C_POS1_SDL_T4 = 0.0;
			public static final double C_POS1_SDL_T5 = 0.0;
				
		/*Position 2 to Left Side*/
			public static final double C_POS2_SDL_SPD1 = 0.0;
			public static final double C_POS2_SDL_SPD2 = 0.0;
			public static final double C_POS2_SDL_SPD3 = 0.0;
			public static final double C_POS2_SDL_ROT1 = 0.0;
			public static final double C_POS2_SDL_ROT2 = 0.0;
			public static final double C_POS2_SDL_T1 = 0.0;
			public static final double C_POS2_SDL_T2 = 0.0;
			public static final double C_POS2_SDL_T3 = 0.0;
			public static final double C_POS2_SDL_T4 = 0.0;
			public static final double C_POS2_SDL_T5 = 0.0;
				
		/*Position 3 to Left Side*/
			public static final double C_POS3_SDL_SPD1 = 0.0;
			public static final double C_POS3_SDL_SPD2 = 0.0;
			public static final double C_POS3_SDL_SPD3 = 0.0;
			public static final double C_POS3_SDL_ROT1 = 0.0;
			public static final double C_POS3_SDL_ROT2 = 0.0;
			public static final double C_POS3_SDL_T1 = 0.0;
			public static final double C_POS3_SDL_T2 = 0.0;
			public static final double C_POS3_SDL_T3 = 0.0;
			public static final double C_POS3_SDL_T4 = 0.0;
			public static final double C_POS3_SDL_T5 = 0.0;
				
				
				
		/*Position 1 to Right Side*/
			public static final double C_POS1_SDR_SPD1 = 0.0;
			public static final double C_POS1_SDR_SPD2 = 0.0;
			public static final double C_POS1_SDR_SPD3 = 0.0;
			public static final double C_POS1_SDR_ROT1 = 0.0;
			public static final double C_POS1_SDR_ROT2 = 0.0;
			public static final double C_POS1_SDR_T1 = 0.0;
			public static final double C_POS1_SDR_T2 = 0.0;
			public static final double C_POS1_SDR_T3 = 0.0;
			public static final double C_POS1_SDR_T4 = 0.0;
			public static final double C_POS1_SDR_T5 = 0.0;
				
		/*Position 2 to Right Side*/
			public static final double C_POS2_SDR_SPD1 = 0.0;
			public static final double C_POS2_SDR_SPD2 = 0.0;
			public static final double C_POS2_SDR_SPD3 = 0.0;
			public static final double C_POS2_SDR_ROT1 = 0.0;
			public static final double C_POS2_SDR_ROT2 = 0.0;
			public static final double C_POS2_SDR_T1 = 0.0;
			public static final double C_POS2_SDR_T2 = 0.0;
			public static final double C_POS2_SDR_T3 = 0.0;
			public static final double C_POS2_SDR_T4 = 0.0;
			public static final double C_POS2_SDR_T5 = 0.0;
				
		/*Position 3 to Right Side*/
			public static final double C_POS3_SDR_SPD1 = 0.0;
			public static final double C_POS3_SDR_SPD2 = 0.0;
			public static final double C_POS3_SDR_SPD3 = 0.0;
			public static final double C_POS3_SDR_ROT1 = 0.0;
			public static final double C_POS3_SDR_ROT2 = 0.0;
			public static final double C_POS3_SDR_T1 = 0.0;
			public static final double C_POS3_SDR_T2 = 0.0;
			public static final double C_POS3_SDR_T3 = 0.0;
			public static final double C_POS3_SDR_T4 = 0.0;
			public static final double C_POS3_SDR_T5 = 0.0;

/*--------------------------------------------------------------------------------------------------------------------*/
	/*AutoMID Speeds, Rotations, Times*/
		/*Left Middle Switch*/
			public static final double M_SDL_SPD1 = 0.0;
			public static final double M_SDL_SPD2 = 0.0;
			public static final double M_SDL_ROT1 = 0.0;
			public static final double M_SDL_T1 = 0.0;
			public static final double M_SDL_T2 = 0.0;
			public static final double M_SDL_T3 = 0.0;
		
			/*Right Middle Switch*/
			public static final double M_SDR_SPD1 = 0.0;
			public static final double M_SDR_SPD2 = 0.0;
			public static final double M_SDR_ROT1 = 0.0;
			public static final double M_SDR_T1 = 0.0;
			public static final double M_SDR_T2 = 0.0;
			public static final double M_SDR_T3 = 0.0;	
}