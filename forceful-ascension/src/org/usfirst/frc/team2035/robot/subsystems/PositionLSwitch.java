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
	
//	private boolean getPosA() {
//		return posA.get();
//	}
	
//	private boolean getPosC() {
	//	return posC.get();
//	}
	
	public int getRobotStart() {
		if (!posA.get() && !posC.get()) //switch is wired high
			return -1; //this shouldn't happen
		else if(!posA.get())
			return 0; //start at position A
		else if(!posC.get())
			return 2; //start at position C
		else
			return 1; //start at position B
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

