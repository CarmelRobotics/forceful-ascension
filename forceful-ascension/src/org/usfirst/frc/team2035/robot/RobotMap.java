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
	
	
	//Arm 1:27.41 DO NOT CHANGE!!!
	
	
	public static final int ARM_STARTING_POSITION = -20275; //-20275 or 65 degrees//raw sensor units
	public static final double ARM_POSITION_0 = 0; // 0 degrees on arm gear 
	public static final double ARM_POSITION_1 = 548; // 20 degrees on arm gear 
	public static final double ARM_POSITION_2 = 1508; // 55 degrees on arm gear //-17158
	public static final double ARM_POSITION_3 = 1782; // 65 degrees on arm gear // -20275
	public static final double ARM_POSITION_4 = 2800; // 90 degrees on arm gear // 2467 precise
		
	// PWM  
	
	public static final int RB_DRIVETRAIN_MOTOR_PWM = 0; // 0
	public static final int ARM_CLIMBER_1 = 1; 
	public static final int ARM_CLIMBER_2 = 2; 
	public static final int ARM_CLIMBER_3 = 3; 
	public static final int LB_DRIVETRAIN_MOTOR_PWM = 4; // LB - left bottom	4
	public static final int ARM_EXTENDER = 5; 
	
	public static final int R_CUBEMECH_MOTOR_PWM = 6;
	public static final int L_CUBEMECH_MOTOR_PWM = 7;

	
	/*DIOs*/
	public static final int ONE_SWITCH = 0;
	public static final int TWO_SWITCH = 1;
	
	
	/* Motor Speeds */
	public static final double CUBEMECH_SPEED = 0.6;
	public static final double ARM_CLIMB_SPEED = 1.0;
	public static final double ARM_EXTEND_SPEED = 1.0;
	

	/* Solenoids */
	
	public static final int COMPRESSOR_PCM_ID = 0;

	public static final int SOLE_GEARSHIFT_HIGH = 0;
	public static final int SOLE_GEARSHIFT_LOW = 1;
	public static final int WINGS = 2;
	public static final int CUBE_SOLENOID_OPEN = 3;
	public static final int CUBE_SOLENOID_CLOSE = 4;
	public static final int PLACEHOLDER = 5;
	public static final int ARM_LATCH_OPEN = 6;
	
	
	
	

	//CAN Network
	
	public static final int LT_DRIVETRAIN_MOTOR = 1; //1
	public static final int RT_DRIVETRAIN_MOTOR = 2; //2
	public static final int ANGLER_ID = 3;
	
	/* Joystick */
	public static final int JOY_DRIVE_USB = 0;
	public static final Joystick JOY_DRIVE = new Joystick(JOY_DRIVE_USB);
	public static final int JOY_ARM_USB = 1;
	public static final Joystick JOY_ARM = new Joystick(JOY_ARM_USB);
	
    
	
	/* Buttons (Ari's)*/ 
	
	
	//public static final JoystickButton GEARSHIFT_LOW = new JoystickButton(JOY_DRIVE, 1);
	public static final JoystickButton GEARSHIFT_HIGH = new JoystickButton(JOY_DRIVE, 1);

	public static final JoystickButton CUBE_IN_DRIVER = new JoystickButton(JOY_DRIVE, 2);
	//public static final JoystickButton CHANGE_ARM_ANGLE_1_DRIVER = new JoystickButton(JOY_DRIVE,3);
	public static final JoystickButton CUBE_OUT_DRIVER = new JoystickButton(JOY_DRIVE, 3);
	public static final JoystickButton CHANGE_ARM_ANGLE_0_DRIVER = new JoystickButton(JOY_DRIVE,4); 
	public static final JoystickButton CHANGE_ARM_ANGLE_3_DRIVER = new JoystickButton(JOY_DRIVE,5);
	//public static final JoystickButton CHANGE_ARM_ANGLE_4_DRIVER = new JoystickButton(JOY_DRIVE,5);

	public static final JoystickButton ARM_DRIVER_EXTEND = new JoystickButton(JOY_DRIVE,6);
	//public static final JoystickButton ARM_DRIVER_RETRACT = new JoystickButton(JOY_DRIVE,7);
	public static final JoystickButton OPEN_HANGER = new JoystickButton(JOY_DRIVE,7);
	public static final JoystickButton ARM_CLIMB = new JoystickButton(JOY_DRIVE,8);
	public static final JoystickButton WINGS_OUT = new JoystickButton(JOY_DRIVE, 9);
	public static final JoystickButton ARM_LATCH = new JoystickButton(JOY_DRIVE, 10);
	public static final JoystickButton ARM_REVERSE_CLIMB = new JoystickButton(JOY_DRIVE,11);

	
	
//	public static final JoystickButton OPEN_HANGER = new JoystickButton(JOY_ARM, 1);
	public static final JoystickButton RESET_ARM_ANGLE = new JoystickButton(JOY_ARM,1);
	public static final JoystickButton ARM_RETRACT = new JoystickButton(JOY_ARM,2);
	public static final JoystickButton ARM_EXTEND = new JoystickButton(JOY_ARM,3);
	public static final JoystickButton CUBE_IN = new JoystickButton(JOY_ARM, 4);
	public static final JoystickButton CUBE_OUT = new JoystickButton(JOY_ARM, 5);
    public static final JoystickButton CHANGE_ARM_ANGLE_0 = new JoystickButton(JOY_ARM,6); 
	public static final JoystickButton CHANGE_ARM_ANGLE_1 = new JoystickButton(JOY_ARM,7);
	public static final JoystickButton CHANGE_ARM_ANGLE_2 = new JoystickButton(JOY_ARM,8);
	public static final JoystickButton CHANGE_ARM_ANGLE_3 = new JoystickButton(JOY_ARM,9);
	public static final JoystickButton CHANGE_ARM_ANGLE_4 = new JoystickButton(JOY_ARM,10);

	
	public static final JoystickButton ARM_MANUAL_LOWER = new JoystickButton(JOY_ARM,11); 
	//public static final JoystickButton ARM_MANUAL_RAISE = new JoystickButton(JOY_DRIVE,6); 
	
	
}

	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}

