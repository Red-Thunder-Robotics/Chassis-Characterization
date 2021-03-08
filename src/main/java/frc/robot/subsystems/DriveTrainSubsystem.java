// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
public class DriveTrainSubsystem extends SubsystemBase {
  
  /** Creates a new DriveTrainSubsystem. */
  public DriveTrainSubsystem() {}
  PWMVictorSPX left = new PWMVictorSPX(Constants.LEFT_SPINNY_BOI);
  PWMVictorSPX right = new PWMVictorSPX(Constants.Right_SPINNY_BOI);

  DifferentialDrive differentialRocketLeagueDrive = new DifferentialDrive(left, right);
  public void RocketLeagueDrive(double speed, double turn, double stop){
      double turning = 0.0;
      double moving = 0.0;
      double driveSpeed = 0.75; // Max drivespeed
      double rotateSpeed = 0.55; // How fast the bot turns while moving forward/backward
      double swivel = 0.45;  //How fast the bot pivots in place
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

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
