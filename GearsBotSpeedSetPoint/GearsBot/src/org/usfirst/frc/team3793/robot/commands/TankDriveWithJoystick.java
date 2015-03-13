/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team3793.robot.commands;

import org.usfirst.frc.team3793.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Have the robot drive tank style using the PS3 Joystick until interrupted.
 */
public class TankDriveWithJoystick extends Command {
    public TankDriveWithJoystick() {
        requires(Robot.drivetrain);
        new DriveStraight(0.0);
    }

    // Called just before this Command runs the f iirst time
    protected void initialize() {}

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	int throttleVal;
    	int steerVal;
    	double drive;
    //    Robot.drivetrain.drive(Robot.oi.getJoystick());
    	throttleVal = Robot.oi.getThrottleSlider();
    	steerVal =  Robot.oi.getSteeringSlider();
    	drive = (throttleVal-50.0)/50.0;
    	if (steerVal == 50) {
    		new DriveStraight(drive);
    	}
   		Robot.drivetrain.drive(throttleVal,steerVal);
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false; // Runs until interrupted
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.drivetrain.drive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}