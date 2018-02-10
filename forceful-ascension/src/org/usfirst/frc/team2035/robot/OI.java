/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2035.robot;

import org.usfirst.frc.team2035.robot.commands.ArmChangePosition;

import edu.wpi.first.wpilibj.buttons.Button;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	
	public static Button changeArmAngleTo0;
	public static Button changeArmAngleTo1;
	public static Button changeArmAngleTo2;
	public static Button changeArmAngleTo3;
	public static Button changeArmAngleTo4;
	public static Button resetArmAngle;
	
	
	
	
	public static void initialize() {
	changeArmAngleTo0 = RobotMap.CHANGE_ARM_ANGLE_1;
	changeArmAngleTo1 = RobotMap.CHANGE_ARM_ANGLE_2;
	changeArmAngleTo2 = RobotMap.CHANGE_ARM_ANGLE_3;
	changeArmAngleTo3 = RobotMap.CHANGE_ARM_ANGLE_4;
	changeArmAngleTo4 = RobotMap.CHANGE_ARM_ANGLE_5;
	resetArmAngle = RobotMap.RESET_ARM_ANGLE;
	
	
	
	changeArmAngleTo0.whenPressed(new ArmChangePosition(RobotMap.ARM_POSITION_1));
	changeArmAngleTo1.whenPressed(new ArmChangePosition(RobotMap.ARM_POSITION_2));
	changeArmAngleTo2.whenPressed(new ArmChangePosition(RobotMap.ARM_POSITION_3));
	changeArmAngleTo3.whenPressed(new ArmChangePosition(RobotMap.ARM_POSITION_4));
	changeArmAngleTo4.whenPressed(new ArmChangePosition(RobotMap.ARM_POSITION_5));
	resetArmAngle.whenPressed(new ArmChangePosition(RobotMap.ARM_STARTING_POSITION));
	
	
	
	
	}
	
}
