/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2035.robot;

/**
 * AutoValuesBetter is like AutoValues, but better.
 * System: STARTSFROM_GOESTO_VALUETYPE (START_BRIDGE_SPD stores the speed for the movement going from the starting positions to the "bridge" area)
 * bridge: the small area between the starting positions and the switches
 */
public class AutoValuesBetter { 
	
	public static final double TURN_RIGHT_SPD = 0.0;
	public static final double TURN_RIGHT_TIME = 0.0;
	
	public static final double TURN_LEFT_SPD = 0.0;
	public static final double TURN_LEFT_TIME = 0.0;
	
	//AutoSW1 Speeds, Times
	
	public static final double START_BRIDGE_SPD = 0.0;
	public static final double START_BRIDGE_TIME = 0.0;
	
	public static final double START_SWITCHSIDE_SPD = 0.0;
	public static final double START_SWITCHSIDE_TIME = 0.0;
	
	public static final double BRIDGE_SWITCHFRONT_SPD = 0.0;
	public static final double BRIDGE_SWITCHFRONT_TIME = 0.0;
	
	public static final double BRIDGE_CROSS_SPD = 0.0; //goes from one side of the bridge to the opposite side's switch
	public static final double BRIDGE_CROSS_TIME = 0.0;
	
	public static final double MIDBRIDGE_LEFTSHORT_SPD = 0.0; //goes from middle of bridge (arrival from position 2) to front of left switch
	public static final double MIDBRIDGE_LEFTSHORT_TIME = 0.0;
	
	public static final double MIDBRIDGE_RIGHTSHORT_SPD = 0.0;
	public static final double MIDBRIDGE_RIGHTSHORT_TIME = 0.0;
	
	public static final double SWITCHSIDE_SHORTAPPROACH_SPD = 0.0;
	public static final double SWITCHSIDE_SHORTAPPROACH_TIME = 0.0;
	
	//AutoSW2 Speeds, Times
	
	
	
	//AutoCL Speeds, Times
	
	public static final double STARTSIDE_CROSSLINE_SPD = 0.0;
	public static final double STARTSIDE_CROSSLINE_TIME = 0.0;
	
	public static final double MIDBRIDGE_LEFTLONG_SPD = 0.0; //goes from middle of bridge (arrival from position 2) to left side of field
	public static final double MIDBRIDGE_LEFTLONG_TIME = 0.0;
	
	public static final double MIDBRIDGE_RIGHTLONG_SPD = 0.0;
	public static final double MIDBRIDGE_RIGHTLONG_TIME = 0.0;
	
	public static final double BRIDGE_CROSSLINE_SPD = 0.0;
	public static final double BRIDGE_CROSSLINE_TIME = 0.0;
	
}