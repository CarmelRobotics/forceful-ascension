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

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	
	//Arm
	public static final int ARM_ANGLE_SPEED = 1;
	public static final int ARM_EXTEND_SPEED = 1;
	public static final int ARM_STARTING_POSITION = 30; //temp
	
		//switch to angle measurements later
	public static final double ARM_POSITION_1 = 0; 
	public static final double ARM_POSITION_2 = 15;
	public static final double ARM_POSITION_3 = 30;
	public static final double ARM_POSITION_4 = 60; //temp
	public static final double ARM_POSITION_5 = 90;
	
	//PWMS
	public static final int LEFT_ARM_ANGLE = 4;
	public static final int RIGHT_ARM_ANGLE = 5; 
	public static final int ARM_EXTEND_1 = 6; 
	public static final int ARM_EXTEND_2 = 7; 
	public static final int ARM_EXTEND_3 = 8; 
	
	//CAN
	public static final int ARM_SOLENOID = 0;
	
	//Encoder channel
	
	public static final int ANGLER_ID = 4;
	
	
	//Joysticks
	
	public static final int JOYSTICK_A_USB_NUMBER = 0;
    public static final Joystick DRIVER_JOYSTICK_A = new Joystick(JOYSTICK_A_USB_NUMBER);
    
    public static final JoystickButton CHANGE_ARM_ANGLE_1 = new JoystickButton(DRIVER_JOYSTICK_A,1); //change later
    public static final JoystickButton CHANGE_ARM_ANGLE_2 = new JoystickButton(DRIVER_JOYSTICK_A,2);//change later
    public static final JoystickButton CHANGE_ARM_ANGLE_3 = new JoystickButton(DRIVER_JOYSTICK_A,3);//change later
    public static final JoystickButton CHANGE_ARM_ANGLE_4 = new JoystickButton(DRIVER_JOYSTICK_A,4);//change later
    public static final JoystickButton CHANGE_ARM_ANGLE_5 = new JoystickButton(DRIVER_JOYSTICK_A,5);//change later
    public static final JoystickButton RESET_ARM_ANGLE = new JoystickButton(DRIVER_JOYSTICK_A,6);//change later
	
	
	
}
