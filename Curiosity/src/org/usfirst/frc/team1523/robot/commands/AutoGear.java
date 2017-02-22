package org.usfirst.frc.team1523.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class AutoGear extends CommandGroup {

	//1 = left, 2 = center, 3 = right
	public AutoGear(int pos) {
		setTimeout(15);
		
		//Drive to Gear
		if(pos==0){
			addSequential(new AutoDrive(0.5, 48));
			addSequential(new AutoTurn(-60));
			addSequential(new AutoDrive(0.5, 6));
		}else if(pos==1){
			addSequential(new AutoDrive(0.5, 48));
		}else if(pos==2){
			addSequential(new AutoDrive(0.5, 48));
			addSequential(new AutoTurn(60));
			addSequential(new AutoDrive(0.5, 6));
		}

		//Place Gear
		addSequential(new Vision());
		addSequential(new SetUpperGear(false));
		addSequential(new WaitCommand(0.5));
		addSequential(new SetUpperGear(true));
		
		//Go Across Baseline
		if(pos==0){
			addSequential(new AutoDrive(0.3, -30));
			addSequential(new AutoTurn(30));
			addSequential(new AutoDrive(0.3, 100));
		}else if(pos==3){
			addSequential(new AutoDrive(0.3, -30));
			addSequential(new AutoTurn(-30));
			addSequential(new AutoDrive(0.3, 100));
		}
	}
}
