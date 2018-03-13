package org.usfirst.frc.team2035.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team2035.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.RemoteLimitSwitchSource;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


public class Arm extends Subsystem{
	//private Victor leftArmAngler;
	//private Victor rightArmAngler;
	private Victor armExtender1;
	private Victor armExtender2;
	private Victor armExtender3;
	private Solenoid armSolenoid;
	private WPI_TalonSRX angler;
	private int startingPos;
	private double currentPos;
	private boolean hasNotMoved;
	
	
	
	public Arm() {
		
		super("Arm");
		
		armExtender1 = new Victor(RobotMap.ARM_EXTEND_1);
		armExtender2 = new Victor(RobotMap.ARM_EXTEND_2);
		armExtender3 = new Victor(RobotMap.ARM_EXTEND_3);
		armSolenoid = new Solenoid(RobotMap.ARM_SOLENOID);
		angler = new WPI_TalonSRX(RobotMap.ANGLER_ID);
		startingPos = RobotMap.ARM_STARTING_POSITION;
		hasNotMoved = true;
		
		currentPos = startingPos;
		angler.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
		//angler.setSelectedSensorPosition(startingPos, 0, 0);
		angler.setSelectedSensorPosition(0, 0, 0);
		//System.out.println(angler.getSelectedSensorPosition(0)/(4096/360));
		
		
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
	public void climb() {
		armExtender1.set(RobotMap.ARM_CLIMB_SPEED);
		armExtender2.set(RobotMap.ARM_CLIMB_SPEED);
		armExtender3.set(RobotMap.ARM_CLIMB_SPEED);
		
		
		
		
	}
	
	public void reverse() {
		armExtender1.set(-RobotMap.ARM_CLIMB_SPEED);
		armExtender2.set(-RobotMap.ARM_CLIMB_SPEED);
		armExtender3.set(-RobotMap.ARM_CLIMB_SPEED);
	}
	
	public void extendStop() {
		armExtender1.set(0.0);
		armExtender2.set(0.0);
		armExtender3.set(0.0);
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
		//System.out.println(angler.getSelectedSensorPosition(0)/(4096/360));
		angler.set(ControlMode.PercentOutput, 0.7);
		System.out.println(-angler.getSelectedSensorPosition(0)/(4096/360));
		System.out.println("raising here");
		
		
		
	}
	
	public void manualLowerAngle() { 
		//System.out.println(angler.getSelectedSensorPosition(0)/(4096/360));
		angler.set(ControlMode.PercentOutput, -0.3);
		System.out.println(-angler.getSelectedSensorPosition(0)/(4096/360));
		//System.out.println("lowering here");
		
		
	}
	
	public void armRaiseAngle(double currentPos, double desiredPos) 
	{ //Code to raise the arm
		
		if(desiredPos - currentPos >= 50) //If we are far away from our destination angle old:5
		{
			angler.set(ControlMode.PercentOutput, 0.7); //.2
		}
		else //If we are close to destination angle (serves to prevent overshooting the angle)
		{
			angler.set(ControlMode.PercentOutput, 0.7); //.15
		}
		currentPos = -(angler.getSelectedSensorPosition(0)/(4096/360));
		
		System.out.println("raising, cp: " + currentPos + " dp: " + desiredPos);
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
		
		System.out.println("lowering, cp: " + currentPos + " dp: " + desiredPos);
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
	
	
	
	public void openHangerClaws() {
		armSolenoid.set(true);
		
	}
	
	public void closeHangerClaws() {
		armSolenoid.set(false);
		
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