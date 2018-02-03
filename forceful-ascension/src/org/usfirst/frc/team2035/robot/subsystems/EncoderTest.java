package org.usfirst.frc.team2035.robot.subsystems;



import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import org.usfirst.frc.team2035.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.BaseMotorController;

import edu.wpi.first.wpilibj.command.Subsystem; 

public class EncoderTest extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	private WPI_TalonSRX angler;
	
	public EncoderTest() {
		
		super("EncoderTest");
		
		angler = new WPI_TalonSRX(4);
		angler.setSelectedSensorPosition(0, 0, 0);
		
	}
	
	
	public void test() {
		//System.out.println("hi");
		angler.set(ControlMode.PercentOutput, 0.2);
		System.out.println(angler.getSelectedSensorPosition(0));
		
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
