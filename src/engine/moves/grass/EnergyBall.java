package engine.moves.grass;

import engine.InBattlePokemon;
import engine.moves.Move;

public class EnergyBall extends GrassMove {

	/**
	 * id 365
	 * special
	 * base power 90
	 * base accuracy 100 percent
	 * pp 10
	 */
	public EnergyBall() {
		super(412, Move.SPECIAL, 90, 1.0, 10, "Energy Ball");
		setDescription("The user draws power from nature and fires it at the target. This may also lower the target's Sp. Def.");
	}

	/**
	 * side status decreases targets defense
	 * @param target
	 */
	public void afflictSideStatus(InBattlePokemon user, InBattlePokemon target) {
		if (willSideStatusOccur(user, target)) {
			if(target.decreaseSpDefense(1, false, user)){
				user.getDisplay().animateStatDecrease(target);
				while(user.getDisplay().isAnimatingStat()){
					System.out.print("");
				}
			}
			
		}
	}

	/**
	 * Uses randomness to determine whether a status effect will occur
	 * 10 percent of the time
	 * @return
	 */
	public boolean willSideStatusOccur(InBattlePokemon user, InBattlePokemon target) {
		if (user.getRandomGen().next() < 0.10)
			return true;
		return false;
	}

	@Override
	public Move newInstance() {
		return new EnergyBall();
	}

}