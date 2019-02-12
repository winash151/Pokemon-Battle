package engine.moves.water;

import engine.InBattlePokemon;
import engine.moves.Move;

public class MuddyWater extends WaterMove {

	/**
	 * id 397
	 * physical
	 * base power 100
	 * base accuracy 75 percent
	 * pp 15
	 */
	public MuddyWater() {
		super(330, Move.SPECIAL, 90, 0.85, 10, "Muddy Water");
		setDescription("The user attacks by shooting muddy water at the opposing Pokemon. This may also lower their accuracy.");
	}

	/**
	 * side status decreases targets defense
	 * @param target
	 */
	public void afflictSideStatus(InBattlePokemon user, InBattlePokemon target) {
		if (willSideStatusOccur(user, target)) {
			if(target.decreaseAccuracy(1, false, user)){
				user.getDisplay().animateStatDecrease(target);
				while(user.getDisplay().isAnimatingStat()){
					System.out.print("");
				}
			}
		}
	}

	/**
	 * Uses randomness to determine whether a status effect will occur
	 * 30 percent of the time
	 * @return
	 */
	public boolean willSideStatusOccur(InBattlePokemon user, InBattlePokemon target) {
		if (user.getRandomGen().next() < 0.30)
			return true;
		return false;
	}

	@Override
	public Move newInstance() {
		return new MuddyWater();
	}

}
