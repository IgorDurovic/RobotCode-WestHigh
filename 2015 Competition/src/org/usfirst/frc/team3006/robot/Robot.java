
package org.usfirst.frc.team3006.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
    RobotDrive myRobut;
    Joystick stick1; 
    Joystick stick2;
    Joystick control;
    Talon lift;
    Victor liftB;
    Talon turn;
    boolean liftingBoxes;
    double startTime, currentTime;
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        myRobut = new RobotDrive(1, 0);
        myRobut.setExpiration(0.1);
        stick1 = new Joystick(0);
        stick2 = new Joystick(1);
        control = new Joystick(2);
        lift = new Talon(2);
        liftB = new Victor(4);
        turn = new Talon(3);
    }
    
    /**
     * This function is called once at the start of autonomous
     */
    public void autonomousInit() {
    	/*turn.set(1.0);
    	Timer.delay(3.5);
    	turn.set(0.0);*/
    	
        //Each of the following lines of code will work. Pick one to run, by removing the "//" at the front.
    	//autonomousOneBox();
    	//autonomousTwoBoxes();
    	//autonomousThreeBoxes();
    }
    
    /**
     * This autonomous option will pick up one box and drive to the center.
     */
    public void autonomousOneBox() {
    	//Disable safety on motors so you don't need constant input
    	myRobut.setSafetyEnabled(false);
    	lift.setSafetyEnabled(false);
    	liftB.setSafetyEnabled(false);
    	
    	//Drive the robot forward to the box
    	myRobut.drive(-0.5, 0.0);
    	Timer.delay(0.7);
    	myRobut.drive(0.0, 0.0);
    	Timer.delay(0.3);
    	
    	//Pick up the box
    	lift.set(0.75);
    	liftB.set(0.75);
    	Timer.delay(2.0);
    	lift.set(0.0);
    	liftB.set(0.0);
    	Timer.delay(1.0);
    	
    	//Drive to the center of the arena
    	myRobut.drive(-0.5, -1.0);
    	Timer.delay(3.0);
    	myRobut.drive(-0.6, 0.0);
    	Timer.delay(2.0);
    	myRobut.drive(0.0, 0.0);
    }
    
    /**
     * This autonomous option will pick up a pair of boxes and drive to the center.
     */
    public void autonomousTwoBoxes() {
    	//Disable safety on motors so you don't need constant input
    	myRobut.setSafetyEnabled(false);
    	lift.setSafetyEnabled(false);
    	liftB.setSafetyEnabled(false);
    	
    	//Drive the robot forward for 0.5 seconds
    	myRobut.drive(-0.75, 0.0);
    	Timer.delay(0.5);
    	myRobut.drive(0.0, 0.0);
    	
    	//Pick up the first box
    	lift.set(0.75);
    	liftB.set(0.75);
    	Timer.delay(4.0);
    	lift.set(0.0);
    	liftB.set(0.0);
    	
    	//Move the trashcan out of the way
    	myRobut.drive(-0.6, 0.5);
    	Timer.delay(2.0);
    	myRobut.drive(-0.6, -0.5);
    	Timer.delay(2.0);
    	myRobut.drive(0.0, 0.0);
    	
    	//Drive forward to the next box
    	myRobut.drive(-0.75, 0.0);
    	Timer.delay(1.0);
    	myRobut.drive(0.0, 0.0);
    	
    	//Pick up the second box
    	lift.set(0.75);
    	liftB.set(0.75);
    	Timer.delay(2.0);
    	lift.set(0.0);
    	liftB.set(0.0);
    	
    	//Drive to the center of the arena
    	myRobut.drive(-0.6, 1.0);
    	Timer.delay(1.0);
    	myRobut.drive(-0.75, 0.0);
    	Timer.delay(3.0);
    	myRobut.drive(0.0, 0.0);
    }
    
    /**
     * This autonomous option will pick up three boxes and drive to the center.
     */
    public void autonomousThreeBoxes() {
    	//Disable safety on motors so you don't need constant input
    	myRobut.setSafetyEnabled(false);
    	lift.setSafetyEnabled(false);
    	liftB.setSafetyEnabled(false);
    	
    	//Drive the robot forward for 0.5 seconds
    	myRobut.drive(-0.75, 0.0);
    	Timer.delay(0.5);
    	myRobut.drive(0.0, 0.0);
    	
    	//Pick up the first box
    	lift.set(0.75);
    	liftB.set(0.75);
    	Timer.delay(4.0);
    	lift.set(0.0);
    	liftB.set(0.0);
    	
    	//Move the first trashcan out of the way
    	myRobut.drive(-0.6, 0.5);
    	Timer.delay(2.0);
    	myRobut.drive(-0.6, -0.5);
    	Timer.delay(2.0);
    	myRobut.drive(0.0, 0.0);
    	
    	//Drive forward to the next box
    	myRobut.drive(-0.75, 0.0);
    	Timer.delay(1.0);
    	myRobut.drive(0.0, 0.0);
    	
    	//Pick up the second box
    	lift.set(0.75);
    	liftB.set(0.75);
    	Timer.delay(2.0);
    	lift.set(0.0);
    	liftB.set(0.0);
    	
    	//Move the second trashcan out of the way
    	myRobut.drive(-0.6, 0.5);
    	Timer.delay(2.0);
    	myRobut.drive(-0.6, -0.5);
    	Timer.delay(2.0);
    	myRobut.drive(0.0, 0.0);
    	
    	//Drive forward to the next box
    	myRobut.drive(-0.75, 0.0);
    	Timer.delay(1.0);
    	myRobut.drive(0.0, 0.0);
    	
    	//Pick up the third box
    	lift.set(0.75);
    	liftB.set(0.75);
    	Timer.delay(2.0);
    	lift.set(0.0);
    	liftB.set(0.0);
    	
    	//Drive to the center of the arena
    	myRobut.drive(-0.6, 1.0);
    	Timer.delay(1.0);
    	myRobut.drive(-0.75, 0.0);
    	Timer.delay(3.0);
    	myRobut.drive(0.0, 0.0);
    }
    
    /**
     * This function is called once at the start of operator control
     */
    public void teleopInit() {
        myRobut.setSafetyEnabled(true);
        myRobut.setMaxOutput(0.8);
        lift.setSafetyEnabled(true);
        liftB.setSafetyEnabled(true);
        turn.setSafetyEnabled(true);
        liftingBoxes = false;
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        myRobut.tankDrive(stick1, stick2); // drive with tank style (left and right sticks)
        /*
         * Automatically lift boxes for 8.0 seconds, while allowing for continuous input.
         */
        if(liftingBoxes) {
        	lift.set(0.75);
        	liftB.set(0.75);
        	
        	currentTime = System.nanoTime();
        	if(currentTime >= startTime + 8.0) {
        		lift.set(0.0);
        		liftB.set(0.0);
        		liftingBoxes = false;
        	}
        }
        else {
        	if(stick2.getRawButton(3)) {
        		liftingBoxes = true;
        		startTime = System.nanoTime();
        	}
        } 
        
        /* If the 3 and 2 buttons on the {side} stick are pressed, the lift motors will be controlled.
         * If you press the 3 button on either stick, they should winch up.
         * If you press the 2 button on either stick, they should winch down.
         */
        if(stick1.getRawButton(3) || stick2.getRawButton(3)) {
        	lift.set(0.75);
        	liftB.set(0.75);
        }
        else if(stick1.getRawButton(2) || stick2.getRawButton(2)) {
        	lift.set(-0.4);
        	liftB.set(-0.4);
        }
        
        /* If the 4 and 5 buttons on the stick are pressed, the turning motors will be controlled.
         * If you press the 4 button on either stick, they should rotate the can clockwise.
         * If you press the 5 button on either stick, they should rotate the can counter-clockwise.
         */
        if(stick1.getRawButton(10) || stick2.getRawButton(10)) {
        	turn.set(-0.25);
        }
        else if(stick1.getRawButton(11) || stick2.getRawButton(11)) {
        	turn.set(0.25);
        }
        
        // Delay 1/200th of a second before the next update.
        Timer.delay(0.005);
    }
}
