package engine.moves.normal;

import engine.InBattlePokemon;
import engine.moves.Move;

public class SmokeScreen extends NormalMove {

	/**
	 * id 299
	 * status
	 * base accuracy 100
	 * pp 20
	 */
	public SmokeScreen() {
		super(108, Move.STATUS, 1.0, 20, "Smokescreen");
		setDescription("The user releases an obscuring cloud of smoke or ink. This lowers the target's accuracy.");
	}

	/**
	 * decreases target's accuracy
	 */
	public void implementSoloStatus(InBattlePokemon user, InBattlePokemon target) {
		if(target.decreaseAccuracy(1, true, user)){
			user.getDisplay().animateStatDecrease(target);
			while(user.getDisplay().isAnimatingStat()){
				System.out.print("");
			}
		}
	}

	@Override
	public Move newInstance() {
		return new SmokeScreen();
	}
}
