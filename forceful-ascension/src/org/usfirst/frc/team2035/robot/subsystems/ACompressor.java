package org.usfirst.frc.team2035.robot.subsystems;

import org.usfirst.frc.team2035.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Compressor;

/**
 * Subsystem for the onboard compressor
 * @author Team 2035
 */
public class ACompressor extends Subsystem{
	
	private static Compressor compress;

	/**
	 * Creates a new Compressor Subsystem<br>
	 * Initializes wpilib Compressor<br>
	 */
	public ACompressor() {
		super("Compressor");
		compress = new Compressor(RobotMap.COMPRESSOR_PCM_ID);
		// TODO auto-generated method stub
	}
	
	/**
	 * Starts the compressor
	 */
	public void start() {
		compress.start();
	}
	
	/**
	 * Checks the pressure switch value and turns off the compressor when it reaches that value
	 */
	public void checkPressure()
	{
		if(!compress.getPressureSwitchValue())
        {
        	if(compress.enabled())
        	{
        		compress.stop();
        	}
        }
	}


	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}
}