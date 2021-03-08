// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.DriveTrainCommand;
import frc.robot.subsystems.DriveTrainSubsystem;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();
  DriveTrainSubsystem m_drivetrainsubsystem = new DriveTrainSubsystem();
    
  //Creating buttons for controller(s)

  GenericHID driverController = new XboxController(Constants.DRIVE_CONTROLLER);
  
  Button A_Button = new JoystickButton(driverController, 1);  
  Button B_Button = new JoystickButton(driverController, 2);
  Button X_Button = new JoystickButton(driverController, 3);
  Button Y_Button = new JoystickButton(driverController, 4);
  Button LB_Button = new JoystickButton(driverController, 5);
  Button RB_Button = new JoystickButton(driverController, 6);
  Button Select_Button = new JoystickButton(driverController, 7);
  Button Start_Button = new JoystickButton(driverController, 8);
  Button Left_Stick_Button = new JoystickButton(driverController, 9);
  Button Right_Stick_Button = new JoystickButton(driverController, 10);


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
  configureButtonBindings();
  
    m_drivetrainsubsystem.setDefaultCommand(new DriveTrainCommand(m_drivetrainsubsystem,
    () -> driverController.getRawAxis(Constants.DRIVE_RIGHT_TRIGGER),
    () -> driverController.getRawAxis(Constants.DRIVE_LEFT_TRIGGER),
    () -> driverController.getRawAxis(Constants.DRIVE_RIGHT_X_AXIS),
    () -> driverController.getRawAxis(Constants.DRIVE_LEFT_Y_AXIS)));
            
    configureButtonBindings();


}

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand(){
    return m_chooser.getSelected();
  }
}
