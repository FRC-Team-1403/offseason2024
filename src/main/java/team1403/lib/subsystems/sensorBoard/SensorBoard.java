package team1403.lib.subsystems.sensorBoard;

import com.revrobotics.SparkMaxRelativeEncoder.Type;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team1403.lib.core.CougarLibInjectedParameters;
import team1403.lib.core.CougarSubsystem;
import team1403.lib.device.AdvancedMotorController;
import team1403.lib.device.wpi.CougarSparkMax;
import team1403.lib.device.wpi.WpiLimitSwitch;

public class SensorBoard extends CougarSubsystem {
    private final WpiLimitSwitch limitSwitch;
    //private final Encoder encoder;
    private final AdvancedMotorController motor;

    /**
     * setting up the sensors and the motors.
     * and connecting them to the sensor board. 
     *
     * @param name name.
     * @param injectedParameters cougarLibInjectedParameters.
     */
    public SensorBoard(String name, CougarLibInjectedParameters injectedParameters) {
        super(name, injectedParameters);
        limitSwitch = new WpiLimitSwitch("limitSwitch", 0);
        //encoder = new Encoder(0, 1);
        motor = injectedParameters.getDeviceFactory().makeBrushedCanSparkMax(
            "Motor", 9, Type.kNoSensor, getLogger());
    }
    /**
     * adjusting the parameters of the sensors and motors.
     * 
     */
    public void command() {
        boolean limitSwitchValue = limitSwitch.get();
        if (limitSwitchValue == false) {
            motor.setSpeed(0.1);
        } else {
            motor.setSpeed(0);
        }
    }

    /**
     * putting sensor data into the shuffleboard.
     * 
     */
    public void periodic() {
        SmartDashboard.putBoolean("limitSwitch", limitSwitch.get());
        //SmartDashboard.putData(encoder);
        //motor.setSpeed(0.1);
        command();
    }

}
