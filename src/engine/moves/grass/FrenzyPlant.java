package engine.moves.grass;

import engine.InBattlePokemon;
import engine.moves.Move;

public class FrenzyPlant extends GrassMove {

	//turn of two turn attack
	private int turn = 1;

	/**
	 * id 162
	 * special move
	 * base power 150
	 * base accuracy 90
	 * pp 5
	 */
	public FrenzyPlant() {
		super(338, Move.SPECIAL, 150, .9, 5, "Frenzy Plant");
		setDescription("The user slams the target with an enormous tree. The user can't move on the next turn.");
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
		return new FrenzyPlant();
	}

}
