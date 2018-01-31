package org.usfirst.frc.team2035.robot.subsystems;



import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.BaseMotorController;

import edu.wpi.first.wpilibj.command.Subsystem; 

public class EncoderTest extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	private WPI_TalonSRX angler;
	
	public EncoderTest() {
		super("EncoderTest");
		
		angler = new WPI_TalonSRX(0); 
		
		
	}
	
	
	public void test() {
		//System.out.println("hi");
		angler.set(ControlMode.PercentOutput, .5);
		System.out.println(angler.getSelectedSensorPosition(0));
		
	}
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
