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
	
	public static final int START_POS = 0; //leftmost is 0, rightmost is 2
	
	/* PWM */
	public static final int LF_DRIVETRAIN_MOTOR_PWM = 0;
	public static final int LB_DRIVETRAIN_MOTOR_PWM = 0;
	public static final int RF_DRIVETRAIN_MOTOR_PWM = 0;
	public static final int RB_DRIVETRAIN_MOTOR_PWM = 0;
	public static final int R_CUBEMECH_MOTOR_PWM = 0;
	public static final int L_CUBEMECH_MOTOR_PWM = 0;
	
	/* DIO */
	
	/* Motor Speeds */
	public static final double CUBEMECH_IN_SPEED= 1.0;
	public static final double CUBEMECH_OUT_SPEED= -1.0;

	/* Solenoids */
	public static final int L_WINGS = 0;
	public static final int R_WINGS = 0;
	public static final int SOLE_GEARSHIFT_ID = 0;
	public static final int SOLE_GEARSHIFT_HIGH = 0;
	public static final int SOLE_GEARSHIFT_LOW = 0;
	
	/* Joystick */
    public static final int JOY_DRIVE_USB = 0;
    public static final Joystick JOY_DRIVE = new Joystick(JOY_DRIVE_USB);
	
	/* Buttons */
    public static final JoystickButton GEARSHIFT_HIGH = new JoystickButton(JOY_DRIVE, 1);
    public static final JoystickButton GEARSHIFT_LOW = new JoystickButton(JOY_DRIVE, 1);
	public static final JoystickButton CUBE_IN = new JoystickButton(JOY_DRIVE, 1);
	public static final JoystickButton CUBE_OUT = new JoystickButton(JOY_DRIVE, 1);
	public static final JoystickButton WINGS_OUT = new JoystickButton(JOY_DRIVE, 1);
	
	/* Autonomous Speeds... "POS_L2_SPEED1" Means switch Position Left, and Robot Placement Two */
	public static final double POS_L1_SPEED1 = 1;
	public static final double POS_L1_SPEED2 = 1;
	public static final double POS_L1_SPEED3 = 1;
	public static final double POS_L2_SPEED1 = 1;
	public static final double POS_L2_SPEED2 = 1;
	public static final double POS_L2_SPEED3 = 1;
	public static final double POS_L3_SPEED1 = 1;
	public static final double POS_L3_SPEED2 = 1;
	public static final double POS_L3_SPEED3 = 1;
	
	public static final double POS_R1_SPEED1 = 1;
	public static final double POS_R1_SPEED2 = 1;
	public static final double POS_R1_SPEED3 = 1;
	public static final double POS_R2_SPEED1 = 1;
	public static final double POS_R2_SPEED2 = 1;
	public static final double POS_R2_SPEED3 = 1;
	public static final double POS_R3_SPEED1 = 1;
	public static final double POS_R3_SPEED2 = 1;
	public static final double POS_R3_SPEED3 = 1;
	/* Autonomous Directions*/
	public static final double POS_L1_ROTATION1 = 1;
	public static final double POS_L1_ROTATION2 = 1;
	public static final double POS_L2_ROTATION1 = 1;
	public static final double POS_L2_ROTATION2 = 1;
	public static final double POS_L3_ROTATION1 = 1;
	public static final double POS_L3_ROTATION2 = 1;
	
	public static final double POS_R1_ROTATION1 = 1;
	public static final double POS_R1_ROTATION2 = 1;
	public static final double POS_R2_ROTATION1 = 1;
	public static final double POS_R2_ROTATION2 = 1;
	public static final double POS_R3_ROTATION1 = 1;
	public static final double POS_R3_ROTATION2 = 1;
}
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
}
