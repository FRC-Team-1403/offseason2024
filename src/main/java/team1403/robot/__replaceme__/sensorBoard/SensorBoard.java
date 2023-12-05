package team1403.robot.__replaceme__.sensorBoard;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team1403.lib.core.CougarLibInjectedParameters;
import team1403.lib.core.CougarSubsystem;
import team1403.lib.device.wpi.WpiLimitSwitch;

public class SensorBoard extends CougarSubsystem{
    private final WpiLimitSwitch limitSwitch;
    private final Encoder encoder;
    
    public SensorBoard(String name, CougarLibInjectedParameters injectedParameters) {
        super(name, injectedParameters);
        limitSwitch = new WpiLimitSwitch(name, 0);
        encoder = new Encoder(0, 1);
      }
    public void periodic() {
        SmartDashboard.putBoolean("ma3", limitSwitch.get());
        SmartDashboard.putData(encoder);
    }
    
}
