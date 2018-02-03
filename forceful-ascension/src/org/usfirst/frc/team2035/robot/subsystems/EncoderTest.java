package org.usfirst.frc.team2035.robot.subsystems;



import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import org.usfirst.frc.team2035.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.BaseMotorController;

import edu.wpi.first.wpilibj.command.Subsystem; 

public class EncoderTest extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	private WPI_TalonSRX angler;
	
	public EncoderTest() {
		
		super("EncoderTest");
		
		angler = new WPI_TalonSRX(4);
		angler.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
		angler.setSelectedSensorPosition(0, 0, 0);
		
		
	} 
	
	
	public void test() {
		//System.out.println("hi");
		//if (angler.getSelectedSensorPosition(0) < 10000) {
			angler.set(ControlMode.PercentOutput, 0.2);
		//}
		//else {
		//	angler.set(ControlMode.PercentOutput, 0.0);
		//}
		
		//angler.set(ControlMode.Position, 5000);
		//System.out.println("Old equation" + angler.getSelectedSensorPosition(0)/4096);
		System.out.println("New equation" + (angler.getSelectedSensorPosition(0)/(4096/360)));
		
	}
	
	public void backTest() {
		//System.out.println("hi");
		//if (angler.getSelectedSensorPosition(0) < 10000) {
			angler.set(ControlMode.PercentOutput, -0.2);
		//}
		//else {
		//	angler.set(ControlMode.PercentOutput, 0.0);
		//}
		
		//angler.set(ControlMode.Position, 5000);
		//System.out.println("Old equation" + angler.getSelectedSensorPosition(0)/4096);
		System.out.println("New equation" + (angler.getSelectedSensorPosition(0)/(4096/360)));
		
	}
	public void endTest() {
		
		angler.set(ControlMode.PercentOutput, 0.0);
		System.out.println("at endTest");
	}
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
