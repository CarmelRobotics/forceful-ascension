/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST Team 2035. All Rights Reserved.                   */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2035.robot.subsystems;

import edu.wpi.first.wpilibj.SensorBase;
import edu.wpi.first.wpilibj.smartdashboard.SendableBuilder;
import edu.wpi.first.wpilibj.AnalogInput;


public class UltrasonicSensor extends SensorBase {

    AnalogInput chl;
    
    public UltrasonicSensor(int analogChannel) {
        chl = new AnalogInput(analogChannel);
        
    }
    
    public double getRangeCM() {
    	double range;
    	range = chl.getVoltage();
    	if (range < 0.0)
    		return -1.0;
    	double mv = chl.getVoltage()*1000;
    	double cm = (5*mv)/(48.8);
    	return cm;
    	
    }
    
    public double getRangeIN() {
    	double range;
    	range = chl.getVoltage();
    	if (range < 0.0)
    		return -1.0;
    	double mv = chl.getVoltage()*1000;
    	double in = (5*mv)/(48.8*2.54);
    	return in;
    	
    }

	@Override
	public void initSendable(SendableBuilder builder) {
		// TODO Auto-generated method stub
		
	}
}