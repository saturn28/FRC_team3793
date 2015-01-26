// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc3793.RobotJeff;
    
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.CounterBase.EncodingType; import edu.wpi.first.wpilibj.PIDSource.PIDSourceParameter;

import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import java.util.Vector;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static SpeedController drivetrainRightFront;
    public static SpeedController drivetrainRightRear;
    public static SpeedController drivetrainLeftFront;
    public static SpeedController drivetrainLeftRear;
    public static Encoder drivetrainQuadEncRight;
    public static Encoder drivetrainQuadEncLeft;
    public static Compressor clawCompressor1;
    public static Solenoid clawSolenoid1;
    public static SpeedController pulleyPulley;
    public static Ultrasonic sensorUltrasonic1;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        drivetrainRightFront = new Victor(0);
        LiveWindow.addActuator("Drivetrain", "RightFront", (Victor) drivetrainRightFront);
        
        drivetrainRightRear = new Victor(1);
        LiveWindow.addActuator("Drivetrain", "RightRear", (Victor) drivetrainRightRear);
        
        drivetrainLeftFront = new Victor(2);
        LiveWindow.addActuator("Drivetrain", "LeftFront", (Victor) drivetrainLeftFront);
        
        drivetrainLeftRear = new Victor(3);
        LiveWindow.addActuator("Drivetrain", "LeftRear", (Victor) drivetrainLeftRear);
        
        drivetrainQuadEncRight = new Encoder(0, 1, false, EncodingType.k4X);
        LiveWindow.addSensor("Drivetrain", "QuadEncRight", drivetrainQuadEncRight);
        drivetrainQuadEncRight.setDistancePerPulse(1.0);
        drivetrainQuadEncRight.setPIDSourceParameter(PIDSourceParameter.kRate);
        drivetrainQuadEncLeft = new Encoder(2, 3, false, EncodingType.k4X);
        LiveWindow.addSensor("Drivetrain", "QuadEncLeft", drivetrainQuadEncLeft);
        drivetrainQuadEncLeft.setDistancePerPulse(1.0);
        drivetrainQuadEncLeft.setPIDSourceParameter(PIDSourceParameter.kRate);
        clawCompressor1 = new Compressor(0);
        
        
        clawSolenoid1 = new Solenoid(0, 0);
        LiveWindow.addActuator("Claw", "Solenoid 1", clawSolenoid1);
        
        pulleyPulley = new Victor(4);
        LiveWindow.addActuator("Pulley", "Pulley", (Victor) pulleyPulley);
        
        sensorUltrasonic1 = new Ultrasonic(4, 5);
        LiveWindow.addSensor("Sensor", "Ultrasonic 1", sensorUltrasonic1);
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}
