package org.usfirst.frc.team2035.robot.subsystems;
import org.usfirst.frc.team2035.robot.RobotMap;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
/**
 *
 */
public class Drivetrain extends Subsystem {
	private Victor leftFront;
	private Victor leftBack;
	private Victor rightFront;
	private Victor rightBack;
	private SpeedControllerGroup leftGroup;
	private SpeedControllerGroup rightGroup;
	private DifferentialDrive train;
	private Solenoid gearshift;
	
	public Drivetrain() {
    	super("Drivetrain");
    	leftFront = new Victor(RobotMap.LF_DRIVETRAIN_MOTOR_PWM);
    	leftBack = new Victor(RobotMap.LB_DRIVETRAIN_MOTOR_PWM);
    	rightFront = new Victor(RobotMap.RF_DRIVETRAIN_MOTOR_PWM);
    	rightBack = new Victor(RobotMap.RB_DRIVETRAIN_MOTOR_PWM);
    	leftGroup = new SpeedControllerGroup(leftFront, leftBack);
    	rightGroup = new SpeedControllerGroup(rightFront, rightBack);
    	train = new DifferentialDrive(leftGroup, rightGroup);
    	gearshift = new Solenoid(RobotMap.GEARSHIFT);
    }
	
	//takes joystick position as speed and direction, drives using those values
	public void joystickDrive() {
		train.arcadeDrive(xSpeed, zRotation);
	}
	
	//takes set doubles as speed and direction, drives using those values; boolean is whether to turn in place
	public void numericDrive(double speed, double rotation, boolean turnInPlace) {
		train.curvatureDrive(speed, rotation, turnInPlace);
	}
    public void initDefaultCommand() {
    	
    }
}
