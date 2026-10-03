package org.firstinspires.ftc.teamcode.robots.Catapultabot;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class MeccanumDrive
{
    //4 motors for 4 wheels
    private DcMotorEx fleft, fright,  bleft, bright;
    public MeccanumDrive(HardwareMap controller)
    {
        //assign vars
        fleft = controller.get(DcMotorEx.class, "fleft");
        fright = controller.get(DcMotorEx.class, "fright");
        bleft = controller.get(DcMotorEx.class, "bleft");
        bright = controller.get(DcMotorEx.class, "bright");
    }
    //Sets motor power based on controll input+maths to drive
    public void drive(double forward, double strafe, double turn)
    {
            //math for moving
            double fl, fr, bl, br;
            fl = forward + strafe + turn;
            fr = forward - strafe - turn;
            bl = forward - strafe + turn;
            br = forward + strafe - turn;
            //math for mapping to -1 to 1 on a motor if they are greater than 1
            double max = Math.max(
                       1.0, Math.max(
                                     Math.max(fl, fr), Math.max(bl,br)
                                     )
                       );
            setMotorPower(fl/max, fr/max, bl/max, br/max);
    }
    //Sets motor power to the wheels
    public void setMotorPower(double fl, double fr, double bl, double br)
    {
        fleft.setPower(fl);
        fright.setPower(fr);
        bleft.setPower(bl);
        bright.setPower(br);
    }
}
