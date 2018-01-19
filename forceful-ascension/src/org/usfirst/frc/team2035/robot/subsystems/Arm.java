package org.usfirst.frc.team2035.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team2035.robot.RobotMap;
import edu.wpi.first.wpilibj.Solenoid;
import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;


public class Arm extends Subsystem{
	private Victor v1;
	private Victor v2;
	private Victor v3;
	private Victor v4;
	private Victor v5;
	private Solenoid s1;
	
	
	public Arm() {
		
		super("Arm");
		v1 = new Victor(RobotMap.LEFT_ARM_ANGLE);
		v2 = new Victor(RobotMap.RIGHT_ARM_ANGLE);
		v3 = new Victor(RobotMap.ARM_EXTEND_1);
		v4 = new Victor(RobotMap.ARM_EXTEND_2);
		v5 = new Victor(RobotMap.ARM_EXTEND_3);
		s1 = new Solenoid(RobotMap.ARM_SOLENOID);
		
		
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
	public void extend() {
		v1.set(RobotMap.ARM_EXTEND_SPEED);
		v2.set(RobotMap.ARM_EXTEND_SPEED);
		v3.set(RobotMap.ARM_EXTEND_SPEED);
		
		
		
		
	}
	
	public void armRaise() {
		v4.set(RobotMap.ARM_ANGLE_SPEED);
		v5.set(RobotMap.ARM_ANGLE_SPEED);
		
	}
	public void openHangerClaws() {
		s1.set(true);
		
	}
	
	public void closeHangerClaws() {
		s1.set(false);
		
	}
	

}
