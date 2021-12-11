package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "2022 TeleOp -CHOOSE THIS ONE-", group = "TeleOp")
public class TeleOp2022 extends LinearOpMode
{
    OpMode opmode;

    @Override
    public void runOpMode() {
        Hardware h = new Hardware();


        try {
            h.init(hardwareMap, telemetry);
        } catch (Exception e) {
            telemetry.addData("Init Error:", "Something failed to initialize");
            e.printStackTrace();
        }
        h.servoIntake.setPosition(1);
        telemetry.addData("Main Initialization ", "complete");
        telemetry.update();

        boolean pressedLastIterationIntake = false;
        boolean pressedLastIterationCarousel = false;
        boolean pressedLastIterationCarouselReverse = false;

        waitForStart();
        while (opModeIsActive())
        {
            boolean pressedCarousel = gamepad1.a;
            boolean pressedIntake = gamepad1.x;
            boolean pressedCarouselReverse = gamepad1.b;
            //telemetry.addData("range", String.format("%.01f in", h.distanceSensor.getDistance(DistanceUnit.INCH)));
            //telemetry.addData("Distance: ",h.distanceSensor.getDistance(DistanceUnit.INCH));
            telemetry.addData("Carousel Toggle: ", pressedCarousel);
            telemetry.addData("Carousel Last Iteration Toggle: ", pressedLastIterationCarousel);
            telemetry.addData("Intake Toggle: ", pressedIntake);
            telemetry.addData("Intake Last Iteration Toggle: ", pressedLastIterationIntake);
            telemetry.addData("motorArm Position: ", h.motorArm.getCurrentPosition());
            telemetry.addData("motorWinch Position: ", h.motorWinch.getCurrentPosition());
            telemetry.addData("servoIntake: ", h.servoIntake.getPosition());
            telemetry.addData("rightTrigger: ", gamepad1.right_trigger);
            telemetry.addData("leftTrigger: ", gamepad1.left_trigger);
            telemetry.addData("rightBumper: ", gamepad1.right_bumper);
            telemetry.addData("rightBumper: ", gamepad1.left_bumper);
            telemetry.addData("motorFrontLeft encoder value: ",h.motorFrontLeft.getCurrentPosition());
            telemetry.addData("motorFrontRight encoder value: ",h.motorFrontRight.getCurrentPosition());
            telemetry.addData("motorBackLeft encoder value: ",h.motorBackLeft.getCurrentPosition());
            telemetry.addData("motorBackRight encoder value: ",h.motorBackRight.getCurrentPosition());
            telemetry.update();
            h.driveOmniDir(gamepad1.left_stick_x, gamepad1.left_stick_y, gamepad1.right_stick_x);
            if(gamepad1.dpad_left)
            {
                h.motorFrontLeft.setPower(-.2);
                h.motorFrontRight.setPower(-.2);
                h.motorBackLeft.setPower(-.2);
                h.motorBackRight.setPower(-.2);
            }
            else if (gamepad1.dpad_right)
            {
                h.motorFrontLeft.setPower(.2);
                h.motorFrontRight.setPower(.2);
                h.motorBackLeft.setPower(.2);
                h.motorBackRight.setPower(.2);
            }
            if(gamepad1.dpad_up)
            {
                h.motorFrontLeft.setPower(.2);
                h.motorFrontRight.setPower(-.2);
                h.motorBackLeft.setPower(.2);
                h.motorBackRight.setPower(-.2);
            }
            else if(gamepad1.dpad_down)
            {
                h.motorFrontLeft.setPower(-.2);
                h.motorFrontRight.setPower(.2);
                h.motorBackLeft.setPower(-.2);
                h.motorBackRight.setPower(.2);
            }


            if(pressedIntake & !pressedLastIterationIntake)
            {
                if(h.servoIntake.getPosition() == 1)
                {
                    h.servoIntake.setPosition(0);
                }
                else
                {
                    h.servoIntake.setPosition(1);
                }

            }

            if (gamepad1.y)
            {
                h.servoIntake.setPosition(.2);
            }

            if(pressedCarousel & !pressedLastIterationCarousel)
            {
                if(h.motorCarousel.getPower() == 0 && gamepad1.b)
                {
                    h.motorCarousel.setPower(.3);
                }
                else if(h.motorCarousel.getPower() == 0)
                {
                    h.motorCarousel.setPower(-.3);
                }
                else
                {
                    h.motorCarousel.setPower(0);
                }

            }
            /*if(pressedCarouselReverse & !pressedLastIterationCarouselReverse)
            {
                if(h.motorCarousel.getPower() == 0)
                {
                    h.motorCarousel.setPower(-.3);
                }
                else
                {
                    h.motorCarousel.setPower(0);
                }

            }*/
            if(gamepad1.right_trigger > .01 /*&& h.motorArm.getPosition() < high limit*/)
            {
                h.motorArm.setPower(1);
            }
            if (gamepad1.right_bumper /*&& h.motorArm.getPosition() > low limit*/)
            {
                h.motorArm.setPower(-1);
            }
            if(!gamepad1.right_bumper && gamepad1.right_trigger == 0)
            {
                h.motorArm.setPower(0);
            }

            if(gamepad1.left_trigger > .01)
            {
                h.motorWinch.setPower(.5);
            }
            if (gamepad1.left_bumper)
            {
                h.motorWinch.setPower(-.5);
            }
            if(!gamepad1.left_bumper && gamepad1.left_trigger == 0)
            {
                h.motorWinch.setPower(0);
            }
           /* if(gamepad1.y)
            {
                h.motorLaunch.setPower(gamepad1.left_trigger);
            }
            if(gamepad1.x)
            {
                h.motorLaunch.setPower(0);
            }*/
            /*if(gamepad1.left_trigger == 1 ) // Trigger Launcher Control
            {
                h.motorLaunch.setPower(1);
                //++h.launchValue;
            }
            else if (gamepad1.left_trigger < .5)
            {
                h.motorLaunch.setPower(0);
            }*/
            /*if (gamepad1.y)
            {
                h.motorLaunch.setPower(1);
            }
            else
            {
                h.motorLaunch.setPower(0);
            }
            if(pressed & !pressedLastIteration)
            {
                if(h.motorLaunch.getPower() == 0)
                {
                    h.motorLaunch.setPower(1);
                }
                else
                {
                    h.motorLaunch.setPower(0);
                }

            }
            pressedLastIteration = pressed;*/


            /*if (gamepad1.y) //y button toggle Launcher Control
            {
                ++launchValue;
            }
            switch (launchValue)
            {
                case 1:
                    h.motorLaunch.setPower(1);
                    break;
                case 2:
                    h.motorLaunch.setPower(0);
                    launchValue = 0;
                    break;
            }*/
            /*if(gamepad1.a)
            {
                h.servoIntake.setPosition(.7);
            }
            if(gamepad1.b)
            {
                h.servoIntake.setPosition(1);
            }*/
            /*if (gamepad1.a) //Intake Control
            {
                ++intakeValue;
            }
            switch (intakeValue)
            {
                case 1:
                    h.motorIntake.setPower(1);
                    h.motorLaunch.setPower(-0.3);
                    break;
                case 2:
                    h.motorIntake.setPower(0);
                    h.motorLaunch.setPower(0);
                    intakeValue = 0;
                    break;
                default:
                    intakeValue = 0;
            }*/

            /*if (gamepad1.left_bumper) //High Position
            {
                h.motorArm.setTargetPosition(1);
                h.motorArm.setPower(.6);

            }
            if (gamepad1.right_bumper) //Low Position
            {
                h.motorArm.setTargetPosition(-1);
                h.motorArm.setPower(.6);
            }
            if (!h.motorArm.isBusy())
            {
                h.motorArm.setPower(0);
            }*/


            pressedLastIterationIntake = pressedIntake;
            pressedLastIterationCarousel = pressedCarousel;
        }
    }
}
