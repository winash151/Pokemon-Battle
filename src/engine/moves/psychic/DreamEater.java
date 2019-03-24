package engine.moves.psychic;

import engine.InBattlePokemon;
import engine.moves.Move;

public class DreamEater extends PsychicMove {

	/**
	 * id 365
	 * special
	 * base power 90
	 * base accuracy 100 percent
	 * pp 10
	 */
	public DreamEater() {
		super(138, Move.SPECIAL, 100, 1.0, 15, "Dream Eater");
		setDescription("The user eats the dreams of a sleeping target. It absorbs half the damage caused to heal its own HP.");
	}
	
	public void healBack(InBattlePokemon user, int damageDone) {
		user.increaseHP(damageDone/2);
	}
	
	public boolean canHit(InBattlePokemon user, InBattlePokemon target) {
		if(!target.isAsleep())
			return false;
		return super.canHit(user, target);
	}
	
	@Override
	public Move newInstance() {
		// TODO Auto-generated method stub
		return new DreamEater();
	}

}