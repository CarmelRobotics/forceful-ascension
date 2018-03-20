package org.usfirst.frc.team2035.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team2035.robot.RobotMap;


import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Timer;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


public class Arm extends Subsystem{
	
	private Victor armClimber1;
	private Victor armClimber2;
	private Victor armClimber3;
	private Victor extender;
	private WPI_TalonSRX angler;
	private int startingPos;
	private double currentPos;
	private boolean hasNotMoved;
	private SpeedControllerGroup climbers;
	private DoubleSolenoid latch;
	private boolean canExtend;
	private Timer retractTimer;
	
	public Arm() {
		
		super("Arm");
		
		armClimber1 = new Victor(RobotMap.ARM_CLIMBER_1);
		armClimber2 = new Victor(RobotMap.ARM_CLIMBER_2);
		armClimber3 = new Victor(RobotMap.ARM_CLIMBER_3);
		extender = new Victor(RobotMap.ARM_EXTENDER);
		angler = new WPI_TalonSRX(RobotMap.ANGLER_ID);
		startingPos = RobotMap.ARM_STARTING_POSITION;
		hasNotMoved = true;
		climbers = new SpeedControllerGroup(armClimber1, armClimber2, armClimber3);

		latch = new DoubleSolenoid(RobotMap.ARM_LATCH_OPEN, RobotMap.PLACEHOLDER);
		angler.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
		angler.setSelectedSensorPosition(RobotMap.ARM_STARTING_POSITION, 0, 0);
		//angler.setSelectedSensorPosition(0, 0, 0);
		canExtend = false;
		retractTimer = new Timer();

		
		
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
	public void latchOpen() {
		latch.set(DoubleSolenoid.Value.kForward); 
	} 
	
	
	
	public void climb() {
		climbers.set(RobotMap.ARM_CLIMB_SPEED);
		
		
	}
	public void reverseClimb() {
		climbers.set(-RobotMap.ARM_CLIMB_SPEED);
		
	}
	
	public void extend() {
		extender.set(RobotMap.ARM_EXTEND_SPEED);
		
	}
	
	public void retract () {
		extender.set(-RobotMap.ARM_EXTEND_SPEED);
	}
	public void climbStop() {
		climbers.set(0.0);
	}
	public void extendStop() {
		extender.set(0.0);
		
	}
	/*
	public void resetAngle() {
		
		currentPos = (angler.getSelectedSensorPosition(0)/(4096/360));
		if ((currentPos - startingPos) > 0) {
			armLowerAngle();
			
		}
		
		else if ((currentPos - startingPos) < 0) {
			armRaiseAngle();
			
		}
		else {
			armAnglerStop();
			
		}
		
	}
	
	*/
	public boolean armChangeAngle(double desiredPos) { //This method serves to change the arm's angle to any given angle
		currentPos = -(angler.getSelectedSensorPosition(0)/(4096/360));
		
		if (desiredPos == RobotMap.ARM_POSITION_3 || desiredPos == RobotMap.ARM_POSITION_4) {
			canExtend = true;
			
		}
		else if (currentPos < RobotMap.ARM_POSITION_3){
			
			canExtend = false;
		}
		/*
		else if (currentPos >= RobotMap.ARM_POSITION_3) {
			canExtend = false;
			retractTimer.start();
			if (retractTimer.get() < 2) {
				System.out.println(retractTimer.get());
				retract();
				
			}
			else {
				extendStop();
				retractTimer.stop();
				retractTimer.reset();
			}	
			}
	*/
		
		
		
		if (currentPos < desiredPos && hasNotMoved) {  //If we need to move the arm up
			armRaiseAngle(currentPos, desiredPos); //calls the method defined below //armRaise
			return false; //movement not finished
		}
		
		
		
		else if (currentPos > desiredPos && hasNotMoved) { //If we need to move the arm down
			armLowerAngle(currentPos, desiredPos); //calls the other method defined below //armLower
			return false; //movement not finished
		}
		
		
		
		else { //if We have reached the desired position
			System.out.println(currentPos);
			armAnglerStop(); //Stop changing the arm angle
			System.out.println("Ok, We are there! Sweet!");
			return true; //movement is finished
		}
		
		
	}
	
	
	public void manualRaiseAngle() {
		angler.set(ControlMode.PercentOutput, .8);
		System.out.println(-angler.getSelectedSensorPosition(0)/(4096/360));
		System.out.println("raising here");
		
		
		
	}
	
	public void manualLowerAngle() { 
		angler.set(ControlMode.PercentOutput, -0.3);
		System.out.println(-angler.getSelectedSensorPosition(0)/(4096/360));
		System.out.println("lowering here");
		
		
	}
	
	public void armRaiseAngle(double currentPos, double desiredPos) 
	{ //Code to raise the arm
		
		if(desiredPos - currentPos >= 100) //If we are far away from our destination angle old:5
		{
			angler.set(ControlMode.PercentOutput, .8); //.7
		}
		else //If we are close to destination angle (serves to prevent overshooting the angle)
		{
			angler.set(ControlMode.PercentOutput, .5); //.7
		}
		currentPos = -(angler.getSelectedSensorPosition(0)/(4096/360));
		
		//System.out.println("raising, cp: " + currentPos + " dp: " + desiredPos);
		if (currentPos >= desiredPos || currentPos >= desiredPos + 3 || currentPos >= desiredPos-3) {
			hasNotMoved = false;
		}
	}
	
	public void armLowerAngle(double currentPos, double desiredPos) 
	{ //Code to lower the arm
		
		if(desiredPos - currentPos <= -50)//If we are far away from our destination angle
		{
			angler.set(ControlMode.PercentOutput, -0.3);
		}
		else//If we are close to destination angle (serves to prevent overshooting the angle)
		{
			angler.set(ControlMode.PercentOutput, -0.2);
		}
		currentPos = -(angler.getSelectedSensorPosition(0)/(4096/360));
		
		//System.out.println("lowering, cp: " + currentPos + " dp: " + desiredPos);
		if (currentPos <= desiredPos || currentPos <= desiredPos + 3 || currentPos <= desiredPos-3) {
			hasNotMoved = false;
		}
	}
	
	
	
	
	public void armAnglerStop() {  
		
		angler.set(ControlMode.PercentOutput, 0.0);
		System.out.println("time to stop!");
		hasNotMoved = true;
	}
	
	public void armStop() {  
		
		angler.stopMotor();
		
		
	}
	
	public boolean getcanExtend() {
		return canExtend;
	}
	
	
	/*
	public boolean notMoving() {
		if (angler.get() > 0 || angler.get() < 0) {
			return false;
		}
		return true;
		
	}
	*/

}