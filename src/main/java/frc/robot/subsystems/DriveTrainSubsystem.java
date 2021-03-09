// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
public class DriveTrainSubsystem extends SubsystemBase {
  
  /** Creates a new DriveTrainSubsystem. */
  public DriveTrainSubsystem() {
    m_leftencoder.setPositionConversionFactor(Constants.ENCODER_METERS);
    m_rightencoder.setPositionConversionFactor(Constants.ENCODER_METERS);
    m_leftencoder.setVelocityConversionFactor(Constants.ENCODER_METERS_PER_SECOND);
    m_rightencoder.setVelocityConversionFactor(Constants.ENCODER_METERS_PER_SECOND);
  }
  CANSparkMax m_leftmotor = new CANSparkMax(Constants.LEFT_MOTOR, MotorType.kBrushless);
  CANSparkMax m_rightmotor= new CANSparkMax(Constants.RIGHT_MOTOR, MotorType.kBrushless);

  CANEncoder m_leftencoder = m_leftmotor.getEncoder();
  CANEncoder m_rightencoder = m_rightmotor.getEncoder();
  

  DifferentialDrive differentialRocketLeagueDrive = new DifferentialDrive(m_leftmotor, m_rightmotor);
  public void RocketLeagueDrive(double speed, double turn, double stop){
      double turning = 0.0;
      double moving = 0.0;
      double driveSpeed = 0.75; // Max drivespeed
      double rotateSpeed = 0.55; // How fast the bot turns while moving forward/backward
      double swivel = 0.45;  //How fast the bot pivots in place

      setBrake();
      if(Math.abs(stop) > 0.5){
      } else if(speed >= 0.10 || speed <= -0.10){
  
          moving = driveSpeed * speed;
          if(Math.abs(turn) > 0.10){
            turning = rotateSpeed * turn;
          }
        } else if(Math.abs(turn) > 0.10){
  
            turning = swivel * Math.pow(turn, 3);
        }
  
      differentialRocketLeagueDrive.arcadeDrive(moving, turning);
  
    }

    public void setBrake(){
      m_leftmotor.setIdleMode(IdleMode.kBrake);
      m_rightmotor.setIdleMode(IdleMode.kBrake);
      SmartDashboard.putString("B/C Mode", "Brake");

    }

    public void setCoast(){
      m_leftmotor.setIdleMode(IdleMode.kCoast);
      m_rightmotor.setIdleMode(IdleMode.kCoast);
      SmartDashboard.putString("B/C Mode", "Coast");
    }
    public DifferentialDriveWheelSpeeds getwheelspeeds() {
      return new DifferentialDriveWheelSpeeds(m_leftencoder.getVelocity(), m_rightencoder.getVelocity());
    }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    

  }
}
