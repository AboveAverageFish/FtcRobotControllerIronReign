package org.firstinspires.ftc.teamcode.robots.Catapultabot.Subsystems;

import com.acmerobotics.dashboard.canvas.Canvas;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import java.util.Collections;
import java.util.Map;

public class Intake implements Subsystem{
    private final DcMotorEx spinner;
    private double IntakePower;
    public enum intakeS
    {
        Idle,
        Out,
        In
    }
    public intakeS intakeState = intakeS.Idle;

    public Intake(HardwareMap controller)
    {
        spinner = controller.get(DcMotorEx.class, "intake");
    }

    @Override
    public void readSensors() {
    }

    @Override
    public void calc(Canvas fieldOverlay) {
        switch (intakeState){
            case In:
                IntakePower = 1;
                break;
            case Out:
                IntakePower = -1;
                break;
            case Idle:
                IntakePower = 0;
                break;
        }
    }

    @Override
    public void act() {
        spinner.setPower(IntakePower);
    }

    @Override
    public void stop() {
        IntakePower = 0;
    }

    @Override
    public void resetStates() {
        spinner.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    @Override
    public Map<String, Object> getTelemetry(boolean debug) {
        return Collections.emptyMap();
    }

    @Override
    public String getTelemetryName() {
        return "Intake";
    }
}
