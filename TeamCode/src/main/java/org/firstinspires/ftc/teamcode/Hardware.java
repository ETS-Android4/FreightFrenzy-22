package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import com.qualcomm.hardware.rev.Rev2mDistanceSensor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Hardware extends LinearOpMode
{
    public DcMotor motorFrontRight;
    public DcMotor motorBackRight;
    public DcMotor motorBackLeft;
    public DcMotor motorFrontLeft;

    public DcMotor motorArm;
    public DcMotor motorWinch;
    public DcMotor motorLift;
    public DcMotor motorSpinner;
    public DcMotor motorSwivel;
    public DcMotor motorLaunch;
    public DcMotor motorIntake;
    public DcMotor motorWorm;
    //public DcMotor motorLeftLaunch;

    Servo markerDropServo;
    Servo bucketFlapServo;
    Servo servoStopper;
    Servo servoSwivel;
    Servo servoFoundation1;
    Servo servoFoundation2;
    Servo servoSuction;
    Servo servoIntake;

    CRServo servoSpin;
    CRServo servoSpin2;

    ColorSensor colorSensor;
    DistanceSensor distanceSensor;
    //Rev2mDistanceSensor distanceSensor;

    ModernRoboticsI2cGyro MRgyro;
    ModernRoboticsI2cRangeSensor MRRange;

    //private HardwareMap aMap;
    DcMotor.RunMode initialMode = null;

    int driveTime;
    boolean stopper;
    public int currentDegrees;
    public int launchValue = 0;

    private Telemetry telemetry;


    @Override
    public void runOpMode()
    {
    }

    public void init(HardwareMap aMap, Telemetry inputTelemetry)
    {
        telemetry = inputTelemetry;
        //this.aMap = inputOpMode.hardwareMap;
        //this.telemetry = inputOpMode.telemetry;
        
        motorFrontRight = aMap.dcMotor.get("motorFrontRight");
        motorBackRight = aMap.dcMotor.get("motorBackRight");
        motorBackLeft = aMap.dcMotor.get("motorBackLeft");
        motorFrontLeft = aMap.dcMotor.get("motorFrontLeft");
        /* motorArm = aMap.dcMotor.get("motorArm");
        motorWinch = aMap.dcMotor.get("motorWinch");
        motorSwivel =aMap.dcMotor.get("motorSwivel");*/

        //motorLeftLaunch = aMap.dcMotor.get("motorLeftLaunch");
        motorLaunch = aMap.dcMotor.get("motorLaunch");
            //motorIntake = aMap.dcMotor.get("motorIntake");
        //motorWorm = aMap.dcMotor.get("motorWorm");
        /*//motorLift = aMap.dcMotor.get("motorLift");
        //motorSpinner = aMap.dcMotor.get("motorSpinner");

        //markerDropServo = aMap.servo.get("markerDropServo");
        //bucketFlapServo = aMap.servo.get("bucketFlapServo");
        servoSwivel = aMap.servo.get("servoSwivel");
        servoStopper = aMap.servo.get("servoStopper");
        servoFoundation1 = aMap.servo.get("servoFoundation1");
        servoFoundation2 = aMap.servo.get("servoFoundation2");
        servoSuction = aMap.servo.get("servoSuction");
        */
        servoIntake = aMap.servo.get("servoIntake");
        /*
        servoSpin = aMap.crservo.get("servoSpin");
        servoSpin2 = aMap.crservo.get("servoSpin2");

        MRgyro = aMap.get(ModernRoboticsI2cGyro.class, "MRgyro");
        //MRRange = aMap.get(ModernRoboticsI2cRangeSensor.class, "MRRange");*/

        //colorSensor = aMap.get(ColorSensor.class, "REVcolor");
        //distanceSensor = aMap.get(DistanceSensor.class, "REVcolor");
        //distanceSensor = hardwareMap.get(DistanceSensor.class, "Distance");


        motorLaunch.setDirection(DcMotorSimple.Direction.FORWARD);
            //motorIntake.setDirection(DcMotorSimple.Direction.FORWARD);
        //motorWorm.setDirection(DcMotorSimple.Direction.FORWARD);
        //motorLeftLaunch.setDirection(DcMotorSimple.Direction.REVERSE);
       /* motorArm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //motorArm.setTargetPosition(0);
        //motorArm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorArm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorArm.setDirection(DcMotorSimple.Direction.FORWARD);
        motorArm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        /*motorWinch.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorWinch.setTargetPosition(0);
        motorWinch.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorWinch.setDirection(DcMotorSimple.Direction.REVERSE);
        motorWinch.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        motorSwivel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorSwivel.setDirection(DcMotorSimple.Direction.FORWARD);
        /*motorSwivel.setTargetPosition(0);
        motorSwivel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorSwivel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorSwivel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);*/

        //motorLift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //motorLift.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        //motorSpinner.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        //motorWinch.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        //motorArm.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        // motorSwivel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
       // motorArm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //motorWinch.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        motorFrontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        motorBackRight.setDirection(DcMotorSimple.Direction.REVERSE);
        motorFrontLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        motorBackLeft.setDirection(DcMotorSimple.Direction.FORWARD);

        motorFrontRight.setPower(0);
        motorBackRight.setPower(0);
        motorFrontLeft.setPower(0);
        motorBackLeft.setPower(0);
    }


    public void drive(boolean forward, int distanceInches, double power)
    {

        int distanceEncodeVal;

        motorFrontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorFrontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorBackLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorBackRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        distanceEncodeVal = (int) Math.round((distanceInches/(4* Math.PI))*1120);
        driveTime = (distanceInches/10)*1000;



        if(forward)
        {
            motorFrontLeft.setTargetPosition(distanceEncodeVal);
            motorFrontRight.setTargetPosition(distanceEncodeVal);
            motorBackLeft.setTargetPosition(distanceEncodeVal);
            motorBackRight.setTargetPosition(distanceEncodeVal);
        }
        else
        {
            motorFrontLeft.setTargetPosition(-distanceEncodeVal);
            motorFrontRight.setTargetPosition(-distanceEncodeVal);
            motorBackLeft.setTargetPosition(-distanceEncodeVal);
            motorBackRight.setTargetPosition(-distanceEncodeVal);
        }

        motorFrontLeft.setPower(power);
        motorFrontRight.setPower(power);
        motorBackLeft.setPower(power);
        motorBackRight.setPower(power);

        motorFrontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorFrontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorBackLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorBackRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        /*
        while((motorFrontLeft.getCurrentPosition() > distanceEncodeVal) && opModeIsActive())
        {
            telemetry.addData("Running", "...");
            telemetry.update();
        }
        */

        //telemetry.addData("Running", "...");
        //telemetry.update();

        if(forward)
        {

            while (motorFrontLeft.getCurrentPosition() < distanceEncodeVal - 20)
            {

            }
        }
        else
        {

            while (motorFrontLeft.getCurrentPosition() > -distanceEncodeVal + 20)
            {

            }

        }

        //telemetry.addData("Finished", ".");
        //telemetry.update();



        /*motorFrontLeft.setTargetPosition(0);
        motorFrontRight.setTargetPosition(0);
        motorBackLeft.setTargetPosition(0);
        motorBackRight.setTargetPosition(0);*/

        motorFrontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorFrontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorBackLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorBackRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        motorFrontLeft.setPower(0);
        motorFrontRight.setPower(0);
        motorBackLeft.setPower(0);
        motorBackRight.setPower(0);


    }

    public void TestDrive(boolean forward, int distanceInches, double power)
    {

        int distanceEncodeVal;

        motorFrontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorFrontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorBackLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorBackRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        distanceEncodeVal = (int) Math.round((distanceInches/(4* Math.PI))*1120);
        driveTime = (distanceInches/10)*1000;



        if(forward)
        {
            motorFrontLeft.setTargetPosition(distanceEncodeVal);
            motorFrontRight.setTargetPosition(distanceEncodeVal);
            motorBackLeft.setTargetPosition(distanceEncodeVal);
            motorBackRight.setTargetPosition(distanceEncodeVal);
        }
        else
        {
            motorFrontLeft.setTargetPosition(-distanceEncodeVal);
            motorFrontRight.setTargetPosition(-distanceEncodeVal);
            motorBackLeft.setTargetPosition(-distanceEncodeVal);
            motorBackRight.setTargetPosition(-distanceEncodeVal);
        }

        motorFrontLeft.setPower(power);
        motorFrontRight.setPower(power);
        motorBackLeft.setPower(power);
        motorBackRight.setPower(power);

        motorFrontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorFrontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorBackLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorBackRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        /*
        while((motorFrontLeft.getCurrentPosition() > distanceEncodeVal) && opModeIsActive())
        {
            telemetry.addData("Running", "...");
            telemetry.update();
        }
        */

        //telemetry.addData("Running", "...");
        //telemetry.update();

        /*try{
            Thread.sleep(10000);

        }catch(Exception e){}*/
        while (motorFrontLeft.getCurrentPosition() < distanceEncodeVal - 20)
        {
            try{
                Thread.sleep(500);

            }catch(Exception e){}
        }


        //telemetry.addData("Finished", ".");
        //telemetry.update();



        /*motorFrontLeft.setTargetPosition(0);
        motorFrontRight.setTargetPosition(0);
        motorBackLeft.setTargetPosition(0);
        motorBackRight.setTargetPosition(0);

        motorFrontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorFrontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorBackLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorBackRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);*/

        motorFrontLeft.setPower(0);
        motorFrontRight.setPower(0);
        motorBackLeft.setPower(0);
        motorBackRight.setPower(0);


    }

    public void strafe(boolean left, int distanceInches,double power)
    {
        int distanceEncodeVal;

        motorFrontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorFrontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorBackLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorBackRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        distanceEncodeVal = -(int) Math.round((distanceInches/(4* Math.PI))*1120);
        driveTime = (distanceInches/10)*1000;



        if(left)
        {
            motorFrontLeft.setTargetPosition(-distanceEncodeVal);
            motorFrontRight.setTargetPosition(distanceEncodeVal);
            motorBackLeft.setTargetPosition(distanceEncodeVal);
            motorBackRight.setTargetPosition(-distanceEncodeVal);
        }
        else
        {
            motorFrontLeft.setTargetPosition(distanceEncodeVal);
            motorFrontRight.setTargetPosition(-distanceEncodeVal);
            motorBackLeft.setTargetPosition(-distanceEncodeVal);
            motorBackRight.setTargetPosition(distanceEncodeVal);
        }

        motorFrontLeft.setPower(power);
        motorFrontRight.setPower(power);
        motorBackLeft.setPower(power);
        motorBackRight.setPower(power);

        motorFrontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorFrontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorBackLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorBackRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        /*
        while((motorFrontLeft.getCurrentPosition() > distanceEncodeVal) && opModeIsActive())
        {
            telemetry.addData("Running", "...");
            telemetry.update();
        }
        */
        if(left)
        {

            while (motorFrontLeft.getCurrentPosition() < -distanceEncodeVal + 20)
            {

            }
        }
        else
        {

            while (motorFrontLeft.getCurrentPosition() > distanceEncodeVal - 20)
            {

            }

        }



        /*motorFrontLeft.setTargetPosition(0);
        motorFrontRight.setTargetPosition(0);
        motorBackLeft.setTargetPosition(0);
        motorBackRight.setTargetPosition(0);*/

        motorFrontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorFrontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorBackLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorBackRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        motorFrontLeft.setPower(0);
        motorFrontRight.setPower(0);
        motorBackLeft.setPower(0);
        motorBackRight.setPower(0);

    }

    public void driveOmniDir(double joystickX, double joystickY, double rotation)
     {
        
        motorFrontRight.setPower(-joystickY - joystickX - rotation);
        motorBackRight.setPower(-joystickY + joystickX - rotation);
        motorFrontLeft.setPower(-joystickY + joystickX + rotation);
        motorBackLeft.setPower(-joystickY - joystickX + rotation);
    }

    public void turn(int targetDegrees, double power, double correctionPower)
    {

        motorFrontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motorBackLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motorFrontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motorBackRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);



//Right is all positive
//Left is all negative
//Straight is left positive. Right negative.
        if(targetDegrees == 0)
        {
            //Tell robot to correct to straight forward

            if(MRgyro.getIntegratedZValue() > 0)
            {
                //If the MRgyro reads back left from zero

                motorFrontLeft.setPower(-power);
                motorBackLeft.setPower(-power);
                motorFrontRight.setPower(power);
                motorBackRight.setPower(power);

                while(MRgyro.getIntegratedZValue() > targetDegrees)
                {

                    telemetry.addData("Target Value: ", targetDegrees);
                    telemetry.addData("Current Value: ", MRgyro.getIntegratedZValue());
                    telemetry.update();

                    try {
                        Thread.sleep(20);
                    }catch(Exception e){}
                    idle();
                }

                motorFrontLeft.setPower(correctionPower);
                motorBackLeft.setPower(correctionPower);
                motorFrontRight.setPower(-correctionPower);
                motorBackRight.setPower(-correctionPower);

                while(MRgyro.getIntegratedZValue() < targetDegrees)
                {
                    telemetry.addData("Target Value: ", targetDegrees);
                    telemetry.addData("Current Value: ", MRgyro.getIntegratedZValue());
                    telemetry.update();
                    try {
                        Thread.sleep(20);
                    }catch(Exception e){}
                    idle();
                }
            }
            if(MRgyro.getIntegratedZValue() < 0)
            {
                //If the MRgyro reads back right from zero

                motorFrontLeft.setPower(power);
                motorBackLeft.setPower(power);
                motorFrontRight.setPower(-power);
                motorBackRight.setPower(-power);

                while(MRgyro.getIntegratedZValue() < targetDegrees)
                {
                    telemetry.addData("Target Value: ", targetDegrees);
                    telemetry.addData("Current Value: ", MRgyro.getIntegratedZValue());
                    telemetry.update();

                    try {
                        Thread.sleep(20);
                    }catch(Exception e){}
                    idle();
                }
                motorFrontLeft.setPower(-correctionPower);
                motorBackLeft.setPower(-correctionPower);
                motorFrontRight.setPower(correctionPower);
                motorBackRight.setPower(correctionPower);

                while(MRgyro.getIntegratedZValue() > targetDegrees)
                {
                    telemetry.addData("Target Value: ", targetDegrees);
                    telemetry.addData("Current Value: ", MRgyro.getIntegratedZValue());
                    telemetry.update();
                    try {
                        Thread.sleep(20);
                    }catch(Exception e){}
                    idle();
                }
            }
            motorFrontLeft.setPower(0);
            motorBackLeft.setPower(0);
            motorFrontRight.setPower(0);
            motorBackRight.setPower(0);
        }
////////////////////////////////////////////////////////////////////////////////////////////////////
        if(targetDegrees > 0)
        {
            //TURNING LEFT
            motorFrontLeft.setPower(-power);
            motorBackLeft.setPower(-power);
            motorFrontRight.setPower(power);
            motorBackRight.setPower(power);

            while(MRgyro.getIntegratedZValue() < targetDegrees)
            {
                telemetry.addData("Target Value: ", targetDegrees);
                telemetry.addData("Current Value: ", MRgyro.getIntegratedZValue());
                telemetry.update();

                try {
                    Thread.sleep(20);
                }catch(Exception e){}
                idle();
            }

            motorFrontLeft.setPower(correctionPower);
            motorBackLeft.setPower(correctionPower);
            motorFrontRight.setPower(-correctionPower);
            motorBackRight.setPower(-correctionPower);

            while(MRgyro.getIntegratedZValue() > targetDegrees)
            {
                telemetry.addData("Target Value: ", targetDegrees);
                telemetry.addData("Current Value: ", MRgyro.getIntegratedZValue());
                telemetry.update();
                try {
                    Thread.sleep(20);
                }catch(Exception e){}
                idle();
            }
        }
        else
        {

            //TURNING RIGHT
            motorFrontLeft.setPower(power);
            motorBackLeft.setPower(power);
            motorFrontRight.setPower(-power);
            motorBackRight.setPower(-power);

            while(MRgyro.getIntegratedZValue() > targetDegrees)
            {
                telemetry.addData("Target Value: ", targetDegrees);
                telemetry.addData("Current Value: ", MRgyro.getIntegratedZValue());
                telemetry.update();

                try {
                    Thread.sleep(20);
                }catch(Exception e){}
                idle();
            }
            motorFrontLeft.setPower(-correctionPower);
            motorBackLeft.setPower(-correctionPower);
            motorFrontRight.setPower(correctionPower);
            motorBackRight.setPower(correctionPower);

            while(MRgyro.getIntegratedZValue() < targetDegrees)
            {
                telemetry.addData("Target Value: ", targetDegrees);
                telemetry.addData("Current Value: ", MRgyro.getIntegratedZValue());
                telemetry.update();
                try {
                    Thread.sleep(20);
                }catch(Exception e){}
                idle();
            }
        }

        motorFrontLeft.setPower(0);
        motorBackLeft.setPower(0);
        motorFrontRight.setPower(0);
        motorBackRight.setPower(0);
    }

    public void motorTest()
    {
        motorFrontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motorBackLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motorFrontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motorBackRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        motorFrontLeft.setPower(0.5);
        motorBackLeft.setPower(0.5);
        motorFrontRight.setPower(0.5);
        motorBackRight.setPower(0.5);
    }
    public void motorTester(DcMotor inputMotor)
    {
        inputMotor.setPower(1);
        inputMotor.getPower();

    }
}
