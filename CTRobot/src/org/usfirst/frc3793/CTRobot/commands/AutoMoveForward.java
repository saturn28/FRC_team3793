// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc3793.CTRobot.commands;

import edu.wpi.first.wpilibj.command.*;

import org.usfirst.frc3793.CTRobot.Robot;
import org.usfirst.frc3793.CTRobot.RobotDefines;
import org.usfirst.frc3793.CTRobot.RobotMap;

/**
 *
 */
public class  AutoMoveForward extends Command {
    private double m_dist;
    private double m_speed;
    public AutoMoveForward(double dist, double speed) {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.pIDDriveTrain);
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        m_dist = dist;
        m_speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=INITIALIZE
        Robot.pIDDriveTrain.enable();
//        Robot.pIDDriveTrain.setSetpoint(1.0);
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=INITIALIZE
        Robot.pIDDriveTrain.setSetpoint(m_dist);
        RobotMap.pIDDriveTrainMotorL.pidWrite(m_speed);
        RobotMap.pIDDriveTrainMotorR.pidWrite(-m_speed);
        if (RobotDefines.simulation == true) {
        	RobotMap.pIDDriveTrainWheelLR.pidWrite(m_speed);
        	RobotMap.pIDDriveTrainWheelRR.pidWrite(-m_speed);
        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println("Left Enc " + RobotMap.pIDDriveTrainQuadratureEncoderLeft.getDistance()
    			+ " Right Enc " + RobotMap.pIDDriveTrainQuadratureEncoderRight.getDistance());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=ISFINISHED
        return Robot.pIDDriveTrain.onTarget();
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=ISFINISHED
    }

    // Called once after isFinished returns true
    protected void end() {
        RobotMap.pIDDriveTrainMotorL.pidWrite(0.0);
        RobotMap.pIDDriveTrainMotorR.pidWrite(0.0);
        if (RobotDefines.simulation == true) {
        	RobotMap.pIDDriveTrainWheelLR.pidWrite(0.0);
        	RobotMap.pIDDriveTrainWheelRR.pidWrite(0.0);        	
        }
        System.out.println("Done Autonomous");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}