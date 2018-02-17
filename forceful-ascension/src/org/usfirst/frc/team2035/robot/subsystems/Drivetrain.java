package org.usfirst.frc.team2035.robot.subsystems;
import org.usfirst.frc.team2035.robot.RobotMap;

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
	private SpeedController leftTop;
	private SpeedController leftBack;
	private SpeedController rightTop;
	private SpeedController rightBack;
	private SpeedControllerGroup leftGroup;
	private SpeedControllerGroup rightGroup;
	private DifferentialDrive train;
	private DoubleSolenoid gearshift;
	
	
	public Drivetrain() {
    	super("Drivetrain");
    	leftTop = new WPI_TalonSRX(RobotMap.LT_DRIVETRAIN_MOTOR);
    	leftBack = new VictorSP(RobotMap.LB_DRIVETRAIN_MOTOR_PWM);
    	rightTop = new WPI_TalonSRX(RobotMap.RT_DRIVETRAIN_MOTOR);
    	rightBack = new VictorSP(RobotMap.RB_DRIVETRAIN_MOTOR_PWM);
    	leftGroup = new SpeedControllerGroup(leftTop, leftBack);
    	rightGroup = new SpeedControllerGroup(rightTop, rightBack);
    	train = new DifferentialDrive(leftGroup, rightGroup);
    	gearshift = new DoubleSolenoid(RobotMap.SOLE_GEARSHIFT_HIGH, RobotMap.SOLE_GEARSHIFT_LOW);
    	
	}
	
	//takes joystick position as speed and direction, drives using those values
	public void drive(double speed, double rotation) {
		train.arcadeDrive(speed, rotation);
	}
	
	//takes set doubles as speed and direction, drives using those values; boolean is whether to turn in place
	public void driveCurve(double speed, double rotation, boolean turnInPlace) {
		train.curvatureDrive(speed, rotation, turnInPlace);
	}
	
	public void gearshiftHigh() {
		gearshift.set(DoubleSolenoid.Value.kForward);
	}
	
	public void gearshiftLow() {
		gearshift.set(DoubleSolenoid.Value.kReverse);
	}
	
	
	
	public void initDefaultCommand() {
    	
	}
}
