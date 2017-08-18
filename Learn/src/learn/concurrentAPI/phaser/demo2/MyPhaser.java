package learn.concurrentAPI.phaser.demo2;

import java.util.concurrent.Phaser;


/*
 * Class extending Phaser class and overriding onAdvance()
 * */
public class MyPhaser extends Phaser{

	int numberOfPhases;
	
	
	MyPhaser(int parties, int phaseCount){
		super(parties);
		numberOfPhases = phaseCount - 1;
	}
	
	/*
	 * To terminate a Phase onAdvance() must return True
	 * To keep the Phase alive, onAdvance() must return False
	 * The default version of onAdvance return true
	 * Thus terminate the phase when there are no registered parties
	 * 
	 * On reason to override onAdvace() is to execute a specific number of phase and then stop
	 * 
	 * */
	
	//Override the onAdvance to execute the specific number of phase
	protected boolean onAdvance(int phase, int registeredParties) {
		
		System.out.println("Phase " + phase  + " Completed. \n");
		//If all phases have completed, return true
		if(phase == numberOfPhases || registeredParties == 0)
			return true;
		
		return false;
	}
}
