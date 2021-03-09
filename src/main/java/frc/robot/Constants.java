// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.kinematics.DifferentialDriveKinematics;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. This class should not be used for any other
 * purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the constants are needed, to reduce verbosity.
 */
public final class Constants {

	public static final int LEFT_MOTOR = 1;
	public static final int RIGHT_MOTOR = 0;

	public static final int DRIVE_CONTROLLER = 0; // Driver Controller ID
    public static final int DRIVE_LEFT_X_AXIS = 0;
    public static final int DRIVE_LEFT_Y_AXIS = 1;
    public static final int DRIVE_LEFT_TRIGGER = 2;
    public static final int DRIVE_RIGHT_TRIGGER = 3;
    public static final int DRIVE_RIGHT_X_AXIS = 4;
    public static final int DRIVE_RIGHT_Y_AXIS = 5;
    
    public static final double ENCODER_METERS = .04454;
    public static final double ENCODER_METERS_PER_SECOND = .000742;


//feedforward/feedbackgains
    public static final double ksVolts = 0;
    public static final double kvVoltSecondsPerMeter = 0;
    public static final double kaVoltsSecondsSquaredPerMeter = 0;

    public static final double kPDriveVel =0; 
//Differentialdrivekinematics
    public static final double kTrackWidthMeters = .66;
    public static final DifferentialDriveKinematics kDriveKinematics =
        new DifferentialDriveKinematics(kTrackWidthMeters);
//maxtrajectoryvelocity/acceleration
    public static final double kMaxMeterPerSecond = 2;
    public static final double kMaxAccelerationMetersPerSecondSquared = 2;
//ramseteparameters
    public static final double kRamseteB = 0;
    public static final double kRamseteZeta = 0;


        
    }
