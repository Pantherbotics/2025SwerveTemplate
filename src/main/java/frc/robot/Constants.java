// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix6.configs.FeedbackConfigs;
import com.ctre.phoenix6.configs.MotionMagicConfigs;
import com.ctre.phoenix6.configs.MotorOutputConfigs;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.signals.GravityTypeValue;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.ctre.phoenix6.signals.StaticFeedforwardSignValue;

public class Constants {

    public static class ElevatorConstants {
        public static final int kMotor1ID = 1;
        public static final int kMotor2ID = 2;
        public static final int kLimitSwitch = 1;

        public static final double kMechanismRatio = (15d/36d) * (18d/48d) * (1.44*Math.PI);

        public static final Slot0Configs kMotorGains = new Slot0Configs()
            .withGravityType(GravityTypeValue.Elevator_Static)
            .withKP(1)
            .withKI(0)
            .withKD(0)
            .withKS(0)
            .withKV(0)
            .withKA(0)
            .withKG(0)
            .withStaticFeedforwardSign(StaticFeedforwardSignValue.UseVelocitySign);

        public static final MotionMagicConfigs kProfileConfigs = new MotionMagicConfigs()
            .withMotionMagicAcceleration(30)
            .withMotionMagicCruiseVelocity(80);

        public static final MotorOutputConfigs kOutputConfigs = new MotorOutputConfigs()
            .withNeutralMode(NeutralModeValue.Coast);
    }

}
