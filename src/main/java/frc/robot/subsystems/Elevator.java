// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.configs.MotorOutputConfigs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.controls.MotionMagicVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ElevatorConstants;

public class Elevator extends SubsystemBase {
  private final TalonFX leaderMotor = new TalonFX(ElevatorConstants.kMotor1ID);
  private final TalonFX followerMotor = new TalonFX(ElevatorConstants.kMotor2ID);
  private final DigitalInput limitSwitch = new DigitalInput(ElevatorConstants.kLimitSwitch);
  private final MotionMagicVoltage positionRequest = new MotionMagicVoltage(0);

  public Elevator() {
    TalonFXConfiguration motorConfigs = new TalonFXConfiguration()
      .withSlot0(ElevatorConstants.kMotorGains)
      .withMotionMagic(ElevatorConstants.kProfileConfigs)
      .withMotorOutput(ElevatorConstants.kOutputConfigs);

    leaderMotor.getConfigurator().apply(motorConfigs);

    followerMotor.setControl(new Follower(leaderMotor.getDeviceID(), true));

  }

  private void setGoalHeight(double heightInches){
    leaderMotor.setControl(positionRequest.withPosition(heightInches * ElevatorConstants.kMechanismRatio));
  }

  public Command setHeightCommand(double heightInches){
    return this.runOnce(()->setGoalHeight(heightInches));
  }
  

  @Override
  public void periodic() {
  }
}
