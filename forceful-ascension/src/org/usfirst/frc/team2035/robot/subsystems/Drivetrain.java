package org.usfirst.frc.team2035.robot.subsystems;
import org.usfirst.frc.team2035.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
/**
 *
 */
public class Drivetrain extends Subsystem {
	private WPI_TalonSRX leftTop;
	private SpeedController leftBack;
	private WPI_TalonSRX rightTop;
	private SpeedController rightBack;
	private SpeedControllerGroup leftGroup;
	private SpeedControllerGroup rightGroup;
	private DifferentialDrive train;
	private DoubleSolenoid gearShift;
	private int startingPos;
	
	public Drivetrain() {
    	super("Drivetrain");
    	leftTop = new WPI_TalonSRX(RobotMap.LT_DRIVETRAIN_MOTOR);//RobotMap.LT_DRIVETRAIN_MOTOR);
    	leftBack = new VictorSP(RobotMap.LB_DRIVETRAIN_MOTOR_PWM);
    	rightTop = new WPI_TalonSRX(RobotMap.RT_DRIVETRAIN_MOTOR);
    	rightBack = new VictorSP(RobotMap.RB_DRIVETRAIN_MOTOR_PWM);
    	leftGroup = new SpeedControllerGroup(leftTop, leftBack);
    	rightGroup = new SpeedControllerGroup(rightTop, rightBack);
    	train = new DifferentialDrive(leftGroup, rightGroup);
    	gearShift = new DoubleSolenoid(RobotMap.SOLE_GEARSHIFT_HIGH, RobotMap.SOLE_GEARSHIFT_LOW);
    	startingPos = RobotMap.ARM_STARTING_POSITION;
    	leftTop.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
		leftTop.setSelectedSensorPosition(0, 0, 0);
		rightTop.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
		rightTop.setSelectedSensorPosition(0, 0, 0);
	}
	 
	//takes joystick position as speed and direction, drives using those values
	public void drive(double speed, double rotation) {
		train.arcadeDrive(speed, rotation);
	}
	
	public void driveAuto(double speed) {
		double encoderDifference = currentDegreesRight() - currentDegreesLeft();
		double counteractValue = 0;
		
		if (encoderDifference > 0) {
			if (encoderDifference <= 20)
				counteractValue = -0.05;
			else if (encoderDifference <= 40)
				counteractValue = -0.10;
			else if (encoderDifference <= 60)
				counteractValue = -0.15;
			else if (encoderDifference <= 80)
				counteractValue = -0.20;
			else if (encoderDifference <= 100)
				counteractValue = -0.25;
			else
				counteractValue = -0.30;
		}
		else if (encoderDifference < 0)	{
			if (encoderDifference >= 20)
				counteractValue = 0.05;
			else if (encoderDifference >= -40)
				counteractValue = 0.10;
			else if (encoderDifference >= -60)
				counteractValue = 0.15;
			else if (encoderDifference >= -80)
				counteractValue = 0.20;
			else if (encoderDifference >= -100)
				counteractValue = 0.25;
			else
				counteractValue = -0.30;
		}
		else
			counteractValue = 0.0;
		
		train.arcadeDrive(speed, counteractValue);
	}
	
	//takes set doubles as speed and direction, drives using those values; boolean is whether to turn in place
	public void driveCurve(double speed, double rotation, boolean turnInPlace) {
		train.curvatureDrive(speed, rotation, turnInPlace);
	}
	
	public void gearshiftHigh() {
		gearShift.set(DoubleSolenoid.Value.kForward);
		//System.out.println("hi from GSH");
		
	}
	
	public void gearshiftLow() {
		gearShift.set(DoubleSolenoid.Value.kReverse);
		//System.out.println("hi from GSL");
	}
	
	public double currentDegreesLeft() {
    	//return (leftTop.getSelectedSensorPosition(0));
    	return (.1155*leftTop.getSelectedSensorPosition(0)/(4096/360));//.1305
    }
    
    public double currentDegreesRight() {
    	//return (rightTop.getSelectedSensorPosition(0));
    	return (-.1305*rightTop.getSelectedSensorPosition(0)/(4096/360));
    }
	public void resetLeft() {
		leftTop.setSelectedSensorPosition(0, 0, 0);
	}
	public void resetRight() {
		rightTop.setSelectedSensorPosition(0, 0, 0);
	}
    
	public void stop() {
		train.arcadeDrive(0,0);
		
	}
	
	
	/*
	public void testMotor(double heyEveryoneThisIsAVariableWow) {
		leftFront.set(heyEveryoneThisIsAVariableWow);
	}
	
	*/
	public void initDefaultCommand() {
    	
	}
}