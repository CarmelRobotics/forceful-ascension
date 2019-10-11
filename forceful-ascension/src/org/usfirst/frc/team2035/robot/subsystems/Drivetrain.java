package org.usfirst.frc.team2035.robot.subsystems;
import org.usfirst.frc.team2035.robot.RobotMap;
import org.usfirst.frc.team2035.robot.commands.auto.AutoValues;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Timer;
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
	public static boolean inGearshiftHigh;
	public static Timer gearshiftCooldown;
	public static boolean driveInverse;
	
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
		gearshiftCooldown = new Timer();
		gearshiftCooldown.start();
		driveInverse = false;
	}
	 
	//takes joystick position as speed and direction, drives using those values
	public void drive(double speed, double rotation) {
		if (driveInverse)
			train.arcadeDrive(-speed, -rotation);
		else
			train.arcadeDrive(speed, rotation);
	}
	
	//takes set doubles as speed and direction, drives using those values; boolean is whether to turn in place
	public void driveCurve(double speed, double rotation, boolean turnInPlace) {
		train.curvatureDrive(speed, rotation, turnInPlace);
	}
	
	public void drive() {
		driveCurve(RobotMap.JOY_DRIVE.getY(), -RobotMap.JOY_DRIVE.getX(), true);
	}
		
	public void gearshiftHighT() {
		if (gearshiftCooldown.get() > 0.5)	{
			gearShift.set(DoubleSolenoid.Value.kForward);
			inGearshiftHigh = true;
			gearshiftCooldown.reset();
			gearshiftCooldown = new Timer();
			gearshiftCooldown.start();
			System.out.println("hi from GSH");
		}
	} 
	
	public void gearshiftLowT() {
		if (gearshiftCooldown.get() > 0.5)	{
			gearShift.set(DoubleSolenoid.Value.kReverse);
			inGearshiftHigh = false;
			gearshiftCooldown.reset();
			gearshiftCooldown = new Timer();
			gearshiftCooldown.start();
			System.out.println("hi from GSL");
		}
	}
	
	public void gearshiftHigh() {
			gearShift.set(DoubleSolenoid.Value.kReverse);
			inGearshiftHigh = true;
			System.out.println("hi from GSH");
	} 
	
	public void gearshiftLow() {
			gearShift.set(DoubleSolenoid.Value.kForward);
			inGearshiftHigh = false;
			System.out.println("hi from GSL");
	}
	
	public double currentDegreesLeft() {
    	//return (leftTop.getSelectedSensorPosition(0));
    	return (-AutoValues.ENCODER_ADJUSTMENT*leftTop.getSelectedSensorPosition(0)/(4096/360));//.1305
    }
    
    public double currentDegreesRight() {
    	//return (rightTop.getSelectedSensorPosition(0));
    	return (AutoValues.ENCODER_ADJUSTMENT*rightTop.getSelectedSensorPosition(0)/(4096/360));
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