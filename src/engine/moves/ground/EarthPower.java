package engine.moves.ground;

import engine.InBattlePokemon;
import engine.moves.Move;

public class EarthPower extends GroundMove {

	/**
	 * id 365
	 * special
	 * base power 90
	 * base accuracy 100 percent
	 * pp 10
	 */
	public EarthPower() {
		super(414, Move.SPECIAL, 90, 1.0, 10, "Earth Power");
		setDescription("The user makes the ground under the target erupt with power. This may also lower the target's Sp. Def.");
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
		return new EarthPower();
	}

}