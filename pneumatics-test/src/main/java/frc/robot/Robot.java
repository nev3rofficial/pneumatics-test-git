// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
// import edu.wpi.first.wpilibj.motorcontrol.MotorController;
// import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;


/**
 * This is a sample program showing the use of the solenoid classes during operator control. Three
 * buttons from a joystick will be used to control two solenoids: One button to control the position
 * of a single solenoid and the other two buttons to control a double solenoid. Single solenoids can
 * either be on or off, such that the air diverted through them goes through either one channel or
 * the other. Double solenoids have three states: Off, Forward, and Reverse. Forward and Reverse
 * divert the air through the two channels and correspond to the on and off of a single solenoid,
 * but a double solenoid can also be "off", where the solenoid will remain in its default power off
 * state. Additionally, double solenoids take up two channels on your PCM whereas single solenoids
 * only take a single channel.
 */
public class Robot extends TimedRobot {
  private final Joystick m_stick = new Joystick(0);

  // Solenoid corresponds to a single solenoid.
  private final Solenoid m_solenoid = new Solenoid(0);

  
  // DoubleSolenoid corresponds to a double solenoid.
  private final DoubleSolenoid m_doubleSolenoid = new DoubleSolenoid(6, 7);

  private static final int kSolenoidButton = 1;
  private static final int kDoubleSolenoidForward = 2;
  private static final int kDoubleSolenoidReverse = 3;

  //motor stuff part 2, the motoring
  private static final int kMotorPort = 0;
  private static final int kJoystickPort = 0;

  private MotorController m_motor;
  private Joystick m_joystick;

 // private static final int sorterMotor = 4;
  @Override
  public void teleopPeriodic() {
    /*
     * The output of GetRawButton is true/false depending on whether
     * the button is pressed; Set takes a boolean for whether
     * to use the default (false) channel or the other (true).
     */
    m_solenoid.set(m_stick.getRawButton(kSolenoidButton));

    /*
     * In order to set the double solenoid, if just one button
     * is pressed, set the solenoid to correspond to that button.
     * If both are pressed, set the solenoid will be set to Forwards.
     */
    if (m_stick.getRawButton(kDoubleSolenoidForward)) {
      m_doubleSolenoid.set(DoubleSolenoid.Value.kForward);
    } else if (m_stick.getRawButton(kDoubleSolenoidReverse)) {
      m_doubleSolenoid.set(DoubleSolenoid.Value.kReverse);
    }

  //  m_motor.set(m_joystick.getY());

  }

 @Override
  public void robotInit() {
    m_motor = new PWMSparkMax(kMotorPort);
    m_joystick = new Joystick(kJoystickPort);
  }

  //Motor stuff
  @Override
  public void robotInit() {
    m_motor = new PWMSparkMax(kMotorPort);
    m_joystick = new Joystick(kJoystickPort);
  }

  private static final int kMotorPort = 0;
  private static final int kJoystickPort = 0;

  private MotorController m_motor;
  private Joystick m_joystick; 
}
