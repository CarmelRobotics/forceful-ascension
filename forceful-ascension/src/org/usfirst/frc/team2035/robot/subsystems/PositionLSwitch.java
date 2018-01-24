package org.usfirst.frc.team2035.robot.subsystems;

import org.usfirst.frc.team2035.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class PositionLSwitch extends Subsystem {

	private DigitalInput posA;
	private DigitalInput posC;
	
	public PositionLSwitch () {
		posA = new DigitalInput(RobotMap.LIMITSWITCH_L);
		posC = new DigitalInput(RobotMap.LIMITSWITCH_R);
	}
	
	private boolean getPosA() {
		return posA.get();
	}
	
	private boolean getPosC() {
		return posC.get();
	}
	
	public int getRobotStart() {
		if(posA.get())
			return 0;
		if(posC.get())
			return 3;
		else
			return 1;
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

