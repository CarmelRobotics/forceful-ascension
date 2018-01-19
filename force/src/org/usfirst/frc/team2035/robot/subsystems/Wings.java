package org.usfirst.frc.team2035.robot.subsystems;

import org.usfirst.frc.team2035.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Wings extends Subsystem {
	
	private Solenoid wingR;
	private Solenoid wingL;
	
	public Wings() {
		wingR = new Solenoid(RobotMap.R_WINGS_MOTOR_PWM);
		wingL = new Solenoid(RobotMap.L_WINGS_MOTOR_PWM);
	}
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void wingsSolenoidsOn() {
        wingR.set(true);
        wingL.set(false);
    }
    
    public void wingsSolenoidsOff() {
    	wingR.set(false);
    	wingL.set(false);
    }
    
    public void initDefaultCommand() {
		
	}
}

