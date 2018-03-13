/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2035.robot;

import org.usfirst.frc.team2035.robot.commands.CubeIn;
import org.usfirst.frc.team2035.robot.commands.CubeOut;
import org.usfirst.frc.team2035.robot.commands.GearshiftHigh;
import org.usfirst.frc.team2035.robot.commands.GearshiftLow;
import org.usfirst.frc.team2035.robot.commands.ManualLowerAngle;
import org.usfirst.frc.team2035.robot.commands.WingsOut;
import org.usfirst.frc.team2035.robot.commands.manualRaiseAngle;
import org.usfirst.frc.team2035.robot.commands.testArmMotor;
import org.usfirst.frc.team2035.robot.commands.ArmChangePosition;
import org.usfirst.frc.team2035.robot.commands.ArmClimb;
import org.usfirst.frc.team2035.robot.commands.ArmReverse;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//buttons, buttons, just buttons
	public static Button gearshiftHigh;
	public static Button gearshiftLow;
	public static Button cubeIn;
	public static Button cubeOut; 
	public static Button wingsOut;
	public static Button armReverse;
	public static Button armClimb;
	
	public static Button changeArmAngleTo0;
	public static Button changeArmAngleTo1;
	public static Button changeArmAngleTo2;
	public static Button changeArmAngleTo3;
	public static Button changeArmAngleTo4;
	public static Button resetArmAngle;
	
	public static Button armTest;
	public static Button armManualRaise;
	public static Button armManualLower;
	
	public static void initialize() {
		/**
		 * Sets software buttons to hardware buttons
		 */
		armManualRaise = RobotMap.ARM_MANUAL_RAISE;
		armManualLower = RobotMap.ARM_MANUAL_LOWER;
		
		changeArmAngleTo0 = RobotMap.CHANGE_ARM_ANGLE_0;
		changeArmAngleTo1 = RobotMap.CHANGE_ARM_ANGLE_1;
		changeArmAngleTo2 = RobotMap.CHANGE_ARM_ANGLE_2;
		changeArmAngleTo3 = RobotMap.CHANGE_ARM_ANGLE_3;
		changeArmAngleTo4 = RobotMap.CHANGE_ARM_ANGLE_4;
		//resetArmAngle = RobotMap.RESET_ARM_ANGLE;
		armTest = RobotMap.ARM_TEST;
		
		gearshiftHigh = RobotMap.GEARSHIFT_HIGH;
		gearshiftLow = RobotMap.GEARSHIFT_LOW;
		
		cubeIn = RobotMap.CUBE_IN;
		cubeOut = RobotMap.CUBE_OUT;
		
		armReverse = RobotMap.ARM_REVERSE;
		armClimb = RobotMap.ARM_CLIMB;
		
		wingsOut = RobotMap.WINGS_OUT;
		
		changeArmAngleTo0.whenPressed(new ArmChangePosition(RobotMap.ARM_POSITION_0));
		changeArmAngleTo1.whenPressed(new ArmChangePosition(RobotMap.ARM_POSITION_1));
		changeArmAngleTo2.whenPressed(new ArmChangePosition(RobotMap.ARM_POSITION_2));
		changeArmAngleTo3.whenPressed(new ArmChangePosition(RobotMap.ARM_POSITION_3));
		changeArmAngleTo4.whenPressed(new ArmChangePosition(RobotMap.ARM_POSITION_4));
		//resetArmAngle.whenPressed(new ArmChangePosition(RobotMap.ARM_STARTING_POSITION));
		armManualRaise.whileHeld(new manualRaiseAngle());
		armManualLower.whileHeld(new ManualLowerAngle());
		
		wingsOut.whenPressed(new WingsOut());
		armReverse.whenPressed(new ArmReverse());
		armClimb.whenPressed(new ArmClimb());
		gearshiftHigh.whileHeld(new GearshiftHigh());
		gearshiftLow.whileHeld(new GearshiftLow());
		cubeIn.whileHeld(new CubeIn());
		cubeOut.whileHeld(new CubeOut());
		
		armTest.whenPressed(new testArmMotor());
	}
}