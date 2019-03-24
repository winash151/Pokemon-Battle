package engine.moves.ice;

import engine.InBattlePokemon;
import engine.moves.Move;

public class FrostBreath extends IceMove {

	/**
	 * id 315
	 * physical move
	 * base power 50
	 * base accuracy of 100
	 * pp 35
	 */
	public FrostBreath() {
		super(524, Move.SPECIAL, 60, 0.9, 10, "Frost Breath");
		setDescription("The user blows its cold breath on the target. This attack always results in a critical hit.");
	}
	
	public boolean willCriticalHit(InBattlePokemon user, InBattlePokemon target) {
		return true;
	}

	@Override
	public Move newInstance() {
		return new FrostBreath();
	}

}
