package org.usfirst.frc.team2035.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team2035.robot.RobotMap;
import edu.wpi.first.wpilibj.Solenoid;
//import edu.wpi.first.wpilibj.CANTalon;
import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;


public class Arm extends Subsystem{
	private Victor leftArmAngler;
	private Victor rightArmAngler;
	private Victor armExtender1;
	private Victor armExtender2;
	private Victor armExtender3;
	private Solenoid armSolenoid;
	private CANTalon angler;
	private double startingPos;
	
	
	public Arm() {
		
		super("Arm");
		leftArmAngler = new Victor(RobotMap.LEFT_ARM_ANGLE);
		rightArmAngler = new Victor(RobotMap.RIGHT_ARM_ANGLE);
		armExtender1 = new Victor(RobotMap.ARM_EXTEND_1);
		armExtender2 = new Victor(RobotMap.ARM_EXTEND_2);
		armExtender3 = new Victor(RobotMap.ARM_EXTEND_3);
		armSolenoid = new Solenoid(RobotMap.ARM_SOLENOID);
		angler = new CANTalon(RobotMap.ANGLER_ID);
		startingPos = RobotMap.ARM_STARTING_POSITION;
		
		
	
		
		angler.setPosition(startingPos);
		
		
		
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
	public void extend() {
		armExtender1.set(RobotMap.ARM_EXTEND_SPEED);
		armExtender2.set(RobotMap.ARM_EXTEND_SPEED);
		armExtender3.set(RobotMap.ARM_EXTEND_SPEED);
		
		
		
		
	}
	
	public void resetAngle() {
		
		double currentPos = (angler.getEncPosition()/4096);
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
	
	public void armChangeAngle(double desiredPos) {
		double currentPos = (angler.getEncPosition()/4096);
		if ((currentPos - desiredPos) > 0) {
			armLowerAngle();
			
		}
		
		else if ((currentPos - desiredPos) < 0) {
			armRaiseAngle();
			
		}
		else {
			armAnglerStop();
			
		}
		
	}
	
	
	public void armRaiseAngle() {
		leftArmAngler.set(RobotMap.ARM_ANGLE_SPEED);
		rightArmAngler.set(RobotMap.ARM_ANGLE_SPEED);
		
	}
	
	public void armLowerAngle() {
		leftArmAngler.set(-RobotMap.ARM_ANGLE_SPEED);
		rightArmAngler.set(-RobotMap.ARM_ANGLE_SPEED);
		
	}
	
	public void armAnglerStop() {
		leftArmAngler.set(0);
		rightArmAngler.set(0);
		
	}
	
	
	
	public void openHangerClaws() {
		armSolenoid.set(true);
		
	}
	
	public void closeHangerClaws() {
		armSolenoid.set(false);
		
	}
	

}
