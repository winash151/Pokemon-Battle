package engine.moves.dark;

import engine.InBattlePokemon;
import engine.moves.Move;

public class NastyPlot extends DarkMove {

	/**
	 * id 350
	 * status move
	 * pp 30
	 */
	public NastyPlot() {
		super(417, Move.STATUS, 20, "Nasty Plot");
		setBlockedByProtect(false);
		setNeedsTarget(false);
		setDescription("The user stimulates its brain by thinking bad thoughts. This sharply raises the user’s Sp. Atk.");
	}

	public void implementSoloStatus(InBattlePokemon user, InBattlePokemon target) {
		if(user.increaseSpAttack(2, true, user)){
			user.getDisplay().animateStatIncrease(user);
			while(user.getDisplay().isAnimatingStat()){
				System.out.print("");
			}
		}
	}

	//can always hit
	public boolean willHit(InBattlePokemon user, InBattlePokemon target) {
		return true;
	}

	@Override
	public Move newInstance() {
		return new NastyPlot();
	}

}
