package org.usfirst.frc.team2035.robot.subsystems;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem; 

public class EncoderTest extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	private CANTalon angler;
	private SpeedController encoderMotor;
	public EncoderTest() {
		super("EncoderTest");
		
		angler = new CANTalon(0);
		encoderMotor = new Talon(0);
		
	}
	
	
	public void test() {
		encoderMotor.set(.5);
		System.out.println(angler.getEncPosition());
		
	}
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
