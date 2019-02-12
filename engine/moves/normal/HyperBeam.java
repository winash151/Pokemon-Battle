package engine.moves.normal;

import engine.InBattlePokemon;
import engine.moves.Move;

public class HyperBeam extends NormalMove {

	//turn of two turn attack
	private int turn = 1;

	/**
	 * id 262
	 * special move
	 * base power 150
	 * base accuracy 90
	 * pp 5
	 */
	public HyperBeam() {
		super(63, Move.SPECIAL, 150, .9, 5, "Hyper Beam");
		setDescription("The target is attacked with a powerful beam. The user can't move on the next turn.");
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
		return new HyperBeam();
	}

}
