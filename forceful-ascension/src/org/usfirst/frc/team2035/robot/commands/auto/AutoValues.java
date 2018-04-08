/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2035.robot.commands.auto;

/**
 * the best
 * System: STARTSFROM_GOESTO_VALUETYPE (START_BRIDGE_SPD stores the speed for the movement going from the starting positions to the "bridge" area)
 * bridge: the small area between the starting positions and the switches
 */
public class AutoValues { 
	
	public static final boolean COMPLEX_AUTO = false;
	
	public static final double ENCODER_ADJUSTMENT = .32; //.1155, current is .32
	
	public static final double DEFAULT_TURN_SPEED = 0.5;
	public static final double DEFAULT_MOVE_SPEED = 0.7;
	public static final double SLOW_MOVE_SPEED = 0.6;
	
	public static final double TURN90_RIGHT_INCHES = (28.75/2)*(Math.PI); //20, current is (28.75/2)*Math.PI
	//public static final double TURN90_RIGHT_SPEED = 0.7;
	
	public static final double TURN90_LEFT_INCHES = -1*(28.75/2)*(Math.PI);
	//public static final double TURN90_LEFT_SPEED = 0.7;
	
	public static final double STARTPOS_SWITCHSIDE_INCHES = 168+10; //168
	//public static final double STARTPOS_SWITCHSIDE_SPEED = 0.8;
	
	//public static final double SWITCHSIDE_APPROACH_INCHES = 150; //10'
	//public static final double SWITCHSIDE_APPROACH_SPEED = 0.5;
	
	public static final double STARTPOS2_RIGHTSWITCHFRONT_INCHES = 60; //right-switch-front
	//public static final double STARTPOS2_RIGHTSWITCHFRONT_SPEED = 0.8;
	
	public static final double SWITCHFRONT_APPROACH_INCHES = 60; //right-switch-front
	//public static final double SWITCHFRONT_APPROACH_SPEED = 0.5;
	
	public static final double RIGHTSWITCHFRONT_LEFTSWITCHFRONT_INCHES = 135; //right-switch-front
	//public static final double RIGHTSWITCHFRONT_LEFTSWITCHFRONT_SPEED = 0.8;
	
	public static final double POSITIONFRONT_OPPOSITESWITCHFRONT_INCHES = 180;
	
}