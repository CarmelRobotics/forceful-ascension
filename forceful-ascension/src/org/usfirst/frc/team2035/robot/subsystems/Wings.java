package org.usfirst.frc.team2035.robot.subsystems;

import org.usfirst.frc.team2035.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *Controls the wing management system.
 */
public class Wings extends Subsystem {
	
	private Solenoid wings; //solenoid keeping wings up
	
	public Wings() {
		super("wings");
		wings = new Solenoid(RobotMap.WINGS);
	}

	//turns wing solenoids on, keeping the wings up
	public void wingsSolenoidsOn() {
		wings.set(true);
    }
    
  //turns wing solenoids off, dropping the wings
	public void wingsSolenoidsOff() {
		wings.set(false);
    }
    
	public void initDefaultCommand() {
		
	}

}
