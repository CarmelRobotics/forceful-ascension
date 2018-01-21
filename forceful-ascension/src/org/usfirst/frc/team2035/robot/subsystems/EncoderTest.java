package org.usfirst.frc.team2035.robot.subsystems;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

public class EncoderTest extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	private CANTalon angler;
	
	public EncoderTest() {
		super("EncoderTest");
		
		angler = new CANTalon(3);
		
		
	}
	
	
	public void test() {
		System.out.println(angler.getEncPosition());
		
	}
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
