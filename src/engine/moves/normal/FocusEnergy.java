package engine.moves.normal;

import engine.InBattlePokemon;
import engine.moves.Move;

public class FocusEnergy extends NormalMove {

	/**
	 * id 350
	 * status move
	 * pp 30
	 */
	public FocusEnergy() {
		super(116, Move.STATUS, 30, "Focus Energy");
		setNeedsTarget(false);
		setDescription("The user takes a deep breath and focuses so that critical hits land more easily.");
	}

	public void implementSoloStatus(InBattlePokemon user, InBattlePokemon target) {
		if(user.getCriticalHitStage()>=3) {
			user.getDisplay().consolePrintln("But it failed.");
		} else {
			user.setCriticalHitStage(user.getCriticalHitStage()+2);
		}
	}
	
	
	
	public Move newInstance() {
		return new FocusEnergy();
	}

}
