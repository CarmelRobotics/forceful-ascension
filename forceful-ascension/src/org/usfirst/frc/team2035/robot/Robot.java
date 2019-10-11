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


import edu.wpi.first.wpilibj.TimedRobot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



import org.usfirst.frc.team2035.robot.commands.CubeIn;
import org.usfirst.frc.team2035.robot.commands.GearshiftHigh;
import org.usfirst.frc.team2035.robot.commands.ManualLowerAngle;
//import org.usfirst.frc.team2035.robot.commands.CurveDrive;
import org.usfirst.frc.team2035.robot.commands.TeleopDrive;
import org.usfirst.frc.team2035.robot.commands.WingsOut;
import org.usfirst.frc.team2035.robot.commands.auto.AutoMain;
import org.usfirst.frc.team2035.robot.subsystems.CubeMech;
import org.usfirst.frc.team2035.robot.subsystems.Drivetrain;
import org.usfirst.frc.team2035.robot.subsystems.RotarySwitch;
import org.usfirst.frc.team2035.robot.subsystems.Wings;
import org.usfirst.frc.team2035.robot.subsystems.ACompressor;
import org.usfirst.frc.team2035.robot.subsystems.Arm;
import org.usfirst.frc.team2035.robot.subsystems.CubeDepositer;


import org.usfirst.frc.team2035.robot.commands.ExampleCommand;
import org.usfirst.frc.team2035.robot.subsystems.ExampleSubsystem;


//Your supreme leader Fang was here

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
	public static CubeDepositer cd;
	public static RotarySwitch rs;
	
	public static CameraServer cms;
	public static ACompressor compressor;
	public static OI oi;
	

	
	
	private boolean x;
	
	Command wingSetup;
	Command drive;
	Command putInGear;
	Command manualLowerAngle;
	 Command autonomousCommand;
	 
	
	//SendableChooser<Command> m_chooser = new SendableChooser<>();

	public static final ExampleSubsystem kExampleSubsystem
			= new ExampleSubsystem();
	public static OI m_oi;

	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();
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
		cd = new CubeDepositer();
		rs = new RotarySwitch();
		//putInGear = new GearshiftHigh();
		//putInGear.start();
		arm = new Arm();
		compressor = new ACompressor();
		counter = 0; 
		x = true;
		wing.wingsSolenoidsOff();
		//cms = CameraServer.getInstance();
		//cms.startAutomaticCapture();

		System.out.println("ghostbusters");
		OI.initialize();
	}
	

		m_oi = new OI();
		m_chooser.addDefault("Default Auto", new ExampleCommand());
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", m_chooser);
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
		
		//initializing variables that are passed to autonomous code
		String swPos;
		char swNear;
		char swMid;
		int startPos;
		String gameData;
		
		//resetting drivetrain encoders in preparation for the running of the autonomous code
		drt.resetLeft();
		drt.resetRight();
		
		//sets variables that are based on data in the driver station's Game Data
		swPos = DriverStation.getInstance().getGameSpecificMessage();
		swNear = swPos.charAt(0);
		swMid = swPos.charAt(1);
		
		//sets variable based on position of rotary switch
		startPos = rs.getSwitchPosition();
		
		//ensures that the rotary switch variable is set to a value the autonomous code can use
		if (startPos == -1)
			startPos = 0;
		
		//ensures that the robot is in high gear
		drt.gearshiftHigh();
		
		//sets the command variable to the autonomous object with parameters set to the variables obtained above
		autonomousCommand = new AutoMain(startPos, swNear);
		
		//runs command
		if (autonomousCommand != null) {
			autonomousCommand.start();
		}
	}
	
	
	
	/*
	 * m_autonomousCommand = m_chooser.getSelected();
	 * 
	 * String autoSelected = SmartDashboard.getString("Auto Selector",
	 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
	 * = new MyAutoCommand(); break; case "Default Auto": default:
	 * autonomousCommand = new ExampleCommand(); break; }
	 */
	

	@Override
	public void autonomousInit() {
		m_autonomousCommand = m_chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
	}


	/**
	 * This function is called periodically during autonomous.
	 */
	@Override

	public void autonomousPeriodic() { //works perfectly at drive .4
		
		Scheduler.getInstance().run();
		
		//System.out.println("Left Encoder: "+ drt.currentDegreesLeft());
		//System.out.println("Right Encoder: "+ drt.currentDegreesRight());
		/*
		if (360 - drt.currentDegreesLeft() < 100 && x) {
			drt.drive(.5, 0);
			System.out.println("slow");
			if(drt.currentDegreesLeft() > 360) {
				x = false;
			}
		}
		else if ((drt.currentDegreesLeft()) < 360) {
			drt.drive(0.5, 0.0);
			System.out.println("fast");
		}
	
		 if (drt.currentDegreesLeft() > 360){
			drt.stop();
		
			
		}
		 */

	public void autonomousPeriodic() {
		Scheduler.getInstance().run();

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
		//drive = new TeleopDrive();
		drt.gearshiftHigh();
		arm.setAnglerPosition(-20275);
	//	manualLowerAngle = new ManualLowerAngle();

		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}

	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();

		//1System.out.println(rs.getSwitchPosition());
		//drt.gearshiftHigh();
		drt.drive();
		//drive.start();
	//	manualLowerAngle.start();
		
		
		

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
	public static CubeDepositer getCubeDepositer() {
		return cd;
	}

}
