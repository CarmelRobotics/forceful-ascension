package org.usfirst.frc.team2035.robot.subsystems;

import org.usfirst.frc.team2035.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *Controls the wing management system.
 */
public class Wings extends Subsystem {
	
	private Solenoid wingR; //right side solenoid keeping wings up
	private Solenoid wingL; //left side solenoid keeping wings up
	
	public Wings() {
		wingR = new Solenoid(RobotMap.R_WINGS);
		wingL = new Solenoid(RobotMap.L_WINGS);
	}

	//turns wing solenoids on, keeping the wings up
	public void wingsSolenoidsOn() {
		wingR.set(true);
		wingL.set(true);
    }
    
  //turns wing solenoids off, dropping the wings
	public void wingsSolenoidsOff() {
		wingR.set(false);
		wingL.set(false);
    }
    
	public void initDefaultCommand() {
		
	}

}

