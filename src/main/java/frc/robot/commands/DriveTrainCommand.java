// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrainSubsystem;

public class DriveTrainCommand extends CommandBase{
  DriveTrainSubsystem m_drivetrainsubsystem;
  DoubleSupplier m_foward;
  DoubleSupplier m_backwards;
  DoubleSupplier m_turn;
  DoubleSupplier m_stop;

  /** Creates a new DriveTrainCommand. */
  public DriveTrainCommand(DriveTrainSubsystem subsystem, DoubleSupplier forward, DoubleSupplier backwards, DoubleSupplier turn, DoubleSupplier stop) {
    m_drivetrainsubsystem = subsystem;
    m_foward = forward;
    m_backwards = backwards;
    m_turn = turn;
    m_stop = stop;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double m_speed = m_foward.getAsDouble() - m_backwards.getAsDouble();
    m_drivetrainsubsystem.RocketLeagueDrive(m_speed,m_turn.getAsDouble(),m_stop.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

