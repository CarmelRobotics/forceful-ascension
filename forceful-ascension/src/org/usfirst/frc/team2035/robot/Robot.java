/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2035.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.VisionThread;

import org.usfirst.frc.team2035.robot.vision.Processing;
import org.usfirst.frc.team2035.robot.vision.VisTracker;
import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc.team2035.robot.subsystems.Arm;
import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project
 */
public class Robot extends TimedRobot {
	 
	private VisionThread visionThread;
	private double centerX = 0.0;
	private double tarPixelWidth = 0.0;
	private double distance = 0.0;
	
	private final Object imgLock = new Object();
	
	private static final int IMG_WIDTH = 640;
	private static final int IMG_HEIGHT = 480;
	private static final double FOV_ANGLE = .918803; //radian
	private static final double TARGET_WIDTH = 9.5; //inches
	
	private static Arm arm;
	
	
	private String gameData;
	private CvSource outputStream;
	private VisTracker tracker; 
	
	//private char switchLocation;
	
	public static OI oi;

	Command m_autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();
		
		arm = new Arm();
		// chooser.addObject("My Auto", new MyAutoCommand()); 
		SmartDashboard.putData("Auto mode", chooser);
		
		OI.initialize();
	    outputStream = CameraServer.getInstance().putVideo("Processed", 32, 24);
		UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
	    camera.setResolution(IMG_WIDTH, IMG_HEIGHT);
	    tracker = new VisTracker();
	    
    	System.out.println("Vision initializing...");

	    visionThread = new VisionThread(camera, tracker, pipeline -> {

	        	if (!pipeline.filterContoursOutput().isEmpty()) {
	        		
	            	Rect r = Imgproc.boundingRect(pipeline.filterContoursOutput().get(0));
	            	synchronized (imgLock) { 

	                    centerX = r.x + (r.width / 2);
	                    tarPixelWidth = r.width;
	        	        //distance = (DISTANCE_CONSTANT / (2 *tarPixelWidth * Math.atan()));
	        	        //double angle = Math.atan((8*320)/(tarPixelWidth * 33.5));
	        	        
	        	        distance = (TARGET_WIDTH * IMG_WIDTH) / (2 * Math.tan(FOV_ANGLE) * tarPixelWidth);
	        	        System.out.println("Pixel Width =" + tarPixelWidth); 
		                
	    	        	outputStream.putFrame(pipeline.hsvThresholdOutput());

	            	}
	            	
		        	//outputStream.putFrame(r);

	        	}
	        
	    }); 
	    visionThread.start();
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
	@Override
	public void autonomousInit() {
		m_autonomousCommand = chooser.getSelected();
		
		
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		
		System.out.println("Starting camera server...");
		//Processing.startProcessing();
		
		
		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		
		if(gameData.charAt(0) == 'L') 
		{
			//Put left auto code here
		} else {
			//Put right auto code here
		}
		
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		double centerX;
		double distance;
		double tarPixelWidth;
		
	    synchronized (imgLock) {
	        centerX = this.centerX;
	        tarPixelWidth = this.tarPixelWidth;
	        distance = this.distance;
	    }
	    double turn = centerX - (IMG_WIDTH / 2);
	    //drive.arcadeDrive(-0.6, turn * 0.005);
	    System.out.println("Center X Value = " + centerX);
	    System.out.println("Distance = " + distance + " in");
        System.out.println("Width = " + tarPixelWidth + " px");
		//Processing camProcess = new Processing();
		//System.out.println("yes");
		

	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
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
}
