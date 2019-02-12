package engine.moves.steel;

import engine.InBattlePokemon;
import engine.moves.Move;

public class SteelWing extends SteelMove {

	/**
	 * id 375
	 * physical
	 * base power 60
	 * base accuracy 100 percent
	 * pp 5
	 */
	public SteelWing() {
		super(211, Move.PHYSICAL, 7, 0.9, 25, "Steel Wing");
		setDescription("The target is hit with wings of steel. This may also raise the user's Defense stat.");
	}

	/**
	 * side status decreases targets defense
	 * @param target
	 */
	public void afflictSideStatus(InBattlePokemon user, InBattlePokemon target) {
		if (willSideStatusOccur(user, target)) {
			boolean defenseIncreased = user.increaseDefense(1, false, user);
			if(defenseIncreased) {
				user.getDisplay().animateStatIncrease(user);
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
		if (user.getRandomGen().next() < 0.10)
			return true;
		return false;
	}

	@Override
	public Move newInstance() {
		return new SteelWing();
	}
}