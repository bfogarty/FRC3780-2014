/*
* Copyright 2014 FRC3780 (B. Fogarty, E. Rothchild, A. Lee) Licensed under the
* Educational Community License, Version 2.0 (the "License"); you may
* not use this file except in compliance with the License. You may
* obtain a copy of the License at
* 
* http://www.opensource.org/licenses/ECL-2.0
* 
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an "AS IS"
* BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
* or implied. See the License for the specific language governing
* permissions and limitations under the License.
* 
*/

package org.usfirst.frc3780.commands;

import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc3780.OI;
import org.usfirst.frc3780.subsystems.*;
import org.usfirst.frc3780.components.*;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 * @author Author
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    
    // Create a single static instance of all subsystems
    public static Chassis chassis;
	public static Origami origami = new Origami();
	public static Roller roller;
	public static Arm arm;

    public static void init() {
        
        // Instantiate OI, subsystems.
        oi = new OI();
        try {
            chassis = new Chassis();
        } catch(CANTimeoutException exception) {
            System.out.println(exception.getMessage());
            System.out.println("CANTimeout Exception in CommandBase");
        }
		
		try {
			roller = new Roller();
		} catch(ControllerException e) {
			System.out.println("ControllerException while initializing roller");
			System.out.println(e.getMessage());
		}
		
		try {
			arm = new Arm();
		} catch(ControllerException e) {
			System.out.println("ControllerException while initializing Arm");
			System.out.println(e.getMessage());
		}
        
        // Show what command subsystems are running on the SmartDashboard
        SmartDashboard.putData(chassis);
		SmartDashboard.putData(roller);
		SmartDashboard.putData(arm);
        
    }
	// Placeholder methods

    public CommandBase(String name) {}
	public CommandBase() {}
}
