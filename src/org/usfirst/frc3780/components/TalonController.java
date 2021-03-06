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

package org.usfirst.frc3780.components;

import edu.wpi.first.wpilibj.*;

public class TalonController extends Controller {
	private Talon talon;
	
	public TalonController(int channel) {
		talon = new Talon(channel);
	}
	
	public TalonController(int slot, int channel) {
		talon = new Talon(slot,channel);
	}
	// -100-100
	public double get() {
		return talon.get() * 100;
	}
	
	public void set(double speed) {
		talon.set(speed/100);
	}
}