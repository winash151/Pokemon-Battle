package engine.moves.fire;

import engine.InBattlePokemon;
import engine.moves.Move;

public class BlastBurn extends FireMove {

	//turn of two turn attack
	private int turn = 1;

	/**
	 * id 104
	 * special move
	 * base power 150
	 * base accuracy 90
	 * pp 5
	 */
	public BlastBurn() {
		super(307, Move.SPECIAL, 150, .9, 5, "Blast Burn");
		setDescription("The target is razed by a fiery explosion. The user must rest on the next turn, however.");
	}

	public boolean use(InBattlePokemon user, InBattlePokemon target) {
		boolean didWork = false;
		if (turn == 2) {//if first turn
			user.getDisplay().consolePrintln(user.getName() + " must recharge.");
			turn = 1;
			user.emptyNextMove();
		} else if (turn == 1) {//if second turn use move
			didWork = super.use(user, target);
			if(didWork)
				turn++;
			else{
				turn = 1;
				user.emptyNextMove();
			}
		}
		return didWork;
	}

	public void cleanUp(InBattlePokemon user, InBattlePokemon target) {
		deductPP(user, target);
		user.setLastMove(user.getIndexOfNextMove());
	}

	@Override
	public Move newInstance() {
		return new BlastBurn();
	}

}
