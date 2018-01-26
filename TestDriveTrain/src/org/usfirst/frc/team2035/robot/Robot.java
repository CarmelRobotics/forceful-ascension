/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2035.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

/**
 * Code for using the 2014 bot as a test robot.
 * Made by Robbie. 
 */
public class Robot extends IterativeRobot {
	  private final DifferentialDrive drive; // actual drive
	  private final Victor FLeftMotor;
	  private final Victor MLeftMotor;
	  private final Victor BLeftMotor;
	  private final Victor FRightMotor;
	  private final Victor MRightMotor;
	  private final Victor BRightMotor;

	  private final SpeedControllerGroup LSControlGroup; //Left Speed Controller group
	  private final SpeedControllerGroup RSControlGroup; // Right Speed Controller group
	  
	  /** Driver Station related imports */
	  private final Joystick JStick;
	  private final SmartDashboard SDBoard;
	  
	public Robot()
	{
		/** Speed Controllers */
		FRightMotor = new Victor(0);
		MRightMotor = new Victor(1);
		BRightMotor = new Victor(2);
		FLeftMotor = new Victor(3);
		MLeftMotor = new Victor(4);
		BLeftMotor = new Victor(5);
		
		LSControlGroup = new SpeedControllerGroup(FLeftMotor, MLeftMotor, BLeftMotor);
		RSControlGroup = new SpeedControllerGroup(FRightMotor, MRightMotor, BRightMotor);
		drive = new DifferentialDrive(LSControlGroup, RSControlGroup);
		JStick = new Joystick(0); // Change # in driver station, not here. 
		SDBoard = new SmartDashboard();
		DBoard = new Dashboard(); 
	}
	    /**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit()
	{
		//FLeftMotor.setInverted(true);
		//MLeftMotor.setInverted(true); 
		//BLeftMotor.setInverted(true);
	}

	/**
	 * This function is run once each time the robot enters autonomous mode.
	 */
	@Override
	public void autonomousInit() 
	{
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() 
	{
	}

	/**
	 */
	@Override
	public void teleopInit() 
	{
	}

	/**
	 * This is were everything is going to happen, as this is a bot used to test drivers/drivetrain code.
	 */ 
	@Override
	public void teleopPeriodic() 
	{
		drive.arcadeDrive(JStick.getY(), JStick.getX());
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
