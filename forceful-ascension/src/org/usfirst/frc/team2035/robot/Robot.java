/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2035.robot;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2035.robot.commands.AutoSW;
//import org.usfirst.frc.team2035.robot.commands.AutoSW;
import org.usfirst.frc.team2035.robot.commands.CubeIn;
import org.usfirst.frc.team2035.robot.commands.GearshiftHigh;
//import org.usfirst.frc.team2035.robot.commands.CurveDrive;
import org.usfirst.frc.team2035.robot.commands.TeleopDrive;
import org.usfirst.frc.team2035.robot.commands.WingsOut;
import org.usfirst.frc.team2035.robot.subsystems.CubeMech;
import org.usfirst.frc.team2035.robot.subsystems.Drivetrain;

import org.usfirst.frc.team2035.robot.subsystems.Wings;
import org.usfirst.frc.team2035.robot.subsystems.ACompressor;
import org.usfirst.frc.team2035.robot.subsystems.Arm;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	
	private int counter;
	
	private static Arm arm;
	private String gameData;
	public static CubeMech cbm;
	public static Wings wing;
	public static Drivetrain drt;

	public static CameraServer cms;
	public static ACompressor compressor;
	public static OI oi;
	
	Command wingSetup;
	Command drive;
	Command putInGear;
	
	 Command autonomousCommand;
	 
	
	//SendableChooser<Command> m_chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();
		cbm = new CubeMech();
		wing = new Wings();
		drt = new Drivetrain();

		putInGear = new GearshiftHigh();
		putInGear.start();
		arm = new Arm();
		compressor = new ACompressor();
		counter = 0; 
		//cms = CameraServer.getInstance();
		//cms.startAutomaticCapture();
		
		System.out.println("ghostbusters");
		OI.initialize();
	}
	
	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@SuppressWarnings("unused")
	@Override
	public void autonomousInit() {
		String swPos;
		char swNear;
		char swMid;
		int startPos;
		char sidePass;
		boolean secondBox;
		drt.resetLeft();
		swPos = DriverStation.getInstance().getGameSpecificMessage();
		swNear = swPos.charAt(0);
		swMid = swPos.charAt(1);

		sidePass = RobotMap.SIDE;
		secondBox = RobotMap.SECOND_BOX;
		
		autonomousCommand = new AutoSW(0, 'L');
		/*
		if (RobotMap.ROUTING == 0) //put box on team switch
			autonomousCommand = new AutoSW1(swNear, startPos, sidePass, secondBox);
		else if (RobotMap.ROUTING == 1)  //only cross line
			autonomousCommand = new AutoCL(sidePass, sidePass, 'N', secondBox);
		else if (RobotMap.ROUTING == 2) //put box on middle switch
			autonomousCommand = new AutoCL(sidePass, startPos, swMid, secondBox);
		*/
		if (autonomousCommand != null)
			autonomousCommand.start(); 
	}
	
	/*
	 * Limit Switch Tester
	 * 	int startPos = pls.getRobotStart();
		if(startPos == 1) 
			System.out.println("Position B");
		else if(startPos == 0)
			System.out.println("Position A");
		else if(startPos == 2) 
			System.out.println("Position C");
	 */
	
	/*
	 * m_autonomousCommand = m_chooser.getSelected();
	 * 
	 * String autoSelected = SmartDashboard.getString("Auto Selector",
	 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
	 * = new MyAutoCommand(); break; case "Default Auto": default:
	 * autonomousCommand = new ExampleCommand(); break; }
	 */
	
	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() { //works perfectly at drive .4
		Scheduler.getInstance().run();
		/**
		System.out.println("Left Encoder: "+ drt.currentDegreesLeft());
		System.out.println("Right Encoder: "+ drt.currentDegreesRight());
		if (360 - drt.currentDegreesLeft() < 100) {
			drt.drive(.4, 0);
			System.out.println("slow");
		}
		else if ((drt.currentDegreesLeft()) < 360) {
			drt.drive(0.6, 0.0);
			System.out.println("fast");
		}
	
		 if (drt.currentDegreesLeft() > 360){
			drt.stop();
		
			
		}
		 **/
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null) {
			autonomousCommand.cancel();
		}
		
		compressor.start();
		drive = new TeleopDrive();

	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		drive.start();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
	
	public static Arm getArm() {
		return Robot.arm;
	}
	
	public static CubeMech getCubeMech(){
		return cbm;
	}
	
	public static Wings getWings(){
		return wing;
	}
	
	public static Drivetrain getDrivetrain(){
		return drt;
	}
}
