package team1403.robot.__replaceme__.sensorBoard;

import com.revrobotics.SparkMaxRelativeEncoder.Type;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team1403.lib.core.CougarLibInjectedParameters;
import team1403.lib.core.CougarSubsystem;
import team1403.lib.device.AdvancedMotorController;
import team1403.lib.device.wpi.CougarSparkMax;
import team1403.lib.device.wpi.WpiLimitSwitch;

public class SensorBoard extends CougarSubsystem{
    private final WpiLimitSwitch limitSwitch;
    private final Encoder encoder;
    private final AdvancedMotorController motor;
    
    public SensorBoard(String name, CougarLibInjectedParameters injectedParameters) {
        super(name, injectedParameters);
        limitSwitch = new WpiLimitSwitch(name, 0);
        encoder = new Encoder(0, 1);
        motor = injectedParameters.getDeviceFactory().makeBrushedCanSparkMax("Motor", 9, Type.kNoSensor, getLogger());
      }
    public void periodic() {
        SmartDashboard.putBoolean("limitSwitch", limitSwitch.get());
        SmartDashboard.putData(encoder);
        motor.setSpeed(0.1);
    }

}
