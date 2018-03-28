package org.usfirst.frc.team2035.robot.subsystems;

import org.usfirst.frc.team2035.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class RotarySwitch extends Subsystem {

	public static DigitalInput oneSwitch;
	public static DigitalInput twoSwitch;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public RotarySwitch() {
		oneSwitch = new DigitalInput(RobotMap.ONE_SWITCH);
		twoSwitch = new DigitalInput(RobotMap.TWO_SWITCH);
	}
	
    public int getSwitchPosition() {
    	if(!oneSwitch.get()&&!twoSwitch.get()) //SWITCH IS WIRED HIGH ON TEST BOT AS OF 2/10/18 IF COMMENT IS NOT REMOVED IT STILL IS.
		{
			System.out.println("Both True, this should not happen");
			return -1;
		}
		else if(!oneSwitch.get())
		{
			System.out.println("Switch one true.");
			return 2;
		}
		else if(!twoSwitch.get()) 
		{
			System.out.println("Switch two true");
			return 0;
		}
		else 
		{
			System.out.println("Both False");
			return 1;
		}
    }
    
    public void initDefaultCommand() {
    	
	}
}

