package engine.moves.fighting;

import engine.InBattlePokemon;
import engine.moves.Move;

public class SacredSword extends FightingMove {

	/**
	 * id 369
	 * special move
	 * 100 base power
	 * accuracy 100
	 */
	public SacredSword() {
		super(533, Move.PHYSICAL, 90, 1.0, 15, "Sacred Sword");
		setDescription("The user attacks by slicing with a long horn. The target's stat changes don't affect this attack's damage.");
	}
	
	public int getDefendingStat(InBattlePokemon user, InBattlePokemon target) {
		return target.getDefenseStat();
	}
	
	public boolean willHit(InBattlePokemon user, InBattlePokemon target) {
		if (user.isForesighted())
			return true;
		
		if(!isNeedsTarget())
			return true;

		double currentAccuracy = getAccuracy() * user.getAccuracyModifier();
		
		if (user.getRandomGen().next() < currentAccuracy)
			return true;
		return false;
	}

	@Override
	public Move newInstance() {
		return new SacredSword();
	}

}