package engine.moves.dark;

import engine.InBattlePokemon;
import engine.moves.Move;

public class SuckerPunch extends DarkMove {

	/**
	 * id 279
	 * physical move
	 * base power 40
	 * base accuracy of 100
	 * pp 30
	 * speed priority 1
	 */
	public SuckerPunch() {
		super(389, Move.PHYSICAL, 80, 1.0, 5, "Sucker Punch", 1);
		setDescription("This move enables the user to attack first. This move fails if the target is not readying an attack.");
	}
	
	public boolean canHit(InBattlePokemon user, InBattlePokemon target) {
		if(!target.hasNextMove() || target.getNextMove().isStatus())
			return false;
		return super.canHit(user, target);
	}

	@Override
	public Move newInstance() {
		return new SuckerPunch();
	}

}
