package engine.moves.dark;

import engine.InBattlePokemon;
import engine.moves.Move;

public class NightDaze extends DarkMove {

	/**
	 * id 397
	 * physical
	 * base power 100
	 * base accuracy 75 percent
	 * pp 15
	 */
	public NightDaze() {
		super(539, Move.SPECIAL, 85, 0.95, 10, "Night Daze");
		setDescription("The user lets loose a pitch-black shock wave at its target. This may also lower the target's accuracy.");
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
		if (user.getRandomGen().next() < 0.40)
			return true;
		return false;
	}

	@Override
	public Move newInstance() {
		return new NightDaze();
	}

}
